package com.zjc.springboot.springboothelloworld;

import com.alibaba.fastjson.JSON;
import com.zjc.springboot.common.JsonResult;
import com.zjc.springboot.entity.DTO;
import com.zjc.springboot.util.ClassHelper;
import lombok.Synchronized;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHelloworldApplicationTests {

    private static String A = "A";
    private static String B= "B";
    @Test
    public void contextLoads() {
    }

    @Test
    public void hello() {
//        String json = "{\"lottery\":106,\"bargain\":122}";
//        Map<String,Long> map = JSON.parseObject(json,Map.class);
//        long s = map.get("bargain");
//        System.out.println(s);

        String imgs = "[\"http://xhc-img.oss-cn-beijing.aliyuncs.com/g_images/1815360-6d7f194f41969712bf62ad1f6e9cb729.jpg\",\"http://xhc-img.oss-cn-beijing.aliyuncs.com/g_images/1815360-7155bbabe00072768bb0ec33d54b12e0.jpg\",\"http://xhc-img.oss-cn-beijing.aliyuncs.com/g_images/1815360-0709743f78043d3bab8e0f8341380902.jpg\",\"http://xhc-img.oss-cn-beijing.aliyuncs.com/g_images/1815360-9b5a76fd8a22f846e519e64bf269bdd5.jpg\",\"http://xhc-img.oss-cn-beijing.aliyuncs.com/g_images/1815360-0493cf190446b9768f239c69359a5502.jpg\",\"http://xhc-img.oss-cn-beijing.aliyuncs.com/g_images/1815360-c00ddd46fc3189d50a1c1db4028a9582.jpg\",\"http://xhc-img.oss-cn-beijing.aliyuncs.com/g_images/1815360-4e71825678ac4c5f712095ece13005b5.jpg\"]";

        List<String> list = JSON.parseArray(imgs,String.class);
        System.out.println(" list size is " + list.size());
        System.out.println(JSON.toJSONString(list,true));

    }

    @Test
    public void getEndTime(){
//        Date d = new Date();
//        Calendar calendar = Calendar.getInstance();
//        if (null != d) calendar.setTime(d);
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
//        calendar.set(Calendar.MILLISECOND, 999);
//        System.out.print("结束时间：is {}"+calendar.getTimeInMillis() + (7 * (24 * 60 * 60 * 1000L)));
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 365);
        System.out.print("结束时间：is {}"+calendar.getTimeInMillis());

    }

    @Test
    public void JSON() {
//        List<DTO> dtos = new ArrayList<DTO>();
//        DTO dto = new DTO();
//        dto.setCardType(4);
//        dto.setRemark("您是消费力前1%的顶级用户");
//        dtos.add(dto);
//        DTO dto1 = new DTO();
//        dto1.setCardType(2);
//        dto1.setRemark("感谢您对天天跟我买的喜爱与支持");
//        dtos.add(dto1);
//        System.out.println(JSON.toJSONString(dtos));
        String json = "[{\"cardType\":4,\"remark\":\"您是消费力前1%的顶级用户\"},{\"cardType\":2,\"remark\":\"感谢您对天天跟我买的喜爱与支持\"}]";
        List<DTO> dtos = JSON.parseArray(json,DTO.class);
        System.out.println(JSON.toJSONString(dtos,true));
    }

    @Test
    public void day() {
        long tim = System.currentTimeMillis();
        long time = 1538755199000L;
        long result =time - tim;
        if (result <=0) {
            System.out.println("000000000000000000000");
        } else {
            System.out.println((int)(result/(24 * 60 * 60 * 1000)));
        }
    }

    @Test
    public void getFile() throws  Exception {
        Enumeration<URL> urls = ClassHelper.getCallerClassLoader(JsonResult.class).getResources(JsonResult.class.getName().replace('.', '/') + ".class");
        System.out.println("urls is {}"+JSON.toJSONString(urls));
    }

    @Test
    public void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void test() {
        String path = "Root.食品.酒水饮料.茶类.绿茶";
        String[] arrays = path.split("\\.");
        System.out.println(arrays[1]);
    }
}

