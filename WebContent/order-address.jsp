<%@ page contentType="text/html; charset=utf-8" %>
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

    <title>주문(주소입력)</title>

    <meta name="keywords" content="">

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
</head>

<body>

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

   <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->

    <div id="all">

    <div id="content">
        <div class="container">

            <div class="col-md-12">
                <ul class="breadcrumb">
                    <li><a href="#">Home</a>
                    </li>
                    <li>주문(주소입력)</li>
                </ul>
            </div>

            <div class="col-md-9" id="checkout">

      <div class="box">
          <form method="post" action="order-delivery.leaf">
              <h1>주문하기</h1>
              <ul class="nav nav-pills nav-justified">
                  <li class="active"><a href="#"><i class="fa fa-map-marker"></i><br>주소입력</a>
                  </li>
                  <li class="disabled"><a href="#"><i class="fa fa-money"></i><br>결제방식</a>
                  </li>
              </ul>

              <div class="content">
                  <div class="row">
                      <div class="col-sm-6">
                          <div class="form-group">
                              <label for="firstname">주문번호</label>
                              <input type="text" class="form-control" id="firstname">
                          </div>
                      </div>
                      <div class="col-sm-6">
                          <div class="form-group">
                              <label for="lastname">주문자</label>
                              <input type="text" class="form-control" id="lastname">
                          </div>
                      </div>
                  </div>
                  <!-- /.row -->

                  <div class="row">
                      <div class="col-sm-6">
                          <div class="form-group">
                              <label for="company">전화번호</label>
                              <input type="text" class="form-control" id="company">
                          </div>
                      </div>
                      <div class="col-sm-6">
                          <div class="form-group">
                              <label for="street">주문일</label>
                              <input type="text" class="form-control" id="street">
                          </div>
                      </div>
                  </div>
                  <!-- /.row -->
                             
                   <div class="row">
                     <div class="col-sm-4">
                       <div class="form-group">
                          <label for="city">우편번호</label>
                          <input type="text" class="form-control" id="postCode" disabled>
                        </div>
                      </div>
                      <div class="col-sm-1">
                            <div class="form-group"><br>
                               <input type="button" class="btn btn-primary"  style="margin-top: 5px;" onclick="DaumPostcode()" value="우편번호 찾기">
                           </div>
                      </div>
                   </div>
                   <!-- /.row -->
                   
                   <div class="row">
                     <div class="col-sm-6"> 
                      <div class="form-group">
                        <label for="city">주소</label>
                        <input type="text" class="form-control" id="address" disabled>
                      </div>
                    </div>
                    <div class="col-sm-6"> 
                      <div class="form-group">
                        <label for="city">상세주소</label>
                        <input type="text" class="form-control" id="detailAddress">
                      <span id="guide" style="color:#999"></span>
                      </div>
                   </div>
                 </div>
                <!-- /.row -->
              </div>

              <div class="box-footer">
                  <div class="pull-left">
                      <a href="basket.leaf" class="btn btn-default"><i class="fa fa-chevron-left"></i>장바구니로 가기</a>
                  </div>
                  <div class="pull-right">
                      <button type="submit" class="btn btn-primary">다음단계로<i class="fa fa-chevron-right"></i>
                      </button>
                  </div>
              </div>
          </form>
      </div>
      <!-- /.box -->


                </div>
                <!-- /.col-md-9 -->

                <div class="col-md-3">

                    <div class="box" id="order-summary">
                        <div class="box-header">
                            <h3>주문 요약</h3>
                        </div>
                        <p class="text-muted">배송 및 추가 비용은 입력한 값을 기준으로 계산됩니다.</p>

                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td>주문 총 합계</td>
                                        <th>0원</th>
                                    </tr>
                                    <tr class="total">
                                        <td>총 합계</td>
                                        <th>0원</th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>
                <!-- /.col-md-3 -->

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
                    <p class="pull-left">Â© 2015 Your name goes here.</p>

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

