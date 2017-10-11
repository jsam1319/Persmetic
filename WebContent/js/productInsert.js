
$(document).ready(function() {
	
			/** CKEDITOR 사진 등록 */
			var frontImage = "";

			CKEDITOR.replace(
			'contents',{
						'filebrowserUploadUrl' : 'insert_item/upload.leaf',
					 	'realUrl' : 'http://localhost/uploadphoto/',
						'&realDir' : 'C:/Users/kosta/git/Persmetic/WebContent/uploadphoto/' 
			});
			
		
			
			/** 상품 대표 이미지 등록 */
			var imageUp = $('input[type=file]');
			var formData = new FormData();
			
			imageUp.change(function() {
				var fileName = $('input[type=file]')[0].files[0].name;
				frontImage = fileName;
				formData.append('upload', $('input[type=file]')[0].files[0]);
														

				$.ajax({
					url: '/insert_item/upload.leaf?image_name=' + fileName,
					dataType: 'json',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					success: function(msg){
						alert(msg);
					},
					error: function(msg) {
						console.log(msg);
					}
				}); 
						
				$("#front_image").html("");
				$("#front_image").append("<img style=\"max-width: 280px; max-height: 280px; id=\"upload\" height: 100%;\" src=\"/uploadphoto/"
											+ fileName + "\">");
			})

			
			
			/** 상품등록 */
			$("#btnSubmit").click(function() {
				var param = $("#product_form").serialize();
				
				param = param + CKEDITOR.instances.contents.getData();
				param = param + "&image="+ frontImage;
				
				$.ajax({
					url : '/insert_item/create.leaf',
					data : param,
					dataType : 'json',
					type : 'POST',
					success : function(msg) {
						alert('상품등록 완료!');
					},
	    			error : function(msg) {
	    				alert(msg)
	    			}
				});
														
				location.href = "/list_item.leaf?page=1";
			})		
			
			
			/** 카테고리 다중 옵션 */
			$(function(){
				$("#category").change(function(){
					var sel = $("#category2");
					var value = $(this).val();
					sel.children().remove();
					sel.append('<option value="">카테고리</option>');
					
					if(value == '100'){
						sel.append('<option value="110">파운데이션</option>');
						sel.append('<option value="120">쿠션</option>');
						sel.append('<option value="130">파우더&컴팩트</option>');
						sel.append('<option value="140">메이크업 베이스&컨실러</option>');
						sel.append('<option value="150">블러셔&하이라이터</option>');
					}else if(value == '200'){
						sel.append('<option value="210">마스카라</option>');
						sel.append('<option value="220">아이섀도</option>');
						sel.append('<option value="230">아이브로우</option>');
					}else if(value == '300'){
						sel.append('<option value="310">립스틱</option>');
						sel.append('<option value="320">틴트&립글로즈</option>');
					}

					
				})
				
			})
			
			
		})