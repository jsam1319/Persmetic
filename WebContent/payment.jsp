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

<style>
.bhr {
	border: 0;
	height: 1px;
	background: #464343;
}
</style>

<title>결제</title>
</head>
<body>


	<!-- Title -->
	<div class="panel panel-default">
		<div class="panel-heading" align="center">
			<h2>결제하기</h2>
		</div>
		<!-- Title End -->

		<!-- Body -->
		<div class="panel-body">

			<div class="container">
				<div class="container">
				<div class="row">




					<div>
						<div class="col-md-2">
							<h4>최종주문정보</h4>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-6">
							<div class="form-group">
								<h5>샤넬 루쥬 알뤼르 립스틱</h5>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<p>1개 45,000원</p>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<hr class="bhr">
					</div>
					<div style="margin-bottom: 10px">
						<div class="col-md-2">배송지 선택</div>
						<div class="col-md-10">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="col-md-12">
						<hr>
					</div>
					<div style="margin-top: 5px">
						<div class="col-md-2">배송 시 요청사항</div>
						<div class="col-md-10">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="col-md-12">
						<hr>
					</div>
				</div>
				</div>
				<!-- /.row -->


				<!-- Tab -->
				<div class="col-md-10">
				 <div class="box" id="details">
						<ul id="explainTap" class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a
								data-target="#card" id="card-tab" role="tab"
								data-toggle="tab" aria-controls="card" aria-expanded="true">신용카드</a></li>
							<li role="presentation" class=""><a data-target="#trans"
								role="tab" id="trans-tab" data-toggle="tab" aria-controls="trans"
								aria-expanded="false">실시간 계좌이체</a></li>
							<li role="presentation" class=""><a data-target="#deposit"
								role="tab" id="deposit-tab" data-toggle="tab"
								aria-controls="deposit" aria-expanded="false">무통장입금</a></li>
							<li role="presentation" class=""><a data-target="#payphone"
								role="tab" id="payphone-tab" data-toggle="tab"
								aria-controls="payphone" aria-expanded="false">휴대폰 결제</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="card"
								aria-labelledby="card-tab">
								<div class="col-md-12"></div>
								<p><input type="radio">신용카드(일반) <input type="radio"><span style="color: red;">(원클릭결제)</span></p>
								<p>카드 선택</p>
								<p>할부 선택</p>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="trans"
								aria-labelledby="trans-tab">
								<h5>유의사항</h5>
								<p>무통장 입금의 경우 주문접수 후 입금이 되지 않고 3일이 지나면 자동 취소됩니다.</p>
								<p>현금영수증 신청은 주문 시, 각 결제수단(실시간계좌이체, 무통장입금)의 인증 페이지에서 신청 가능합니다.</p>
								<p>추후 신청은 '회원로그인 > 마이페이지 > 증빙서류 발급'에서 가능합니다.</p>
								<p>(비회원은 '비회원 로그인(주문조회) > 증빙서류 발급')</p>
								<p>사업자증빙의 경우 반드시 주문 시 신청하여야 합니다.</p>
								<p>세금계산서는 고객상담실과 상담 후 발급이 가능합니다.</p>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="deposit"
								aria-labelledby="deposit-tab">
							</div>
							<div role="tabpanel" class="tab-pane fade" id="payphone"
								aria-labelledby="payphone-tab">
								<h5>유의사항</h5>
								<p>결제월이 지난 휴대폰결제의 취소건은 별도의 반품계좌로 환불됩니다.<p>
								<p>주문건의 반품 시 반품금액은 별도의 반품계좌로 환불됩니다.<p>
							</div>

						</div>
					</div> 
					</div>

				<!-- /.Tab -->

			</div>
			<div class="container">
			<div class="col-md-12">
				<input type="checkbox">주문할 상품의 상품명, 상품가격, 배송정보를 확인하였으며,
				구매진행에 동의하시겠습니까? (전자상거래법 제8조 제2항)
			</div>
			<div class="col-md-12">
				<div class="center-block" style='width: 250px'>
					<input type="submit" class="btn btn-default" id="btnSubmit"
						value="결제하기"> <input type="button" class="btn btn-default"
						value="취소" onclick="history.back(1)">
				</div>
			</div>
			</div>


		</div>
	</div>
</body>
</html>