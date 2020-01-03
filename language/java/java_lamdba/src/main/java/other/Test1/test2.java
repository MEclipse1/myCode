package other.Test1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

/**
 * 生成随机字符串
 * 
 * AppVersion
 * 
 * @author drx
 *
 */
public class test2 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * 生成随机字符串
		 */

		/**
		 * Sign, AppVersion,DeviceId,LicenseNo,Nonce
		 */
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		String key = "POSTEST20161017";
		String licenseNo = "Nekusutepu20190502";
//		String DeviceId = "POSTESTNekusutepu20190502";
		String DeviceId = "Nekusutepu20190502";
		String AppVersion = "1.0.1.0";
		String DeviceModel = "Testdevicemodel";
		String DeviceNo = "";

		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}

		String stringA = "AppVersion=" + AppVersion + "&DeviceId=" + DeviceId + "&DeviceModel=" + DeviceModel
				+ "&LicenseNo=" + licenseNo + "&Nonce=" + sb.toString();

		String signTemp = stringA + "&Key=" + key + "";
		System.out.println(signTemp);
		String newString = new String(signTemp.getBytes("UTF-8"));
		String teString = URLEncoder.encode(newString, "UTF-8");
//		System.out.println(signTemp);
		String sign = MD5.md5(teString).toUpperCase();
//		Scanner in = new Scanner(System.in);
//		String sign = in.nextLine();
		System.out.println("{");
		System.out.println("	\"AppVersion\" : " + '"' + AppVersion + '"' + ",");
		System.out.println("	\"DeviceId\" : " + '"' + DeviceId + '"' + ",");
		System.out.println("	\"LicenseNo\" : " + '"' + licenseNo + '"' + ",");
		System.out.println("	\"Nonce\" : " + '"' + sb.toString() + '"' + ",");
		System.out.println("	\"Sign\" : " + '"' + sign + '"');
		System.out.println("	\"DeviceModel\" : " + '"' + DeviceModel + '"');
		System.out.println("	\"DeviceNo\" : " + '"' + DeviceNo + '"');
		System.out.println("}");
	}
}
