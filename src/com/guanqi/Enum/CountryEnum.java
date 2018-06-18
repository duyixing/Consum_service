package com.guanqi.Enum;

public enum CountryEnum {
    QI(1,"齐"),QU(2,"楚"),YAN(3,"燕"),HAN(4,"韩");
    private Integer index;
    private String code;
    private CountryEnum(Integer index,String code) {
        this.index = index;
        this.code = code;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public static CountryEnum getCountryMsg(Integer index){
        for (CountryEnum enums:values()) {
            if(enums.getIndex() == index ){
                return enums;
            }
        }
        return  null;
    }
}
