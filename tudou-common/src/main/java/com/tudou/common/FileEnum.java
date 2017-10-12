/**
 * 美窝云
 * APP服务端
 * 版权所有 2016~ 2017 杭州美窝科技有限公司
 */
package com.tudou.common;

/**
 * Created on 2017/10/12.
 *
 * @auther 地瓜
 */
public enum FileEnum {
    WORD("word",".doc","word.vm"),
    EXCEL("excel",".xls","word.vm");

    private String type;
    private String subfix;
    private String template;

    FileEnum(String type,String subfix,String template){
        this.type = type;
        this.subfix = subfix;
        this.template = template;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubfix() {
        return subfix;
    }

    public void setSubfix(String subfix) {
        this.subfix = subfix;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
