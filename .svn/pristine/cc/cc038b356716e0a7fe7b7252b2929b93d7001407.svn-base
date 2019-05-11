_SHOW_FLAG = false;
//MODIFY BMS-2142
dwr.engine.setErrorHandler(
	function errh(errorString,exception){
		if(typeof(exception)=="object"){
			if(exception.name == "GD0101"){
				//GD0101=鎿嶄綔鍛樻棤姝ゅ姛鑳芥潈闄�
				errAlert(errorString);
				setTimeout('returnRoot()',2000);
				errAlert = function(){};
			}else if(exception.name == "GD0102"){
				//GD0102=鎿嶄綔鍛樹細璇濇棤鏁�
				errAlert(errorString);
				setTimeout('returnRoot()',2000);
				errAlert = function(){};
			}else if(exception.name == "GD0103"){
				//GD0103=姝や細璇濆凡缁忚鍏朵粬鎿嶄綔鍛樼粦瀹�
				errAlert(errorString);
				top.location.href = _application_root;
				errAlert = function(){};
			}else{
				errAlert(errorString);
			}
		}else{
			errAlert(errorString);
		}
	}
);

function returnRoot(){
	top.location.href = _application_root;
}

//END BMS-2142
//This is fairly simple and makes it quite easy to implement your own "loading" message.
function useLoadingMessage(message) {
  var loadingMessage;
  if (message) loadingMessage = message;
  else loadingMessage = "Loading";
  dwr.engine.setPreHook(function() {
    var disabledZone = $('#disabledZone')[0];
    if (!disabledZone) {
      disabledZone = document.createElement('div');
      disabledZone.setAttribute('id', 'disabledZone');
      disabledZone.style.position = "absolute";
      disabledZone.style.zIndex = "1000";
      disabledZone.style.left = "0px";
      disabledZone.style.top = "0px";
      disabledZone.style.width = "100%";
      disabledZone.style.height = "100%";
      document.body.appendChild(disabledZone);
      var messageZone = document.createElement('div');
      messageZone.setAttribute('id', 'messageZone');
      messageZone.style.position = "absolute";
      messageZone.style.top = "0px";
      messageZone.style.right = "0px";
      messageZone.style.background = "red";
      messageZone.style.color = "white";
      messageZone.style.fontFamily = "Arial,Helvetica,sans-serif";
      messageZone.style.padding = "4px";
      disabledZone.appendChild(messageZone);
      var text = document.createTextNode(loadingMessage);
      messageZone.appendChild(text);
    }
    else {
      $('#messageZone')[0].innerHTML = loadingMessage;
      disabledZone.style.visibility = 'visible';
    }
  });

  dwr.engine.setPostHook(function() {
    $('#disabledZone')[0].style.visibility = 'hidden';
  });
}

function useLoadingImage(imageSrc) {
  if (imageSrc) loadingImage = imageSrc;
  else loadingImage = "ajax-loader.gif";
  dwr.engine.setPreHook(function(){funPreHook(imageSrc);});
  dwr.engine.setPostHook(function(){funPostHook();});
}

function funPostHook(targetDoc){
 //document.body.style.backgroundColor = '#FFFFFF';
 //document.body.removeChild($('imageZone'));
 //document.body.removeChild($('disabledImageZone'));
 var _document = targetDoc;
 if(!_document){
 	_document = document;
 }
 var _diz = _document.getElementById('disabledImageZone');
 if (_diz) {
	_diz.style.visibility = 'hidden';
	_diz.style.width = 0;
	_diz.style.height = 0;
 }
 var _iz = _document.getElementById('imageZone');
 if (_iz) {
	_iz.style.visibility = 'hidden'
	_iz.style.top = 0;
	_iz.style.left = 0;
 }
}
function funPreHook(imageSrc, targetDoc) {
    //document.body.style.backgroundColor = '#EEEEEE';
    var _document = targetDoc;
    if(!_document){
    	_document = document;
    }
    var disabledImageZone = _document.getElementById("disabledImageZone");
    if (!disabledImageZone) {
      disabledImageZone = _document.createElement('div');
      disabledImageZone.setAttribute('id', 'disabledImageZone');
      disabledImageZone.style.backgroundColor = '#FFFFFF';
      disabledImageZone.style.position = "absolute";
      disabledImageZone.style.zIndex = "10001";
      disabledImageZone.style.left = "0px";
      disabledImageZone.style.top = "0px";
      disabledImageZone.style.width = winsize().width + "px";//_document.body.scrollLeft + _document.body.scrollWidth;
	  disabledImageZone.style.height = winsize().height + "px";//_document.body.scrollHeight + _document.body.scrollTop;
      disabledImageZone.style.filter = "alpha(opacity=20)";
      disabledImageZone.style.opacity= 0.2;
      var imageZone = _document.createElement('img');
      imageZone.setAttribute('id','imageZone');
      imageZone.setAttribute('src',imageSrc);
      imageZone.style.position = "absolute";
      imageZone.style.zIndex = "10002";
      imageZone.style.backgroundColor = '#FFFFFF';
      imageZone.style.width = "32";
      imageZone.style.height = "32";
//      imageZone.style.left = (_document.body.offsetWidth-parseInt(imageZone.style.width))/2;
//      imageZone.style.top =(_document.body.scrollTop+(_document.body.clientHeight-imageZone.offsetHeight)/2);
      imageZone.style.top = ($(window)._outerHeight() - $(imageZone).height()) / 2 + $(document).scrollTop() + "px"; 
      imageZone.style.left = ($(window)._outerWidth() - $(imageZone).width()) / 2 + $(document).scrollLeft() + "px"; 

      _document.body.appendChild(disabledImageZone);
      _document.body.appendChild(imageZone);
      disabledImageZone.style.visibility = 'visible';
      imageZone.style.visibility = 'visible';
      disabledImageZone.style.display = "";
      imageZone.style.display = "";
    }
    else {
    	v_imageZone = _document.getElementById("imageZone");
      if(v_imageZone){
      	v_imageZone.style.top =($(window)._outerHeight() - $(v_imageZone).height()) / 2 + $(document).scrollTop() + "px"; 
      	v_imageZone.style.left = ($(window)._outerWidth() - $(v_imageZone).width()) / 2 + $(document).scrollLeft() + "px"; 
        disabledImageZone.style.width = winsize().width + "px";//_document.body.scrollLeft + _document.body.scrollWidth;
  	    disabledImageZone.style.height = winsize().height + "px";//_document.body.scrollHeight + _document.body.scrollTop;
   	    disabledImageZone.style.visibility = 'visible';
   	    v_imageZone.style.visibility = 'visible';
   	   }
    }
  }

function showLoadingImage(imageSrc,isshow) {
  var loadingImage;
  if (imageSrc) loadingImage = imageSrc;
  else loadingImage = "ajax-loader.gif";
  if( isshow ){
   document.body.style.backgroundColor = '#EEEEEE';
    var disabledImageZone = $('#disabledImageZone')[0];
    if (!disabledImageZone) {
      disabledImageZone = document.createElement('div');
      disabledImageZone.setAttribute('id', 'disabledImageZone');
      disabledImageZone.style.position = "absolute";
      disabledImageZone.style.zIndex = "1000";

      var imageZone = document.createElement('img');
      imageZone.setAttribute('id','imageZone');
      imageZone.setAttribute('src',imageSrc);
      imageZone.style.position = "absolute";
      imageZone.style.top = "0px";
      imageZone.style.right = "0px";
      imageZone.style.width = "32";
      imageZone.style.height = "32";
      disabledImageZone.appendChild(imageZone);

      disabledImageZone.style.width = imageZone.style.width;
      disabledImageZone.style.height = imageZone.style.height;
      disabledImageZone.style.left = (document.body.offsetWidth-parseInt(disabledImageZone.style.width))/2;
      disabledImageZone.style.top = (document.body.offsetHeight-parseInt(disabledImageZone.style.height))/2;
      document.body.appendChild(disabledImageZone);
    }
    else {
      $('#imageZone')[0].src = imageSrc;
      disabledImageZone.style.visibility = 'visible';
    }
   }else{
    document.body.style.backgroundColor = '#FFFFFF';
    $('#disabledImageZone')[0].style.visibility = 'hidden';
    }
}



function showPageLoadingImage(imageSrc,isshow) {
  var loadingImage;
  if( !imageSrc ){
  	loadingImage =  "/pageloading.gif";
  }else{
  	loadingImage = imageSrc;
  }
  if( isshow ){
   document.body.style.backgroundColor = '#EEEEEE';
    var disabledImageZone = document.getElementById('disabledLoadingImageZone');
    if (!disabledImageZone) {
      disabledImageZone = document.createElement('div');
      disabledImageZone.setAttribute('id', 'disabledImageZone');
      disabledImageZone.style.position = "absolute";
      disabledImageZone.style.zIndex = "1000";

      var imageZone = document.createElement('img');
      imageZone.setAttribute('id','imageZone');
      imageZone.setAttribute('src',loadingImage);
      imageZone.style.position = "absolute";
      imageZone.style.top = "0px";
      imageZone.style.right = "0px";
      imageZone.style.width = "214";
      imageZone.style.height = "15";
      disabledImageZone.appendChild(imageZone);

      disabledImageZone.style.width = imageZone.style.width;
      disabledImageZone.style.height = imageZone.style.height;
      disabledImageZone.style.left = (document.body.offsetWidth-parseInt(disabledImageZone.style.width))/2;
      disabledImageZone.style.top = (document.body.offsetHeight-parseInt(disabledImageZone.style.height))/2;
      document.body.appendChild(disabledImageZone);
    }
    else {
      document.getElementById('imageZone').src = loadingImage;
      disabledImageZone.style.visibility = 'visible';
    }
   }else{
    document.body.style.backgroundColor = '#FFFFFF';
    document.getElementById('disabledLoadingImageZone').style.visibility = 'hidden';
    }
}