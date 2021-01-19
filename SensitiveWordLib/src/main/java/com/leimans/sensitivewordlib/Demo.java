package com.leimans.sensitivewordlib;

import com.leimans.sensitivewordlib.core.IllegalWordsSearch;
import com.leimans.sensitivewordlib.core.IllegalWordsSearchResult;
import com.leimans.sensitivewordlib.core.PinyinMatch;
import com.leimans.sensitivewordlib.core.StringMatch;
import com.leimans.sensitivewordlib.core.StringMatchEx;
import com.leimans.sensitivewordlib.core.StringSearch;
import com.leimans.sensitivewordlib.core.StringSearchEx;
import com.leimans.sensitivewordlib.core.StringSearchEx2;
import com.leimans.sensitivewordlib.core.WordsHelper;
import com.leimans.sensitivewordlib.core.WordsMatch;
import com.leimans.sensitivewordlib.core.WordsMatchEx;
import com.leimans.sensitivewordlib.core.WordsSearch;
import com.leimans.sensitivewordlib.core.WordsSearchEx;
import com.leimans.sensitivewordlib.core.WordsSearchEx2;
import com.leimans.sensitivewordlib.core.WordsSearchResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Demo {

    public static void main(String[] args) throws Exception {

        test_StringSearch();
        test_WordsSearch();
//
//		test_StringSearchEx();
//		test_WordsSearchEx();
//
//		test_StringSearchEx2();
//		test_WordsSearchEx2();
//		test_IllegalWordsSearch();
//
//		test_StringMatch();
//		test_WordsMatch();
//
//		test_StringMatchEx();
//		test_WordsMatchEx();
//
//		test_PinyinMatch();
//		test_PinyinMatch2();
//
//		test_Pinyin();
//		test_words();
//
//
//		test_issues_54();
//		test_issues_57();
//		test_issues_57_2();
//		test_issues_57_3();
//		test_issues_65();
//		test_issues_74();
    }

    public static void test_StringSearch() {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("StringSearch run Test.");

        StringSearch iwords = new StringSearch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.FindFirst(test);
        if (f != "中国") {
            System.out.println("FindFirst is Error.");
        }

        List<String> all = iwords.FindAll(test);
        if (all.get(0) != "中国") {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1) != "国人") {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_StringSearchEx() {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("StringSearchEx run Test.");

        StringSearchEx iwords = new StringSearchEx();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.FindFirst(test);
        if (f != "中国") {
            System.out.println("FindFirst is Error.");
        }

        List<String> all = iwords.FindAll(test);
        if (all.get(0) != "中国") {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1) != "国人") {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_StringSearchEx2() {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("StringSearchEx2 run Test.");

        StringSearchEx2 iwords = new StringSearchEx2();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.FindFirst(test);
        if (f != "中国") {
            System.out.println("FindFirst is Error.");
        }

        List<String> all = iwords.FindAll(test);
        if (all.get(0) != "中国") {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1) != "国人") {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_WordsSearch() {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("WordsSearch run Test.");

        WordsSearch iwords = new WordsSearch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        WordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword != "中国") {
            System.out.println("FindFirst is Error.");
        }

        List<WordsSearchResult> all = iwords.FindAll(test);
        if (all.get(0).Keyword != "中国") {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1).Keyword != "国人") {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_WordsSearchEx() throws IOException {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("WordsSearchEx run Test.");

        WordsSearchEx iwords2 = new WordsSearchEx();
        iwords2.SetKeywords(list);
        iwords2.Save("WordsSearchEx.dat");

        WordsSearchEx iwords = new WordsSearchEx();
        iwords.Load("WordsSearchEx.dat");

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        WordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword.equals("中国") == false) {
            System.out.println("FindFirst is Error.");
        }

        List<WordsSearchResult> all = iwords.FindAll(test);
        if (all.get(0).Keyword.equals("中国") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1).Keyword.equals("国人") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_WordsSearchEx2() {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("WordsSearchEx2 run Test.");

        WordsSearchEx2 iwords = new WordsSearchEx2();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        WordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword != "中国") {
            System.out.println("FindFirst is Error.");
        }

        List<WordsSearchResult> all = iwords.FindAll(test);
        if (all.get(0).Keyword != "中国") {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1).Keyword != "国人") {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_IllegalWordsSearch() {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("IllegalWordsSearch run Test.");

        IllegalWordsSearch iwords = new IllegalWordsSearch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        IllegalWordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword.equals("中国") == false) {
            System.out.println("FindFirst is Error.");
        }

        List<IllegalWordsSearchResult> all = iwords.FindAll(test);
        if (all.get(0).Keyword.equals("中国") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1).Keyword.equals("国人") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_StringMatch() throws Exception {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("[中美]国");
        list.add("国人");
        list.add("zg人");
        System.out.println("StringMatch run Test.");

        StringMatch iwords = new StringMatch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.FindFirst(test);
        if (!f.equals("中国")) {
            System.out.println("FindFirst is Error.");
        }

        List<String> all = iwords.FindAll(test);
        if (!all.get(0).equals("中国")) {
            System.out.println("FindAll is Error.");
        }
        if (!all.get(1).equals("国人")) {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_StringMatchEx() throws Exception {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("[中美]国");
        list.add("国人");
        list.add("zg人");
        System.out.println("StringMatchEx run Test.");

        StringMatchEx iwords = new StringMatchEx();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.FindFirst(test);
        if (!f.equals("中国")) {
            System.out.println("FindFirst is Error.");
        }

        List<String> all = iwords.FindAll(test);
        if (!all.get(0).equals("中国")) {
            System.out.println("FindAll is Error.");
        }
        if (!all.get(1).equals("国人")) {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_WordsMatch() throws Exception {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("[中美]国");
        list.add("国人");
        list.add("zg人");
        System.out.println("WordsMatch run Test.");

        WordsMatch iwords = new WordsMatch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        WordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword.equals("中国") == false) {
            System.out.println("FindFirst is Error.");
        }

        List<WordsSearchResult> all = iwords.FindAll(test);
        if (all.get(0).Keyword.equals("中国") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1).Keyword.equals("国人") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_WordsMatchEx() throws Exception {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("[中美]国");
        list.add("国人");
        list.add("zg人");
        System.out.println("WordsMatchEx run Test.");

        WordsMatchEx iwords = new WordsMatchEx();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        WordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword.equals("中国") == false) {
            System.out.println("FindFirst is Error.");
        }

        List<WordsSearchResult> all = iwords.FindAll(test);
        if (all.get(0).Keyword.equals("中国") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1).Keyword.equals("国人") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_PinyinMatch() throws NumberFormatException, IOException {
        String s = "北京|天津|河北|辽宁|吉林|黑龙江|山东|江苏|上海|浙江|安徽|福建|江西|广东|广西|海南|河南|湖南|湖北|山西|内蒙古|宁夏|青海|陕西|甘肃|新疆|四川|贵州|云南|重庆|西藏|香港|澳门|台湾";
        List<String> list = new ArrayList<String>();
        String[] ss = s.split("\\|");
        for (String st : ss) {
            list.add(st);
        }
        PinyinMatch match = new PinyinMatch();
        match.SetKeywords(list);
        System.out.println("PinyinMatch run Test.");

        List<String> all = match.Find("BJ");
        if (all.get(0).equals("北京") == false) {
            System.out.println("Find is Error.");
        }
        if (all.size() != 1) {
            System.out.println("Find is Error.");
        }

        all = match.Find("北J");
        if (all.get(0).equals("北京") == false) {
            System.out.println("Find is Error.");
        }
        if (all.size() != 1) {
            System.out.println("Find is Error.");
        }

        all = match.Find("北Ji");
        if (all.get(0).equals("北京") == false) {
            System.out.println("Find is Error.");
        }
        if (all.size() != 1) {
            System.out.println("Find is Error.");
        }
        all = match.Find("Su");
        if (all.get(0).equals("江苏") == false) {
            System.out.println("Find is Error.");
        }

        all = match.Find("Sdon");
        if (all.get(0).equals("山东") == false) {
            System.out.println("Find is Error.");
        }
        if (all.size() != 1) {
            System.out.println("Find is Error.");
        }
        all = match.Find("S东");
        if (all.get(0).equals("山东") == false) {
            System.out.println("Find is Error.");
        }
        if (all.size() != 1) {
            System.out.println("Find is Error.");
        }

        List<Integer> all2 = match.FindIndex("BJ");
        if (all2.get(0) != 0) {
            System.out.println("FindIndex is Error.");
        }
        if (all2.size() != 1) {
            System.out.println("FindIndex is Error.");
        }

        all = match.FindWithSpace("S 东");
        if (all.get(0).equals("山东") == false) {
            System.out.println("FindWithSpace is Error.");
        }
        if (all.size() != 1) {
            System.out.println("FindWithSpace is Error.");
        }

        all = match.FindWithSpace("h 江");
        if (all.get(0).equals("黑龙江") == false) {
            System.out.println("FindWithSpace is Error.");
        }

        all2 = match.FindIndexWithSpace("B J");
        if (all2.get(0) != 0) {
            System.out.println("FindIndexWithSpace is Error.");
        }
        if (all2.size() != 1) {
            System.out.println("FindIndexWithSpace is Error.");
        }

        all = match.FindWithSpace("京 北");
        if (all.size() != 0) {
            System.out.println("FindWithSpace is Error.");
        }

        all = match.FindWithSpace("黑龙 龙江");
        if (all.size() != 0) {
            System.out.println("FindWithSpace is Error.");
        }

        all = match.FindWithSpace("黑龙 江");
        if (all.get(0).equals("黑龙江") == false) {
            System.out.println("FindWithSpace is Error.");
        }
        all = match.FindWithSpace("黑 龙 江");
        if (all.get(0).equals("黑龙江") == false) {
            System.out.println("FindWithSpace is Error.");
        }
    }

//    public static void test_PinyinMatch2() throws Exception {
//        String s = "北京|天津|河北|辽宁|吉林|黑龙江|山东|江苏|上海|浙江|安徽|福建|江西|广东|广西|海南|河南|湖南|湖北|山西|内蒙古|宁夏|青海|陕西|甘肃|新疆|四川|贵州|云南|重庆|西藏|香港|澳门|台湾";
//        List<String> list = new ArrayList<String>();
//        String[] ss = s.split("\\|");
//        for (String st : ss) {
//            list.add(st);
//        }
//        PinyinMatch2<String> match = new PinyinMatch2<String>(list);
//        match.SetKeywordsFunc(new Function<String, String>() {
//            @Override
//            public String apply(String t) {
//                return t;
//            }
//        });
//
//        System.out.println("PinyinMatch2 run Test.");
//
//        List<String> all = match.Find("BJ");
//        if (all.get(0).equals("北京") == false) {
//            System.out.println("Find is Error.");
//        }
//        if (all.size() != 1) {
//            System.out.println("Find is Error.");
//        }
//
//        all = match.Find("北J");
//        if (all.get(0).equals("北京") == false) {
//            System.out.println("Find is Error.");
//        }
//        if (all.size() != 1) {
//            System.out.println("Find is Error.");
//        }
//
//        all = match.Find("北Ji");
//        if (all.get(0).equals("北京") == false) {
//            System.out.println("Find is Error.");
//        }
//        if (all.size() != 1) {
//            System.out.println("Find is Error.");
//        }
//        all = match.Find("Su");
//        if (all.get(0).equals("江苏") == false) {
//            System.out.println("Find is Error.");
//        }
//
//        all = match.Find("Sdon");
//        if (all.get(0).equals("山东") == false) {
//            System.out.println("Find is Error.");
//        }
//        if (all.size() != 1) {
//            System.out.println("Find is Error.");
//        }
//        all = match.Find("S东");
//        if (all.get(0).equals("山东") == false) {
//            System.out.println("Find is Error.");
//        }
//        if (all.size() != 1) {
//            System.out.println("Find is Error.");
//        }
//
//        all = match.FindWithSpace("S 东");
//        if (all.get(0).equals("山东") == false) {
//            System.out.println("FindWithSpace is Error.");
//        }
//        if (all.size() != 1) {
//            System.out.println("FindWithSpace is Error.");
//        }
//
//        all = match.FindWithSpace("h 江");
//        if (all.get(0).equals("黑龙江") == false) {
//            System.out.println("FindWithSpace is Error.");
//        }
//
//        all = match.FindWithSpace("京 北");
//        if (all.size() != 0) {
//            System.out.println("FindWithSpace is Error.");
//        }
//
//        all = match.FindWithSpace("黑龙 龙江");
//        if (all.size() != 0) {
//            System.out.println("FindWithSpace is Error.");
//        }
//
//        all = match.FindWithSpace("黑龙 江");
//        if (all.get(0).equals("黑龙江") == false) {
//            System.out.println("FindWithSpace is Error.");
//        }
//        all = match.FindWithSpace("黑 龙 江");
//        if (all.get(0).equals("黑龙江") == false) {
//            System.out.println("FindWithSpace is Error.");
//        }
//    }

    public static void test_save_load() throws IOException {
        String test = "我是中国人";
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("国人");
        list.add("zg人");
        System.out.println("test_save_load run Test.");

        StringSearchEx2 search = new StringSearchEx2();
        search.SetKeywords(list);
        search.Save("1.dat");

        StringSearchEx2 iwords = new StringSearchEx2();
        iwords.Load("1.dat");

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.FindFirst(test);
        if (f != "中国") {
            System.out.println("FindFirst is Error.");
        }

        List<String> all = iwords.FindAll(test);
        if (all.get(0) != "中国") {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1) != "国人") {
            System.out.println("FindAll is Error.");
        }
        if (all.size() != 2) {
            System.out.println("FindAll is Error.");
        }

        String str = iwords.Replace(test, '*');
        if (str.equals("我是***") == false) {
            System.out.println("Replace is Error.");
        }
    }


//    private static String readLineByLineJava8(String filePath) {
//        StringBuilder contentBuilder = new StringBuilder();
//        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
//            stream.forEach(s -> contentBuilder.append(s).append("\n"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return contentBuilder.toString();
//    }

    private static void test_IllegalWordsSearch_loadWordsFormBinaryFile() throws IOException {

        long l1 = System.currentTimeMillis();

        IllegalWordsSearch search = new IllegalWordsSearch();
        long l2 = System.currentTimeMillis();
        System.out.println("IllegalWordsSearch init time:" + (l2 - l1));

        //search.Load(new ClassPathResource("IllegalWordsSearch.dat").getFile().getAbsolutePath());
        long l3 = System.currentTimeMillis();
        System.out.println("load Load time:" + (l3 - l2));

        String test = "卖毒品哈哈哈哈毛澤東porn哈哈哈哈胡锦涛pornasds哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛胡锦涛撒旦撒旦ｐｏｒｎporn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn"
                + "哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡錦濤porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn"
                + "哈哈哈哈胡锦涛porn哈哈哈哈胡锦涛porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
                + "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
                + "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
                + "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn"
                + "哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn哈哈哈哈或porn";

        boolean b = search.ContainsAny(test);
        if (!b) {
            System.out.println("ContainsAny is Error.");
        }
        long l4 = System.currentTimeMillis();
        System.out.println("ContainsAny time:" + (l4 - l3));

        String str = search.Replace(test, '*');
        long l5 = System.currentTimeMillis();
        System.out.println("Replace Result:" + str);
        System.out.println("Replace time:" + (l5 - l4));
    }

    private static void test_IllegalWordsSearch_saveToBinaryFile() throws IOException {
//		List<String> list = new ArrayList<>();
//		try (BufferedReader bufferedReader = new BufferedReader(
//				new InputStreamReader(new ClassPathResource("sensi_words.txt").getInputStream()))) {
//			for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
//				list.add(line);
//			}
//		}
//		IllegalWordsSearch search = new IllegalWordsSearch();
//		search.SetKeywords(list);
//		search.Save("IllegalWordsSearch.dat");
    }

    private static void test_Pinyin() throws NumberFormatException, IOException {
        System.out.println("text_Pinyin run Test.");
        List<String> t = WordsHelper.GetAllPinyin('芃');
        if (t.get(0).equals("Peng") == false) {
            System.out.println("GetAllPinyin is Error.");
        }

        String a = WordsHelper.GetPinyinFast("阿");
        if (a.equals("A") == false) {
            System.out.println("GetPinyinFast is Error.");
        }

        String b = WordsHelper.GetPinyin("摩擦棒");
        if (b.equals("MoCaBang") == false) {
            System.out.println("GetPinyin is Error.");
        }
        b = WordsHelper.GetPinyin("秘鲁");
        if (b.equals("BiLu") == false) {
            System.out.println("GetPinyin is Error.");
        }

        String py = WordsHelper.GetPinyinFast("我爱中国");
        if (py.equals("WoAiZhongGuo") == false) {
            System.out.println("GetPinyinFast is Error.");
        }

        py = WordsHelper.GetPinyin("快乐，乐清");
        if (py.equals("KuaiLe，YueQing") == false) {
            System.out.println("GetPinyin is Error.");
        }

        py = WordsHelper.GetPinyin("快乐清理");
        if (py.equals("KuaiLeQingLi") == false) {
            System.out.println("GetPinyin is Error.");
        }

        py = WordsHelper.GetPinyin("我爱中国", true);
        if (py.equals("WǒÀiZhōngGuó") == false) {
            System.out.println("GetPinyin is Error.");
        }

        py = WordsHelper.GetFirstPinyin("我爱中国");
        if (py.equals("WAZG") == false) {
            System.out.println("GetPinyin is Error.");
        }

        List<String> pys = WordsHelper.GetAllPinyin('传');
        if (pys.get(0).equals("Chuan") == false) {
            System.out.println("GetAllPinyin is Error.");
        }
        if (pys.get(1).equals("Zhuan") == false) {
            System.out.println("GetAllPinyin is Error.");
        }

        py = WordsHelper.GetPinyinForName("单一一");
        if (py.equals("ShanYiYi") == false) {
            System.out.println("GetPinyinForName is Error.");
        }

        py = WordsHelper.GetPinyinForName("单一一", true);
        if (py.equals("ShànYīYī") == false) {
            System.out.println("GetPinyinForName is Error.");
        }

        List<String> all = WordsHelper.GetAllPinyin('石');
        if (all.size() == 0) {
            System.out.println("GetAllPinyin is Error.");
        }

    }

    private static void test_words() throws Exception {
        System.out.println("test_words run Test.");
        String s = WordsHelper.ToSimplifiedChinese("壹佰贰拾叁億肆仟伍佰陆拾柒萬捌仟玖佰零壹元壹角贰分");
        if (s.equals("壹佰贰拾叁亿肆仟伍佰陆拾柒万捌仟玖佰零壹元壹角贰分") == false) {
            System.out.println("ToSimplifiedChinese is Error.");
        }

        String tw = WordsHelper.ToTraditionalChinese("壹佰贰拾叁亿肆仟伍佰陆拾柒万捌仟玖佰零壹元壹角贰分");
        if (tw.equals("壹佰貳拾叄億肆仟伍佰陸拾柒萬捌仟玖佰零壹元壹角貳分") == false) {
            System.out.println("ToTraditionalChinese is Error.");
        }

        String tw2 = WordsHelper.ToTraditionalChinese("原代码11", 2);
        if (tw2.equals("原始碼11") == false) {
            System.out.println("ToTraditionalChinese is Error.");
        }

        String tw3 = WordsHelper.ToTraditionalChinese("反反复复", 2);
        if (tw3.equals("反反覆覆") == false) {
            System.out.println("ToTraditionalChinese is Error.");
        }

        String tw4 = WordsHelper.ToTraditionalChinese("这人考虑事情总是反反复复的", 2);
        if (tw4.equals("這人考慮事情總是反反覆覆的") == false) {
            System.out.println("ToTraditionalChinese is Error.");
        }

    }

    public static void test_issues_54() {
        IllegalWordsSearch search = new IllegalWordsSearch();
        search.SetKeywords(Arrays.asList("test", "world", "this", "hello", "monster"));
        String result = search.Replace("test, hahaha, this is a hello world", '*');
        if (result.equals("****, hahaha, **** is a ***** *****") == false) {
            System.out.println("IllegalWordsSearch Replace is Error.");
        }
    }

    public static void test_issues_57() {
        String test = "一,二二,三三三,四四四四,五五五五五,六六六六六六";
        List<String> list = new ArrayList<String>();
        list.add("一");
        list.add("二二");
        list.add("三三三");
        list.add("四四四四");
        list.add("五五五五五");
        list.add("六六六六六六");
        System.out.println("test_issues_57 run Test.");

        IllegalWordsSearch iwords = new IllegalWordsSearch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        IllegalWordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword.equals("一") == false) {
            System.out.println("FindFirst is Error.");
        }

        List<IllegalWordsSearchResult> all = iwords.FindAll(test);
        if (all.get(0).Keyword.equals("一") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(1).Keyword.equals("二二") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(2).Keyword.equals("三三三") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(3).Keyword.equals("四四四四") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(4).Keyword.equals("五五五五五") == false) {
            System.out.println("FindAll is Error.");
        }
        if (all.get(5).Keyword.equals("六六六六六六") == false) {
            System.out.println("FindAll is Error.");
        }
    }

    public static void test_issues_57_2() {
        String test = "jameson吃饭";
        List<String> list = new ArrayList<String>();
        list.add("jameson吃饭");
        list.add("吃饭jameson");
        System.out.println("test_issues_57_2 run Test.");

        IllegalWordsSearch iwords = new IllegalWordsSearch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        IllegalWordsSearchResult f = iwords.FindFirst(test);
        if (f.Keyword.equals("jameson吃饭") == false) {
            System.out.println("FindFirst is Error.");
        }
    }

    public static void test_issues_57_3() {
        String test = "his is sha ash";
        List<String> list = new ArrayList<String>();
        list.add("ash");
        list.add("sha");
        list.add("bcd");
        System.out.println("test_issues_57_3 run Test.");

        IllegalWordsSearch iwords = new IllegalWordsSearch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        IllegalWordsSearchResult f = iwords.FindFirst(test);
        if (f == null || f.Keyword.equals("sha") == false) {
            System.out.println("FindFirst is Error.");
        }
    }

    public static void test_issues_65() {
        String test = "fFuck";
        List<String> list = new ArrayList<String>();
        list.add("fuck");
        list.add("ffx");
        list.add("bcd");
        System.out.println("test_issues_65 run Test.");

        IllegalWordsSearch iwords = new IllegalWordsSearch();
        iwords.SetKeywords(list);

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }

        String f = iwords.Replace(test);
        if (f == null || f.equals("*****") == false) {
            System.out.println("Replace is Error.");
        }
    }

    public static void test_issues_74(File file) {
        if (file == null) {
            file = new File("sensi_words.txt");
        }
        List<String> list = loadKeywords(file);
        System.out.println("test_issues_74 run Test.");

        IllegalWordsSearch iwords = new IllegalWordsSearch();
        iwords.SetKeywords(list);
        String test = "机机歪歪";

        boolean b = iwords.ContainsAny(test);
        if (b == false) {
            System.out.println("ContainsAny is Error.");
        }
    }
    public  void testAsset(InputStream inputStream,boolean split){
        try {
            System.out.println("Demo load file");
            List<String> list = split? loadExtraKeywords(inputStream):loadKeywordsNoSplit(inputStream);
            StringSearch iwords = new StringSearch();
            System.out.println("Demo init data ");
            iwords.SetKeywords(list);
            //测试头部一个关键词
            System.out.println("Demo start test1");
            String test1="xxxx";
            boolean result1=iwords.ContainsAny(test1);
            System.out.println("Demo start test1 "+result1);
            //测试中部的一个关键词
            System.out.println("Demo start test2");
            String test2="xxx 疯狂赛车";
            boolean result2=iwords.ContainsAny(test2);
            System.out.println("Demo start test2 "+result2);
            // 测试尾部最后一个关键词
            System.out.println("Demo start test3");
            String test3=  "司法部xxxx";
            boolean result3=iwords.ContainsAny(test3);
            System.out.println("Demo start test3 "+result3);
            iwords.release();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> loadExtraKeywords(File file) throws IOException {
        Reader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
        return loadExtraKeywords(br);
    }

    public static List<String> loadExtraKeywords(InputStream inputStream) throws IOException {
        InputStream in;
        Reader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        return loadExtraKeywords(br);
    }
    public static List<String> loadKeywordsNoSplit(InputStream inputStream) {
        List<String> keyArray = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                keyArray.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyArray;
    }

    /**
     * 文件内容以","分割
     *
     * @param br
     * @return
     */
    public static List<String> loadExtraKeywords(Reader br) {
        List<String> keyArray = new ArrayList<String>();
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

    public static List<String> loadKeywords(File file) {
        List<String> keyArray = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                keyArray.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyArray;
    }

}
