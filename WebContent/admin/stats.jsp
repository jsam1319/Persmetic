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
                <li class="active"><a href="#">통계<span
                    class="badge pull-right">42</span></a>
               </li>
                <li>
                  <a href="order-list.jsp">주문내역</a>
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


	
		<!-- Graph -->
       <div class="col-md-8">
          <div id="container"></div>
		
		

      <table style="margin-top: 20px" class="table table-hover">
        <thead >
        <tr>
          <th> 상품 이름 </th>
          <th> 총 판매량 </th>
          <th> 평균 평점 </th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td> 상품 이름 </td>
          <td> 총 판매량 </td>
          <td> 평균 평점 </td>
        </tr>
        <tr>
          <td> 상품 이름 </td>
          <td> 총 판매량 </td>
          <td> 평균 평점 </td>
        </tr>
        </tbody>
      </table>


          
    </div>
  </div>


  <script>
  var chart;
  
  $(document).ready(function() {
	 
	  
	 var startDate;
	 var endDate;
	 
	 var json;
	
	 
	 $("#reportrange").on('apply.daterangepicker', function(ev, picker) {
		var total = $('#reportrange span').html();
	 
	 	startDate = total.split("-")[0];
	 	endDate = total.split("-")[1];
	 	
	 	$.ajax({
	 		url : "/stats.leaf",
	 		type : 'get',
	 		dateType : 'jsonp',
	 		jsonp : 'callback',
	 		data : {
	 			"startDate" : startDate,
	 			"endDate" : endDate
	 		},
	 		success : function(msg) {
	 			json = JSON.parse(msg);
	 			
	 			console.log(json);
	 			
	 			console.log(jsonToData(json));
	 			
	 			drawChart(startDate, jsonToData(json));
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



jsonToData = function(json) {
  	var dataSet = [];
  		
	for(var i in json) {
		var year = i.split('-')[0];
		var month = i.split('-')[1];
		var day = i.split('-')[2];

		var UTCdate = Date.UTC(year, month-1, day);
		
		for(var j in json[i]) {
			if(indexOf(dataSet,json[i][j].name) == -1) {
				var obj = new Object();
				
				obj.name = json[i][j].name;
				obj.data = [[UTCdate, json[i][j].count]];
				
				dataSet.push(obj);
			}
			
			else {
				dataSet[indexOf(dataSet,json[i][j].name)].data.push([UTCdate, json[i][j].count])
			}
		}	
	}
	
	return dataSet;
 } 
 
 indexOf = function(dataSet, nameValue) {
	 for(var i in dataSet) {
		 if(dataSet[i].name == nameValue) return i
	 }
	 
	 return -1;
 }

 var drawChart = function(startDate, data) { 
	 chart = Highcharts.chart('container', {

		    title: {
		        text: '제품 별 판매 그래프'
		    },

		    yAxis: {
		        title: {
		            text: '제품 별 판매'
		        }
		    },
		    tooltip: {
	            xDateFormat: '%Y-%m-%d',
	            shared: true
	        },
		    
		    xAxis: {
		        type: 'datetime',
		        labels: {
		            formatter: function() {
		              return moment(this.value).format("YYYY-MM-DD");
		            }
		          }
		    },
		    
		    legend: {
		        layout: 'vertical',
		        align: 'right',
		        verticalAlign: 'middle'
		    },

		    plotOptions: {
		        series: {
		        	pointStart: Date.UTC(startDate.split('-')[0], startDate.split('-')[1], startDate.split('-')[2]), 
		            pointInterval: 24 * 3600 * 1000 // one day
		        }	
		    },

		    series: data,

		    responsive: {
		        rules: [{
		            condition: {
		                maxWidth: 500
		            },
		            chartOptions: {
		                legend: {
		                    layout: 'horizontal',
		                    align: 'center',
		                    verticalAlign: 'bottom'
		                }
		            }
		        }]
		    }

		});
	 
	 Highcharts.setOptions({
		 lang: {
		        months: [
		            '1월', '2월', '3월', '4월',
		            '5월', '6월', '7월', '8월',
		            '9월', '10월', '11월', '12월'
		        ],
		        weekdays: [
		            '일요일', '월요일', '화요일', '수요일',
		            '목요일', '금요일', '토요일'
		        ],
		        shortMonths: [
		        	"1","2","3","4","5","6","7","8","9","10","11","12"
		        ]
		    }
	 })
 } 
 
  
		</script>


</body>
</html>