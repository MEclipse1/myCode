package aop;

import java.lang.reflect.Proxy;

public class test1 {
	public static void main(String[] args) {
        ManSayHelloWorld sayHelloWorld = new ManSayHelloWorld();
        
        AOPHandle handle = new AOPHandle(sayHelloWorld);
        ISayHelloWorld i = (ISayHelloWorld) Proxy.newProxyInstance(ManSayHelloWorld.class.getClassLoader(), new Class[] { ISayHelloWorld.class }, handle);
        i.say();
    }
}
