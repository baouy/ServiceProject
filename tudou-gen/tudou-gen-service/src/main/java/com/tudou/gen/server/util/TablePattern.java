/**
 * 美窝云
 * APP服务端
 * 版权所有 2016~ 2017 杭州美窝科技有限公司
 */
package com.tudou.gen.server.util;

/**
 * Created on 2017/10/18.
 * 页面表关联类型枚举类
 * @auther 地瓜
 */
public enum TablePattern {
    SINGLE("single","single/"),
    MULTILIST("multilist","multilist/"),
    TREETABLE("treeTable","treeTable/"),
    TREETABLEANDLIST("treeTableAndList","treeTableAndList/"),
    ;

    private String pattern;
    private String packageName;//模板目录下的子包路路径

    TablePattern(String pattern,String packageName){
        this.pattern =pattern;
        this.packageName = packageName;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public static TablePattern getTablePattern(String pattern){
        for(TablePattern tp:TablePattern.values()){
            if(tp.getPattern().equals(pattern))
                return  tp;
        }
        return null;
    }
}
