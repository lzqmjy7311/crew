<html>
<script type="text/javascript" src="${contextPath}/templets/ui/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	  function submit(){
	    	checkPwd();
	    	 window.location.href="http://www.qixianzhi.com/esEntprs/getEntDetailjt2.do?keyid=cc4e04136eaf21e1840b010adc892c88";
	    }
    

    /*—È÷§√‹¬Î*/
    function checkPwd(){
    	/* var reg = /^\w{6,10}$/; */
    	var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$/;
    	$.ajax({
    		url:'http://www.qixianzhi.com/login/selectCustomPwd',
    		type:'POST',
    		data:{'customId':'wangshaoping@gbicc.net','customPwd':'qwe123'},
    		dataType: 'jsonp',
    		async: false,
    		success:function(result){
    			/* console.log(result); */
    			if(result.ok==false){
    				/*  console.log(result.ok); */
    				return false;
    			}
    		},
    		error:function(){
    			console.log("error");
    		}
    	});
    	return true;
    }
	$(document).ready(function(){ 
	°°°° submit();
	}); 
 </script>    	
</html>