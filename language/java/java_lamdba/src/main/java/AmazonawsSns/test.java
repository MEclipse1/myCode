package AmazonawsSns;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeResult;

public class test {
	public static void main(String[] args) {
		
		/**
		 * 终端设备Token数组
		 */
		String[] endPointTokenArray = {			
				"fSzQqp1zbo4:APA91bHW6yHQ5JoB0PZsW2KCrxGHplMGRWUfoeVGLdRGRdyUvbziJWe1WXxvyzPnISk6C8etF0lhR1Y0mcefjSPBQCqosyTPwW73ZHv0fj0AK5SOsKUBJ_3aZhGHvNBMC5rDlwrHrcfx",
				"fRkjtWvDCFg:APA91bFh2snG3M1AsYnJc5Dy8js40q7R33wI5SBhMv1csNNNGLdRWReEezrR6ez6Fq_l9sjhMGpZTPaqL2APahjpKRyV4Ml5-WWGud9YKtIqxi-dWRtIZfidxuW65XEVlIR5X9hMK9lr"
			};
		
		/**
		 * 终端订阅Arn数组
		 */
		String[] subscribeArnArray = new String[endPointTokenArray.length];
		
		/**
		 * 获取AmazorSNS操作
		 */
		AmazonSNS amazonSNS= AmazonSNSClientBuilder.standard()
							  .withRegion("us-east-1")
							  .withCredentials(new ClasspathPropertiesFileCredentialsProvider())
							  .build();
		
		/**
		 * 创建主题，如果主题存在则不创建
		 */
		CreateTopicResult createTopicResult = amazonSNS.createTopic("upLink_topic");
		
		/**
		 * 主题ARN
		 */
		String topticArn = createTopicResult.getTopicArn();
		
		
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
			String endPoint = createPlatformEndpointResult.getEndpointArn();
			
			/**
			 * 创建订阅
			 * 参数1主题ARN
			 * 参数2订阅协议application
			 * 参数3终端ARN
			 */
			SubscribeResult subscribeResult = amazonSNS.subscribe(topticArn, "application", endPoint);
			subscribeArnArray[i] = subscribeResult.getSubscriptionArn();
		} 
		
		PublishRequest request = new PublishRequest();
		
		/**
		 * 给订阅主题的设备发
		 */
		request.setTopicArn(topticArn);
		
		/**
		 * 给单一的设备发 
		 */
//		request.setTargetArn(arrays[0]);
		
		request.setMessageStructure("json");
		String msg = "{\r\n" + 
				"  \"default\": \"示例回退消息\",\r\n" + 
				"  \"email\": \"电子邮件终端节点的示例消息\",\r\n" + 
				"  \"sqs\": \"Amazon SQS 终端节点的示例消息\",\r\n" + 
				"  \"lambda\": \"AWS Lambda 终端节点的示例消息\",\r\n" + 
				"  \"http\": \"HTTP 终端节点的示例消息\",\r\n" + 
				"  \"https\": \"HTTPS 终端节点的示例消息\",\r\n" + 
				"  \"sms\": \"SMS 终端节点的示例消息\",\r\n" + 
				"  \"APNS\": \"{\\\"aps\\\":{\\\"alert\\\": \\\"iOS 终端节点的示例消息\\\"} }\",\r\n" + 
				"  \"APNS_SANDBOX\": \"{\\\"aps\\\":{\\\"alert\\\":\\\"iOS 开发终端节点的示例消息\\\"}}\",\r\n" + 
				"  \"APNS_VOIP\": \"{\\\"aps\\\":{\\\"alert\\\":\\\"Apple VoIP 终端节点的示例消息\\\"}}\",\r\n" + 
				"  \"APNS_VOIP_SANDBOX\": \"{\\\"aps\\\":{\\\"alert\\\": \\\"Apple VoIP 开发终端节点的示例消息\\\"} }\",\r\n" + 
				"  \"MACOS\": \"{\\\"aps\\\":{\\\"alert\\\":\\\"MacOS 终端节点的示例消息\\\"}}\",\r\n" + 
				"  \"MACOS_SANDBOX\": \"{\\\"aps\\\":{\\\"alert\\\": \\\"MacOS 开发终端节点的示例消息\\\"} }\",\r\n" + 
				"  \"GCM\": \"{ \\\"notification\\\": { \\\"body\\\": \\\"test aws\\\", \\\"title\\\": \\\"test aws\\\" } }\",\r\n" + 
				"  \"ADM\": \"{ \\\"data\\\": { \\\"message\\\": \\\"FireOS 终端节点的示例消息\\\" } }\",\r\n" + 
				"  \"BAIDU\": \"{\\\"title\\\":\\\"示例消息标题\\\",\\\"description\\\":\\\"百度终端节点的示例消息\\\"}\",\r\n" + 
				"  \"MPNS\": \"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?><wp:Notification xmlns:wp=\\\"WPNotification\\\"><wp:Tile><wp:Count>输入计数</wp:Count><wp:Title>Windows Phone 7+ 终端节点的示例消息</wp:Title></wp:Tile></wp:Notification>\",\r\n" + 
				"  \"WNS\": \"<badge version=\\\"1\\\" value=\\\"42\\\"/>\"\r\n" + 
				"}";
		request.setMessage(msg);
		PublishResult result = amazonSNS.publish(request);
		
		/**
		 * 删除主题
		 */
		amazonSNS.deleteTopic(topticArn);
		
		/**
		 * 删除订阅
		 */
		for (int i = 0; i < subscribeArnArray.length; i++) {
			amazonSNS.unsubscribe(subscribeArnArray[i]);
		}
		
		/**
		 *   发送短信
		 */
//		PublishResult result = amazonSNS.publish(new PublishRequest().withMessage("包文东比段志刚还帅").withPhoneNumber("+8613354803362"));
//		System.out.println(result);
	}
}
