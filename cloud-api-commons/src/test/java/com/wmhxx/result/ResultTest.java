package com.wmhxx.result;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.wmhxx.entity.Payment;

import java.util.Map;

class ResultTest {

    void result() {
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

    @org.junit.jupiter.api.Test
    void ok() {
        Result ok = Result.ok();
        Console.log(ok);
    }

    @org.junit.jupiter.api.Test
    void error() {
        Console.log(Result.error());
    }

    @org.junit.jupiter.api.Test
    void testOk() {

    }

    @org.junit.jupiter.api.Test
    void testOk1() {
    }

    @org.junit.jupiter.api.Test
    void testError() {
    }

    @org.junit.jupiter.api.Test
    void testError1() {
    }

    @org.junit.jupiter.api.Test
    void resultEnum() {
    }

    @org.junit.jupiter.api.Test
    void code() {
    }

    @org.junit.jupiter.api.Test
    void message() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void getData() {
    }

    @org.junit.jupiter.api.Test
    void getErrorCode() {
    }

    @org.junit.jupiter.api.Test
    void getErrorMsg() {
    }
}