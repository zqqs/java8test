package cn.qing.zhang.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:测试堆栈溢出
 * @author: qing.zhang
 * @date: 2016/10/27 11:19
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
