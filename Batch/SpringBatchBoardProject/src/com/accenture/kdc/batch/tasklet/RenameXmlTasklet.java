package com.accenture.kdc.batch.tasklet;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class RenameXmlTasklet implements Tasklet, InitializingBean {

	private Resource directory;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		File dir = directory.getFile();
		
		File[] files = dir.listFiles();
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.getName().endsWith(".xml")) {
					File renameFile = new File(file.getAbsoluteFile() + ".old");
					boolean renamed = file.renameTo(renameFile);
					if (!renamed) {
						throw new UnexpectedJobExecutionException("파일명 변경 실패 : " + file.getPath());
					}
				}
			}
		}
		return RepeatStatus.FINISHED;
	}

	public Resource getDirectory() {
		return directory;
	}

	public void setDirectory(Resource directory) {
		this.directory = directory;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(directory, "디렉토리 설정 실패");
	}

}
