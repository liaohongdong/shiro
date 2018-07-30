package cn.liaohongdong.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to return json data
 */
@Getter
@Setter
@ToString
public class JsonData {
    private boolean ret;
    private String msg;
    private Object data;
    private Integer code;

    public JsonData() {
    }

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData success(Object data, String msg, int code) {
        JsonData jsonData = new JsonData(true);
        jsonData.msg = msg;
        jsonData.data = data;
        jsonData.code = code;
        return jsonData;
    }

    public static JsonData success(String msg, int code) {
        JsonData jsonData = new JsonData(true);
        jsonData.msg = msg;
        jsonData.code = code;
        return jsonData;
    }

    public static JsonData success() {
        return new JsonData(true);
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("ret", ret);
        map.put("msg", msg);
        map.put("data", data);
        map.put("code", code);
        return map;
    }
}
