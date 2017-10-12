<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Obaju e-commerce template">
<meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
<meta name="keywords" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/css/bootstrap.min.css" rel="stylesheet">

<link
  href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,200,100'
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
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!-- 별점 CSS, JS -->
<link href="css/grade.css" rel="stylesheet">
<script src="js/review.js"></script>


<title>리뷰 등록</title>
</head>
<body>


  <!-- Title -->
  <div class="panel panel-default">
    <div class="panel-heading" align="center">
      <h2>리뷰 작성</h2>
    </div>
    <!-- Title End -->

    <!-- Body -->
    <div class="panel-body">

      <div class="container">

        <div class="row">

          <div class="container">

            <div class="row">

              <form method="post" id="review_form">
                <hr>
                <div>
                  <div>
                    <input type="hidden" name="productCode"
                      id="productCode" value="${product.productCode}">
                    <input type="hidden" name="ctmNo" id="ctmNo"
                      value="${customer.ctmNo}"> <input
                      type="hidden" name="ctmId" id="ctmId"
                      value="${customer.ctmId}">
                    <div class="col-md-2">
                      <img
                        src="http://localhost/uploadphoto/${product.productImage}"
                        alt="ProductImage" class="img-responsive">
                    </div>
                    <div class="col-md-10">
                      <div class="form-group">
                        <label for="name">${product.productName}
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <hr>
                  </div>
                  <div>
                    <div class="col-md-2">평가</div>
                    <div class="col-md-10">
                      <span class="star-input"> <span
                        class="input"> <input type="radio"
                          name="star-input" value="1" id="p1"> <label
                          for="p1">1</label> <input type="radio"
                          name="star-input" value="2" id="p2"> <label
                          for="p2">2</label> <input type="radio"
                          name="star-input" value="3" id="p3"> <label
                          for="p3">3</label> <input type="radio"
                          name="star-input" value="4" id="p4"> <label
                          for="p4">4</label> <input type="radio"
                          name="star-input" value="5" id="p5"> <label
                          for="p5">5</label>
                      </span><input type="hidden" id="grade" name="grade" value="0">
                      </span>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <hr>
                  </div>
                  <div>
                    <div class="col-md-2">상품평</div>
                    <div class="col-md-10">
                      <textarea name="content" id="content"
                        class="form-control"
                        style="width: 100%; height: 100px;"
                        placeholder="상품평을 입력해주세요"></textarea>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <hr>
                  </div>
                  <div>
                    <div class="col-md-2">한줄요약</div>
                    <div class="col-md-10">
                      <input type="text" class="form-control" id="title"
                        name="title">
                    </div>
                  </div>
                  <div class="col-md-12">
                    <hr>
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="center-block" style='width: 250px'>
                    <input type="button" class="btn btn-default"
                      id="btnSubmit" value="등록"> <input
                      type="button" class="btn btn-default" value="취소"
                      onclick="history.back(1)">
                  </div>
                </div>

              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>