package com.leimans.sensitivewordlib.dfa;

import com.leimans.sensitivewordlib.sensitive_words.core.SensitiveFilter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ：HeXinGen
 * @Date : 1/21/21
 * @Description :
 */
public class Demo2 {


    public static void test(InputStream inputStream){
       Set<String>  dataList= SensitiveWordUtil.loadKeywordsNoSplit(inputStream);
       SensitiveWordUtil.init(dataList);

        //测试头部一个关键词
        System.out.println("Demo start test1");
        String test1="xxxx";
        boolean result1=( SensitiveWordUtil.contains(test1));
        System.out.println("Demo start test1 "+result1);
        //测试中部的一个关键词
        System.out.println("Demo start test2");
        String test2="xxx 疯狂赛车";
        boolean result2= SensitiveWordUtil.contains(test2);
        System.out.println("Demo start test2 "+result2);
        // 测试尾部最后一个关键词
        System.out.println("Demo start test3");
        String test3= "xxxxxx色鬼";
        boolean result3=SensitiveWordUtil.contains(test3);
        System.out.println("Demo start test3 "+result3);
    }
    public static void test2(InputStream inputStream){
        Set<String>  dataList= loadExtraKeywords(new InputStreamReader(inputStream));
        System.out.println("Demo init data start");
        SensitiveWordUtil.init(dataList);
        System.out.println("Demo init data finish");
        //测试头部一个关键词
        System.out.println("Demo start test1");
        String test1="xxxx骚";
        boolean result1=( SensitiveWordUtil.contains(test1));
        System.out.println("Demo start test1 "+result1);
        //测试中部的一个关键词
        System.out.println("Demo start test2");
        String test2="xxx 每月400分钟免费打";
        boolean result2= SensitiveWordUtil.contains(test2);
        System.out.println("Demo start test2 "+result2);
        // 测试尾部最后一个关键词
        System.out.println("Demo start test3");
        String test3= "xxxxxx这篇帖子构思新颖题材独具匠心段落清晰情节诡异跌宕起伏主线分明引人入胜平淡中显示出不凡的文学功底可谓是字字珠玑句句经典是我辈应当学习之典范";
        boolean result3=SensitiveWordUtil.contains(test3);
        System.out.println("Demo start test3 "+result3);
    }
    /**
     * 文件内容以","分割
     *
     * @param br
     * @return
     */
    public static Set<String> loadExtraKeywords(Reader br) {
        Set<String> keyArray = new HashSet<String>();
        try {
            final char split = ',';
            final int end = -1;
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            for (; ; ) { // 循环读取
                i = br.read();
                if (i == end) {
                    String temp = stringBuilder.toString().trim();
                    if (temp != null && temp.length() > 0) {
                        keyArray.add(temp);
                    }
                    break;
                } else {
                    char c = (char) i;
                    if (c != split) {
                        stringBuilder.append(c);
                    } else {
                        String temp = stringBuilder.toString().trim();
                        if (temp != null && temp.length() > 0) {
                            keyArray.add(temp);
                        }
                        stringBuilder=new StringBuilder();
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyArray;
    }
}
