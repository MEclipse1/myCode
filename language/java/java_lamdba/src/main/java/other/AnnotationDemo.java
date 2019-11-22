package other;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 注解的生命周期 
 */
@Retention(RetentionPolicy.RUNTIME)

/*
 * 注解使用的位置
 */
@Target({ ElementType.METHOD, ElementType.TYPE} )

public @interface AnnotationDemo {
	/**
	 * 定义基本属性
	 * @return
	 */
	String value()  ;
}
