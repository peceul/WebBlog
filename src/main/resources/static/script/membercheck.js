/**
 * JQuery Ajax를 이용해 id 중복확인 체크
 */

 $(function(){
	 $("#blogid").keyup(function() {
		 let mid = $(this).val();
		 if (mid.trim().length < 3 || mid.trim().length > 10) {
			 $("#idcheck").css("color", "red");
			 $("#idcheck").text('아이디는 5~8자 사이로 입력해 주세요.');
			 return false;
		 } else {
		 	 $("#idcheck").css("color", "green");
			 $("#idcheck").text('');			 
		 }

		 $.ajax({
			 method : "GET",
			 url : "idCheck",
			 data : {"blogid" : mid},
			 success : function(resp) {
				 if (resp == true) {
					$("#idcheck").css("color", "green");
				 	$("#idcheck").text('사용할 수 있는 아이디 입니다.');
				 	$("#complete").remove();
				 	$("#submitabove").before('<input type="submit" name="complete" id="complete" value="가입">');
				 } else if (resp == false) {
					$("#idcheck").css("color", "red");
				 	$("#idcheck").text('사용할 수 없는 아이디 입니다.');
				 	$("#complete").remove();
				 }
			 }
		 })
	 })
 })