package com.ognice.controller.admin;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Plan;
import com.ognice.domain.Preuser;
import com.ognice.service.IPlanService;
import com.ognice.service.IPreuserService;
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
 * 日程管理 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/plan")
public class AdminPlanController {
    @Resource
    private IPlanService planService;
        @Resource
        private IPreuserService preuserService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Plan searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = planService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        return "admin/plan/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Plan record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = planService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/plan";
            }
            model.addAttribute("msg", msg);
        }
            model.addAttribute("preusers", preuserService.all());
        model.addAttribute("record", record);
        return "admin/plan/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Plan record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

        String msg = planService.save(record);
        if (msg.equals("添加成功")) {      Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
            if(p!=null){
                return "redirect:/admin/plan?preuserid="+p.getId();

            }
        return "redirect:/admin/plan";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/plan/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Plan record = planService.getPlanById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
            model.addAttribute("preusers", preuserService.all());
        return "admin/plan/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Plan record = planService.getPlanById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
            model.addAttribute("preusers", preuserService.all());
        return "admin/plan/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Plan record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
planService.update(record); Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
        if(p!=null){
            return "redirect:/admin/plan?preuserid="+p.getId();

        }
        return "redirect:/admin/plan";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Plan   plan=planService.getPlanById(id);
        planService.delete(id); Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
        if(p!=null){
            return "redirect:/admin/plan?preuserid="+p.getId();

        }
        return "redirect:/admin/plan";
    }
}
