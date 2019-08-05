package com.util;


import java.util.Map;

public class ReturnDataMap {

    private Map<String, Object> map;

//    private

    private String msg;

    public ReturnDataMap() {
    }

    public ReturnDataMap(Map<String, Object> map, String msg) {
        this.map = map;
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
