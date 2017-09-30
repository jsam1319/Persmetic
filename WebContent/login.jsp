<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="css/custom.css" rel="stylesheet">

    <script src="js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

  <!-- 로그인 페이지 -->
  
     <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->
   
   <h3 style="text-align: center; margin: 70px; "><image src="../img/infor.png" width="50px"></image>
   등록된 정보가 일치하지 않습니다.</h3>
   
  

  <div class="div" align="center">
    <form name="loginForm" method="post" action="${pageContext.servletContext.contextPath}/customer/certify.leaf">
      <p>
        <strong>Id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </strong> <input
          type="text" name="ctm_id" id="ctm_id" size="" autocomplete="off" required>
      </p>
      <p>
        <strong>Passwd &nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;</strong> <input type="password"
           name="ctm_passwd" id="ctm_passwd" 
          maxlength="15"/>
      </p>
      <p>
        <button type="submit" class="btn btn-success">LOGIN</button>
      </p>

    </form>
  </div>

</body>
</html>