/**
 * 
 */
  function update() {
	let rem = confirm("정말로 이 글을 수정하시겠습니까?");
	if (rem) {
		document.getElementById("updateboard").submit();
		return true;
	} else {
		return false;
	}
}