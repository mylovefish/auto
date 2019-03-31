package com.ognice.controller.admin;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Meeting;
import com.ognice.domain.Meetuser;
import com.ognice.domain.Msg;
import com.ognice.service.IMeetingService;
import com.ognice.service.IMeetuserService;
import com.ognice.service.IMsgService;
import com.ognice.service.IPreuserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * @author ..(@qq.com)<br>
 * @date 2018-04-07
 *  controller
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/meetuser")
public class AdminMeetuserController {
    @Resource
    private IMeetuserService meetuserService;
        @Resource
        private IPreuserService preuserService;
        @Resource
        private IMeetingService meetingService;
    @Resource
    private IMsgService msgService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Meetuser searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = meetuserService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        model.addAttribute("preusers", preuserService.all());
        return "admin/meetuser/page";
    }

    @RequestMapping(value = "page", method = { RequestMethod.GET, RequestMethod.POST })
    public String page(HttpServletRequest request,ModelMap model, Meetuser searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = meetuserService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("record", searchParam);
        model.addAttribute("meets", meetingService.all());
        return "admin/meetuser/page2";
    }

    //新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Meetuser record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = meetuserService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/meetuser";
            }
            model.addAttribute("msg", msg);
        }
            model.addAttribute("preusers", preuserService.all());
            model.addAttribute("meetings", meetingService.all());
        model.addAttribute("record", record);
        return "admin/meetuser/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Meetuser record) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {

        String msg = meetuserService.save(record);
        if (msg.equals("添加成功")) {
            Msg msg2=new Msg();
            msg2.setPreuserid(record.getPreuserid());
            Meeting m=meetingService.getMeetingById(record.getMeetingid());
            SimpleDateFormat f=new SimpleDateFormat("yyyy年MM月dd日");

            msg2.setMsg(f.format(m.getOndate())+" "+"参与会议："+m.getTitle());
            msg2.setStatus(0);
            msgService.save(msg2);
        return "redirect:/admin/meetuser?meetingid="+record.getMeetingid();
        }
        request.setAttribute("msg", msg);
        }
        return "admin/meetuser/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Meetuser record = meetuserService.getMeetuserById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
            model.addAttribute("preusers", preuserService.all());
            model.addAttribute("meetings", meetingService.all());
        return "admin/meetuser/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Meetuser record = meetuserService.getMeetuserById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
            model.addAttribute("preusers", preuserService.all());
            model.addAttribute("meetings", meetingService.all());
        return "admin/meetuser/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Meetuser record, ModelMap model) {
if ("post".equals(request.getMethod().toLowerCase())) {

}
meetuserService.update(record);
        return "redirect:/admin/meetuser?meetingid="+record.getMeetingid();
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
Meetuser   meetuser=meetuserService.getMeetuserById(id);
        meetuserService.delete(id);
        return "redirect:/admin/meetuser?meetingid="+meetuser.getMeetingid();
    }
}
