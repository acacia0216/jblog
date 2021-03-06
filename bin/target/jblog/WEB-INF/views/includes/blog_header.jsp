<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 차뉴라빠
  Date: 2018-05-10
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 블로그 해더 -->
<div id="header">
    <h1><a href="/jblog/${map.blog.id}">${map.blog.blogTitle}</a></h1>
    <ul>
        <c:if test="${authUser eq null}">
            <!-- 로그인 전 메뉴 -->
            <li><a href="/jblog/user/loginform">로그인</a></li>
        </c:if>
        <c:if test="${authUser ne null}">
            <%--로그인 후 메뉴--%>
            <li><a href="/jblog/user/logout">로그아웃</a></li>
            <c:if test="${authUser.id eq map.blog.id}">
                <li><a href="/jblog/${map.blog.id}/admin/basic">내블로그 관리</a></li>
            </c:if>
        </c:if>
    </ul>
</div>