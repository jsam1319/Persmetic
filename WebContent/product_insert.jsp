<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
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


<link
  href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100'
  rel='stylesheet' type='text/css'>

<!-- styles -->
<link href="css/font-awesome.css" rel="stylesheet">
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
<script src="//code.jquery.com/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script src="js/productInsert.js"></script>
<link rel="stylesheet" href="css/palette-color-picker.css">
<script src="js/palette-color-picker.js"></script>





<!-- 태그 처리 (키워드) -->
<script src="js/tagsinput/bootstrap-tagsinput.js"></script>
<link href="js/tagsinput//bootstrap-tagsinput.css" rel="stylesheet">

<style>
div#front_image {
	width: 280px;
	height: 280px;
	border: 1px solid gray;
}
</style>
<title>글쓰기</title>
</head>
<body>


  <!-- Title -->
  <div class="panel panel-default">
    <div class="panel-heading" align="center">
      <h2>상품 등록하기</h2>
    </div>
    <!-- Title End -->

    <!-- Body -->
    <div class="panel-body">

      <div class="container">

        <div class="row">


          <div class="container">

            <div class="row">

              <form method="post" id="product_form">
                <div class="col-md-3">
                  <div id="front_image">
                    <input type="file" name="front" accept="image/*"
                      id="upload">
                  </div>


                </div>
                <div class="col-md-9">
                  <div class="col-md-12">
                    <div class="form-inline" style="margin-bottom: 5px">
                      카테고리 <select class="form-control" id="category">
                        <option value="000">카테고리</option>
                        <option value="100">FACE</option>
                        <option value="200">EYE</option>
                        <option value="300">LIP</option>
                      </select>
                      <select class="form-control" name="categoryno" id="category2">
                        <option value="">카테고리</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <div class="form-group">
                      <label for="name">상품명 </label> <input type="text"
                        class="form-control" name="name">
                    </div>
                  </div>

                  <div class="col-md-12">
                    <div class="form-group">
                      <label for="price">가격 </label> <input
                        type="number" class="form-control" name="price"
                        id="price">
                    </div>
                  </div>


                  <div class="col-md-2">
                    <div class="form-inline" style="margin-bottom: 5px">
                      <select class="form-control" name="brand">
                        <option value="브랜드">브랜드</option>
                        <option value="나스">나스</option>
                        <option value="디올">디올</option>
                        <option value="랑콤">랑콤</option>
                        <option value="맥">맥</option>
                        <option value="바비브라운">바비브라운</option>
                        <option value="샤넬">샤넬</option>
                        <option value="에스티로더">에스티로더</option>
                        <option value="입생로랑">입생로랑</option>
                        <option value="크리니크">크리니크</option>
                        <option value="페리페라">페리페라</option>
                      </select>
                    </div>
                  </div>

                  <div class="col-md-4">
	                    <input type="text" name="color" 
                      data-palette='["#D50000","#F361A6","#00B8D4","#00C853","#FFD600",
                                                    "#FF6D00","#FF1744","#FFB2D9","#00E5FF","#00E676","#FFEA00",
                                                    "#FF9100","#FF5252","#D9418C","#18FFFF","#69F0AE","#FFFF00","#FFAB40"]' value="">
                    </div>
                    <div class="form-inline" style="margin-bottom: 5px">
                    
                    
                <!--       <select class="form-control" name="color">
                        <option value="000">컬러 </option> 
                        <option value="100">빨강</option>
                        <option value="빨강">빨강</option>
                        <option value="주황">주황</option>
                        <option value="노랑">노랑</option>
                        <option value="초록">초록</option>
                        <option value="파랑">파랑</option>
                        <option value="남색">남색</option>
                        <option value="보라">보라</option>
                      </select> -->
                  </div>

                  <div class="col-md-2">
                    <div class="form-inline" style="margin-bottom: 5px">
                      <select class="form-control" name="tone">
                        <option value="톤">톤</option>
                        <option value="봄웜">봄웜</option>
                        <option value="여름쿨">여름쿨</option>
                        <option value="가을웜">가을웜</option>
                        <option value="겨울쿨">겨울쿨</option>
                      </select>
                    </div>
                  </div>


                  <div class="col-md-4">
                    <div class="form-inline"
                      style="margin-bottom: 5px; margin-left: 20px">
                      재고 <input type="number" class="form-control"
                        name="sow">
                    </div>
                  </div>
                </div>
                <div class="col-md-10">
                  <label for="subject">키워드 </label> <input type="text"
                    class="form-control" data-role="tagsinput"
                    name="keyword" id="keyword">
                </div>
            </div>
          </div>
        </div>


        <div class="form-group center-block">
          <label for="long_ex">상품상세설명 </label>
          <form method="post" id="insertBoardFrm"
            enctype="multipart/form-data">
            <textarea name="contents" id="contents"
              style="width: 90%; height: 700px;"></textarea>

          </form>
        </div>

        <div class="center-block" style='width: 250px'>
          <input type="submit" class="btn btn-primary" id="btnSubmit"
            value="저장"> <input type="button"
            class="btn btn-primary" value="취소" onclick="history.back(1)">
        </div>
        </form>

      </div>
    </div>
  </div>


</body>

<script>
$(document).ready(function() {
	$('[name="color"]').paletteColorPicker();

})

</script>
</html>