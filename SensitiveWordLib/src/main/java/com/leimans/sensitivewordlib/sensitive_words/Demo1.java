package com.leimans.sensitivewordlib.sensitive_words;

import com.leimans.sensitivewordlib.sensitive_words.core.SensitiveFilter;

import java.io.InputStream;
import java.util.List;

/**
 * @Author ：HeXinGen
 * @Date : 1/21/21
 * @Description :
 *
 * 参考连接：https://github.com/elulis/sensitive-words
 *
 * 只能匹配2个字符以上的
 */
public class Demo1 {

    public static void main(String[] args) {

    }

    public  void test(InputStream inputStream){
        SensitiveFilter filter=new SensitiveFilter();
        List<String> keyWordList= SensitiveFilter.loadKeywordsNoSplit(inputStream);
        filter.setKeyWord(keyWordList);
        keyWordList.clear();
        keyWordList=null;
        //测试头部一个关键词
        System.out.println("Demo start test1");
        String test1="xxxx";
        boolean result1=(filter.filter(test1,'*')==test1);
        System.out.println("Demo start test1 "+result1);
        //测试中部的一个关键词
        System.out.println("Demo start test2");
        String test2="xxx 疯狂赛车";
        boolean result2=(filter.filter(test2,'*')==test2);
        System.out.println("Demo start test2 "+result2);
        // 测试尾部最后一个关键词
        System.out.println("Demo start test3");
        String test3=  "色";
        boolean result3=(filter.filter(test3,'*')==test3);
        System.out.println("Demo start test3 "+result3);
    }

}
