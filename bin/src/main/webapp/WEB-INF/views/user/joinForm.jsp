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
<div class="center-content">

    <c:import url="/WEB-INF/views/includes/header.jsp"/>

    <form class="join-form" id="join-form" method="post" action="/jblog/user/join">
        <label class="block-label" for="name">이름</label>
        <input type="text" name="userName" value=""/>

        <label class="block-label" for="id">아이디</label>
        <input type="text" name="id" value=""/>

        <input id="btn-checkid" type="button" value="id 중복체크">
        <p id="checkid-msg" class="form-error">
            &nbsp;
        </p>

        <label class="block-label" for="password">패스워드</label>
        <input type="password" name="password" value=""/>

        <fieldset>
            <legend>약관동의</legend>
            <label class="l-float"><input id="agree-prov" type="checkbox" name="agreeProv" value="y">
           서비스 약관에 동의합니다.</label>
        </fieldset>

        <input id="final" type="submit" value="가입하기">

    </form>
</div>

</body>

<script type="text/javascript">
    $("#btn-checkid").on("click", function () {
        var id = $("[name=id]").val();
        $.ajax({
            url: '/jblog/user/idcheck',
            type: 'post',
            data: {id: id},

            dataType: 'json',
            success: function (result) {
                if (result == true) {
                    $("#checkid-msg").html("<font color='red'>아이디 사용가능<font>");
                } else if (result == false) {
                    $("#checkid-msg").html("<font color='red'>다른 아이디를 입력해 주세요</font>");
                } else {
                    alert("에러, 다시 시도해 주세요");
                }
            }, error: function () {
                alert("통신실패");
            }
        })
    })

    $("#final").on("click", function () {
        var userName = $("[name=userName]").val();
        var id = $("[name=id]").val();
        var password = $("[name=password]").val();

        var agree = $("#agree-prov").is(":checked");
        if(!userName){
            alert("이름을 입력해주세요");
            return false;
        }else if(!id){
            alert("아이디를 입력해주세요");
            return false;
        }else if(!password){
            alert("비밀번호를 입력해주세요");
            return false;
        }else if (agree == false) {
            alert("약관 동의를 하셔야 회원가입이 가능합니다");
            return false;
        }else if(agree == true){
            return true;
        }
    })
</script>

</html>