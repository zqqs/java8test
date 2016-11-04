package cn.qing.zhang.stack;

/**
 * @Description:自救逃离Gc
 * @author: qing.zhang
 * @date: 2016/11/1 9:58
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isALive(){
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    /**
     * 测试finalize方法执行 垃圾回收时会且紧紧会执行一次 会对对象标记2次才会真正被回收
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //第一次拯救自己对象
        SAVE_HOOK = null;
        System.gc();
        //finalize 方法级别低 线程暂停0.5秒
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            System.out.println("finalize方法执行自救成功");
            SAVE_HOOK.isALive();
        }else {
            System.out.println("拯救失败，对象被回收");
        }
        //第二次拯救自己
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            System.out.println("finalize方法再次执行，自救成功");
            SAVE_HOOK.isALive();
        }else {
            System.out.println("finalize方法二次执行失败，自救失败");
        }
    }
}
