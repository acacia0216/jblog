<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JBlog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
    <script type="text/javascript" src="/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>
<div class="center-content">

    <c:import url="/WEB-INF/views/includes/header.jsp"/>

    <form class="search-form" action="${pageContext.request.contextPath}/search" method="post">
        <fieldset>
            <input type="text" name="keyword"/>
            <input id="search" type="submit" value="검색"/>
        </fieldset>
        <fieldset>
            <input type="radio" name="which" value="blog-title"> <label>블로그 제목</label>
            <input type="radio" name="which" value="blog-user"> <label>블로거</label>
        </fieldset>
    </form>
</div>
<div style="width:100%;" align="center">
    <table>
        <tr>
            <c:if test="${map.blogList.length lt 1}">
                <c:forEach items="${map.userList}" var="i">
                    <td>${i.userName}</td>
                </c:forEach>
            </c:if>
            <c:if test="${map.userList.length lt 1}">
                <c:forEach items="${map.blogList}" var="i">
                    <td>${i.blogTitle}</td>
                </c:forEach>
            </c:if>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    $("#search").on("click", function () {
        var kwd = $("[name=keyword]").val();
        var which = $(":input:radio[name=which]:checked").val();
        console.log(which);
        if (!kwd) {
            alert("검색 내용을 입력해 주세요");
            return false;
        } else if (!which) {
            alert("검색할 분류를 선택해 주세요");
            return false;
        } else {
            return true;
        }
    })
</script>
</html>