package com.util;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AboutTime {

    /**
     * 获取当前时间
     *
     * @return
     */
    public Timestamp getNowTime(){
        Date date = new Date();
        return  new Timestamp(date.getTime());
    }

    /**
     * Timestamp转String
     *
     * @param timestamp
     * @return
     */
    public String timestampTostring(Timestamp timestamp){
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //方法一
            tsStr = sdf.format(timestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tsStr;
    }

    public static void main(String [] args){
        AboutTime aboutTime=new AboutTime();
        System.out.println(aboutTime.timestampTostring(aboutTime.getNowTime()));
    }
}
