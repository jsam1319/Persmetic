<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="css/custom.css" rel="stylesheet">

    <script src="js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">

</head>
<script type="text/javascript">
window.onload = function(){

	

document.getElementById("button").onclick = function(){	

	if($("input:checkbox[name=warm]:checked").length > $("input:checkbox[name=cool]:checked").length){
		location.href="warm_result.jsp";

	}else if ($("input:checkbox[name=cool]:checked").length > $("input:checkbox[name=warm]:checked").length){
		location.href="cool_result.jsp";

	}else{
		  $("#question").show();
	}
	
}
}



</script>

<body style="background-color:#FBF8EF">
   <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->

   

        <div style="background-color:#FBF8EF" id="question">
        
            <div class="container" >

                <div class="container" style="width:960px" >
                
                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li><a href="color_check.leaf">퍼스널컬러 Self-Test</a></li>
                    </ul>
                </div>

            
              <div class="container" style="width:960px">

                    <div class="box">


 
 <div style="text-align: center; margin: 130px">

 <p><h1>Personal Color Self-Test</h1></p>
 <br>
  <h4 style="color: #FE642E">평소에 여러분과 잘 어울리는 색에 가까운 컬러 팔레트는 어떤 것인가요?</h4>
 <h4 style="color: #FE642E">컬러 팔레트로 여러분의 퍼스널 컬러를 찾아보세요!</h4>
 <h4 style="color: #FE642E">스크롤 바를 내려서 몇가지 테스트를 해 보세요!</h4>
 <h4 style="color: #FE642E">(해당사항에 체크하세요!)</h4>
 </div>
                             
 <div style="text-align: center; padding-bottom: 100px" >
 <image src="../img/bg11.png" width="550x" style="margin: 100px;" ></image>

</div>


  <div style="text-align: center; padding-bottom: 190px">
 <p><image src="../img/color2.PNG" width="600px"></image></p>
 <p><font size="4pt" color="#B40486">코랄vs핑크 , 나에게 딱! 맞는 립컬러는 무엇?</font></p>
 <label for="coral"><input type="checkbox" name="warm" id="coral"><font color="#FE2E64" size="3pt">코랄계열(Coral Base)</font> </label>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <label for="pink"><input type="checkbox" name="cool" id="pink"><font color="#DF01D7" size="3pt">핑크계열(Pink Base)</font></label> 
 </div>
 
   <div style="text-align: center; padding-bottom: 200px">
 <p><image src="../img/color3.PNG" width="600px"></image></p>
  <p><font size="4pt" color="#B40486">갈색vs검은색 , 나에게 딱! 맞는 헤어컬러는 무엇?</font></p>
 <label for="bronzeHair"><input type="checkbox" name="warm" id="bronzeHair"><font color="#DF7401" size="3pt">Bronze Hair</font></label> 
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <label for="blackHair"><input type="checkbox" name="cool" id="blackHair"><font color="black" size="3pt">Black Hair</font></label>
 </div>
 
  <div style="text-align: center; padding-bottom: 200px">
 <p><image src="../img/color4.PNG" width="600px"></image></p>
   <p><font size="4pt" color="#B40486">골드vs실버 , 나에게 딱! 맞는 액세서리 컬러는 무엇?</font></p>
 <label for="gold"><input type="checkbox" name="warm" id="gold"><font color="#DBA901" size="3pt">Gold line</font></label>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <label for="silver"><input type="checkbox" name="cool" id="silver"><font color="#A4A4A4" size="3pt">Silver Line</font></label> 
 </div>
 
 <div style="text-align: center; padding-bottom: 200px">
 <p><image src="../img/color5.PNG" width="600px"></image></p>
 <p><font size="4pt" color="#B40486">밝은 갈색vs짙은갈색/검은색 , 내 눈동자 컬러는 무엇?</font></p>
 <label for="brownEyes"><input type="checkbox" name="warm" id="brownEyes"><font color="#B45F04" size="3pt">Light Brown</font></label> 
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label for="blackEyes"><input type="checkbox" name="cool" id="blackEyes"><font color="#3B0B0B" size="3pt"> Brown / Black</font></label>
 </div>

 <div style="text-align: center; padding-bottom: 150px">
 <p><image src="../img/color0.PNG" width="600px"></image></p>
  <p><font size="4pt" color="#B40486">나에게 어울리는 컬러는?</font></p>
<label for="pastel"><input type="checkbox" name="warm" id="pastel"><font color="#F79F81" size="3pt">따뜻한분위기의 파스텔톤</font></label> 
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label for="vivid"><input type="checkbox" name="cool" id="vivid"><font color="#0404B4" size="3pt">차가운분위기의 비비드톤</font></label>
 </div>
 
 <div style="text-align: center">
 <h3 style="color: #F78181"><p>선택한 결과로 자신의 퍼스널컬러를 찾아보세요! </p></h3>
 </div>
 <br>
 <br>
 <br>
 <br>
 <br>
 <div style="text-align: center">
 <input type="image" name="submit" id="button" src="../img/result.png" width="270px" style="margin: 20px; margin-left: 400px">
 </div>
               
                     
                    </div>
                </div>
                 
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
                            <li><a href="text.leaf">About us</a>
                            </li>
                            <li><a href="text.leaf">Terms and conditions</a>
                            </li>
                            <li><a href="faq.leaf">FAQ</a>
                            </li>
                            <li><a href="contact.leaf">Contact us</a>
                            </li>
                        </ul>

                        <hr>

                        <h4>User section</h4>

                        <ul>
                            <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                            </li>
                            <li><a href="register.leaf">Regiter</a>
                            </li>
                        </ul>

                        <hr class="hidden-md hidden-lg hidden-sm">

                    </div>
                    <!-- /.col-md-3 -->

                    <div class="col-md-3 col-sm-6">

                        <h4>Top categories</h4>

                        <h5>Men</h5>

                        <ul>
                            <li><a href="category.leaf">T-shirts</a>
                            </li>
                            <li><a href="category.leaf">Shirts</a>
                            </li>
                            <li><a href="category.leaf">Accessories</a>
                            </li>
                        </ul>

                        <h5>Ladies</h5>
                        <ul>
                            <li><a href="category.leaf">T-shirts</a>
                            </li>
                            <li><a href="category.leaf">Skirts</a>
                            </li>
                            <li><a href="category.leaf">Pants</a>
                            </li>
                            <li><a href="category.leaf">Accessories</a>
                            </li>
                        </ul>

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->

                    <div class="col-md-3 col-sm-6">

                        <h4>Where to find us</h4>

                        <p><strong>Obaju Ltd.</strong>
                            <br>13/25 New Avenue
                            <br>New Heaven
                            <br>45Y 73J
                            <br>England
                            <br>
                            <strong>Great Britain</strong>
                        </p>

                        <a href="contact.leaf">Go to contact page</a>

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->



                    <div class="col-md-3 col-sm-6">

                        <h4>Get the news</h4>

                        <p class="text-muted">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>

                        <form>
                            <div class="input-group">

                                <input type="text" class="form-control">

                                <span class="input-group-btn">

             <button class="btn btn-default" type="button">Subscribe!</button>

         </span>

                            </div>
                            <!-- /input-group -->
                        </form>

                        <hr>

                        <h4>Stay in touch</h4>

                        <p class="social">
                            <a href="#" class="facebook external" data-animate-hover="shake"><i class="fa fa-facebook"></i></a>
                            <a href="#" class="twitter external" data-animate-hover="shake"><i class="fa fa-twitter"></i></a>
                            <a href="#" class="instagram external" data-animate-hover="shake"><i class="fa fa-instagram"></i></a>
                            <a href="#" class="gplus external" data-animate-hover="shake"><i class="fa fa-google-plus"></i></a>
                            <a href="#" class="email external" data-animate-hover="shake"><i class="fa fa-envelope"></i></a>
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
                    <p class="pull-left">© 2015 Your name goes here.</p>

                </div>
                <div class="col-md-6">
                    <p class="pull-right">Template by <a href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a> & <a href="https://fity.cz">Fity</a>
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
    <script src="js/bootstrap.min.js">