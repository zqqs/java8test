package cn.qing.zhang.proxy;

/**
 * @Description:定义一个类实现方法
 * @author: qing.zhang
 * @date: 2016/10/12 10:34
 */
public class ZhangXueYou implements Person {
    @Override
    public void sing(String name) {
        System.out.println("张学友唱歌"+name);
    }

    @Override
    public void dance(String name) {
        System.out.println("张学友跳舞"+name);
    }
}
