package cn.qing.zhang.proxy;

/**
 * @Description:测试代理
 * @author: qing.zhang
 * @date: 2016/10/12 11:04
 */
public class ProxyTest {
    public static void main(String[] args) {
        ZhangXueYouProxy zxy = new ZhangXueYouProxy();
        zxy.getProxyPerson().dance("张学友跳舞不给钱");
        zxy.getProxyPerson().sing("张学友唱歌不给钱");
    }
}
