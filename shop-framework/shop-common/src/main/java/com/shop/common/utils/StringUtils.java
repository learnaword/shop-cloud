package com.shop.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 支付的工具类
 */
public class StringUtils {


    /**
     * 生成订单号
     */
    public static String createOrderNum(){
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());

        System.out.println(date);
        System.out.println(seconds);

        String result = date + "000010000" + getTwo() + "00"+seconds + getTwo();
        return  result;
    }

    /**
     * 生成一个随机的两位数
     * @return
     */
    private static String getTwo() {
        Random random = new Random();
        String result = random.nextInt(100)+"";
        if(result.length() == 1){
            result = "0"+result;
        }
        return result;
    }
}
