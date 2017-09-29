<%@ page contentType="text/html; charset=utf-8"%>
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
<link href="/css/bootstrap.min.css" rel="stylesheet">

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

<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script>
window.onload=function(){
	CKEDITOR.replace( 'contents',{
	    'filebrowserUploadUrl':'/ckeditor/upload.jsp?'
	    +'realUrl=http://localhost/uploadphoto/'
	    +'&realDir=C:/Users/kosta/git/Persmetic/WebContent/uploadphoto/'
	}); 
}


</script>
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
              <div class="col-md-3">
                <form action="ckeditor/upload.jsp" method="post" enctype="multipart/form-data" name=""></form>
                <!-- <img class="img-fluid d-block mb-4 w-100 img-thumbnail"
                  src="img/image.png"> -->
                  <output id="image"></output>
                <input type="file" name="photoadd">
                </form>
              </div>
              <div class="col-md-9">

                <div class="col-md-12">
                  <div class="form-group">  
                    <label for="name">상품명 </label> <input type="text"
                      class="form-control" name="name">
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <label for="price">가격 </label> <input type="text"
                      class="form-control" name="price" id="price">
                  </div>
                </div>

                <div class="col-md-12">
                  <div class="form-group">
                    <label for="short_ex">상품간단설명 </label>
                    <textarea class="form-control" rows="2"
                      name="short_ex" id="short_ex"></textarea>
                  </div>
                </div>

                <div class="col-md-12">
                  <label></label>
                </div>

                <div class="col-md-3">
                  <div class="form-inline" style="margin-bottom: 5px">
                    <select class="form-control" name="brand">
                      <option value="브랜드">브랜드</option>
                      <option value="이니스프리">이니스프리</option>
                      <option value="헤라">헤라</option>
                      <option value="맥">맥</option>
                      <option value="에스티로더">에스티로더</option>
                    </select>
                  </div>
                </div>

                <div class="col-md-2">
                  <div class="form-inline" style="margin-bottom: 5px">
                    <select class="form-control" name="color">
                      <option value="색깔">색깔 </option>
                      <option value="빨강">빨강</option>
                      <option value="주황">주황</option>
                      <option value="노랑">노랑</option>
                      <option value="초록">초록</option>
                      <option value="파랑">파랑</option>
                      <option value="남색">남색</option>
                      <option value="보라">보라</option>
                    </select>
                  </div>
                </div>

                <div class="col-md-1">
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
              </div>

              <div class="col-md-10">
                <div class="form-group">
                  <label for="subject">키워드 </label> <input type="text"
                    class="form-control" name="keyword" id="keyword">
                </div>
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


      </div>
    </div>
  </div>

</body>
</html>