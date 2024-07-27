package com.example.consumer;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.consumer.config.CustomConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
@Slf4j
public class HuToolTests {

    /**
     * 类型转换
     */
    @Test
    public void testHuTools() {
        CustomConverter converter = new CustomConverter();
        int a = 445566;
        String result = converter.convert(a, null);
        Assert.assertEquals("Custom: 445566", result);
    }

    @Test
    public void testHuToolsDate() {
        Date date = DateUtil.date();
        Date date2 = DateUtil.date(Calendar.getInstance());
        Date date3 = DateUtil.date(System.currentTimeMillis());
        String now = DateUtil.now();
        log.info(date + "|" + date2 + "|" + date3 + "|" + now );

        String today = DateUtil.today();
        Date date4 = DateUtil.parse(now);
        Date beginOfDay = DateUtil.beginOfDay(date4);
        Date endOfDay = DateUtil.endOfDay(date4);
        log.info(today + "|" + date4 + "|" + beginOfDay + "|" + endOfDay);

        Date lastYear = DateUtil.offset(date4, DateField.YEAR, 2);
        Date lastMonth = DateUtil.offsetMonth(date4, -2);
        DateTime lastDay = DateUtil.offsetDay(date4, -2);
        DateTime lastHour = DateUtil.offsetHour(date4, -2);
        log.info(lastYear + "|" + lastMonth + "|" + lastDay + "|" + lastHour);



    }

}
