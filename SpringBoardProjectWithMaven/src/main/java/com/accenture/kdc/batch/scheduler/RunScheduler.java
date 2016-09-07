package com.accenture.kdc.batch.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

public class RunScheduler {
	
	private Logger logger = Logger.getLogger(RunScheduler.class);
	
	@Autowired
	private JobLauncher jobLauncher;
	
	private Job job;
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void run() {
		try {
			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//			String date = format.format(now);
			//어제로 셋팅함.
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			String date = format.format(cal.getTime());
			
			//테스트용
			//String date = "20140804";
			JobParameters jobParam = new JobParametersBuilder().addString("date", date).toJobParameters();
			
			JobExecution jobExecution = jobLauncher.run(job, jobParam);
			logger.info("JOB STATUS : " + jobExecution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
