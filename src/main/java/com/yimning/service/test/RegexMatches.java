package com.yimning.service.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: yimning
 * @description:
 * @author: Yimning
 * @create: 2021-04-20 12:57
 **/

public class RegexMatches
{
    public static void main( String args[] ){

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

        /** 
        * 取两个字符之间的字符串 
        */
        String filetext = "@张小名: 25分,@李小花: 43分,@王力: 100分";
        Pattern p = Pattern.compile("\\@(.*?)\\:");//正则表达式，取=和|之间的字符串，不包括=和|
        Matcher m1 = p.matcher(filetext);
        while(m1.find()) {
            System.out.println(m1.group(0));//m.group(1)不包括这两个字符
            System.out.println(m1.group(1));//m.group(1)不包括这两个字符
        }

    }
}