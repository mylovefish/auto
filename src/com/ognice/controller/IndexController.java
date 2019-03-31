/**
 *
 */
package com.ognice.controller;

import com.ognice.domain.Preuser;
import com.ognice.domain.User;
import com.ognice.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * <br>
 * ========================== <br>
 * 开发：@qq.com <br>
 * 版本：1.0 <br>
 * 创建时间：11月25日 <br>
 * ==========================
 */
@Controller
public class IndexController {
    @Resource
    private IUserService userservice;
    //@Resource
   // private IPreuserService preuserservice;

   // @Resource
    //private ICateService cateService;

    //@Resource
   // private IKechengService kechengService;

    /**
     *
     */
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "admin/demo";
    }


    /**
     * 前台首页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String preindex(ModelMap model) {
        // return "pre/login";//必须登录
//        model.addAttribute("cates",cateService.all());//分类
//        PageSearchParam psp = new PageSearchParam();
//        psp.setPage(1);
//        psp.setPagesize(9);
//        Kecheng kecheng=new Kecheng();
//        psp.setParams(kecheng);
//        model.addAttribute("lists",kechengService.getPages(psp));//列表
        return "redirect:/admin";
    }
    /**
     * 前台首页
     */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/";
    }

    /**
     * 前台退出
     */
    @RequestMapping(value = "/index/logout")
    public String logout2(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("indexUser");
        return "redirect:/index";
    }

    /**
     * 前台z注册
     */
//    @RequestMapping(value = "/index/reg")
//    public String indexreg(HttpServletRequest request, HttpServletResponse response) {
//        return "pre/register";
//    }
//    @RequestMapping(value = "/index/regsave")
//    public String regsave(HttpServletRequest request, HttpServletResponse response, Preuser record, @RequestParam("file") MultipartFile file) {
//        if ("post".equals(request.getMethod().toLowerCase())) {
//            record.setCreated(new Date());
//            if (file.getSize() != 0) {
//                String url = "";
//
//                try {
//                    String staticPath = request.getSession().getServletContext().getRealPath("static/dist/img/");
//                    String fileName = file.getOriginalFilename();
//                    String[] filestr = fileName.split("\\.");
//                    String fileurl = System.currentTimeMillis() + "." + filestr[1];
//                    java.io.File targetFile = new java.io.File(staticPath, fileurl);
//                    file.transferTo(targetFile);
//                    url = "http://localhost:" + request.getLocalPort() + request.getSession().getServletContext().getContextPath() + "/static/dist/img/" + fileurl;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                record.setPicurl(url);
//            }
//            PageSearchParam psp=new PageSearchParam();
//            psp.setPage(1);
//            psp.setPagesize(1);
//            Preuser ps=new Preuser();
//            ps.setUsername(record.getUsername());
//            ps.setEmail(record.getEmail());
//            psp.setParams(ps);
//
//            if(preuserservice.getPages(psp).getTotal()>0){
//                request.setAttribute("msg", "用户名或邮箱已存在！");
//                return "pre/register";
//
//            }
//            String msg = preuserservice.save(record);
//            if (msg.equals("添加成功")) {
//                request.getSession().setAttribute("indexUser",record);
//                return "redirect:/";
//            }
//            request.setAttribute("msg", msg);
//        }
//        return "pre/register";
//    }
//
//    /**
//     * 前台登录
//     */
//    @RequestMapping(value = "/index/login")
//    public String indexlogin(HttpServletRequest request, HttpServletResponse response) {
//        String username = request.getParameter("username");
//        String psw = request.getParameter("psw");
//        Preuser u = userservice.prelogin(username, psw);
//        if (null == u) {
//              if(request.getMethod().equals("POST")) {
//        request.setAttribute("msg", "账号或密码错误");
//    }
//            return "pre/login";
//
//        }
//        request.getSession().setAttribute("indexUser", u);
//
//        return "redirect:/index";
//    }
//
//
//    /**
//     * 前台个人中心
//     */
//    @RequestMapping(value = "/index/center")
//    public String center(HttpServletRequest request, HttpServletResponse response) {
//        Preuser pu=(Preuser)request.getSession().getAttribute("indexUser");
//        if(pu==null){
//            return "pre/login";
//        }
//        return "pre/center";
//    }
//    /**
//     * 前台个人中心修改信息
//     */
//    @RequestMapping(value = "/index/center2")
//    public String update(HttpServletRequest request, Preuser record, ModelMap model, @RequestParam("file") MultipartFile file) {
//        if (file.getSize() != 0) {
//            String url = "";
//
//            try {
//                String staticPath = request.getSession().getServletContext().getRealPath("static/dist/img/");
//                String fileName = file.getOriginalFilename();
//                String[] filestr = fileName.split("\\.");
//                String fileurl = System.currentTimeMillis() + "." + filestr[1];
//                java.io.File targetFile = new java.io.File(staticPath, fileurl);
//                file.transferTo(targetFile);
//                url = "http://localhost:" + request.getLocalPort() + request.getSession().getServletContext().getContextPath() + "/static/dist/img/" + fileurl;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            record.setPicurl(url);
//        }
//        preuserservice.update(record);
//        request.getSession().setAttribute("indexUser",record);
//        return "redirect:/index/center";
//    }
//



    /**
     * 后台首页
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "admin/index";
    }
    /**
     * 后台登录
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("u");
        String psw = request.getParameter("p");
        User u = userservice.login(username, psw);
        if (null == u) {
            if(request.getMethod().equals("POST")) {
                request.setAttribute("msg", "账号或密码错误");
            }
            return "admin/login";

        }
        if (u.getStatus().equals(1)) {
            request.setAttribute("msg", "账号已禁用");
            return "admin/login";

        }
        request.getSession().setAttribute("loginUser", u);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/login2")
    public String login2(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("u");
        String psw = request.getParameter("p");
        Preuser u = userservice.prelogin(username, psw);
        if (null == u) {
            if(request.getMethod().equals("POST")) {
                request.setAttribute("msg", "账号或密码错误");
            }
            return "admin/login2";

        }
        request.getSession().setAttribute("indexUser", u);

        return "redirect:/admin";
    }


    /**
     * 后台退出
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("indexUser");
        return "redirect:/admin";
    }

}
