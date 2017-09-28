<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
.button {
	width: 80;
	height: 60%;
	background-color: black;
	color: white;
	border: 0;
	outline: 0;
}
</style>

<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Obaju e-commerce template">
<meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
<meta name="keywords" content="">

<title>Obaju : e-commerce template</title>

<meta name="keywords" content="">

<link
  href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100'
  rel='stylesheet' type='text/css'>

<!-- styles -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.theme.css" rel="stylesheet">

<!-- theme stylesheet -->
<link href="css/style.default.css" rel="stylesheet"
  id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="css/custom.css" rel="stylesheet">

<script src="js/respond.min.js"></script>


<link rel="shortcut icon" href="favicon.png">

<script>

window.onload = function(){
	document.getElementById("btnSubmit").onclick = function(){
		
		if($("#ctm_name").val().trim() == ""){
		      $("#nameCheck").html("");
		      
		 }	
		if($("#ctm_passwd").val().trim() == ""){
			 $("#pwCheck").html("");
		      return false;			
		}
		if($("#checkPw").val().trim() == ""){
			 $("#repwCheck").html("");
		      return false;			
		}
		if($("#checkPw").val().trim() != $("#ctm_passwd").val().trim()  ){
			 $("#repwCheck").html("비밀번호가 일치하지 않습니다.");
		}else{
				 $("#repwCheck").html(""); 
   					
		}
		if($("#ctm_email").val().trim() == ""){
			 $("#emailCheck").html("");
		      return false;			
		}
		if($("#ctm_age").val().trim() == ""){
			 $("#ageCheck").html("");
		      return false;			
		}
		if($("#ctm_gender").val().trim() == '선택'){
			 $("#genderCheck").html("성별을 선택하세요.");
		      return false;			
		}
		if($("#ctm_job").val().trim() == '선택'){
			 $("#jobCheck").html("직업을 선택하세요.");
		      return false;			
		}
		if($("#ctm_address").val().trim() == ""){
			 $("#addressCheck").html("");
		      return false;			
		}
	}

	document.getElementById("btnId").onclick = function() {
		var id = document.getElementById("ctm_id")[0].value;
		
		ajax({
			method: "get",
			url: "regist_check.jsp",
			param: "ctm_id="+id,
			success: receiveMessage
		});
	}
	
	
	console.log($("#btnSubmit"));
	
}

	
	

function receiveMessage(request){
	var message = request.responseText;
	var check = document.getElementById("IDcheck");
	check.innerHTML = message;
}







/**
	//회원가입 입력값들 검사
	window.onload = function() {
		btnSubmit.onclick = function() {

			var form = document.userInfo;

			if (!form.ctm_id.value) {
				alert("아이디를 입력하세요.");
				return false;
			}
			if (!form.ctm_name.value) {
				alert("이름을 입력하세요.");
				return false;
			}
			if (!form.ctm_passwd.value) {
				alert("비밀번호를 입력하세요.");
				return false;
			}
			if (!form.checkPw.value) {
				alert("비밀번호를 다시한번 입력하세요.");
				return false;
			}

			// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
			if (form.ctm_passwd.value != form.checkPw.value) {
				alert("비밀번호를 동일하게 입력하세요.");
				return false;
			}

			if (!form.ctm_email.value) {
				alert("이메일을 입력하세요.");
				return false;
			}
			if (!form.ctm_age.value) {
				alert("나이를 입력하세요.");
				return false;
			}
			
			if(form.ctm_gender.value.trim() == '선택') {
				alert("성별을 선택하세요");
				return false;
			}
			if(form.ctm_job.value.trim() == '선택') {
				alert("직업을 선택하세요");
				return false;
			}
			if (!form.ctm_address.value) {
				alert("주소를 입력하세요.");
				return false;
			}
		
		}

	}
	**/
/**
	
	 function goFirstForm() {
         location.href="index.leaf";
     } 
	  // 아이디 중복체크 화면open
     function openIdChk(){
     
         window.name = "parentForm";
         window.open("member/IdCheckForm.jsp",
                 "chkForm", "width=500, height=300, resizable = no, scrollbars = no");    
     }

     // 다시 중복체크를 하도록 한다.
     function inputIdChk(){
         document.userInfo.idDuplication.value ="idUncheck";
     }
     
     function idCheck(){

       var user_id = form.id.value;
       var url="../user/check_id.jsp?id=" + user_id;
       wo = window.open(url, "IdCheck", "toolbar=no, width=350, height=150, top=150, left=150");
       wo.moveTo(x,y);
       return;
    }
**/

</script>
</head>

<body>
  <!-- *** TOPBAR ***
 _________________________________________________________ -->
  <div id="top">
    <div class="container">
      <div class="col-md-6 offer" data-animate="fadeInDown">
        <a href="#" class="btn btn-success btn-sm"
          data-animate-hover="shake">Offer of the day</a> <a href="#">Get
          flat 35% off on orders over $50!</a>
      </div>
      <div class="col-md-6" data-animate="fadeInDown">
        <ul class="menu">
          <li><a href="#" data-toggle="modal"
            data-target="#login-modal">Login</a></li>
          <li><a href="register.leaf">Register</a></li>
          <li><a href="contact.leaf">Contact</a></li>
          <li><a href="#">Recently viewed</a></li>
        </ul>
      </div>
    </div>
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
      aria-labelledby="Login" aria-hidden="true">
      <div class="modal-dialog modal-sm">

        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
              aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="Login">Customer login</h4>
          </div>
          <div class="modal-body">
            <form action="customer-orders.leaf" method="post">
              <div class="form-group">
                <input type="text" class="form-control" id="email-modal"
                  placeholder="email">
              </div>
              <div class="form-group">
                <input type="password" class="form-control"
                  id="password-modal" placeholder="password">
              </div>

              <p class="text-center">
                <button class="btn btn-primary">
                  <i class="fa fa-sign-in"></i> Log in
                </button>
              </p>

            </form>

            <p class="text-center text-muted">Not registered yet?</p>
            <p class="text-center text-muted">
              <a href="register.leaf"><strong>Register now</strong></a>!
              It is easy and done in 1&nbsp;minute and gives you access
              to special discounts and much more!
            </p>

          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- *** TOP BAR END *** -->

  <!-- *** NAVBAR ***
 _________________________________________________________ -->

  <div class="navbar navbar-default yamm" role="navigation" id="navbar">
    <div class="container">
      <div class="navbar-header">

        <a class="navbar-brand home" href="index.leaf"
          data-animate-hover="bounce"> <img src="img/logo.png"
          alt="Obaju logo" class="hidden-xs"> <img
          src="img/logo-small.png" alt="Obaju logo" class="visible-xs"><span
          class="sr-only">Obaju - go to homepage</span>
        </a>
        <div class="navbar-buttons">
          <button type="button" class="navbar-toggle"
            data-toggle="collapse" data-target="#navigation">
            <span class="sr-only">Toggle navigation</span> <i
              class="fa fa-align-justify"></i>
          </button>
          <button type="button" class="navbar-toggle"
            data-toggle="collapse" data-target="#search">
            <span class="sr-only">Toggle search</span> <i
              class="fa fa-search"></i>
          </button>
          <a class="btn btn-default navbar-toggle" href="basket.leaf">
            <i class="fa fa-shopping-cart"></i> <span class="hidden-xs">3
              items in cart</span>
          </a>
        </div>
      </div>
      <!--/.navbar-header -->

      <div class="navbar-collapse collapse" id="navigation">

        <ul class="nav navbar-nav navbar-left">
          <li class="active"><a href="index.leaf">Home</a></li>
          <li class="dropdown yamm-fw"><a href="#"
            class="dropdown-toggle" data-toggle="dropdown"
            data-hover="dropdown" data-delay="200">Men <b
              class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <div class="yamm-content">
                  <div class="row">
                    <div class="col-sm-3">
                      <h5>Clothing</h5>
                      <ul>
                        <li><a href="category.leaf">T-shirts</a></li>
                        <li><a href="category.leaf">Shirts</a></li>
                        <li><a href="category.leaf">Pants</a></li>
                        <li><a href="category.leaf">Accessories</a>
                        </li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>Shoes</h5>
                      <ul>
                        <li><a href="category.leaf">Trainers</a></li>
                        <li><a href="category.leaf">Sandals</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                        <li><a href="category.leaf">Casual</a></li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>Accessories</h5>
                      <ul>
                        <li><a href="category.leaf">Trainers</a></li>
                        <li><a href="category.leaf">Sandals</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                        <li><a href="category.leaf">Casual</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                        <li><a href="category.leaf">Casual</a></li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>Featured</h5>
                      <ul>
                        <li><a href="category.leaf">Trainers</a></li>
                        <li><a href="category.leaf">Sandals</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                      </ul>
                      <h5>Looks and trends</h5>
                      <ul>
                        <li><a href="category.leaf">Trainers</a></li>
                        <li><a href="category.leaf">Sandals</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                      </ul>
                    </div>
                  </div>
                </div> <!-- /.yamm-content -->
              </li>
            </ul></li>

          <li class="dropdown yamm-fw"><a href="#"
            class="dropdown-toggle" data-toggle="dropdown"
            data-hover="dropdown" data-delay="200">Ladies <b
              class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <div class="yamm-content">
                  <div class="row">
                    <div class="col-sm-3">
                      <h5>Clothing</h5>
                      <ul>
                        <li><a href="category.leaf">T-shirts</a></li>
                        <li><a href="category.leaf">Shirts</a></li>
                        <li><a href="category.leaf">Pants</a></li>
                        <li><a href="category.leaf">Accessories</a>
                        </li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>Shoes</h5>
                      <ul>
                        <li><a href="category.leaf">Trainers</a></li>
                        <li><a href="category.leaf">Sandals</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                        <li><a href="category.leaf">Casual</a></li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>Accessories</h5>
                      <ul>
                        <li><a href="category.leaf">Trainers</a></li>
                        <li><a href="category.leaf">Sandals</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                        <li><a href="category.leaf">Casual</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                        <li><a href="category.leaf">Casual</a></li>
                      </ul>
                      <h5>Looks and trends</h5>
                      <ul>
                        <li><a href="category.leaf">Trainers</a></li>
                        <li><a href="category.leaf">Sandals</a></li>
                        <li><a href="category.leaf">Hiking
                            shoes</a></li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <div class="banner">
                        <a href="#"> <img src="img/banner.jpg"
                          class="img img-responsive" alt="">
                        </a>
                      </div>
                      <div class="banner">
                        <a href="#"> <img src="img/banner2.jpg"
                          class="img img-responsive" alt="">
                        </a>
                      </div>
                    </div>
                  </div>
                </div> <!-- /.yamm-content -->
              </li>
            </ul></li>

          <li class="dropdown yamm-fw"><a href="#"
            class="dropdown-toggle" data-toggle="dropdown"
            data-hover="dropdown" data-delay="200">Template <b
              class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <div class="yamm-content">
                  <div class="row">
                    <div class="col-sm-3">
                      <h5>Shop</h5>
                      <ul>
                        <li><a href="index.leaf">Homepage</a></li>
                        <li><a href="category.leaf">Category -
                            sidebar left</a></li>
                        <li><a href="category-right.leaf">Category
                            - sidebar right</a></li>
                        <li><a href="category-full.leaf">Category
                            - full width</a></li>
                        <li><a href="detail.leaf">Product
                            detail</a></li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>User</h5>
                      <ul>
                        <li><a href="register.leaf">Register /
                            login</a></li>
                        <li><a href="customer-orders.leaf">Orders
                            history</a></li>
                        <li><a href="customer-order.leaf">Order
                            history detail</a></li>
                        <li><a href="customer-wishlist.leaf">Wishlist</a>
                        </li>
                        <li><a href="customer-account.leaf">Customer
                            account / change password</a></li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>Order process</h5>
                      <ul>
                        <li><a href="basket.leaf">Shopping cart</a>
                        </li>
                        <li><a href="checkout1.leaf">Checkout -
                            step 1</a></li>
                        <li><a href="checkout2.leaf">Checkout -
                            step 2</a></li>
                        <li><a href="checkout3.leaf">Checkout -
                            step 3</a></li>
                        <li><a href="checkout4.leaf">Checkout -
                            step 4</a></li>
                      </ul>
                    </div>
                    <div class="col-sm-3">
                      <h5>Pages and blog</h5>
                      <ul>
                        <li><a href="blog.leaf">Blog listing</a></li>
                        <li><a href="post.leaf">Blog Post</a></li>
                        <li><a href="faq.leaf">FAQ</a></li>
                        <li><a href="text.leaf">Text page</a></li>
                        <li><a href="text-right.leaf">Text page
                            - right sidebar</a></li>
                        <li><a href="404.leaf">404 page</a></li>
                        <li><a href="contact.leaf">Contact</a></li>
                      </ul>
                    </div>
                  </div>
                </div> <!-- /.yamm-content -->
              </li>
            </ul></li>
        </ul>

      </div>
      <!--/.nav-collapse -->

      <div class="navbar-buttons">

        <div class="navbar-collapse collapse right" id="basket-overview">
          <a href="basket.leaf" class="btn btn-primary navbar-btn"><i
            class="fa fa-shopping-cart"></i><span class="hidden-sm">3
              items in cart</span></a>
        </div>
        <!--/.nav-collapse -->

        <div class="navbar-collapse collapse right"
          id="search-not-mobile">
          <button type="button" class="btn navbar-btn btn-primary"
            data-toggle="collapse" data-target="#search">
            <span class="sr-only">Toggle search</span> <i
              class="fa fa-search"></i>
          </button>
        </div>

      </div>

      <div class="collapse clearfix" id="search">

        <form class="navbar-form" role="search">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Search">
            <span class="input-group-btn">

              <button type="submit" class="btn btn-primary">
                <i class="fa fa-search"></i>
              </button>

            </span>
          </div>
        </form>

      </div>
      <!--/.nav-collapse -->

    </div>
    <!-- /.container -->
  </div>
  <!-- /#navbar -->

  <!-- *** NAVBAR END *** -->

  <div id="all">

    <div id="content">
      <div class="container">

        <div class="col-md-12">

          <ul class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li>New account / Sign in</li>
          </ul>

        </div>

        <div class="col-md-7 col-md-offset-3">
          <div class="box">
            <h2>Persmetic Sign Up</h2>

            <hr>

            <form action="customer-orders.leaf" method="post"
              name="userInfo">
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">아이디</label> <input
                  type="text" id="ctm_id" class="form-control"
                   style="width: 250px" placeholder="아이디를 입력하세요."/>  <button
                 id="btnId" class="button" style="width: 80px; height: 30px"
                 >중복확인</button><span id="IDcheck"></span> <input type="hidden"
                  name="idDuplication" value="idUncheck">
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">이름</label> <input
                  type="text" id="ctm_name" class="form-control"
                  style="width: 250px"  placeholder="이름을 입력하세요." />
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">비밀번호</label> <input
                  type="password" id="ctm_passwd" class="form-control"
                  style="width: 250px" placeholder="비밀번호를 입력하세요." />
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">비밀번호 확인</label> <input
                  type="password" id="checkPw" class="form-control"
                  style="width: 250px" placeholder="비밀번호를 다시한번 입력하세요." /><span id="repwCheck"></span>
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">이메일</label> <input
                  type="text" id="ctm_email" class="form-control"
                  style="width: 250px" placeholder="이메일을 입력하세요." />
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">나이</label> <input
                  type="text" id="ctm_age" class="form-control"
                  style="width: 250px" placeholder="나이를 입력하세요."/>
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">성별</label> <select
                  id="ctm_gender">
                  <option id="genderChoice">선택</option>
                  <option id="M">남성</option>
                  <option id="F">여성</option>
                </select><span id="genderCheck"></span>
              </div>
              <div>
                <label style="width: 100px">직업</label> <select
                  id="ctm_job">
                  <option id="jobChoice">선택</option>
                  <option>회사원</option>
                  <option>강사</option>
                  <option>학생</option>
                  <option>기타</option>
                </select><span id="jobCheck"></span>
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">주소</label> <input
                  type="text" id="ctm_address" class="form-control"
                  style="width: 300px" placeholder="주소를 입력하세요." />&nbsp;&nbsp;
                  <span><input class="button" type="button" value="우편번호"
                  /></span>
              </div>

              <div class="text-center">
                <input class="button" type="submit" value="가입하기"
                  id="btnSubmit" /> <input class="button"
                  type="button" value="취소" onclick="goFirstForm()">
              </div>
            </form>
          </div>
        </div>


      </div>


    </div>
    <!-- /.container -->
  </div>
  <!-- /#content -->


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