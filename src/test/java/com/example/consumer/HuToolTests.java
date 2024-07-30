package com.example.consumer;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.consumer.config.CustomConverter;
import com.example.consumer.entity.Employee;
import com.example.consumer.entity.OutboundApplyNote;
import com.example.consumer.service.IOutboundApplyNoteService;
import com.example.consumer.service.impl.OutboundApplyNoteServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
public class HuToolTests {
    
    
    // 深克隆  ObjectUtil.cloneByStream(obj)

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

    /**
     * 验证日期
     */
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

        int year = DateUtil.year(date);
        int month = DateUtil.month(date);
        int day = DateUtil.dayOfMonth(date);
        log.info("year: " + year + " month: " + month + " day: " + day);

    }

    @Test
    public void testStr() {
        String fileName = StrUtil.removeSuffix("pretty_girl.jpg", ".jpg");
        log.info(fileName);

        String str = "abcdefgh";
        String strSub1 = StrUtil.sub(str, 2, 3); //strSub1 -> c
        String strSub2 = StrUtil.sub(str, 2, -3); //strSub2 -> cde
        String strSub3 = StrUtil.sub(str, 3, 2); //strSub2 -> c
        String strSub01 = StrUtil.sub(str, 2,  -1 ); //strSub1 -> cdefg
        log.info(strSub1 + "|" + strSub2 + "|" + strSub3 + "|" + strSub01);

        String template = "{}爱{}，就像老鼠爱大米";
        String str2 = StrUtil.format(template, "我", "你"); //str -> 我爱你，就像老鼠爱大米
        log.info(str2);

    }

    @Test
    public void testHex() {
        String str = "我是一个字符串";

        String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
        //hex是：
        //e68891e698afe4b880e4b8aae5ad97e7aca6e4b8b2
        String decodedStr = HexUtil.decodeHexStr(hex);
        //解码后与str相同
        log.info(str + " _ " + decodedStr + " _ " + hex);

    }

    @Autowired
    private IOutboundApplyNoteService outboundApplyNoteService;

    // 查询
    @Test
    void contextLoads() {
        QueryWrapper<OutboundApplyNote> queryWrapper=new QueryWrapper<>();
        List<OutboundApplyNote> applyNoteList = outboundApplyNoteService.list(queryWrapper);
        applyNoteList.forEach(System.out::println);
    }
}
