var curPane="tip1";
function show(switchSysBar)
{
if(switchSysBar==curPane){return;}
document.getElementById(curPane).style.display="none";
document.getElementById(switchSysBar).style.display="block";
curPane=switchSysBar;
}
