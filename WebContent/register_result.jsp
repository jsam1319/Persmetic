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
   
<div border="1px">
    <div align="center" style="margin: 90px" >
      <img src="../img/register.png" width="50px">
      <h3>회원가입이 완료되었습니다.</h3><br>
      <p>아이디 : ${customer.ctmId }</p>
      <p>이름 : ${customer.ctmName }</p>
      <p>이메일 : ${customer.ctmEmail }</p>
    </div>
  </div>
  
    <!-- *** FOOTER ***
 _________________________________________________________ -->
  <div id="footer" data-animate="fadeInUp">
    <div class="container">
      <div class="row">
        <div class="col-md-3 col-sm-6">
          <h4>Pages</h4>

          <ul>
            <li><a href="text.leaf">About us</a></li>
            <li><a href="text.leaf">Terms and conditions</a></li>
            <li><a href="faq.leaf">FAQ</a></li>
            <li><a href="contact.leaf">Contact us</a></li>
          </ul>

          <hr>

          <h4>User section</h4>

          <ul>
            <li><a href="#" data-toggle="modal"
              data-target="#login-modal">Login</a></li>
            <li><a href="register.leaf">Regiter</a></li>
          </ul>

          <hr class="hidden-md hidden-lg hidden-sm">

        </div>
        <!-- /.col-md-3 -->

        <div class="col-md-3 col-sm-6">

          <h4>Top categories</h4>

          <h5>Men</h5>

          <ul>
            <li><a href="category.leaf">T-shirts</a></li>
            <li><a href="category.leaf">Shirts</a></li>
            <li><a href="category.leaf">Accessories</a></li>
          </ul>

          <h5>Ladies</h5>
          <ul>
            <li><a href="category.leaf">T-shirts</a></li>
            <li><a href="category.leaf">Skirts</a></li>
            <li><a href="category.leaf">Pants</a></li>
            <li><a href="category.leaf">Accessories</a></li>
          </ul>

          <hr class="hidden-md hidden-lg">

        </div>
        <!-- /.col-md-3 -->

        <div class="col-md-3 col-sm-6">

          <h4>Where to find us</h4>

          <p>
            <strong>Obaju Ltd.</strong> <br>13/25 New Avenue <br>New
            Heaven <br>45Y 73J <br>England <br> <strong>Great
              Britain</strong>
          </p>

          <a href="contact.leaf">Go to contact page</a>

          <hr class="hidden-md hidden-lg">

        </div>
        <!-- /.col-md-3 -->



        <div class="col-md-3 col-sm-6">

          <h4>Get the news</h4>

          <p class="text-muted">Pellentesque habitant morbi
            tristique senectus et netus et malesuada fames ac turpis
            egestas.</p>

          <form>
            <div class="input-group">

              <input type="text" class="form-control"> <span
                class="input-group-btn">

                <button class="btn btn-default" type="button">Subscribe!</button>

              </span>

            </div>
            <!-- /input-group -->
          </form>

          <hr>

          <h4>Stay in touch</h4>

          <p class="social">
            <a href="#" class="facebook external"
              data-animate-hover="shake"><i class="fa fa-facebook"></i></a>
            <a href="#" class="twitter external"
              data-animate-hover="shake"><i class="fa fa-twitter"></i></a>
            <a href="#" class="instagram external"
              data-animate-hover="shake"><i class="fa fa-instagram"></i></a>
            <a href="#" class="gplus external"
              data-animate-hover="shake"><i
              class="fa fa-google-plus"></i></a> <a href="#"
              class="email external" data-animate-hover="shake"><i
              class="fa fa-envelope"></i></a>
          </p>


        </div>
        <!-- /.col-md-3 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
  </div>
  <!-- /#footer -->

  <!-- *** FOOTER END *** -->




  <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
  <div id="copyright">
    <div class="container">
      <div class="col-md-6">
        <p class="pull-left">Â© 2015 Your name goes here.</p>

      </div>
      <div class="col-md-6">
        <p class="pull-right">
          Template by <a
            href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a>
          & <a href="https://fity.cz">Fity</a>
          <!-- Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate  -->
        </p>
      </div>
    </div>
  </div>
  <!-- *** COPYRIGHT END *** -->



  </div>
  <!-- /#all -->




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