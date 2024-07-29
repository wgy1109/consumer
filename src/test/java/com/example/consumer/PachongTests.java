package com.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Slf4j
@SpringBootTest
public class PachongTests {

    @Test
    void httpPachong() {
        try {
            String url = "https://www.example.com";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // 设置请求方法为 GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine())!= null) {
                response.append(inputLine);
            }
            in.close();

            // 打印响应内容
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void JsoupTest() {
        try {
//            String url = "https://b.lenovo.com.cn/";



            jsoupUrl(url);
        } catch (Exception e) {
            log.error( "报错了" + e.getMessage());
        }
    }
    public Integer num = 1;

    public void jsoupUrl(String url)  {

        if(!url.startsWith("http")) {
            return;
        }

        try {
//        String url = "https://club.lenovo.com.cn/thread-7931273-1-1.html";
            Document doc = Jsoup.connect(url).get();

            // 提取标题
            String title = doc.title();
//        System.out.println("Title: " + title);
            num++;
            log.info(num + " , Title: " + title + ", url : " + url);

            // 提取所有链接
            for (org.jsoup.nodes.Element link : doc.select("a[href]")) {
    //            System.out.println("Link: " + link.attr("href"));
                jsoupUrl(link.attr("href"));
            }
        } catch (Exception e) {
            log.info("url : " + url + " 报错了"+ e.getMessage());
        }

    }
}
