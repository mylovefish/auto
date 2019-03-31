<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title></title>
    <jsp:include page="../common/static.jsp"></jsp:include>
</head>
<body class="page-body">
<jsp:include page="../common/profile.jsp"></jsp:include>
<div class="page-container">
    <jsp:include page="../common/menu.jsp"></jsp:include>
    <div class="main-content">
        <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="row">
            <div class="col-sm-12">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"></h3>
                        <div class="panel-options">
                            <a href="#" data-toggle="panel">
                                <span class="collapse-icon">&ndash;</span>
                                <span class="expand-icon">+</span>
                            </a>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form role="form" class="form-horizontal"  action="<c:if test="${edit==true }">${path }/admin/contact/update</c:if><c:if test="${edit==false }">${path }/admin/contact/add</c:if><c:if test="${edit==null }">${path }/admin/contact/save</c:if>" method="post">
                            <input type="hidden" name="id" value="${record.id }">
                            <input type="hidden" name="owner" value="${record.owner }">
                                        <div class="form-group">
                                           <label class="col-sm-2 control-label" for="contact">联系人</label>
                                            <div class="col-sm-10">
                                                <input required type="text" class="form-control " <c:if test="${edit==false }">disabled</c:if> name="contact" value="${record.contact}" id="contact" placeholder="联系人">
                                            </div>
                                        </div>
                                        <div class="form-group-separator"></div>


                                        <div class="form-group">
                                           <label class="col-sm-2 control-label" for="tel">联系电话</label>
                                            <div class="col-sm-10">
                                                <input required type="text" class="form-control " <c:if test="${edit==false }">disabled</c:if> name="tel" value="${record.tel}" id="tel" placeholder="联系电话">
                                            </div>
                                        </div>
                                        <div class="form-group-separator"></div>


                                        <div class="form-group">
                                           <label class="col-sm-2 control-label" for="bumen">部门</label>
                                            <div class="col-sm-10">
                                                <input required type="text" class="form-control " <c:if test="${edit==false }">disabled</c:if> name="bumen" value="${record.bumen}" id="bumen" placeholder="部门">
                                            </div>
                                        </div>
                                        <div class="form-group-separator"></div>


                                        <div class="form-group">
                                           <label class="col-sm-2 control-label" for="email">邮箱</label>
                                            <div class="col-sm-10">
                                                <input required type="text" class="form-control " <c:if test="${edit==false }">disabled</c:if> name="email" value="${record.email}" id="email" placeholder="邮箱">
                                            </div>
                                        </div>
                                        <div class="form-group-separator"></div>

<c:if test="${indexUser!=null&&loginUser==null}">
                            <input required type="hidden" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="type" value="1" id="type" >
                            </c:if>
<c:if test="${indexUser==null&&loginUser!=null}">

<input required type="hidden" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="type" value="0" id="type" >
                            </c:if>


                                        <div class="form-group-separator"></div>


                                <div class="has-error">
                                    <span class="help-block">${msg }</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <c:if test="${edit==false }"><a href="${path }/admin/contact" class="btn btn-gray btn-single">返回</a></c:if>
                                <c:if test="${edit==true || edit==null}"><button type="submit" class="btn btn-info btn-single pull-right">保存</button></c:if>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
    $(function () {
//Date picker

    });
</script>
</html>
