package AmazonawsSns;

import java.util.HashMap;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreatePlatformApplicationRequest;

public class test5 {
	public static void main(String[] args) {
		
		String CERTIFICATE = "-----BEGIN CERTIFICATE-----\r\n" + 
				"MIIFkTCCBHmgAwIBAgIIJSX3hA8WR7kwDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV\r\n" + 
				"BAYTAlVTMRMwEQYDVQQKDApBcHBsZSBJbmMuMSwwKgYDVQQLDCNBcHBsZSBXb3Js\r\n" + 
				"ZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9uczFEMEIGA1UEAww7QXBwbGUgV29ybGR3\r\n" + 
				"aWRlIERldmVsb3BlciBSZWxhdGlvbnMgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkw\r\n" + 
				"HhcNMTkxMDE1MDgzODU1WhcNMjAxMDE0MDgzODU1WjCBkDEmMCQGCgmSJomT8ixk\r\n" + 
				"AQEMFmpwLmNvLndpbm9vLnVwbGlua1Rlc3QxRDBCBgNVBAMMO0FwcGxlIERldmVs\r\n" + 
				"b3BtZW50IElPUyBQdXNoIFNlcnZpY2VzOiBqcC5jby53aW5vby51cGxpbmtUZXN0\r\n" + 
				"MRMwEQYDVQQLDAo3OVZWREdTN01RMQswCQYDVQQGEwJVUzCCASIwDQYJKoZIhvcN\r\n" + 
				"AQEBBQADggEPADCCAQoCggEBAL0KmKXPvZxW5i1slwCpceB+bR/N3ADakD51lajc\r\n" + 
				"RbfBWiaRoe5Oqx3F67pYJ6amENbZ+I6Fc3WgXVVHQgw5tovYVm7FwtO4nvwzzuuV\r\n" + 
				"KOYhw6J7m3FTeerD+APBjeJo3S0dNAchLcoawNAlXotwG2BMc0w8UaZarQgLgAPp\r\n" + 
				"uo7k3vBhLqsyrGDbHptIzY1GuKVqxC+qOWizYjcgMHTIv8DwT2TpgLRClwKsuYdI\r\n" + 
				"xReTu9KcJkcRhbEAlIOz1KUHQRTj6uVTWPMvZjZX/EzFg5okbK4Qk14xmEEfxmn1\r\n" + 
				"Sj0RN76MpM62jWR8JCFDsvqXXPEFTOPWwUu2cc64vDOxcQ0CAwEAAaOCAeUwggHh\r\n" + 
				"MAkGA1UdEwQCMAAwHwYDVR0jBBgwFoAUiCcXCam2GGCL7Ou69kdZxVJUo7cwggEP\r\n" + 
				"BgNVHSAEggEGMIIBAjCB/wYJKoZIhvdjZAUBMIHxMIHDBggrBgEFBQcCAjCBtgyB\r\n" + 
				"s1JlbGlhbmNlIG9uIHRoaXMgY2VydGlmaWNhdGUgYnkgYW55IHBhcnR5IGFzc3Vt\r\n" + 
				"ZXMgYWNjZXB0YW5jZSBvZiB0aGUgdGhlbiBhcHBsaWNhYmxlIHN0YW5kYXJkIHRl\r\n" + 
				"cm1zIGFuZCBjb25kaXRpb25zIG9mIHVzZSwgY2VydGlmaWNhdGUgcG9saWN5IGFu\r\n" + 
				"ZCBjZXJ0aWZpY2F0aW9uIHByYWN0aWNlIHN0YXRlbWVudHMuMCkGCCsGAQUFBwIB\r\n" + 
				"Fh1odHRwOi8vd3d3LmFwcGxlLmNvbS9hcHBsZWNhLzATBgNVHSUEDDAKBggrBgEF\r\n" + 
				"BQcDAjBNBgNVHR8ERjBEMEKgQKA+hjxodHRwOi8vZGV2ZWxvcGVyLmFwcGxlLmNv\r\n" + 
				"bS9jZXJ0aWZpY2F0aW9uYXV0aG9yaXR5L3d3ZHJjYS5jcmwwHQYDVR0OBBYEFGPP\r\n" + 
				"ZlMSjNvVRGURncJm5ss7yqBmMAsGA1UdDwQEAwIHgDAQBgoqhkiG92NkBgMBBAIF\r\n" + 
				"ADANBgkqhkiG9w0BAQUFAAOCAQEADGOOEYkvogxYjcef15mxwLu2jlLAyj901a4B\r\n" + 
				"AentsnxYMPdbSzbZfJ4WWK5vWpI26z1R8E9wAUQR+4G5hyJXZVDI9VlAFG5g/dS1\r\n" + 
				"Erf3kUope6QZyR+iyxJtGG8SSXw5TKhPTFJO3IuqtdjyKX3mLeO9UtrMOWnczGBh\r\n" + 
				"WhBMgRhIvo5MKwG+hFo0B28vxKUeOGHevvSeDHs7ZoMoU0yhTGW4Uc/Ci84pZqvu\r\n" + 
				"q2eBuz7mXnezlbwKgF/8il9eVcZpCF9WVSPO3Vbv49l17a/1P4JfNz5vlfZJ2laE\r\n" + 
				"8maeYAaWUzCXI93b6JmAG11q5igWworKTvPzTU3gcfLkxa/e8Q==\r\n" + 
				"-----END CERTIFICATE-----\r\n" + 
				"";
		
		String PRIVATEKey = "-----BEGIN PRIVATE KEY-----\r\n" + 
				"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9Cpilz72cVuYt\r\n" + 
				"bJcAqXHgfm0fzdwA2pA+dZWo3EW3wVomkaHuTqsdxeu6WCemphDW2fiOhXN1oF1V\r\n" + 
				"R0IMObaL2FZuxcLTuJ78M87rlSjmIcOie5txU3nqw/gDwY3iaN0tHTQHIS3KGsDQ\r\n" + 
				"JV6LcBtgTHNMPFGmWq0IC4AD6bqO5N7wYS6rMqxg2x6bSM2NRrilasQvqjlos2I3\r\n" + 
				"IDB0yL/A8E9k6YC0QpcCrLmHSMUXk7vSnCZHEYWxAJSDs9SlB0EU4+rlU1jzL2Y2\r\n" + 
				"V/xMxYOaJGyuEJNeMZhBH8Zp9Uo9ETe+jKTOto1kfCQhQ7L6l1zxBUzj1sFLtnHO\r\n" + 
				"uLwzsXENAgMBAAECggEBAIF/48gawpp50R6m996FNTSDhv+1hxOypgOTi11s3/mc\r\n" + 
				"Y8RuGU7l50TzE6PIxgjcVEbKdQI1Gz4mCCnmMbGsS4gLQFKL+QYOwCKm3wX1XVoh\r\n" + 
				"ISKKqJZ+h9MyQhFYo3jJO1KvYbfMm9CKeTFdmCHPP4G9fXJpE8nw7f3H2v9TOvCt\r\n" + 
				"XH7Y4fzu+N08KUPBu5u99syN9moPsOF8hBtG/eWEbD8HiOFiOPge87W1jr0xjKaO\r\n" + 
				"QY9CTxunrWBNVcfY84LOvCcLYnaRCMOBBcwlnwWiEu8ck6CTMM2PQip83+Vcg+2N\r\n" + 
				"CiR1Bsf/lHHl9T4LgH2JL7SEXCm09oIreiyqJv2/dgUCgYEA7CUbZF5JjrK6JYPw\r\n" + 
				"fLGuZ+rh7aMFbvRh+qE7z51Hw3nW60vc4zF/vjw9D4x2hzFBHQRzoskRrqDpdpT1\r\n" + 
				"f322ioobWJjvepTT/Ks8BbEK3AHMZutzGhFppdOjutKL3x6hO+jmIM0CRUmenQfd\r\n" + 
				"045xDQVQ+U//U8uffVSrAwYp4fsCgYEAzO+cTJXQOh2oahSkZHcFqcnLgiDWYhYK\r\n" + 
				"lfCYqd9jXp7yzJAAjZmGVJJbRTe8dGC7ddCjs6W9O4qUrcOBWfBoTxgb+vN3noA9\r\n" + 
				"oMSnRFbUNuD2zTR6QrhOlULPITfxfP071sMDxJnZHYSq0TvBT2EOFoBWYQLxPYbr\r\n" + 
				"xTL2ZcuUkpcCgYEApffqiZ9PGZD6DZXutuT2jCjkQ225SuNN3aXmcKO9JWEDsXov\r\n" + 
				"NCq8+opB7CSvxZLTjb5sO3QQDmkfzO0ioklLu5EXaSyL296wIzyCQgnNdRV6gLdo\r\n" + 
				"vWCRnS/jOlHyZo2TipTE8TbFKsd0SC+YM7FAOYOMBr232UAaxy5zxvtVAnMCgYBW\r\n" + 
				"mMV2AzQq6o9YzAIvRbAJ7/Bju1Z7ug6dDz6jQXbu68FzOUJSk1YU9IdGt2eV0a5E\r\n" + 
				"+XXDGrzcpRFwX5WQGKsrCOgB4dFhE5V3EsIPeZVQ3zzKt2sWOGVUYxe9VLNhemxH\r\n" + 
				"sr4r3ErHU2EO6u4jicJ3NaHKeoDP2+xSttcxapYMXwKBgBIdEeie/EVZY0mY/dFO\r\n" + 
				"is0EEfcm5902LxQ0YTje16JvEyySJ8X5N/LnBHwwZCFP3vX5Dbp2Kyd8pJLqSc+h\r\n" + 
				"c/W4Cas69UqkPSzYUlBsWqW62hGod1ovT3ejbpNKPXxXPIbQCUlft/g1Q5cIiLBs\r\n" + 
				"GlslcJiwMxorMLFbYbQ+v4tf\r\n" + 
				"-----END PRIVATE KEY-----\r\n" + 
				"";
		/**
		 * 获取AmazorSNS操作
		 */
		AmazonSNS amazonSNS= AmazonSNSClientBuilder.standard()
							  .withRegion("us-east-1")
							  .withCredentials(new ClasspathPropertiesFileCredentialsProvider())
							  .build();
		
		HashMap<String, String> map = new HashMap<>();
		map.put("PlatformPrincipal", CERTIFICATE);
		map.put("PlatformCredential", PRIVATEKey);
		
		var createPlatformApplicationRequest = new CreatePlatformApplicationRequest();
		
		createPlatformApplicationRequest
			.withName("upLinkTest1")
			.withPlatform("APNS_SANDBOX")
			.withAttributes(map);
		
		amazonSNS.createPlatformApplication(createPlatformApplicationRequest);
	}
}
