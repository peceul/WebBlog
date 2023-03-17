/**
 * Ajax 통신으로 SQL 처리 후 데이터를 다시 화면에 전송
 */

function recommend(blogseq) {	
	let url = document.getElementById("address").value;
	console.log(blogseq);
	console.log(url);
	$.ajax({
		method : "GET",
		url : url,
		data : {"blogseq" : blogseq},
		success : function(resp) {
				$("#likecount").remove();
				$("#countlabel").after('<td id="likecount" name="likecount" style="text-align:center;">' + resp + '</td>');
			
			/*if (resp == "OK") {
				$("#CheckResult").css("color", "green");
				$("#CheckResult").text('사용할 수 있는 아이디 입니다.');
				$("#joinbutton").remove();
				$("#resetbutton").before('<input type="submit" id="joinbutton" value=" 가입 ">');
				$("#joinbutton").after("&nbsp;&nbsp;");
			} else if (resp == "Fail") {
				$("#CheckResult").css("color", "red");
				$("#CheckResult").text('사용할 수 없는 아이디 입니다.');
				$("#joinbutton").remove();
			}*/
		}
	})
}