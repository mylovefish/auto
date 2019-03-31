package com.ognice.controller.admin;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Meeting;
import com.ognice.domain.Preuser;
import com.ognice.service.IMeetingService;
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
 * 会议管理 controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/meeting")
public class AdminMeetingController {
    @Resource
    private IMeetingService meetingService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Meeting searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = meetingService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        return "admin/meeting/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Meeting record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = meetingService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/meeting";
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("record", record);
        return "admin/meeting/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Meeting record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

        String msg = meetingService.save(record);
        if (msg.equals("添加成功")) {
            Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
            if(p!=null){
                return "redirect:/admin/meeting?preuserid="+p.getId();

            }
        return "redirect:/admin/meeting";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/meeting/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Meeting record = meetingService.getMeetingById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/meeting/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Meeting record = meetingService.getMeetingById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/meeting/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Meeting record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
meetingService.update(record);      Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
        if(p!=null){
            return "redirect:/admin/meeting?preuserid="+p.getId();

        }
        return "redirect:/admin/meeting";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Meeting   meeting=meetingService.getMeetingById(id);
        meetingService.delete(id);      Preuser p=(Preuser)request.getSession().getAttribute("indexUser");
        if(p!=null){
            return "redirect:/admin/meeting?preuserid="+p.getId();

        }
        return "redirect:/admin/meeting";
    }
}
