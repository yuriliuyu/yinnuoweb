package com.yuri.ynweb.utils;

public enum EnumResCode {
    /**
     * server成功
     */
    SUCCESSFUL(1),
    /**
     * server失败
     */
    SERVER_ERROR(0);

    private EnumResCode(int status) {
        this.status = status;
    }

    private int status;

    public int value() {
        return status;
    }
}
