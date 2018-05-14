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
            <input type="text" name="keyword" value="${map.keyword}"/>
            <input id="search" type="submit" value="검색"/>
        </fieldset>
        <fieldset>
            <label><input type="radio" name="which" value="blog-title" checked="checked"> 블로그 제목</label>
            <label><input type="radio" name="which" value="blog-user"> 블로거</label>
        </fieldset>
    </form>
</div>
<div style="width:100%;" align="center">
    <table>
            <c:if test="${empty map.blogList and empty map.userList}">
                <tr>
                    <td id="emptycheck" align="center" style="font-size: xx-large">검색 결과가 없습니다.</td>
                </tr>
        </c:if>
        <c:if test="${!empty map.blogList}">
            <c:forEach items="${map.blogList}" var="i">
                <tr>
                    <td align="center" style="border:3px #437aff solid; padding:15px; font-size: xx-large"><a
                            href="${pageContext.request.contextPath}/${i.id}">${i.blogTitle} 에 놀러가기</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${!empty map.userList}">
            <c:forEach items="${map.userList}" var="i">
                <tr>
                    <td align="center" style="border:3px #437aff solid; padding:15px; font-size: xx-large"><a
                            href="${pageContext.request.contextPath}/${i.id}">${i.id} 님의 블로그로 놀러가기</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        var keyword = $("[name=keyword]").val();
        if(keyword == ""){
            $("#emptycheck").remove();
        }
    })

    $("#search").on("click", function () {
        var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/gi;
        var kwd = $("[name=keyword]").val();
        var which = $(":input:radio[name=which]:checked").val();
        console.log(which);

        if(pattern3.test(kwd)){
            alert("검색시 특수문자 사용 금지");
            return false;
        }
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