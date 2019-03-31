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
import com.ognice.domain.Preuser;
import com.ognice.service.IPreuserService;
import com.ognice.service.IApartmentService ;
import com.ognice.service.IJueseService ;

import java.util.Date;
/**
 * @author ..(@qq.com)<br>
 * @date -07
 * 用户管理 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/preuser")
public class AdminPreuserController {
    @Resource
    private IPreuserService preuserService;
        @Resource
        private IApartmentService apartmentService;
        @Resource
        private IJueseService jueseService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Preuser searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = preuserService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        return "admin/preuser/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Preuser record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = preuserService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/preuser";
            }
            model.addAttribute("msg", msg);
        }
                if(record.getApartmentid()!=null){
                record.setApartmentname(apartmentService.getApartmentById(record.getApartmentid()).getName());
            }
            model.addAttribute("apartments", apartmentService.all());
                if(record.getJueseid()!=null){
                record.setJuesename(jueseService.getJueseById(record.getJueseid()).getName());
            }
            model.addAttribute("jueses", jueseService.all());
        model.addAttribute("record", record);
        return "admin/preuser/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Preuser record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

    if(record.getApartmentid()!=null){
    record.setApartmentname(apartmentService.getApartmentById(record.getApartmentid()).getName());
    }
    if(record.getJueseid()!=null){
    record.setJuesename(jueseService.getJueseById(record.getJueseid()).getName());
    }
        String msg = preuserService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/preuser";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/preuser/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Preuser record = preuserService.getPreuserById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
            model.addAttribute("apartments", apartmentService.all());
            model.addAttribute("jueses", jueseService.all());
        return "admin/preuser/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Preuser record = preuserService.getPreuserById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
            model.addAttribute("apartments", apartmentService.all());
            model.addAttribute("jueses", jueseService.all());
        return "admin/preuser/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Preuser record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
    if(record.getApartmentid()!=null){
    record.setApartmentname(apartmentService.getApartmentById(record.getApartmentid()).getName());
    }
    if(record.getJueseid()!=null){
    record.setJuesename(jueseService.getJueseById(record.getJueseid()).getName());
    }
    preuserService.update(record);
        return "redirect:/admin";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Preuser   preuser=preuserService.getPreuserById(id);
        preuserService.delete(id);
        return "redirect:/admin/preuser";
    }
}
