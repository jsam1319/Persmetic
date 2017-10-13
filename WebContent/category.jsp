<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Persmetic</title>

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

<style>
.img-responsive {
  height: 200px;
}
</style>


</head>

<body style="background-color:white">
  <!-- Header -->
  <jsp:include page="include/header.jsp" />
  <!-- Header End -->

  <div id="all">

    <div id="content">
      <div class="container">

        <div class="col-md-12">
          <ul class="breadcrumb">
          <li><a href="index.leaf">Home</a></li>
            <c:choose>
            <c:when test="${tone.categoryNo == 0}">
              <li><a href="list_item.leaf?tone=${tone.productTone}">${tone.productTone}</a></li>
            </c:when>
            <c:otherwise>
              <li><a id="category1" href="list_item.leaf?&category_no=${tone.categoryNo}"></a></li>
            </c:otherwise>
            </c:choose>
          </ul>
        </div>




        <div class="col-md-12">


          <div class="row products" >
            <div class="col-md-12 col-sm-6">

              <c:forEach items="${list}" var="i">
                <!--List -->
                <div class=" col-md-3 col-sm-3">
                  <a style="color: black" href="detail_item.leaf?product_code=${i.productCode}" class="image"> <img
                    src="/uploadphoto/${i.productImage}"
                    alt="image" class="img-responsive" >
                  </a>
                  <div class="content">
                    <h5>
                      <a href="detail_item.leaf?product_code=${i.productCode}">${i.productName}</a>
                    </h5>
                    <p class="price">${i.productPrice}원</p>
                    <p class="buttons">
                      <a href="detail_item.leaf?product_code=${i.productCode}" class="btn btn-default">상세보기</a>&nbsp;&nbsp;
                      <a href="#" value="${i.productCode}" name="addToCart" class="btn btn-default"><i
                        class="fa fa-shopping-cart"></i>장바구니</a>
                    </p>
                  </script>
                 
                  </div>
                </div>
              </c:forEach>
              <!-- /.text -->
            </div>
            <!-- /.product -->
          </div>
          <!-- /.products -->



             <!-- Paging -->
            <div class="pages">
            <nav aria-label="Page navigation">
            <c:choose>
               <c:when test="${tone.categoryNo == 0}">
                <ul class="pagination">
                  <c:if test="${pageBuilder.isShowFirst()}">
                    <li><a href="${pageBuilder.getQueryString(1)}&tone=${tone.productTone}"> << </a></li>
                  </c:if>

                  <c:if test="${pageBuilder.isShowPrevious()}">
                    <li class="prev"><a
                      href="${pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())}&tone=${tone.productTone}"> < </a></li>
                  </c:if>

                  <c:forEach var="i" begin="${pageBuilder.currentStartPage }"
                    end="${pageBuilder.currentEndPage}" varStatus="status">
                    <c:choose>
                      <c:when test="${i==params.page}">
                        <li class="active"><a>${i}</a></li>
                      </c:when>
                      <c:otherwise>
                        <li><a href="${pageBuilder.getQueryString(i)}&tone=${tone.productTone}">${i}</a></li>
                      </c:otherwise>
                    </c:choose>
                  </c:forEach>

                  <c:if test="${pageBuilder.isShowNext()}">
                    <li class="next"><a
                      href="${pageBuilder.getQueryString(pageBuilder.getNextStartPage())}&tone=${tone.productTone}"> > </a></li>
                  </c:if>

                  <c:if test="${pageBuilder.isShowLast()}">
                    <li><a
                      href="${pageBuilder.getQueryString(pageBuilder.getTotalPageCount())}&tone=${tone.productTone}"> >> </a></li>
                  </c:if>
                </ul>
                 </c:when> 
                 <c:otherwise>
                <ul class="pagination">
                  <c:if test="${pageBuilder.isShowFirst()}">
                    <li><a href="${pageBuilder.getQueryString(1)}&category_no=${tone.categoryNo}"> << </a></li>
                  </c:if>

                  <c:if test="${pageBuilder.isShowPrevious()}">
                    <li class="prev"><a
                      href="${pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())}&category_no=${tone.categoryNo}"> < </a></li>
                  </c:if>

                  <c:forEach var="i" begin="${pageBuilder.currentStartPage }"
                    end="${pageBuilder.currentEndPage}" varStatus="status">
                    <c:choose>
                      <c:when test="${i==params.page}">
                        <li class="active"><a>${i}</a></li>
                      </c:when>
                      <c:otherwise>
                        <li><a href="${pageBuilder.getQueryString(i)}&category_no=${tone.categoryNo}">${i}</a></li>
                      </c:otherwise>
                    </c:choose>
                  </c:forEach>

                  <c:if test="${pageBuilder.isShowNext()}">
                    <li class="next"><a
                      href="${pageBuilder.getQueryString(pageBuilder.getNextStartPage())}&category_no=${tone.categoryNo}"> > </a></li>
                  </c:if>

                  <c:if test="${pageBuilder.isShowLast()}">
                    <li><a
                      href="${pageBuilder.getQueryString(pageBuilder.getTotalPageCount())}&category_no=${tone.categoryNo}"> >> </a></li>
                  </c:if>

                </ul>
                
                </c:otherwise> 
                </c:choose>
              </nav>
          </div> 

          <!-- /.Paging --> 


          


        </div>
        <!-- /.col-md-9 -->
      </div>
      <!-- /.container -->
    </div>
    <!-- /#content -->


      
    <jsp:include page="include/footer.jsp"></jsp:include>



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


  <script>
  
    window.onload = function() {
    	categoryName()
    	
      var addButton = $("a[name=addToCart]");
      
      
      addButton.click(function() {
        var pPrice = $(this).parent().siblings().filter("p.price");
        var price = pPrice.html();
        var priceNum = price.split("원")[0];
        
        $.ajax({
          url : "cart_create.leaf",
          data : {
            'product_code' : $(this).attr('value'),
            'ctm_no' : "${cookie.customer.value}",
            'cart_quantity' : 1,
            'cart_price' : priceNum
          },
          success : function(request) {
            console.log(request);
            alert("장바구니 넣기 성공!");
            
            $.ajax({
              url : "log.leaf",
              data : {
                'type' : 'CART_INSERT',
                'content' : $("a[name=addToCart]").attr('value')
              },
              success : function(msg) {
                console.log(msg);
              }
            })
            //return false;
          },
          error : function(request) {
            console.log(request);
            alert("장바구니에 담겨있는 상품입니다.");
            //return false;
          }
        })
      })
      
      
    
      function categoryName(){
          var ctg = "";
          var categoryNo = ${tone.categoryNo}
           switch(categoryNo){
        	   case 110 :  ctg+="파운데이션"; break;
               case 120 :  ctg+="쿠션"; break;
               case 130 :  ctg+="파우더&컴팩트"; break;
               case 140 :  ctg+="메이크업 베이스&컨실러"; break;
               case 150 :  ctg+="블러셔&하이라이터"; break;
               case 210 :  ctg+="마스카라"; break;
               case 220 :  ctg+="아이섀도"; break;
               case 230 :  ctg+="아이브로우"; break;
               case 310 :  ctg+="립스틱"; break;
               case 320 :  ctg+="틴트&립글로즈"; break;
             default   :   return; break;
           }
          $("#category1").append(ctg);
       }
       
     }
  </script>


</body>

</html>