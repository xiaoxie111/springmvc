package com.util;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonUtil {

    public Map<String, Object> getMapForList(List<Map<String, Object>> list) {
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
