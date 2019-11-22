package Anotation;

import java.lang.reflect.Field;

public class test {
    @TestAnnotation
    Animal animal;

    @TestAnnotation
    String animal1;

    public void printAnimalTestMethod() {
        System.out.println(animal1);
        animal.animalTest();
    }

    public static void main(String[] args) {
        test t= new test();
        try {
            for (Field declaredField : t.getClass().getDeclaredFields()) {
                if (declaredField.getAnnotation(TestAnnotation.class) !=null ) {
                   if (declaredField.getType() == Animal.class) {
                       declaredField.setAccessible(true);
                       declaredField.set(t,new Animal());
                   } else if(declaredField.getType() == String.class) {
                        declaredField.setAccessible(true);
                        declaredField.set(t,"123");
                    }
                }
            }
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        t.printAnimalTestMethod();
    }
}
