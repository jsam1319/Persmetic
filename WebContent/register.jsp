<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>회원가입 페이지</title>

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

<link rel="shortcut icon" href="favicon.png">

<!-- theme stylesheet -->
<link href="css/style.default.css" rel="stylesheet"
  id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="css/custom.css" rel="stylesheet">

<script src="js/respond.min.js"></script>

<script>

window.onload = function(){
  document.getElementById("btnSubmit").onclick = function(){    
    
    if($("#repasswd").val().trim() != $("#passwd").val().trim()  ){
       $("#repwCheck").html("비밀번호가 일치하지 않습니다.");
    }else{
         $("#repwCheck").html(""); 
            
    }
    
    if($("#gender").val().trim() == '선택'){
       $("#genderCheck").html("성별을 선택하세요.");
          return false;     
    }
    if($("#job").val().trim() == '선택'){
       $("#jobCheck").html("직업을 선택하세요.");
          return false;     
    }
  }
  

  document.getElementById("btnId").onclick= function(){
    var id = document.getElementById("id").value;
    $.ajax({
      method: "POST",
      url: "/idCheck.leaf",
      data: {"ctm_id":id},
      
      success:function(data) {
        if($("#id").val().trim() == ''){
           $("#idchk").html("아이디를 입력해 주세요.");
              return false;     
        }
        
        $('#idchk').html(data);
          
      },
      
      error : function(data) {
        alert("error!");
        alert(data);
      }
    });
    
  }

}


</script>

<!-- 다음주소 API -->                 
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

    function DaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postCode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('detailAddress').focus();
            }
        }).open();
    }
</script>   

</head>

<body>
     <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->

  <div id="all">

    <div id="content">
      <div class="container">

        <div class="col-md-12">

          <ul class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li>Sign up</li>
          </ul>

        </div>

        <div class="col-md-7 col-md-offset-3">
          <div class="box">
            <h2>Persmetic Sign Up</h2>

            <hr>

            <form action="${pageContext.servletContext.contextPath}/join.leaf" method="post"
              name="userInfo">
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">아이디</label> <input
                  type="text" name="ctm_id" id="id" class="form-control"
                   style="width: 250px" placeholder="아이디를 입력하세요." required="required"/>  <input
                type="button" id="btnId" class="button" style="width: 65px; height: 20px" value="중복확인" font-size="5pt"
                 />&nbsp;<span id="idchk"></span>
                  <input type="hidden" name="idDuplication" value="idUncheck">
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">이름</label> <input
                  type="text" name="ctm_name" id="name" class="form-control" required="required"
                  style="width: 250px"  placeholder="이름을 입력하세요." />
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">비밀번호</label> <input
                  type="password" name="ctm_passwd" id="passwd" class="form-control" required="required"
                  style="width: 250px" placeholder="비밀번호를 입력하세요." />
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">비밀번호 확인</label> <input
                  type="password"  id="repasswd" class="form-control"
                  style="width: 250px" placeholder="비밀번호를 다시한번 입력하세요." required="required"/><span id="repwCheck"></span>
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">이메일</label> <input
                  type="text" name="ctm_email" id="email" class="form-control"
                  style="width: 250px" placeholder="이메일을 입력하세요." required="required" />
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">나이</label> <input
                  type="text" name="ctm_age" id="age" class="form-control"
                  style="width: 250px" placeholder="나이를 입력하세요." required="required"/>
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px">성별</label> <select
                  name="ctm_gender" id="gender">
                  <option value="선택">선택</option>
                  <option value="M">M</option>
                  <option value="F">F</option>
                </select>&nbsp;<span id="genderCheck"></span>
              </div>
              <div>
                <label style="width: 100px">직업</label> <select
                  name="ctm_job" id="job">
                  <option value="선택">선택</option>
                  <option value="학생">학생</option>
                  <option value="회사원">회사원</option>
                  <option value="주부">주부</option>
                  <option value="기타">기타</option>
                </select>&nbsp;<span id="jobCheck"></span>
              </div> 
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px" for="city">우편번호</label> <input
                  type="text" name="ctm_address" id="postCode" class="form-control"
                  style="width: 150px" disabled />&nbsp;&nbsp;
                  <span><input class="button" type="button" value="우편번호"  onclick="DaumPostcode()"
                  /></span>
              </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px"  for="city">주소</label> <input
                  type="text" name="ctm_address" id="address" class="form-control"
                  style="width: 250px"  disabled />
                  </div>
              <div class="form-inline" style="margin-bottom: 5px">
                <label style="width: 100px"  for="city">상세주소</label> <input
                  type="text" name="ctm_address" id="detailAddress" class="form-control"
                  style="width: 250px"  required="required" placeholder="나머지 주소를 입력해주세요." />
                  </div>
              
              
              
              <br>

              <div class="text-center">
                 <button class="btn btn-default" type="submit" id="btnSubmit" >가입하기</button>
              <button class="btn btn-default"  type="reset" onclick="location.href='index.leaf'">취소하기</button>
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