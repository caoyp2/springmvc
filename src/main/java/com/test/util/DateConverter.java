package com.test.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期类型转换
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Date parse = null;

        try {

            parse = simpleDateFormat.parse(s);

        } catch (ParseException e) {

            e.printStackTrace();

        }
        return parse;
    }
}
