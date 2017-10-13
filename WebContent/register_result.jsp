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
<title>회원가입 결과</title>
</head>
<body style="background-color: white">

     <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->
   
<div border="1px">
    <div align="center" style="margin: 90px" >
      <img src="../img/register.png" width="50px">
      <h3>회원가입이 완료되었습니다.</h3><br>
      <p>아이디 : ${customer.ctmId }</p>
      <p>이름 : ${customer.ctmName }</p>
      <p>이메일 : ${customer.ctmEmail }</p>
    </div>
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