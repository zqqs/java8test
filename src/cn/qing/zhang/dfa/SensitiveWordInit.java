package cn.qing.zhang.dfa;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化敏感词库，将敏感词加入到HashMap中，构建DFA算法模型
 */
public class SensitiveWordInit {

    public static HashMap sensitiveWordMap;

    public SensitiveWordInit(List<SensitiveWordsVO> sensitiveWordsList) {
        addSensitiveWordToHashMap(sensitiveWordsList);
    }

    /**
     * 读取敏感词库，将敏感词放入HashMap中，构建一个DFA算法模型
     *
     * @param sensitiveWordsList
     */
    @SuppressWarnings("rawtypes")
    public static void addSensitiveWordToHashMap(List<SensitiveWordsVO> sensitiveWordsList) {
        sensitiveWordMap = new HashMap(sensitiveWordsList.size());// 初始化敏感词容器，减少扩容操作
        String key = null;
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        for (int i = 0; i < sensitiveWordsList.size(); i++) {

            key = sensitiveWordsList.get(i).getSensitiveWord();// 关键字
            nowMap = sensitiveWordMap;
            for (int j = 0; j < key.length(); j++) {
                char keyChar = key.charAt(j);// 转换成char型
                Object wordMap = nowMap.get(keyChar);// 获取

                if (wordMap != null) {// 如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else {// 不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0");// 不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (j == key.length() - 1) {
                    nowMap.put("isEnd", "1");// 最后一个
                }
            }
        }
    }
}