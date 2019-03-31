package com.ognice.controller.admin;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Contact;
import com.ognice.domain.Preuser;
import com.ognice.service.IContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author ..(@qq.com)<br>
 * @date 2018-04-07
 * 通讯录 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/contact")
public class AdminContactController {
    @Resource
    private IContactService contactService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Contact searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = contactService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        return "admin/contact/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Contact record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = contactService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/contact";
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("record", record);
        return "admin/contact/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Contact record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

        String msg = contactService.save(record);
        if (msg.equals("添加成功")) { Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
            if(p!=null){
                return "redirect:/admin/contact?owner="+p.getId();

            }
        return "redirect:/admin/contact";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/contact/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Contact record = contactService.getContactById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/contact/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Contact record = contactService.getContactById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/contact/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Contact record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
contactService.update(record);Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
        if(p!=null){
            return "redirect:/admin/contact?owner="+p.getId();

        }
        return "redirect:/admin/contact";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Contact   contact=contactService.getContactById(id);
        contactService.delete(id);Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
        if(p!=null){
            return "redirect:/admin/contact?owner="+p.getId();

        }
        return "redirect:/admin/contact";
    }
}
