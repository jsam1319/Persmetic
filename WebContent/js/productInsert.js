
$(document).ready(
		function() {
			/** CKEDITOR 사진 등록 */
			var frontImage = "";

			CKEDITOR.replace(
			'contents',{
						'filebrowserUploadUrl' : 'insert_item/upload.leaf',
					 	'realUrl' : 'http://localhost/uploadphoto/',
						'&realDir' : 'C:/Users/kosta/git/Persmetic/WebContent/uploadphoto/' 
			});
			
			console.log(CKEDITOR);
		
			/** 상품 대표 이미지 등록 */
			var imageUp = $('input[type=file]');
			var formData = new FormData();
			
			imageUp.change(function() {
				var fileName = $('input[type=file]')[0].files[0].name;
				frontImage = fileName;
			//	console.log($("#upload").attr("src"));
			//	console.log($('input[type=file]')[0].files[0]);
				formData.append('upload', $('input[type=file]')[0].files[0]);
														
			//	console.log(formData);

			//	alert(fileName);
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
				$("#front_image").append("<img style=\"max-width: 100%; id=\"upload\" height: 100%;\" src=\"/uploadphoto/"
											+ fileName + "\">");
			})

			
			/** 상품등록 */
			$("#btnSubmit").click(function() {
				var param = $("#product_form").serialize();
				
				param = param + CKEDITOR.instances.contents.getData();
				param = param + "&image="+ frontImage;
				
				console.log(param);
				
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
		})