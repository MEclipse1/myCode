package other.java反射;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import other.workout.childActivity;

public class test {
		
		public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
			
			childActivity class0 = new childActivity();
						
			Field field=class0.getClass().getDeclaredField ("DEFAULT_OFFSCREEN_PAGES");
			field.setAccessible(true);
			field.setInt(class0, 2); 
			field.setAccessible(false);
			
			class0.test();
		}
}
