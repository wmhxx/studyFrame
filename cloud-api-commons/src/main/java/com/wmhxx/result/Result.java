package com.wmhxx.result;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.wmhxx.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回Body
 *
 * @author :WangMenghe
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Result {
    /**
     * 返回体
     */
    private Map<String, Object> data;
    /**
     * 返回码
     */
    private String errorCode;
    /**
     * 返回信息
     */
    private String errorMsg;

    public Result(Map<String, Object> data, ResultEnum resultEnum) {
        this.data = data;
        this.errorCode = resultEnum.getCode();
        this.errorMsg = resultEnum.getMsg();
    }

    public static Result ok() {
        return new Result(new HashMap<>(1), ResultEnum.SUCCESS);
    }

    public static Result error() {
        return new Result(new HashMap<>(1), ResultEnum.ERROR);
    }

    public static Result ok(Map<String, Object> map) {
        return new Result(map, ResultEnum.SUCCESS);
    }

    public static Result ok(Object data) {
        return new Result(BeanUtil.beanToMap(data, false, false), ResultEnum.SUCCESS);
    }

    public static Result error(Map<String, Object> map) {
        return new Result(map, ResultEnum.ERROR);
    }

    public static Result error(Object data) {
        return new Result(BeanUtil.beanToMap(data, false, false), ResultEnum.ERROR);
    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setId(1L);
        Map<String, Object> map = BeanUtil.beanToMap(payment);
        String jsonStr = JSONUtil.parseObj(Result.ok(payment), false, true).toJSONString(0);
        Console.log("1:{}", jsonStr);
        Console.log("2:{}", payment);
        Console.log("3:{}", Result.ok());
        Console.log("4:{}", Result.error());
        Console.log("5:{}", Result.ok(map));
        Console.log("6:{}", Result.error(map));
        Console.log("7:{}", Result.ok(payment));
        Console.log("8:{}", Result.error(payment));
        Console.log("9:{}", Result.ok(payment).code("0").message("交易成功"));
        Console.log("10:{}", Result.error(payment).code("8888").message("交易失败了"));
        Console.log("11:{}", Result.ok(payment).resultEnum(ResultEnum.SUCCESS));
        Console.log("12:{}", Result.error(payment).resultEnum(ResultEnum.ERROR));
    }

    private void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    private void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Result resultEnum(ResultEnum resultEnum) {
        this.setErrorCode(resultEnum.getCode());
        this.setErrorMsg(resultEnum.getMsg());
        return this;
    }

    public Result code(String errorCode) {
        this.setErrorCode(errorCode);
        return this;
    }

    public Result message(String errorMsg) {
        this.setErrorMsg(errorMsg);
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
