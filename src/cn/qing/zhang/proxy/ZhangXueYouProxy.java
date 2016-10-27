package cn.qing.zhang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:创建代理类
 * @author: qing.zhang
 * @date: 2016/10/12 10:39
 */
public class ZhangXueYouProxy {
    //定义一个类用来生成代理
    private ZhangXueYou zxy = new ZhangXueYou();
    //获取代理方法 返回一个代理实例
    public Person getProxyPerson(){
        return (Person) Proxy.newProxyInstance(ZhangXueYouProxy.class.getClassLoader(), zxy.getClass().getInterfaces(), new InvocationHandler() {
            //proxy 传递进来的代理对象，method代理对象的方法 ,args 参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sing")){
                    //唱歌方法
                    System.out.println("我是他的经纪人，要唱歌先给100000块钱");
                    return method.invoke(zxy,args);//调用代理人的真实唱歌方法
                }
                if(method.getName().equals("dance")) {
                    //跳舞方法
                    System.out.println("我是他的经纪人，要跳舞先给100000块钱");
                    return method.invoke(zxy, args);//调用代理人的真实跳舞方法
                }
                return null;
            }
        });
    }
}

