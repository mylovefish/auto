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
                        <form role="form" class="form-horizontal"  action="<c:if test="${edit==true }">${path }/admin/juese/update</c:if><c:if test="${edit==false }">${path }/admin/juese/add</c:if><c:if test="${edit==null }">${path }/admin/juese/save</c:if>" method="post">
                            <input type="hidden" name="id" value="${record.id }">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="name">名称</label>
                                            <div class="col-sm-10">
                                            <input required type="text" class="form-control" <c:if test="${edit==false }">disabled</c:if> name="name" value="${record.name}" id="name" placeholder="名称">
                                            </div>
                                        </div>
                                        <div class="form-group-separator"></div>


                                <div class="has-error">
                                    <span class="help-block">${msg }</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <c:if test="${edit==false }"><a href="${path }/admin/juese" class="btn btn-gray btn-single">返回</a></c:if>
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
