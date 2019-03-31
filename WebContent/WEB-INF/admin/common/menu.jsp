<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<div class="sidebar-menu toggle-others fixed">

    <div class="sidebar-menu-inner">

        <header class="logo-env">

            <!-- logo -->
            <div class="logo">
                <a href="${path}/admin" class="logo-expanded">
                </a>

                <a href="${path}/admin" class="logo-collapsed">
                </a>
            </div>

            <!-- This will toggle the mobile menu and will be visible only on mobile devices -->
            <div class="mobile-menu-toggle visible-xs">
                <a href="#" data-toggle="user-info-menu">
                    <i class="fa-bell-o"></i>
                    <span class="badge badge-success">7</span>
                </a>

                <a href="#" data-toggle="mobile-menu">
                    <i class="fa-bars"></i>
                </a>
            </div>

            <!-- This will open the popup with user profile settings, you can use for any purpose, just be creative -->
            <div class="settings-icon">
                <a href="#" data-toggle="settings-pane" data-animate="true">
                </a>
            </div>


        </header>


        <ul id="main-menu" class="main-menu">
            <!-- add class "multiple-expanded" to allow multiple submenus to open -->
            <!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
<c:if test="${loginUser!=null && indexUser==null}">

            <c:forEach items="${menu }" var="m">

                <li class="<c:if test="${main==m.id}">active</c:if><c:if test="${url!=null&&m.code==url }">active</c:if> <c:if test="${!empty m.childs}">treeview <c:if test="${main==m.id}" > opened </c:if> </c:if>">
                    <a href="${path}${m.code}">
                        <i class="linecons-desktop"></i>
                        <span class="title">${m.title }</span>
                    </a>

                    <c:if test="${!empty m.childs}">
                        <ul>
                            <c:forEach items="${m.childs }" var="cm">
                                <li class="<c:if test="${cm.code==url }">active</c:if>"><a
                                        href="${path}${cm.code }"><span class="title">${cm.title }</span></a></li>
                            </c:forEach>
                        </ul>

                    </c:if>
                </li>

            </c:forEach>

</c:if>
<c:if test="${indexUser!=null }">
    <li>
        <a href="${path}/admin/preuser/edit?id=${indexUser.id}">
            <i class="linecons-desktop"></i>
            <span class="title">个人信息</span>
        </a>

    </li>
    <li>
        <a href="${path}/admin/contact?owner=${indexUser.id}">
            <i class="linecons-desktop"></i>
            <span class="title">通讯录</span>
        </a>

    </li>    <li>
    <a href="${path}/admin/notice">
        <i class="linecons-desktop"></i>
        <span class="title">公告</span>
    </a>

</li>    <li>
    <a href="${path}/admin/comment">
        <i class="linecons-desktop"></i>
        <span class="title">留言板</span>
    </a>

</li>    <li>
    <a href="${path}/admin/plan?preuserid=${indexUser.id}">
        <i class="linecons-desktop"></i>
        <span class="title">日程安排</span>
    </a>

</li>    <li class="treeview">
    <a href="${path}/admin/msg?preuserid=${indexUser.id}">
        <i class="linecons-desktop"></i>
        <span class="title">消息提醒</span>
    </a>

</li>    <li>
    <a href="">
        <i class="linecons-desktop"></i>
        <span class="title">会议管理</span>
    </a>
    <ul>
        <li class=""><a
                href="${path}/admin/meeting?preuserid=${indexUser.id}"><span class="title">我的会议</span></a></li>
        <li class=""><a
                href="${path}/admin/meetuser/page?preuserid=${indexUser.id}"><span class="title">参与会议</span></a></li>
    </ul>
</li>
    <li>
        <a href="${path}/admin/a/reset?id=${loginUser.id}">
            <i class="linecons-desktop"></i>
            <span class="title">组织管理</span>
        </a>
        <ul>
                <li class=""><a
                        href="${path}/admin/apartment"><span class="title">部门管理</span></a></li>
            <li class=""><a
                    href="${path}/admin/juese"><span class="title">角色管理</span></a></li>
        </ul>

    </li>
</c:if>

</ul>


    </div>

</div>




