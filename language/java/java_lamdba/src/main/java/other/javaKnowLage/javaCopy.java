package other.javaKnowLage;

public class javaCopy implements Cloneable {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public static void main(String[] args) {
		javaCopy c1 = new javaCopy();
		c1.setNumber(100);
		
		javaCopy c2 = (javaCopy)c1.clone();
		c2.setNumber(200);
		
		System.out.println("学生1:" + c1.getNumber()); 
        System.out.println("学生2:" + c2.getNumber()); 
	}

	@Override
	public Object clone() {
		javaCopy javaCopy = null;
		try {
			javaCopy=(javaCopy)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return javaCopy;
	}
}
