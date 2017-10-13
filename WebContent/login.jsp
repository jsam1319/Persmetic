<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
<title>로그인 페이지</title>
</head>
<body>

     <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->
   
   
     <!-- 로그인 페이지 -->    
   <h3 style="text-align: center; margin: 60px; "><image src="../img/infor.png" width="50px"></image>
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


           <!-- FOOTER -->
       <jsp:include page="include/footer.jsp"></jsp:include>
    <!-- /.FOOTER -->
    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/modernizr.js"></script>
    <script src="js/bootstrap-hover-dropdown.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/front.js"></script>

</body>
</html>