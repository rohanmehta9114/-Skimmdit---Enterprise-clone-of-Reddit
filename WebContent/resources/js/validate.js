/**
 * 
 */
function validate() {
		var i = 0;
		
		if (document.submitForm.title.value == 0) {
			document.getElementById("title1").style.display = '';
			i++;
		} else {
			document.getElementById("title1").style.display = 'none';
		}
		
		if (document.submitForm.link.value == 0) {
			document.getElementById("link1").style.display = '';
			i++;
		} else {
			
				document.getElementById("link1").style.display = 'none';
			}
		if (i >= 1) {
			return false;
		} else {
			return true;
		}
}