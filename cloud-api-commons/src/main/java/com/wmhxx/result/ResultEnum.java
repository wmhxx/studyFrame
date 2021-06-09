package com.wmhxx.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回信息 枚举
 *
 * @author :WangMenghe
 **/
@AllArgsConstructor
@Getter
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS("0", "交易成功"),
    /**
     * 失败
     */
    ERROR("9999", "交易失败");


    /**
     * 返回码
     */
    private final String code;
    /**
     * 返回信息
     */
    private final String msg;

    /**
     * 根据错误码获取错误信息
     *
     * @param code 错误码
     * @return java.lang.String
     */
    public static String getMsg(String code) {
        for (ResultEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value.getMsg();
            }
        }
        return null;
    }

}
