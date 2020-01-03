package AmazonawsSns;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeResult;

public class test2 {
	public static void main(String[] args) {
		/**
		 * 终端设备Token数组
		 */
		String[] endPointTokenArray = {			
				"fSzQqp1zbo4:APA91bHW6yHQ5JoB0PZsW2KCrxGHplMGRWUfoeVGLdRGRdyUvbziJWe1WXxvyzPnISk6C8etF0lhR1Y0mcefjSPBQCqosyTPwW73ZHv0fj0AK5SOsKUBJ_3aZhGHvNBMC5rDlwrHrcfx",
				"fRkjtWvDCFg:APA91bFh2snG3M1AsYnJc5Dy8js40q7R33wI5SBhMv1csNNNGLdRWReEezrR6ez6Fq_l9sjhMGpZTPaqL2APahjpKRyV4Ml5-WWGud9YKtIqxi-dWRtIZfidxuW65XEVlIR5X9hMK9lr"
			};
		
		/**
		 * 获取AmazorSNS操作
		 */
		AmazonSNS amazonSNS= AmazonSNSClientBuilder.standard()
							  .withRegion("us-east-1")
							  .withCredentials(new ClasspathPropertiesFileCredentialsProvider())
							  .build();
		
		CreatePlatformEndpointRequest createPlatformEndpointRequest = new CreatePlatformEndpointRequest();
		
		/**
		 * 将终端设备token关联到AWS SNS平台应用程序上
		 */
		createPlatformEndpointRequest.setPlatformApplicationArn("arn:aws:sns:us-east-1:790156933617:app/GCM/fireBase");
		
		for (int i = 0; i < endPointTokenArray.length; i++) {
			/**
			 * 将设备token转换成ARN
			 */
			createPlatformEndpointRequest.setToken(endPointTokenArray[i]);
			CreatePlatformEndpointResult createPlatformEndpointResult = amazonSNS.createPlatformEndpoint(createPlatformEndpointRequest);
			String endPointArn = createPlatformEndpointResult.getEndpointArn();
		} 
	}
}
