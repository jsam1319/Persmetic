<%@page import="kr.or.kosta.leaf.customer.domain.Customer"%>
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<style>
div#mainImage {
  width: 180px;
  height: 200px;
 /*  border: 1px solid gray; */
}
div.content {
  width: 180px;
  height: 60px;
}
div.price {
    width: 180px;
  height: 40px;
}
</style>

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>
      Permestic
    </title>

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

<body style="background-color:white" >

   <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->


    <div id="all">

        <div id="content">

            <div class="container"  style="width:1000px; text-align: center; ">
                <div  style="width:1000px;  text-align: center; " >
                    <div id="main-slider">
                        <div class="item">
                            <a href="list_item.leaf?category_no=120"><img src="img/armani.png" alt="" class="img-responsive" width="1000px"></a>
                        </div>
                        <div class="item">
                            <a href="list_item.leaf?category_no=320"><img class="img-responsive" src="img/saint.PNG" alt="" width="1000px"></a>
                        </div>
                        <div class="item">
                            <a href="list_item.leaf?category_no=120"><img class="img-responsive" src="img/dlqtod.jpg" alt="" width="1000px"></a>
                        </div>

                    </div>
                    <!-- /#main-slider -->
                </div>
            </div>



            <!-- *** HOT PRODUCT SLIDESHOW ***
 _________________________________________________________ -->
          <div id="hot">

                <div class="container" id="suggest">
                </div>
                <!-- /.container -->
            </div>
            <!-- /#hot -->

            <!-- *** HOT END *** -->


            <!-- *** BLOG HOMEPAGE END *** -->


        </div>
        <!-- /#content -->


       <!-- FOOTER -->
       <jsp:include page="include/footer.jsp"></jsp:include>
		<!-- /.FOOTER -->

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
<script>

$(document).ready( function() {
	if('${empty cookie.customer}' == 'true') return false;
	else {
		$.ajax({
			url : '/suggest.leaf',
			data : {
				'ctm_no' : ${cookie.customer.value}
			},
			success : function(msg) {
				var json = JSON.parse(msg);
				console.log(json);
				appendProduct(json);
			},
			error : function(msg, a, b) {
				console.log(msg);
				console.log(a);
				console.log(b);
			}
		});	
	}
})

appendProduct = function(json) {
	for(var i in json.products) {
		var product = json.products[i];
		var div = "";
		
		div += 	 "<div class=\"col-md-2 col-sm-3\">\r\n" + 
				 "<div id=\"mainImage\">"+
				 "	<a href=\"detail_item.leaf?product_code=" + product.productCode + "\" class=\"image\"> \r\n" + 
				 "		<img src=\"uploadphoto/" + product.productImage + "\" alt=\"image\" class=\"img-responsive\" style=\"max-height: 200px; height: 90%;\">\r\n" + 
				 "	</a>\r\n" + 
				 "</div>"+
				 "	\r\n" + 
				 "	<div class=\"content\">\r\n" + 
				 "		<h3>\r\n" + 
				 "			<a href=\"detail_item.leaf?product_code=" + product.productCode + "\"</a>\r\n" + 
				 "		</h3>\r\n" + 
				 "		<p class=\"name\">" + product.productName + " </p>\r\n" + 
				 "	</div>\r\n" + 
				 "	<div class=\"price\">"+
				 "		<p class=\"price\">" + product.productPrice + " </p>\r\n" +
				 "                 \r\n" + 
				 "	</div>\r\n" + 
				 "<div>"+
				 "		<p class=\"buttons\">\r\n" + 
				 "			<a href=\"detail_item.leaf?product_code=" + product.productCode + "\" class=\"btn btn-default\">상세보기</a>\r\n" + 
				 "		</p>\r\n" + 
				 "</div>"+
				 "</div>"
		
		$("#suggest").append(div);
	}
}





</script>
</html>