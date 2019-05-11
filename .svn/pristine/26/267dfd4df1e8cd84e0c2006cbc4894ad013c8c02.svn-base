<#-- 打印按钮 -->
<#macro print>
<input type=button name=print value="打印" onClick="javascript:window.print()" />
</#macro>

<#--文字栏-->
<#macro bulletin bulletintitle name id>
<TABLE  id="${id}" name="${name}" WIDTH="99%" BORDER="0" CELLSPACING="1" CELLPADDING="3">
	<TR><TD>
			<TABLE WIDTH="80%" BORDER="0" CELLSPACING="0" CELLPADDING="0" ALIGN="left" BORDERCOLOR="#DFDFDF">
			<tr><td>
			<TABLE WIDTH="100%" BORDER="1" CELLSPACING="2" CELLPADDING="5" ALIGN="left" BORDERCOLOR="#DFDFDF">
				<TR><TD BGCOLOR="#88B8EF" CLASS="unnamed1" ALIGN="center">
						<DIV ALIGN="LEFT"><B><FONT SIZE="2" COLOR="#FFFFFF"> 
						<IMG SRC="${contextPath}/page/resources/image/common/b_kuk.gif" WIDTH="6" HEIGHT="10">&nbsp;&nbsp;${bulletintitle}</FONT></B></DIV>
					</TD></TR>
			</TABLE></TD></TR>
	<TR><TD>
			<TABLE WIDTH="500" BORDER="0" CELLSPACING="0" CELLPADDING="0" align="center">	
				<TR><TD colspan="3">&nbsp;</TD></TR>
				<TR><TD colspan="3"><IMG SRC="${contextPath}/page/resources/image/common/tiao-down-blue.jpg" WIDTH="500" HEIGHT="23"></TD></TR>
				<TR><TD width="20"  BGCOLOR="#EDF1F9"></TD>
				    <TD VALIGN="TOP"  BGCOLOR="#EDF1F9"><#nested></TD>
				    <TD width="20"  BGCOLOR="#EDF1F9"></TD></TR>
				<TR><TD colspan="3"><IMG SRC="${contextPath}/page/resources/image/common/tiao-up-blue.jpg" WIDTH="500" HEIGHT="23"></TD></TR>
			</TABLE></TD></TR></table></td></tr>
</TABLE>
</#macro>

<#--欢迎栏-->
<#macro welcomepanel OprID>
<DIV class=main style="WIDTH: 80%">
  <DIV class=panel>
    <P>当前登录柜员：<STRONG style="COLOR: #d3646d">${OprID}</STRONG> 
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现在时间：
      <script language=JavaScript>         
       today=new Date();
       function initArray()
       {
          this.length=initArray.arguments.length
          for(var i=0;i<this.length;i++)
          this[i+1]=initArray.arguments[i]  
       }
       
       var d=new initArray(
       "星期日",
       "星期一",
       "星期二",
       "星期三",
       "星期四",
       "星期五",
       "星期六");
       
       document.write(
          "<font color=##000000 style='font-size:9pt;font-family: 宋体'> ",
          today.getYear(),"年",
          today.getMonth()+1,"月",
          today.getDate(),"日   ",
          d[today.getDay()+1],
          "</font>" ); 
      </script>

</#macro>
