<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="��̬��Ԥ��">
<div style='color:red;padding:5px;border:1px solid #999;width:90%'>
	 ͬ����������Ҫ����hasChild���ԣ��������ѡ�����ҽڵ�϶�ʹ�ø���</br>
	 ͬ����ǰ����Ⱦ��2.6��ǰ�汾֧�֣���Ч�ʽ��������ڵ㽨��500���ڣ���ֱ̨�ӷ���list&lt;TreeNode&gt;����</br>
	 ͬ���������Ⱦ��2.6�汾��ʼ֧�֣����ɺ����Ⱦ����html��Ч�ʽϸߣ���1500 IE8-2�����ң�������ǰ����genTreeHTML(list);����λȨ�����ò��øù��ܣ�</br></br>
	�첽������Ҫ�Լ���ѯ�Ƿ���hasChild���ԣ���̨д����ע��</br>
	�첽��ǰ����Ⱦ��2.6��ǰ�汾֧�֣���Ч�ʽϸߣ�ÿ��ֻ���ص�ǰ��ڵ㣬ǰ�˵��ʱ�������ز���Ⱦ��һ��ڵ�</br>
	 �첽�������Ⱦ��2.6�汾��ʼ֧�֣���Ч����ߣ�ÿ��ֻ���ص�ǰ��ڵ㣬�ɺ����Ⱦ����html��ǰ�˵��ʱ�������ز������Ⱦhtml����ǰ��
</div>
<br/>
<#assign result = "[{'id':1,'text':'delete','seperator':false,'iconCls':'','attributes':'','href':'','children':[]}]">
<@CommonQueryMacro.MenuItem id="mm" json=result />
<@CommonQueryMacro.CommonQuery id="TreeNode" init="true" submitMode="current" navigate="false">
<@CommonQueryMacro.SimpleButton id="b1" desc="ȫѡ" />
<@CommonQueryMacro.SimpleButton id="b2" desc="ȫ��ѡ" />
<@CommonQueryMacro.SimpleButton id="b3" desc="��ȡѡ�нڵ�" />
<@CommonQueryMacro.SimpleButton id="b4" desc="ˢ��ѡ�еĽڵ�" />
<@CommonQueryMacro.DynamicTree id="tree1" contextmenu="mm" checkbox="true"/>
<#-- mode="static" �����Ⱦ��������-->

</@CommonQueryMacro.CommonQuery>
<script>
function Menu_mm_onClick(item, data) {
	var t = data.tree;
	var n = data.node;
	DynamicTree_tree1.remove(n.id);
}
function b1_onClick(){
	DynamicTree_tree1.selectAll();
}
function b2_onClick(){
	DynamicTree_tree1.unSelectAll();
}
function b3_onClick(){
	alert(DynamicTree_tree1.getChecked());
}
function b4_onClick(){
	var n = DynamicTree_tree1.getSelected();
	if(n) {
		DynamicTree_tree1.refresh(n.id);
	} else {
		alert("��ѡ��");
	}
}

function DynamicTree_tree1_beforeExpandNode(_target, node){
	//alert(node.status); 0��ʾδѡ�� 1��ʾѡ�� 2��ʾ��ѡ��
	TreeNode_dataset.setParameter('paramChk',node.checked);
	return true;
}



</script>
</@CommonQueryMacro.page>