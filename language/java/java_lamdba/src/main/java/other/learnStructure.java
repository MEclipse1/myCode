package other;

/**
 * 
 * @author drx
 *
 *
   *   学习数据结构与算法
 */
public class learnStructure {
	
public static void main(String[] args) {
	
	/**
	 * 浅复制
	 */
	int[] array1 = {1,2,3,4};
	
	int[] array2= array1;
	
	array1[0]=5;
	
	System.out.println(array2[0]);
	
	
	
	/**
	 * 将一个字符串根据特定字符，分割成一个字符数组
	 */
	String str = "hello，world";
	
	String[] newStr = str.split("，");
	
	System.out.println(newStr[1]);
	
//	for (int i = 0; i < newStr.length; i++) {
//		System.out.println(newStr[i]);
//	}
}
}
