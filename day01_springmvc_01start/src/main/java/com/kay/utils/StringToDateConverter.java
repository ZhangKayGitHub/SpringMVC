package com.kay.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * String source    传入进来的字符串
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {

        //判断
        if(source == null)
            throw new RuntimeException("请您传入数据");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //把字符串转换成日期
            return df.parse(source);
        }catch (Exception e){
            throw new RuntimeException("数据类型转化错误");
        }
    }
}
