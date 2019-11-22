package AmazonawsSns;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.Endpoint;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationRequest;

public class test3 {
	public static void main(String[] args) {
		/**
		 * 获取AmazorSNS操作
		 */
		AmazonSNS amazonSNS= AmazonSNSClientBuilder.standard()
							  .withRegion("us-east-1")
							  .withCredentials(new ClasspathPropertiesFileCredentialsProvider())
							  .build();
		
		//创建设备回调函数
	    ProgressListener progressListener = new ProgressListener() {
			
			public void progressChanged(ProgressEvent progressEvent) {
				System.out.println(progressEvent.getEventType());
			}
		};
		
		//创建设备
		var createPlatformEndpointRequest = new CreatePlatformEndpointRequest();
		createPlatformEndpointRequest.setPlatformApplicationArn("arn:aws:sns:us-east-1:790156933617:app/GCM/fireBase1");
		createPlatformEndpointRequest.setToken("12345");
		createPlatformEndpointRequest.setGeneralProgressListener(progressListener);
		amazonSNS.createPlatformEndpoint(createPlatformEndpointRequest);
		
		//获取平台应用程序上的所有设备ARN
		////////////////////////////////////
		var listEndpointsByPlatformApplicationRequest = new ListEndpointsByPlatformApplicationRequest();
		
		listEndpointsByPlatformApplicationRequest.setPlatformApplicationArn("arn:aws:sns:us-east-1:790156933617:app/GCM/fireBase");
		var listEndpointsByPlatformApplicationResult = amazonSNS.listEndpointsByPlatformApplication(listEndpointsByPlatformApplicationRequest);
		
		var listEndPoint = listEndpointsByPlatformApplicationResult.getEndpoints();
		
		for (Endpoint endpoint : listEndPoint) {
			System.out.println(endpoint.getEndpointArn());
		}
		////////////////////////////////////
	}
}
