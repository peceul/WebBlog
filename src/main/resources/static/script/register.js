/* 회원정보 검증하기 */
 function validate() {
	 
	 let blogid = document.getElementById("blogid");
	 let blogpwd = document.getElementById("blogpwd");
	 let bloggername = document.getElementById("bloggername");
	 
	 if (blogid.value.trim().length < 3 || blogid.value.trim().length > 10) {
		alert("ID는 3~10자 사이로 입력하세요.");
		//해당 element를 선택하여 블록을 씌움
		blogid.focus();
		blogid.select();
		return false;
	 }

	 if (blogpwd.value.length < 3 || blogpwd.value.length > 10) {
		alert("비밀번호는 3~10자 사이로 입력하세요.");
		//해당 element를 선택하여 블록을 씌움
		blogpwd.focus();
		blogpwd.select();
		return false;
	 }	 
	 
	 if (bloggername.value.trim().length <= 0) {
		alert("이름을 다시 입력해 주세요.");
		//해당 element를 선택하여 블록을 씌움
		bloggername.focus();
		bloggername.select();
		return false;
	 }
	 
 }