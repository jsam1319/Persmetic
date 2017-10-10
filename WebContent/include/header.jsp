<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="../WEB-INF/util-functions.tld" %>


 <!-- *** TOPBAR ***
 _________________________________________________________ -->
    <div id="top">
        <div class="container">
            <div class="col-md-6" data-animate="fadeInDown">
                <ul class="menu">
                   
                
                 <c:choose>
                    <c:when test="${empty cookie.customer }">
                    <li><a  data-toggle="modal" data-target="#login-modal">Login</a> </li>
                     <li><a href="/register.leaf">Register</a>   </li>
                      </c:when>
        			<c:otherwise>
			              <li><a href="${pageContext.servletContext.contextPath}/customer/certify.leaf">Logout</a> </li>
			                <c:choose>
			                	<c:when test="${cookie.customer.value eq 0}">
			                		<li><a href="${pageContext.servletContext.contextPath}/admin.leaf">AdminPage</a></li>
			                	</c:when>
			                	<c:otherwise>
			             			<li><a href="${pageContext.servletContext.contextPath}/customer-order.leaf">MyPage</a></li>
			             		</c:otherwise>
			             		</c:choose>
                    </c:otherwise>
      </c:choose>  
                
                    <li><a href="/contact.leaf">Contact</a>
                    </li>
                    <li><a href="#">Recently viewed</a>
                    </li>
                </ul>
            </div>
        </div>
        
        
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="Login">Member login</h4>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/customer/certify.leaf" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" id="ctm_id" name="ctm_id" placeholder="Id">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="ctm_passwd" name="ctm_passwd" placeholder="Password">
                            </div>

                            <p class="text-center">
                                <button class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                            </p>

                        </form>


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

                <a class="navbar-brand home" href="index.leaf" data-animate-hover="bounce">
                    <img src="/img/logo.png" alt="Obaju logo" class="hidden-xs">
                    <img src="/img/logo-small.png" alt="Obaju logo" class="visible-xs"><span class="sr-only">Obaju - go to homepage</span>
                </a>
                <div class="navbar-buttons">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <i class="fa fa-align-justify"></i>
                    </button>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#search">
                        <span class="sr-only">Toggle search</span>
                        <i class="fa fa-search"></i>
                    </button>
                    <a class="btn btn-default navbar-toggle" href="/cart.leaf?ctm_no=${cookie.customer.value}">
                        <i class="fa fa-shopping-cart"></i>  <span class="hidden-xs">Shopping Cart</span>
                    </a>
                </div>
            </div>
            <!--/.navbar-header -->

            <div class="navbar-collapse collapse" id="navigation">

                <ul class="nav navbar-nav navbar-left">
                    <li class="active"><a href="/index.leaf">Home</a>
                    </li>
                    <li><a href="#">자가진단</a></li>
                    <li class="dropdown yamm-fw">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">제품별 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="yamm-content">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h5>페이스</h5>
                                            <ul>
                                                <li><a href="category.leaf">파운데이션</a>
                                                </li>
                                                <li><a href="category.leaf">쿠션</a>
                                                </li>
                                                <li><a href="category.leaf">파우더 & 컴팩트</a>
                                                </li>
                                                <li><a href="category.leaf">메이크업 베이스 & 컨실러</a>
                                                </li>
                                                <li><a href="category.leaf">블러셔 & 하이라이터</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-3">
                                            <h5>아이</h5>
                                            <ul>
                                                <li><a href="category.leaf">마스카라</a>
                                                </li>
                                                <li><a href="category.leaf">아이라이너</a>
                                                </li>
                                                <li><a href="category.leaf">아이섀도</a>
                                                </li>
                                                <li><a href="category.leaf">아이브로우</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-3">
                                            <h5>립</h5>
                                            <ul>
                                                <li><a href="category.leaf">립스틱</a>
                                                </li>
                                                <li><a href="category.leaf">립틴트 & 립글로스</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.yamm-content -->
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown yamm-fw">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">톤별 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="yamm-content">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h5>톤</h5>
                                            <ul>
                                                <li><a href="category.leaf">봄</a>
                                                </li>
                                                <li><a href="category.leaf">여름</a>
                                                </li>
                                                <li><a href="category.leaf">가을</a>
                                                </li>
                                                <li><a href="category.leaf">겨울</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class="banner">
                                                <a href="#">
                                                    <img src="img/banner.jpg" class="img img-responsive" alt="">
                                                </a>
                                            </div>
                                            <div class="banner">
                                                <a href="#">
                                                    <img src="img/banner2.jpg" class="img img-responsive" alt="">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.yamm-content -->
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>
            <!--/.nav-collapse -->

            <div class="navbar-buttons">

                <div class="navbar-collapse collapse right" id="basket-overview">
                    <a href="cart.leaf?ctm_no=${cookie.customer.value}" class="btn btn-primary navbar-btn"><i class="fa fa-shopping-cart"></i><span class="hidden-sm">Shopping Cart</span></a>
                </div>
                <!--/.nav-collapse -->

                <div class="navbar-collapse collapse right" id="search-not-mobile">
                    <button type="button" class="btn navbar-btn btn-primary" data-toggle="collapse" data-target="#search">
                        <span class="sr-only">Toggle search</span>
                        <i class="fa fa-search"></i>
                    </button>
                </div>

            </div>

            <div class="collapse clearfix" id="search">

                <form class="navbar-form" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search">
                        <span class="input-group-btn">

      <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>

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