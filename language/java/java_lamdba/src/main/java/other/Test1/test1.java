package other.Test1;

import java.util.ArrayList;

/**
 * 研究forEach循环遍历数组/集合更改其中的值
 * 
 * @author drx
 *
 */
public class test1 {
	private String tString;

	public static void main(String[] args) {
		String[] array = { "a", "b", "c" };
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		for (Integer str : list) {
			str = 1;
		}

//		for (int i = 0; i < array.length; i++) {
//			String string = array[i];
//			System.out.println(string);
//		}
		for (Integer str : list) {
			System.out.println(str);
		}
	}
}
