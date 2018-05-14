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

            <table class="admin-cat">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>카테고리명</th>
                    <th>포스트 수</th>
                    <th>설명</th>
                    <th>삭제<input type="hidden" id="user_id" value="${authUser.id}"></th>
                </tr>
                </thead>
                <tbody id=cateList>

                </tbody>
            </table>

            <h4 class="n-c">새로운 카테고리 추가</h4>
            <table id="admin-cat-add">
                <tr>
                    <td class="t">카테고리명</td>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <td class="t">설명</td>
                    <td><input type="text" name="desc"></td>
                </tr>
                <tr>
                    <td class="s">&nbsp;</td>
                    <td><input id="btnAddCate" type="submit" value="카테고리 추가"></td>
                </tr>
            </table>

        </div>
    </div>

    <c:import url="/WEB-INF/views/includes/blog_footer.jsp"></c:import>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function () {
        var id = $("#user_id").val();
        var url = "${pageContext.request.contextPath }/" + id + "/admin/category/getList";
        $.ajax({
            url: url,
            type: "post",
            data: {id: id},

            dataType: "json",
            success: function (list) {
                for (var i = 0; i < list.length; i++) {
                    rander(list[i]);
                }
            }, error: function () {
                alert("통신 실패");
            }
        })
    })

    function rander(vo) {
        var str = "";
        str += "<tr id='"+vo.cateNo+"'>"
        str += "    <td>"+vo.cateNo+"</td>"
        str += "    <td>"+vo.cateName+"</td>"
        str += "    <td>"+vo.postCount+"</td>"
        str += "    <td>"+vo.description+"</td>"
        str += "    <td><img id='"+vo.cateNo+"' src='${pageContext.request.contextPath }/assets/images/delete.jpg'></td>"
        str += "</tr>"
        $("#cateList").prepend(str);
    }

    $("#btnAddCate").on("click",function () {
        var cateName = $("[name=name]").val();
        var description = $("[name=desc]").val();
        var id = $("#user_id").val();
        console.log(cateName);
        console.log(description);
        console.log(id);
        $.ajax({
            url:"${pageContext.request.contextPath }/"+id+"/admin/category/insert",
            type:"post",
            data:{cateName:cateName,description:description,id:id},

            dataType:"json",
            success:function (result) {
                rander(result);
            },error:function () {
                alert("통신 실패");
            }
        })
        $("[name=name]").val("");
        $("[name=desc]").val("");
    })

    $("#cateList").on("click","img",function () {
        var $this = $(this).attr("id");
        var id = $("#user_id").val();
        console.log("삭제버튼 클릭"+$this);
        $.ajax({
            url:"${pageContext.request.contextPath }/"+id+"/admin/category/delete",
            type:"post",
            data:{cateNo:$this},

            dataType:"json",
            success:function (result) {
                $("#"+result).remove();
            },error:function () {
                alert("카테고리에 포스트가 있어 삭제가 불가능합니다");
            }
        })
    })

</script>

</html>