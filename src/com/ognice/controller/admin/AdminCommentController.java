package com.ognice.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

import com.ognice.controller.common.JsonResult;
import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Comment;
import com.ognice.service.ICommentService;
import com.ognice.service.IPreuserService ;

import java.util.Date;
/**
 * @author ..(@qq.com)<br>
 * @date 2018-04-07
 * 留言板管理 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/comment")
public class AdminCommentController {
    @Resource
    private ICommentService commentService;
        @Resource
        private IPreuserService preuserService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Comment searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = commentService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        return "admin/comment/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Comment record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            record.setCreated(new Date());
            String msg = commentService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/comment";
            }
            model.addAttribute("msg", msg);
        }
            model.addAttribute("preusers", preuserService.all());
        model.addAttribute("record", record);
        return "admin/comment/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Comment record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

            record.setCreated(new Date());
        String msg = commentService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/comment";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/comment/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Comment record = commentService.getCommentById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
            model.addAttribute("preusers", preuserService.all());
        return "admin/comment/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Comment record = commentService.getCommentById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
            model.addAttribute("preusers", preuserService.all());
        return "admin/comment/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Comment record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
commentService.update(record);
        return "redirect:/admin/comment";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Comment   comment=commentService.getCommentById(id);
        commentService.delete(id);
        return "redirect:/admin/comment";
    }
}
