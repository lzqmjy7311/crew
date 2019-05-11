var _fileIncluded_tree=true;

var _rightclick_row=null;
var _stored_treeinfo=null;

function initTree(tree){
	tree.clearAllNodes=tree_clearAllNodes;
	tree.clearChildNodes=tree_clearChildNodes;
	tree.refreshNode=tree_refreshNode;
	tree.addNode=tree_addNode;
	tree.addDataNode=tree_addDataNode;
	tree.deleteNode=tree_deleteNode;
	tree.expandNode=tree_expandNode;
	tree.collapseNode=tree_collapseNode;
	tree.setActiveNode=tree_setActiveNode;
	tree.selectNode=tree_selectNode;

	for (var i=1; i<=8; i++){
		var tmpDataset=tree.getAttribute("dataset"+i);
		if (typeof(tmpDataset)!="undefined") eval("tree.dataset"+i+"="+tmpDataset+";");
	}

	tree.repeatrow=tree.rows[0].cloneNode(true);
	tree.deleteRow(0);

	tree.topNode=_createTreeNode(tree, null);
	if (tree.getAttribute("childNodes")){
		initTreeNodes(tree, tree.topNode, 0);
	}

	tree.expandNode(null);
	tree.setActiveNode(null);
	if (_isDropDownPage) tree.onclick=_dropdown_onclick;
}

function _createTreeNode(tree, parentNode){
	var level=0;
	if (parentNode){
		level=parentNode.level+1;
	}

	var newNode=new Object();
	newNode.childNodes=new pArray();
	newNode.tree=tree;
	newNode.level=level;
	newNode.parentNode=parentNode;
	newNode.expanded=false;

	var hasChild=getValidStr(tree.getAttribute("hasChild"+newNode.level));
	if (hasChild!=""){
		newNode.hasChild=isTrue(hasChild);
	}
	else{
		newNode.hasChild=true;
	}

	newNode.icon=tree.getAttribute("icon"+newNode.level);
	newNode.expandedIcon=tree.getAttribute("expandedIcon"+newNode.level);
	newNode.selectable=tree.getAttribute("selectable"+newNode.level);
	newNode.selected=tree.getAttribute("selected"+newNode.level);
	newNode.dataInited=false;
	return newNode;
}

function initTreeNodes(tree, parentNode, pos){
	if (!tree.treeNodes) return;
	while (pos<tree.treeNodes.length){
		var newNode=tree.addNode(parentNode, "");
		for(var i=0; i<8; i++){
			var newPos=tree.treeNodes.indexOf(",", pos);
			if (newPos>=0){
				var prop=tree.treeNodes.substring(pos, newPos);
				switch (i){
					case 0: newNode.label=getDecodeStr(prop); break;
					case 1: newNode.targetUrl=getDecodeStr(prop); break;
					case 2: newNode.icon=getDecodeStr(prop); break;
					case 3: newNode.expandedIcon=getDecodeStr(prop); break;
					case 4: newNode.hasChild=isTrue(prop); break;
					case 5: newNode.selectable=isTrue(prop); break;
					case 6: newNode.selected=isTrue(prop); break;
					case 7: newNode.tag=getDecodeStr(prop); break;
				}
			}
			else{
				return 99999;
			}
			pos=newPos+1;
		}

		if (tree.treeNodes.charAt(pos)!=";")
			pos=initTreeNodes(tree, newNode, pos);
		else
			pos++;

		if (tree.treeNodes.charAt(pos)==";") return pos+1;
	}
	return pos;
}

function getTreeNodeStyle(row){
	if (row.rowIndex % 2)
		return "row_odd";
	else
		return "row_even";
}

function refreshTreeNodeColor(row){
	var tree=getTableByRow(row);
	var selectedNode=tree.selectedNode;
	if (selectedNode && selectedNode.row==row){
		row.className="row_selected";
	}
	else{
		row.className=getTreeNodeStyle(row);
	}
}

function refreshTreeColor(tree, startIndex){
	var row;
	var maxIndex=tree.rows.length-1;
	for(var i=startIndex; i<=maxIndex; i++){
		row=tree.rows[i];
		refreshTreeNodeColor(row);
	}
}

function tree_clearAllNodes(tree){
	tree.clearChildNodes(tree);

	tree.expandNode();
	tree.setActiveNode(tree, null);
}

function refreshTreeNode(node){
	var row=node.row;
	if (row){
		for(var i=0; i<row.cells.length; i++){
			refreshElementValue(row.cells[i]);
		}
	}
}

function tree_refreshNode(node){
	refreshTreeNode(node);
}

function tree_addNode(parentNode, label, tag, mode, node){
	return _addTreeNode(this, parentNode, label, tag, null, mode, node);
}

function tree_addDataNode(parentNode, record){
	return _addTreeNode(this, parentNode, "", null, record);
}

function _addTreeNode(tree, parentNode, label, tag, record, mode, node){

	function getSlideNext(node){
		if (node){
			var result=node.nextUnit;
			if (!result) result=getSlideNext(node.parentNode);
			return result;
		}
	}

	var nodes=parentNode.childNodes;
	var newNode=_createTreeNode(tree, parentNode);
	newNode.label=label;
	newNode.tag=tag;
	newNode.record=record;

	if (record)
	{
		var dataField=tree.getAttribute("dataField"+newNode.level);
		if (dataField)
			newNode.label=record.getString(dataField);
		else
			newNode.label=record.getString(0);
	}

	var newRow;
	if (parentNode.expanded){
		var _mode, _node;
		switch (mode){
			case "begin":{
				_node=nodes.firstUnit;
				if (_node){
					_mode="before";
				}
				else{
					_mode="after";
					if (node) _node=node.parentNode;
				}
				break;
			}
			case "before":{
				_node=node;
				_mode="before";
				break;
			}
			case "after":{
				_node=node.nextUnit;
				if (_node){
					_mode="before";
				}
				else{
					_node=getSlideNext(node.parentNode);
					if (_node){
						_mode="before";
					}
					else{
						_mode="end";
					}
				}
				break;
			}
			default:{
				_node=getSlideNext(parentNode);
				if (_node){
					_mode="before";
				}
				else{
					_mode="end";
				}
				break;
			}
		}

		if (!_node){
			_mode="end";
		}
		else{
			var row=_node.row;
		}

		newRow=tree.repeatrow.cloneNode(true);
		switch (_mode){
			case "begin":{
				tree.tBodies[0].insertAdjacentElement("afterBegin", newRow);
				break;
			}
			case "before":{
				row.insertAdjacentElement("beforeBegin", newRow);
				break;
			}
			case "after":{
				row.insertAdjacentElement("afterEnd", newRow);
				break;
			}
			default:{
				tree.tBodies[0].insertAdjacentElement("beforeEnd", newRow);
				break;
			}
		}
		newRow.cells[0].node=newNode;
		newNode.row=newRow;
	}

	pArray_insert(nodes, mode, node, newNode);

	parentNode.hasChild=true;
	refreshTreeNode(parentNode);

	if (tree.selectedNode==null) tree.setActiveNode(newNode);

	var eventName=getElementEventName(tree, "onInitTreeNode");
	fireUserEvent(eventName, [tree, newNode]);

	refreshTreeNode(newNode);
	if (newRow) refreshTreeColor(tree, newRow.rowIndex);

	return newNode;
}

function tree_deleteNode(node){
	var tree=this;
	var parentNode=node.parentNode;
	var nodes=parentNode.childNodes;
	tree.collapseNode(node);
	pArray_delete(nodes, node);
	if (node.row){
		var rowIndex=node.row.rowIndex;
		node.row.removeNode(true);
		refreshTreeColor(tree, rowIndex);
		node.row=null;
	}

	if (node==tree.rightSelectedNode) tree.rightSelectedNode=null;
	if (node==tree.selectedNode){
		if (node.level>1){
			tree.setActiveNode(null);
		}
		else {
			tree.setActiveNode(parentNode);
		}
	}

	parentNode.hasChild=(parentNode.childNodes.length>0);
	refreshTreeNode(parentNode);
}

function _expandTreeNode(node){
	var nodes=node.childNodes;
	if (nodes.length<1) return;

	var tree=node.tree;
	var row=node.row;

	var _node=nodes.firstUnit;
	while (_node && (row || node.level==0)){
		var newRow=tree.repeatrow.cloneNode(true);
		if (row)
			row.insertAdjacentElement("afterEnd", newRow);
		else
			tree.tBodies[0].insertAdjacentElement("afterBegin", newRow);

		newRow.cells[0].node=_node;
		_node.row=newRow;
		refreshTreeNode(_node);

		row=newRow;
		_node=_node.nextUnit;
	}

	_node=nodes.firstUnit;
	while (_node){
		if (_node.expanded) _expandTreeNode(_node);
		_node=_node.nextUnit;
	}
}

function tree_expandNode(node){
	var tree=this;
	if (!node) node=tree.topNode;

	try{
		if (node.expanded) return;
		var eventName=getElementEventName(tree, "beforeExpandNode");
		var event_result=fireUserEvent(eventName, [tree, node]);
		if (event_result) throw event_result;

		if (!node.dataInited){
			eval("var child_dataset=tree.getAttribute(\"dataset"+(node.level+1)+"\");");
			if (child_dataset){
				if (node.level>0){
					eval("var dataset=tree.getAttribute(\"dataset"+node.level+"\");");
					if (dataset) dataset.setRecord(node.record);
				}

				var record=child_dataset.getFirstRecord();
				while (record){
					tree.addDataNode(node, record);
					record=record.getNextRecord();
				}
				node.dataInited=true;
			}
		}

		_expandTreeNode(node);

		var eventName=getElementEventName(tree, "afterExpandNode");
		fireUserEvent(eventName, [tree, node]);

		node.expanded=true;
		node.hasChild=(node.childNodes.length>0);
		if (node.row){
			refreshTreeColor(node.tree, node.row.rowIndex);
			refreshTreeNode(node);
		}
	}
	catch (e){
		processException(e);
	}
}

function _collapseTreeNode(node){
	if (node.childNodes.length<1) return;

	var _node=node.childNodes.firstUnit;
	while (_node){
		if (_node==_node.tree.selectedNode){
			_node.tree.selectedNode=null;
		}

		_collapseTreeNode(_node);
		if (_node.row) _node.row.removeNode(true);
		_node=_node.nextUnit;
	}
}

function tree_collapseNode(node){
	try{
		var tree=this;
		if (!node) return;
		if (!node.expanded) return;

		var eventName=getElementEventName(tree, "beforeCollapseNode");
		var event_result=fireUserEvent(eventName, [tree, node]);
		if (event_result) throw event_result;

		_collapseTreeNode(node);

		if (tree.selectedNode==null){
			tree.setActiveNode(node);
		}

		var eventName=getElementEventName(tree, "afterCollapseNode");
		fireUserEvent(eventName, [tree, node]);

		node.expanded=false;
		refreshTreeColor(node.tree, node.row.rowIndex);
		refreshTreeNode(node);
	}
	catch (e){
		processException(e);
	}
}

function tree_clearChildNodes(node){
	function deleteNodes(nodes){
		var unit=nodes.firstUnit;
		var _unit;
		while (unit){
			_unit=unit;
			unit=unit.nextUnit;
			tree.deleteNode(_unit);
		}
	}

	var tree=this;
	if (node){
		deleteNodes(node.childNodes);
		delete(node.childNodes);
                node.expanded=false;
                node.dataInited = false;
                node.childNodes = new pArray();
	}
	else{
		deleteNodes(tree.topNode.childNodes);
                tree.topNode.expanded=false;
                tree.topNode.dataInited = false;
                tree.topNode.childNodes = new pArray();
	}
}

function TreeNodeClick(tree, node){
	if (node && node.expanded){
		tree.collapseNode(node);
	}
	else{
		tree.expandNode(node);
	}
}

function processNodeChanged(){
	var tree=_stored_treeinfo[0];
	var node=_stored_treeinfo[1];
	var eventName=getElementEventName(tree, "afterNodeChanged");
	if (isUserEventDefined(eventName))
		fireUserEvent(eventName, _stored_treeinfo);

	if (getValidStr(node.targetUrl)!=""){
		open(node.targetUrl, tree.getAttribute("targetFrame"));
	}
}

function tree_setActiveNode(node){
	try{
		var tree=this;
		if (!node) node=tree.topNode.childNodes.firstUnit;

		var eventName=getElementEventName(tree, "beforeNodeChanged");
		if (isUserEventDefined(eventName)){
			var event_result=fireUserEvent(eventName, [tree, node]);
			if (event_result) throw event_result;
		}

		var old_node=tree.selectedNode;
		var old_row, row;
		if (old_node) old_row=old_node.row;
		if (node) row=node.row;

		if (old_row!=row){
			tree.selectedNode=node;
			if (old_row) refreshTreeNodeColor(old_row);
			if (row) refreshTreeNodeColor(row);

			clearTimeout(tree.timeout_id);
			_stored_treeinfo=[tree, node];
			tree.timeout_id=setTimeout("processNodeChanged();", 400);
		}
	}
	catch (e){
		processException(e);
	}
}

function resetRightClickRow(){
	try{
		if (_rightclick_row){
			var tree=getTableByRow(_rightclick_row);
			tree.rightSelectedNode=null;
			refreshTreeNodeColor(_rightclick_row);
		}
	}
	catch (e){
		//do nothing
	}
	finally{
		_rightclick_row=null;
	}
}

function _tree_expendclick(button){
	var cell=button.treenode;
	var row=getRowByCell(cell);
	var node=row.cells[0].node;
	var tree=getTableByRow(row);

	TreeNodeClick(tree, node);
	event.cancelBubble=true;
}

function _tree_onmousedown(row){
	if (event.srcElement.id=="_button_expand") return;

	var tree=getTableByRow(row);
	var selectedNode=tree.selectedNode;
	var node=row.cells[0].node;

	if (event.button==2){
		if (isTrue(tree.getAttribute("supportRightClick"))){
			tree.rightSelectedNode=node;
			row.className="row_rightclick";

			try{
				if (_rightclick_row) refreshTreeNodeColor(_rightclick_row);
			}
			catch (e){
				//do nothing
			}
			_rightclick_row=row;
			setTimeout("resetRightClickRow()", 1000);
		}
		else
			tree.setActiveNode(node);
	}
	else{
		tree.setActiveNode(node);
	}
}

function processTreeKeyDown(tree, keycode){

	function getCurrentNode(){
		var node=tree.selectedNode;
		if (!node){
			var nodes=tree.topNode.childNodes;
			node=nodes.firstUnit;
		}
		return node;
	}

	switch (keycode){
		//Left
		case 37:{
			var node=getCurrentNode();
			if (node && node.hasChild && node.expanded){
				TreeNodeClick(tree, node);
			}
			break;
		}
		//Up
		case 38:{
			var node=getCurrentNode();
			var rowIndex=node.row.rowIndex;
			if (rowIndex>0){
				tree.setActiveNode(tree.rows[rowIndex-1].cells[0].node);
			}
			break;
		}
		//Right
		case 39:{
			var node=getCurrentNode();
			if (node && node.hasChild && !node.expanded){
				TreeNodeClick(tree, node);
			}
			break;
		}
		//Down
		case 40:{
			var node=getCurrentNode();
			var rowIndex=node.row.rowIndex;
			if (rowIndex+1<tree.rows.length){
				tree.setActiveNode(tree.rows[rowIndex+1].cells[0].node);
			}
			break;
		}
	}
}

function _tree_onkeydown(tree){
	processTreeKeyDown(tree, event.keyCode);
}

function _tree_checkbox_onClick(){
	var node=event.srcElement.node;
	var tree=node.tree;
	if (node) tree.selectNode(node, !node.selected);
}

function _selectTreeNode(tree, node, selected) {
	if (node.selected != selected) {
		node.selected = selected;
		tree.refreshNode(node);

		var eventName=getElementEventName(tree, "onSelectionChanged");
		fireUserEvent(eventName, [tree, node]);
	}
}

function tree_selectNode(node, selected) {
	_selectTreeNode(this, node, selected);
}
