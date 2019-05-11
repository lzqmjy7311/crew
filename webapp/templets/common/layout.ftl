<#macro page title>
  <html>
  <head>
    <title>FreeMarker Struts Example - ${title?upper_case}</title>
    <meta http-equiv="Content-type" content="text/html; charset=gb2312">
  </head>
  <body>
  	<center>
    	<h1>${title?html}</h1>
    </center>
    <hr>
    <hr>
    <table border="0" cellspacing=0 cellpadding=0 width="100%">
     	<#nested>
    </table>
  </body>
  </html>
</#macro>