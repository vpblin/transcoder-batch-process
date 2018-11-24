package com.blinkazazi;


import java.util.Arrays;
import java.util.List;

import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoder;
import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoderClient;
import com.amazonaws.services.elastictranscoder.model.CreateJobOutput;
import com.amazonaws.services.elastictranscoder.model.CreateJobPlaylist;
import com.amazonaws.services.elastictranscoder.model.CreateJobRequest;
import com.amazonaws.services.elastictranscoder.model.Job;
import com.amazonaws.services.elastictranscoder.model.JobInput;
import com.amazonaws.services.elastictranscoder.model.JobWatermark;
import com.amazonaws.services.elastictranscoder.model.ListJobsByPipelineRequest;

public class Transcoder {
    private static final String PIPELINE_ID = "PIPELINE_ID";
    private static final AmazonElasticTranscoder amazonElasticTranscoder = new AmazonElasticTranscoderClient();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int video_id = 1; video_id < 150; video_id ++) {
			String INPUT_KEY = "file/path/"+video_id+".mp4";

	        JobInput input = new JobInput()
	                .withKey(INPUT_KEY);

	        JobWatermark lowerWaterMark = new JobWatermark()
	        		.withPresetWatermarkId("Name2")
	        		.withInputKey("watermark/url2.jpg");

	        JobWatermark topRightWaterMark = new JobWatermark()
	        		.withPresetWatermarkId("Name")
	        		.withInputKey("watermark/url.jpg");

	        List<JobWatermark> watermarks = Arrays.asList(lowerWaterMark, topRightWaterMark);

	        CreateJobOutput fullHD = new CreateJobOutput()
	                .withKey("file/path/hd/"+video_id+".mp4")
	                .withPresetId("Job-preset-id")
	                .withWatermarks(watermarks);

	        CreateJobOutput notFullHD = new CreateJobOutput()
	                .withKey("file/path/sd/"+video_id+".mp4")
	                .withPresetId("Job-preset-id")
	        		.withWatermarks(watermarks);

	        List<CreateJobOutput> outputs = Arrays.asList(fullHD, notFullHD);

	        CreateJobRequest createJobRequest = new CreateJobRequest()
	                .withPipelineId(PIPELINE_ID)
	                .withInput(input)
	                .withOutputs(outputs);

	        System.out.println("VIDEO ID : " +video_id + "RESULT -> " + amazonElasticTranscoder.createJob(createJobRequest).getJob());

	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}

}
