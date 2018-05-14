<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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
        <div id="content">
            <div class="blog-content">

                <c:if test="${!empty map.post}">
                    <h3>${map.getPostOne.postTitle}</h3>
                    <div style="width:700px;">
                    <pre style="font-size: x-large; white-space: normal">${map.getPostOne.postContent}</pre>
                    </div>
                    <input type="hidden" name="postNo" value="${map.getPostOne.postNo}">
                    <input type="hidden" name="blogId" value="${map.blog.id}">
                    <input type="hidden" name="authId" value="${authUser.userno}">
                    <br>
                </c:if>

                <!-- 등록된 글이 없는경우 -->
                <c:if test="${empty map.post}">
                    <h4>등록된 글이 없습니다.</h4>
                    <p>
                    </p>
                </c:if>
                <p></p>
            </div>
            <c:if test="${authUser eq null}">
                <div align="center">로그인 하시면 댓글을 달 수 있습니다.</div>
            </c:if>
            <c:if test="${authUser ne null and !empty map.post}">
                <form action="/jblog/cmtpush" method="post">
                    <table style="border: 1px black solid; width:100%">
                        <tr>
                            <td align="center"
                                style="border: 1px black solid; width:10%; padding:5px;">${authUser.userName}</td>
                            <td style="border: 1px black solid; width:100%; padding:5px;">
                                <input type="text" name="comment" value="좋은 글 감사합니다." style="width:100%; border:none">
                            </td>
                            <td align="center" style="border: 1px black solid; width:10%; padding:5px;">
                                <input type="button" name="cmtPush" value="저장">
                            </td>
                        </tr>
                    </table>
                </form>
            </c:if>
            <br>

            <table id="cmt_list" style="border: 1px black solid; width:100%">

            </table>
            <table style="width:100%">
                <tr>
                    <td style="border:1px black solid; width:100%">
                        <ul class="blog-list">
                            <c:if test="${!empty map.post}">
                                <c:forEach items="${map.post}" var="i" begin="0" end="${map.postCount}">
                                    <li>
                                        <a href="/jblog/${map.blog.id}/mainPage?crtPage=${map.crtPage}&cateNo=${i.cateNo}&postNo=${i.postNo}">${i.postTitle}</a>
                                        <span>${i.regdate}</span>
                                    </li>
                                </c:forEach>
                            </c:if>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td align="center">

                        <%--페이징자리--%>
                        <%--if문 처리--%>
                        <c:if test="${map.prev eq true}">
                            <a href="/jblog/${map.blog.id}/mainPage/?crtPage=${map.startPageBtnNo-1}&cateNo=${map.getPostOne.cateNo}&postNo=${map.getPostOne.postNo}">◀</a>
                        </c:if>

                        <%--반복문 시작--%>
                        <c:forEach var="pageNo" begin="${map.startPageBtnNo}" end="${map.endPageBtnNo}">
                            <a href="/jblog/${map.blog.id}/mainPage/?crtPage=${pageNo}&cateNo=${map.getPostOne.cateNo}&postNo=${map.getPostOne.postNo}">${pageNo}</a>
                            <%--반복문 끝--%>
                        </c:forEach>

                        <%--if문 처리--%>
                            <c:if test="${map.next eq true}">
                        <a href="/jblog/${map.blog.id}/mainPage/?crtPage=${map.endPageBtnNo+1}&cateNo=${map.getPostOne.cateNo}&postNo=${map.getPostOne.postNo}">▶</a>
                            </c:if>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div id="extra">
        <div class="blog-logo">
            <c:if test="${map.blog.logoFile eq '/assets/images/spring-logo.jpg'}">
                <img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
            </c:if>
            <c:if test="${map.blog.logoFile ne '/assets/images/spring-logo.jpg'}">
            <img src="/upload/${map.blog.logoFile}">
            </c:if>
        </div>
        <div id="navigation">
            <h2>카테고리</h2>
            <ul>
                <c:forEach items="${map.category}" var="i">
                    <c:if test="${i.cateNo eq cateNo}">
                        <li><strong><a href="/jblog/${map.blog.id}/mainPage?cateNo=${i.cateNo}&postNo=0"
                                       style="font-size: large">${i.cateName}</a></strong></li>
                    </c:if>
                    <c:if test="${i.cateNo ne cateNo}">
                        <li><a href="/jblog/${map.blog.id}/mainPage?cateNo=${i.cateNo}&postNo=0">${i.cateName}</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>


    <c:import url="/WEB-INF/views/includes/blog_footer.jsp"></c:import>

</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        var postNo = $("[name=postNo]").val();
        var authId = $("[name=authId]").val();
        console.log(authId);
        $.ajax({
            url: "/jblog/getCmt",
            type: "post",
            data: {postNo: postNo},

            dataType: "json",
            success: function (cmtList) {
                console.log("갔다왔을듯?");
                console.log(cmtList);
                console.log(cmtList.length);
                for (var i = 0; i < cmtList.length; i++) {
                    if (cmtList[i].userNo == authId) {
                        rander1(cmtList[i]);
                        console.log(cmtList);
                    } else if (cmtList[i].userNo != authId) {
                        rander2(cmtList[i]);
                        console.log(cmtList);
                    } else{
                        $("#cmt_list").prepend("아직 등록된 포스트가 없습니다.");
                    }
                }
            }, error: function () {
                // alert("시작 통신 실패");
                $("#cmt_list").html("<font>아직 등록된 포스트가 없습니다.</font>");
            }
        })
    })

    function rander1(cmt) {
        var str = "";
        str += "<tr id='" + cmt.cmtNo + "'>"
        str += "    <td align='center' style='border: 1px black solid; width:10%; padding:5px;'>" + cmt.userName + "</td>"
        str += "    <td style='border: 1px black solid; width:65%; padding:5px;><pre style='font-size: 13px; white-space: normal'>" + cmt.cmtContent + "</pre></td>"
        str += "    <td align='center' style='border: 1px black solid; width:20%; padding:5px;'>" + cmt.regdate + "</td>"
        str += "    <td align='center' style='border: 1px black solid; width:5%; padding:5px;'><img src='/assets/images/delete.jpg' id='" + cmt.cmtNo + "'></td>"
        str += "</tr>"
        $("#cmt_list").prepend(str);
    }

    function rander2(cmt) {
        var str = "";
        str += "<tr id='" + cmt.cmtNo + "'>"
        str += "    <td align='center' style='border: 1px black solid; width:10%; padding:5px;'>" + cmt.userName + "</td>"
        str += "    <td style='border: 1px black solid; width:65%; padding:5px;'><pre style='font-size: 13px; white-space: normal'>" + cmt.cmtContent + "</pre></td>"
        str += "    <td align='center' style='border: 1px black solid; width:20%; padding:5px;'>" + cmt.regdate + "</td>"
        str += "    <td align='center' style='border: 1px black solid; width:5%; padding:5px;'></td>"
        str += "</tr>"
        $("#cmt_list").prepend(str);
    }

    $("[name=cmtPush]").on("click", function () {
        event.preventDefault();
        var comment = $("[name=comment]").val();
        var userNo = $("[name=authId]").val();
        var postNo = $("[name=postNo]").val();
        console.log(comment);
        console.log(userNo);
        console.log(postNo);
        $.ajax({
            url: "/jblog/addcmt",
            type: "post",
            data: {cmtContent: comment, userNo: userNo, postNo: postNo},

            dataType: "json",
            success: function (cmt) {
                console.log(cmt.length);
                rander1(cmt);
            }, error: function (XHR, status, error) {
                console.error(status + " " + error);
                alert("입력 통신 실패");
            }
        })
        $("[name=comment]").val("좋은 글 감사합니다.");
    })

    $("#cmt_list").on("click", "img", function () {
        var $this = $(this).attr("id");
        console.log($this);
        $.ajax({
            url: "/jblog/delcmt",
            type: "post",
            data: {cmtNo: $this},

            dataType: "json",
            success: function (result) {
                $("#" + result).remove();
            }, error: function (XHR, status, error) {
                console.error(status + " " + error);
                alert("삭제 통신 실패");
            }
        })
    })
    $("[name=comment]").on("click", function () {
        $("[name=comment]").val("");
    })
    $("[name=comment]").on("blur", function () {
        var comment = $("[name=comment]").val();
        if (comment == "") {
            $("[name=comment]").val("좋은 글 감사합니다.");
        }
    })
</script>
</html>