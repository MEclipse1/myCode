package other;

/**
 * 
 * @author  包文东
 *
 */

@AnnotationDemo("1")
public class learnAnnotation {
	
	
	/**
	 * @deprecated 注释用来将过时的方法注掉
	 */
	@Deprecated
	@AnnotationDemo(value = "2")
	public void sayHello() {
		System.out.println("hello world");
	}
	
	
	public static void main(String[] args) {
		
		var lAnnotation = new learnAnnotation();
		
		var antotationDem0 =learnAnnotation.class.getAnnotation(AnnotationDemo.class); //通过反射获取注解中的变量值
		System.out.println(antotationDem0.value());	
	
		lAnnotation.sayHello(); 
		
	}
}
