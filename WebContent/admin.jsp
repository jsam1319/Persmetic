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
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.theme.css" rel="stylesheet">

<!-- theme stylesheet -->
<link href="css/style.default.css" rel="stylesheet"
  id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="css/custom.css" rel="stylesheet">

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/modernizr.js"></script>
<script src="js/bootstrap-hover-dropdown.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/front.js"></script>


<link rel="shortcut icon" href="favicon.png">

</head>


<body>


  <jsp:include page="include/header.jsp"></jsp:include>


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
                <li class="active"><a href="category.leaf">통계<span
                    class="badge pull-right">42</span></a>
                  <ul>
                    <li><a href="category.leaf">상품별 통계</a></li>
                    <li><a href="category.leaf">회원별 통계</a></li>

                  </ul>
               </li>
                <li><a href="category.leaf">문의 답변
                    <span class="badge pull-right">123</span>
                </a>
                  <ul>
                    <li><a href="category.leaf">1:1 답변</a></li>
                    <li><a href="category.leaf">상품답변</a></li>
                  </ul></li>
                
              </ul>

            </div>
          </div>

          <div class="panel panel-default sidebar-menu">

            <div class="panel-heading">
              <h3 class="panel-title">
                Brands <a class="btn btn-xs btn-danger pull-right"
                  href="#"><i class="fa fa-times-circle"></i> Clear</a>
              </h3>
            </div>

            <div class="panel-body">

              <form>
                <div class="form-group">
                  <div class="checkbox">
                    <label> <input type="checkbox">Armani
                      (10)
                    </label>
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox">Versace
                      (12)
                    </label>
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox">Carlo
                      Bruni (15)
                    </label>
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox">Jack
                      Honey (14)
                    </label>
                  </div>
                </div>

                <button class="btn btn-default btn-sm btn-primary">
                  <i class="fa fa-pencil"></i> Apply
                </button>

              </form>

            </div>
          </div>

          <div class="panel panel-default sidebar-menu">

            <div class="panel-heading">
              <h3 class="panel-title">
                Colours <a class="btn btn-xs btn-danger pull-right"
                  href="#"><i class="fa fa-times-circle"></i> Clear</a>
              </h3>
            </div>

            <div class="panel-body">

              <form>
                <div class="form-group">
                  <div class="checkbox">
                    <label> <input type="checkbox"> <span
                      class="colour white"></span> White (14)
                    </label>
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox"> <span
                      class="colour blue"></span> Blue (10)
                    </label>
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox"> <span
                      class="colour green"></span> Green (20)
                    </label>
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox"> <span
                      class="colour yellow"></span> Yellow (13)
                    </label>
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox"> <span
                      class="colour red"></span> Red (10)
                    </label>
                  </div>
                </div>

                <button class="btn btn-default btn-sm btn-primary">
                  <i class="fa fa-pencil"></i> Apply
                </button>

              </form>

            </div>
          </div>
        </div>
        <span style="">

          <div class="col-md-8">
            <div id="container"></div>


      <table style="margin-top: 20px" class="table table-hover">
        <thead >
        <tr>
          <th> 상품 번호 </th>
          <th> 상품 이름 </th>
          <th> 총 판매량 </th>
          <th> 평균 평점 </th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td> 상품 번호 </td>
          <td> 상품 이름 </td>
          <td> 총 판매량 </td>
          <td> 평균 평점 </td>
        </tr>
        <tr>
          <td> 상품 번호 </td>
          <td> 상품 이름 </td>
          <td> 총 판매량 </td>
          <td> 평균 평점 </td>
        </tr>
        </tbody>
      </table>


          </div>
          <li style="list-style-type: none;">
            <ul>
              <button type="button" class="btn btn-primary">Primary</button>
            </ul>
            <ul>
              <button type="button" class="btn btn-primary">Primary</button>
            </ul>
            <ul>
              <button type="button" class="btn btn-primary">Primary</button>
            </ul>
            <ul>
              <button type="button" class="btn btn-primary">Primary</button>
            </ul>
            <ul>
              <button type="button" class="btn btn-primary">Primary</button>
            </ul>
        </li>
        </span>
      </div>
    </div>
  </div>


  <script>
/* 			
  createChart = function(year, month, day, interval)
 */
  Highcharts.chart('container', {

	    title: {
	        text: '제품 별 판매 그래프'
	    },

	    yAxis: {
	        title: {
	            text: '제품 별 판매'
	        }
	    },
	    
	    xAxis: {
	        type: 'datetime'
	    },
	    
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },

	    plotOptions: {
	        series: {
	        	pointStart: Date.UTC(2015, 7, 1),
	            pointInterval: 24 * 3600 * 1000 // one day
	        }	
	    },

	    series: [{
	        name: 'Installation',
	        data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175, 1000000, 200000]
	    }, {
	        name: 'Manufacturing',
	        data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
	    }, {
	        name: 'Sales & Distribution',
	        data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
	    }, {
	        name: 'Project Development',
	        data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
	    }, {
	        name: 'Other',
	        data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
	    }],

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
		</script>


</body>
</html>