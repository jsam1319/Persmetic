<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Obaju e-commerce template">
<meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
<meta name="keywords" content="">

<title>장바구니</title>

<meta name="keywords" content="">

<link
  href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100'
  rel='stylesheet' type='text/css'>

<!-- styles -->
<link href="/css/font-awesome.css" rel="stylesheet">
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/owl.carousel.css" rel="stylesheet">
<link href="/css/owl.theme.css" rel="stylesheet">

<!-- theme stylesheet -->
<link href="/css/style.default.css" rel="stylesheet"
  id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="/css/custom.css" rel="stylesheet">

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>


<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.cookie.js"></script>
<script src="/js/waypoints.min.js"></script>
<script src="/js/modernizr.js"></script>
<script src="/js/bootstrap-hover-dropdown.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/front.js"></script>
<script src="/js/date.js"></script>
<!-- 
<script src="js/moment/min/moment.min.js"></script>
<script src="js/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="js/bootstrap-daterangepicker/daterangepicker.css"></script>
 -->


<!-- Include Required Prerequisites -->
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
 
<!-- Include Date Range Picker -->
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.jqueryui.min.css"/>

<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.jqueryui.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<link rel="shortcut icon" href="favicon.png">



</head>


<body>


  <jsp:include page="../include/header.jsp"></jsp:include>


  <div id="all">

    <div id="content">
      <div class="container">
        <!-- *** MENUS AND FILTERS ***
 _________________________________________________________ -->
        <div class=col-md-3>
          <div class="panel panel-default sidebar-menu">

            <div class="panel-heading">
              <h3 class="panel-title">Categories</h3>
            </div>

            <div class="panel-body">
              <ul class="nav nav-pills nav-stacked category-menu">
                <li><a href="stats.leaf">통계<span
                    class="badge pull-right">42</span></a>
               </li>
                <li class="active">
                  <a href="#">주문내역</a>
                </li>
              
                <li><a href="#">문의 답변
                    <span class="badge pull-right">123</span>
                </a>
                  <ul>
                    <li><a href="#">1:1 답변</a></li>
                    <li><a href="#">상품답변</a></li>
                  </ul></li>
                
              </ul>

            </div>
          </div>
          
 
          <div class="panel panel-default sidebar-menu">

            <div class="panel-heading">
              <h3 class="panel-title">
                날짜선택 
              </h3>
            </div>
              <div id="datepicker"></div>
                  <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 100%">
                      <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>&nbsp;
                      <span></span> <b class="caret"></b>
                  </div>
            <div class="panel-body">
              
            
      
            </div>
            
            
          </div>
          
        </div>

      <div class="col-md-9">
            
          
          
      
            <table id="order" class="display compact" cellspacing="0" width="100%">
              <thead >
              <tr>
                <th> 상품 이름 </th>
                <th> 주문 가격 </th>
                <th> 주문 개수 </th>
                <th> 주문 날짜 </th>
                <th> 주문자 명 </th>
                <th> 결제 여부 </th>
              </tr>
              </thead>  
              <tbody>
              
              </tbody>
              <tfoot>
              </tfoot>
            </table>
      
      
                
          </div>
        </div>

  

<script>
$(document).ready(function() {
	var table = $('#order').DataTable({
		language: {
		        processing:     "데이터 검색 중",
		        search:         "검색",
		        lengthMenu:    "한 페이지 당 _MENU_ 개의 데이터",
		        info:           " _START_ 번째 부터 _END_ 총 _TOTAL_ 중",
		        infoEmpty:      "데이터가 없습니다.",
		        infoFiltered:   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
		        infoPostFix:    "",
		        loadingRecords: "Chargement en cours...",
		        zeroRecords:    "열이 존재하지 않습니다.",
		        emptyTable:     "데이터가 없습니다.",
		        paginate: {
		            first:      "처음",
		            previous:   "이전",
		            next:       "다음",
		            last:       "마지막"
		        },
		        aria: {
		            sortAscending:  ": 오름 차순 정렬",
		            sortDescending: ": 내림 차순 정렬"
		        }
			}
	});  
	
	console.log(table);
	 var startDate;
	 var endDate;
	 
	 var json;
	
	 
	 $("#reportrange").on('apply.daterangepicker', function(ev, picker) {
		var total = $('#reportrange span').html();
	 
	 	startDate = total.split("-")[0];
	 	endDate = total.split("-")[1];
	 	
	 	$.ajax({
	 		url : "/order_list.leaf",
	 		type : 'get',
	 		dateType : 'jsonp',
	 		jsonp : 'callback',
	 		data : {
	 			"startDate" : startDate,
	 			"endDate" : endDate
	 		},
	 		success : function(msg) {
	 			json = JSON.parse(msg);
	 			table.destroy();
	 		
	 			var dataSet = jsonToDataSet(json);
	 			table = $('#order').DataTable( {
	 				autoWidth : true,
	 				data : dataSet,
	 				language: {
	 			        processing:     "데이터 검색 중",
	 			        search:         "검색",
	 			        lengthMenu:    "한 페이지 당 _MENU_ 개의 데이터",
	 			        info:           " _START_ 번째 부터 _END_ 총 _TOTAL_ 중",
	 			        infoEmpty:      "데이터가 없습니다.",
	 			        infoFiltered:   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
	 			        infoPostFix:    "",
	 			        loadingRecords: "Chargement en cours...",
	 			        zeroRecords:    "열이 존재하지 않습니다.",
	 			        emptyTable:     "데이터가 없습니다.",
	 			        paginate: {
	 			            first:      "처음",
	 			            previous:   "이전",
	 			            next:       "다음",
	 			            last:       "마지막"
	 			        },
	 			        aria: {
	 			            sortAscending:  ": 오름 차순 정렬",
	 			            sortDescending: ": 내림 차순 정렬"
	 			        }
	 				}
	 				
	 			} );
	 		},
	 		error : function(msg, status, thrown) {
	 			console.log(status);
	 			console.log(thrown);
	 			console.log(msg);
	 		}
	 	});
	 	

	 });
	  
	 var datepicker = $(function() {

		    var start = moment().subtract(29, 'days');
		    var end = moment();
		    

		    function cb(start, end) {
		        $('#reportrange span').html(start.format('YYYY/MM/DD') + ' - ' + end.format('YYYY/MM/DD'));
		    }

		    $('#reportrange').daterangepicker({
		        startDate: start,
		        endDate: end,
		        ranges: {
		           '오늘': [moment(), moment()],
		           '어제': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
		           '최근 7일': [moment().subtract(6, 'days'), moment()],
		           '최근 30일': [moment().subtract(29, 'days'), moment()],
		           '이번 달': [moment().startOf('month'), moment().endOf('month')],
		           '지난 달': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
		        },
		        locale: {
		            "format": "YYYY/MM/DD",
		            "separator": " - ",
		            "applyLabel": "적용",
		            "cancelLabel": "취소",
		            "fromLabel": "From",
		            "toLabel": "To",
		            "customRangeLabel": "사용자 설정",
		            "weekLabel": "주",
		            "daysOfWeek": [
		                "일",
		                "월",
		                "화",
		                "수",
		                "목",
		                "금",
		                "토"
		            ],
		            "monthNames": [
		                "1월",
		                "2월",
		                "3월",
		                "4월",
		                "5월",
		                "6월",
		                "7월",
		                "8월",
		                "9월",
		                "10월",
		                "11월",
		                "12월"
		            ],
		            "firstDay": 1
		        },
		    }, cb);

		    cb(start, end);
		    
		});
	  
 })

jsonToDataSet = function(json) {
	var dataSet = [];
	
	for(var i in json.orderLogs) {
		var data = [];
		
		data.push(json.orderLogs[i].productName);
		data.push(json.orderLogs[i].orderPrice);
		data.push(json.orderLogs[i].orderCount);
		data.push(json.orderLogs[i].orderDate);
		data.push(json.orderLogs[i].ctmName);
		data.push(json.orderLogs[i].orderYN);

		dataSet.push(data);
	}
	console.log(dataSet);
	return dataSet;
}


</script>
	

</body>
</html>