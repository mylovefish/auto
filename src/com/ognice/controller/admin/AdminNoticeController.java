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
import com.ognice.domain.Notice;
import com.ognice.service.INoticeService;
/**
 * @author ..(@qq.com)<br>
 * @date 2018-04-07
 * 公告管理 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/notice")
public class AdminNoticeController {
    @Resource
    private INoticeService noticeService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Notice searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = noticeService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        return "admin/notice/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Notice record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = noticeService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/notice";
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("record", record);
        return "admin/notice/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Notice record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

        String msg = noticeService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/notice";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/notice/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Notice record = noticeService.getNoticeById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/notice/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Notice record = noticeService.getNoticeById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/notice/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Notice record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
noticeService.update(record);
        return "redirect:/admin/notice";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Notice   notice=noticeService.getNoticeById(id);
        noticeService.delete(id);
        return "redirect:/admin/notice";
    }
}
