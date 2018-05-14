<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 차뉴라빠
  Date: 2018-05-09
  Time: 오전 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 메인해더 -->
<a href="${pageContext.request.contextPath}/">
    <img class="logo" src="${pageContext.request.contextPath}/assets/images/logo.jpg">
</a>
<ul class="menu">
    <c:if test="${authUser eq null}">
        <!-- 로그인 전 메뉴 -->
        <li><a href="${pageContext.request.contextPath }/user/loginform">로그인</a></li>
        <li><a href="${pageContext.request.contextPath }/user/joinform">회원가입</a></li>
    </c:if>
    <c:if test="${authUser ne null}">
        <!-- 로그인 후 메뉴 -->
        <li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
        <li><a href="${pageContext.request.contextPath }/${authUser.id}">내블로그</a></li>
    </c:if>
</ul>