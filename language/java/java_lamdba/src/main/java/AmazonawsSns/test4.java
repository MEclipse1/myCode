package AmazonawsSns;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.ListTopicsResult;

public class test4 {
	public static void main(String[] args) {
		/**
		 * 获取AmazorSNS操作
		 */
		AmazonSNS amazonSNS= AmazonSNSClientBuilder.standard()
							  .withRegion("us-east-1")
							  .withCredentials(new ClasspathPropertiesFileCredentialsProvider())
							  .build();
		
		ListTopicsResult list = amazonSNS.listTopics();
		
		do {
			
		} while (true);
	}
}
