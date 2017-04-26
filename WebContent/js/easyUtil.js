/**
 * 页面工具类
 */
function formatDate(now){
	now = new Date(parseInt(now));
	var year = now.getYear()+1900;
	var month = now.getMonth()+1;
	var date = now.getDate();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
}


