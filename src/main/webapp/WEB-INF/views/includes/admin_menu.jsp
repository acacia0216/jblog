<%--
  Created by IntelliJ IDEA.
  User: 차뉴라빠
  Date: 2018-05-10
  Time: 오전 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="admin-menu">
    <li class="selected"><a href="/jblog/${authUser.id}/admin/basic">기본설정</a></li>
    <li><a href="${pageContext.request.contextPath }/${authUser.id}/admin/category">카테고리</a></li>
    <li><a href="${pageContext.request.contextPath }/${authUser.id}/admin/writeform">글작성</a></li>
</ul>