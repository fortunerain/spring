package com.terry.hellobatch.IF_Example1.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

// ref http://www.jroller.com/0xcafebabe/entry/spring_batch_hello_world_1


public class PrintTasklet implements Tasklet {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		System.out.println(message);
		return RepeatStatus.FINISHED;
	}
}
