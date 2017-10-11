$(document).ready(function() {
	/** url에 get방식으로 전송된 데이터 값 가져오기 */
	function getQuerystring(paramName){
		var tempUrl = window.location.search.substring(1); 		
		var tempArray = tempUrl.split('&'); 					
		for(var i = 0; tempArray.length; i++) { 
			var keyValuePair = tempArray[i].split('=');			
			if(keyValuePair[0] == paramName){ 					
																
				return keyValuePair[1]; 
			} 
		} 
	}
	//*******1) detail url에 product_code만 들어갔을 때 split('&') error 안걸리는 법 ->임시방편 : category->detail url에 &page=1 붙여놓음
	var productCode = getQuerystring('product_code');
	var page = getQuerystring('page');
	
	listPrint();
	
	
	/** 페이지 버튼 값 가져오기 */
	$('.page').each(function(i){
			$(this).click(function(e){
				e.preventDefault();
				page = $(this).attr('value')
				listPrint();
			});
		});
	
	
	/** 리스트출력 ajax */
	function listPrint(){
		$.ajax({
			url: "review_list.leaf",
			dataType: "json",
			data : {
				"product_code" : productCode,
				"page" : page
			},
			success: function(data){
				reviewList(data)
			},
			error : function(data, a, b){
				reviewList(data)
				console.log(a);
				console.log(b);
			}
		})
	  }
	
	/** 리뷰등록 버튼 클릭 */
	$("#reviewbtn").click(function() {
		location.href = "review_write.leaf?productCode="+productCode+"&ctmNo=${cookie.customer.value}"
	})
	
});


function reviewList(data){
	var list = "";
	
	var json = data;

	for(var i in json.reviews) {
		var grade = "";
		for(var g=0; g<json.reviews[i].reviewGrade; g++){
			grade += "<i class='fa fa-star'></i>"
		}
		list += "<div><div class='col-md-2'>";
		list += "<p>" + json.reviews[i].ctmId + "</p>";
		list += "<p>" + grade + "</p>";
		list += "</div>"
		list += "<div class='col-md-4'>"
		list += "<p>" + json.reviews[i].productCode + "</p>";
		list += "<p>" + json.reviews[i].productName + "</p>";
		list += "<p>" + json.reviews[i].reviewTitle + "</p>";
		list += "</div>"
		list += "<div class='col-md-2'>"
		list += "<p>" + json.reviews[i].reviewDate + "</p>";
		list += "</div></div>"
		list += "<div class='col-md-12'> <hr> </div>"
		
		var productCode = json.reviews[i].product_code
	}
	$("#listView").html(list);
	
}