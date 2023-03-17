/**
 * 
 */

 function remove(link) {
	let rem = confirm("정말로 이 글을 삭제하시겠습니까?");
	if (rem) {
		window.location.assign(link);
		return true;
	} else {
		return false;
	}
 }
 
  function update(link) {
	let rem = confirm("정말로 이 글을 수정하시겠습니까?");
	if (rem) {
		window.location.assign(link);
		return true;
	} else {
		return false;
	}
 }