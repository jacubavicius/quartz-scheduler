package com.jacubavicius.quartz_scheduler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class QuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		String directory = "C:/Users/gabri/Downloads/my-directory";
//		
//		File dir = new File(directory);
//		
//		if(dir.exists() && dir.isDirectory()) {
//			String[] files = dir.list();
//			
//			if(files != null && files.length > 0) {
//				System.out.println("New files found");
//				
//				for(String file : files) {
//					System.out.println(file);
//				}
//			} else {
//				System.out.println("No new files found");
//			}
//		} else {
//			System.out.println("Directory not found");
//		}
		
		List<String> directories = List.of("C:/Users/gabri/Downloads/my-directory", "C:/Users/gabri/Downloads/my-directory-2");
		List<String> newFilesDirectories = new ArrayList<>();
		
		for(String dirPath : directories) {
			File dir = new File(dirPath);
			
			if(dir.exists() && dir.isDirectory()) {
				File[] files = dir.listFiles();
				
				if(files != null && files.length > 0) {
					newFilesDirectories.add(dirPath);
				}
			}
		}
		
		if (!newFilesDirectories.isEmpty()) {
			System.out.println("New files found in directories: " + newFilesDirectories);
		} else {
			System.out.println("No new files found");
		}
	}
}
