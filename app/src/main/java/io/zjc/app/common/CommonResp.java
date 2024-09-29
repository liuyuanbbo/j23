package io.zjc.app.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResp<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResp() {
        this(200, "ok");
    }

    public CommonResp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResp(T data) {
        this();
        this.data = data;
    }

    public static <E> CommonResp<E> ok() {
        return new CommonResp<>();
    }

    public static <E> CommonResp<E> ok(E data) {
        return new CommonResp<>(data);
    }

    public static CommonResp<String> fail(String msg) {
        return new CommonResp<>(500, msg);
    }
}