package com.ainilzb.enums;
/*
 * @Desc:是否 枚举
 * */
public enum DefectRank {
    NORMAL(1,"一般"),
    MORESERIOUS(2,"比较严重"),
    SERIOUS(3,"严重");

    public final Integer type;
    public final String value;

    DefectRank(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
