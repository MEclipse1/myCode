package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPHandle implements InvocationHandler{
    private Object obj;
    AOPHandle(Object obj){
        this.obj = obj;
    }
   
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置代理");
        Object ret=method.invoke(obj, args);
        System.out.println("后置代理");
        return ret;
    }
}
