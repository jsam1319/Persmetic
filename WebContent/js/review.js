$(document).ready(function() {
		/** 리뷰 등록 */
		$("#btnSubmit").click(function() {
			var data = $("#review_form").serialize();
			console.log(data)
			$.ajax({
				url : '/review_create.leaf',
  				data : data,
  				dataType : 'json',
  				type : 'POST',
  				success : function(msg) {
  					alert("상품평이 등록되었습니다.")
  					//location.href = "/detail_item.leaf?product_code=${product.productCode}"
  				},
  				error : function(msg) {
  					//alert("실패")
  				}
  			});
  				alert("리뷰등록완료");
  				location.href = "/detail_item.leaf?product_code=${product.productCode}"
  		})
  		
  		
  		/** 별점 처리 */
  		var starRating = function(){
			var $star = $(".star-input");
				
			  	$(document)
				.on("focusin", ".star-input>.input", 
					function(){
			   		 $(this).addClass("focus");
			 	})
					 
			   	.on("focusout", ".star-input>.input", function(){
			    	var $this = $(this);
			    	setTimeout(function(){
			      		if($this.find(":focus").length === 0){
			       			$this.removeClass("focus");
			     	 	}
			   		}, 100);
			 	 })
			  
			    .on("change", ".star-input :radio", function(){
			    	$("#grade").val($(this).next().text());
			  	})
			    .on("mouseover", ".star-input label", function(){
			    	$("#grade").val($(this).text());
			    })
			    .on("mouseleave", ".star-input>.input", function(){
			    	var $checked = $star.find(":checked");
			    		if($checked.length === 0){
			    			$("#grade").val("0");
			   		 	} else {
			   		 	$("#grade").val($checked.next().text());
			    		}
			  	});
			};

			starRating();
  
  	})