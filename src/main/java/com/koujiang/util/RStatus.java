package com.koujiang.util;

public enum RStatus {

	SUCCESS("SUCCESS","成功"),
	FAIL("FAIL","失败"),
	ERROR("ERROR","错误");
	
	private String code;
	private String name;
	
	private RStatus(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static RStatus getEnumByCode(String code) {
		RStatus[] values = RStatus.values();
        for (RStatus mode : values) {
            if (mode.code.equals(code)) {
                return mode;
            }
        }
        return null;
    }

    public String getNameByCode(String code) {
    	RStatus[] values = RStatus.values();
        for (RStatus mode : values) {
            if (mode.code.equals(code)) {
                return mode.name;
            }
        }
        return "";
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
