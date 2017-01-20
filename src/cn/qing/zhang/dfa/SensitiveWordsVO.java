package cn.qing.zhang.dfa;

/**
 * 敏感词（竞品词）VO
 */
public class SensitiveWordsVO {

    private Integer id;// 业务ID
    private String sensitiveWord;// 敏感词（竞品词）
    private Integer isDel;// 是否可用（0：可用；1：不可用）

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setSensitiveWord(String sensitiveWord) {
        this.sensitiveWord = sensitiveWord;
    }

    public String getSensitiveWord() {
        return this.sensitiveWord;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}