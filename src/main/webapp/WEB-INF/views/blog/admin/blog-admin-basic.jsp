<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JBlog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>

<div id="container">

    <c:import url="/WEB-INF/views/includes/blog_header.jsp"></c:import>


    <div id="wrapper">
        <div id="content" class="full-screen">
            <c:import url="/WEB-INF/views/includes/admin_menu.jsp"></c:import>

            <form action="${pageContext.request.contextPath }/${authUser.id}/blogupdate" method="post" enctype="multipart/form-data">
                <table class="admin-config">
                    <tr>
                        <td class="t">블로그 제목</td>
                        <td><input type="text" size="40" name="blogTitle" value="${map.blog.blogTitle}"></td>
                    </tr>
                    <tr>
                        <td class="t">로고이미지</td>
                        <td>
                            <c:if test="${map.blog.logoFile eq '/assets/images/spring-logo.jpg'}">
                                <img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
                            </c:if>
                            <c:if test="${map.blog.logoFile ne '/assets/images/spring-logo.jpg'}">
                                <img src="${pageContext.request.contextPath }/upload/${map.blog.logoFile}">
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td class="t">&nbsp;</td>
                        <td><input type="file" name="file"></td>
                    </tr>
                    <tr>
                        <td class="t">&nbsp;</td>
                        <td class="s"><input type="submit" value="기본설정 변경"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>


    <c:import url="/WEB-INF/views/includes/blog_footer.jsp"></c:import>

</div>
</body>

</html>