package other.Test1;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	public static String md5(String plainText) {

		/**
		 * 定义一个字节数组
		 */
		byte[] secretBytes = null;
		String md5code = null;
		try {
			/**
			 * 生成一个MD5加密计算摘要
			 */
			MessageDigest md = MessageDigest.getInstance("MD5");

			/**
			 * 对字符串进行加密
			 */
			md.update(plainText.getBytes());

			/**
			 * 获得加密后的数据
			 */
			secretBytes = md.digest();

			/**
			 * 将加密后的数据转换为16进制数字
			 */
			md5code = new BigInteger(1, secretBytes).toString(16);

			/**
			 * 如果生成数字未满32位，需要前面补0
			 */
			for (int i = 0; i < 32 - md5code.length(); i++) {
				md5code = "0" + md5code;
			}
		} catch (Exception e) {
			return "";
		}
		return md5code;
	}
}
