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
import com.ognice.domain.Apartment;
import com.ognice.service.IApartmentService;

import java.util.Date;
/**
 * @author ..(@qq.com)<br>
 * @date 2018-04-07
 * 部门管理 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/apartment")
public class AdminApartmentController {
    @Resource
    private IApartmentService apartmentService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Apartment searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = apartmentService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        return "admin/apartment/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Apartment record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = apartmentService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/apartment";
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("record", record);
        return "admin/apartment/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Apartment record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

        String msg = apartmentService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/apartment";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/apartment/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Apartment record = apartmentService.getApartmentById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/apartment/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Apartment record = apartmentService.getApartmentById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/apartment/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Apartment record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
apartmentService.update(record);
        return "redirect:/admin/apartment";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Apartment   apartment=apartmentService.getApartmentById(id);
        apartmentService.delete(id);
        return "redirect:/admin/apartment";
    }
}
