package other.jquanchazhe;

public class Test {
	public static void main(String[] args) {
			String string = "1:";
			String[] teStrings = string.split(":");
			System.out.println(teStrings.length);
			for (int i = 0; i < teStrings.length; i++) {
				System.out.println(teStrings[i] );
			}
	}
	
}
