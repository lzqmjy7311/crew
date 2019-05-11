package com.gbicc.bpm;

import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;
import org.activiti.engine.impl.bpmn.parser.handler.UserTaskParseHandler;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;

/**
 * 自定义UserTaskParseHandler，覆盖原先：UserTaskParseHandler
 * 如：
 * TaskListener.EVENTNAME_CREATE  -任务创建监听器
 * TaskListener.EVENTNAMECOMPLETE -任务完成监听器
 * @date    2016年1月18日
 * @author  tangdu
 * @desc
 */
public class CustomUserTaskParseHandler extends UserTaskParseHandler {

	@Override
	protected void executeParse(BpmnParse bpmnParse, UserTask userTask) {
		ActivityImpl activity = createActivityOnCurrentScope(bpmnParse,
				userTask, "userTask");
		activity.setAsync(userTask.isAsynchronous());
		activity.setExclusive(!userTask.isNotExclusive());
		TaskDefinition taskDefinition = parseTaskDefinition(bpmnParse,
				userTask, userTask.getId(), (ProcessDefinitionEntity) bpmnParse
						.getCurrentScope().getProcessDefinition());
		taskDefinition.addTaskListener(TaskListener.EVENTNAME_CREATE,
				new CustomCreateTaskListener());
		activity.setProperty("taskDefinition", taskDefinition);
		activity.setActivityBehavior(bpmnParse.getActivityBehaviorFactory()
				.createUserTaskActivityBehavior(userTask, taskDefinition));

	}

}
