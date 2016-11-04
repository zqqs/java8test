package cn.qing.zhang.stack;

/**
 * @Description:gc回收
 * @author: qing.zhang
 * @date: 2016/11/1 9:35
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int int_1M = 1024 * 1024;
    private byte[] bigSize = new byte[2*int_1M];

    public static void main(String[] args) {
        ReferenceCountingGC obja = new ReferenceCountingGC();
        ReferenceCountingGC objb = new ReferenceCountingGC();
        obja.instance = objb;
        objb.instance = obja;
        obja = null;
        objb = null;
        System.gc();

    }

}
