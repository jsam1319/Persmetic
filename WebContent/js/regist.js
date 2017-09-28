
window.onload = function(){
	document.getElementById("btnSubmit").onclick = function(){
		
		if($("#ctm_name").val().trim() == ""){
		      $("#nameCheck").html("");
		      
		 }	
		if($("#ctm_passwd").val().trim() == ""){
			 $("#pwCheck").html("");
		      return false;			
		}
		if($("#checkPw").val().trim() == ""){
			 $("#repwCheck").html("");
		      return false;			
		}
		if($("#checkPw").val().trim() != $("#ctm_passwd").val().trim()  ){
			 $("#repwCheck").html("비밀번호가 일치하지 않습니다.");
		}else{
				 $("#repwCheck").html(""); 
   					
		}
		if($("#ctm_email").val().trim() == ""){
			 $("#emailCheck").html("");
		      return false;			
		}
		if($("#ctm_age").val().trim() == ""){
			 $("#ageCheck").html("");
		      return false;			
		}
		if($("#ctm_gender").val().trim() == '선택'){
			 $("#genderCheck").html("성별을 선택하세요.");
		      return false;			
		}
		if($("#ctm_job").val().trim() == '선택'){
			 $("#jobCheck").html("직업을 선택하세요.");
		      return false;			
		}
		if($("#ctm_address").val().trim() == ""){
			 $("#addressCheck").html("");
		      return false;			
		}
	}

	document.getElementById("btnId").onclick = function() {
		var id = document.getElementById("ctm_id")[0].value;
		
		ajax({
			method: "get",
			url: "regist_check.jsp",
			param: "ctm_id="+id,
			success: receiveMessage
		});
	}
	
	
	console.log($("#btnSubmit"));
	
}

function receiveMessage(request){
	var message = request.responseText;
	var check = document.getElementById("IDcheck");
	check.innerHTML = message;
}

