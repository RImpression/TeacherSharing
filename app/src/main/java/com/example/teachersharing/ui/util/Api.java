package com.example.teachersharing.ui.util;



public class Api {
    //教育新闻
    public static final String NEWS_URL = "http://new.jyb.cn/jybuc/hyBaseCol/search.action?callback=jQuery183007362443980556926_1491828024327&pagesize=10&pageindex=1&startDateStr=&endDateStr=&sourceStr=&searchStr=%E7%BB%BC%E5%90%88%2C%E8%80%83%E8%AF%95&searchWordStr=&sortstr=&stage=%E7%BB%BC%E5%90%88&classify=%E8%80%83%E8%AF%95&forms=&zone=&timeone=3&timetwo=&timethree=&pagenames=&_=1491828087406";

    public static final String LOGIN_URL = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/login?";

    public static final String Registered_URL = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/register?";
    //用户信息  http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/user/1?
    public static final String USERINFO_URL = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/user/";

    //教案
    //获取用户教案
    //http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/plan?token=d695410c177356f1a622519a42bca6de
    public static final String TEACHING_PLAN_GET = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/plan?token=";


    //笔记
    //获取用户笔记
    //http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/note/user/1?token=d695410c177356f1a622519a42bca6de
    public static final String USER_NOTE_GET = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/note/user/";

    //教学问题
    //获取教学问题
    //http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/question?token=d695410c177356f1a622519a42bca6de
    public static final String QUESTION_GET = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/question?token=";
    //问题回答
    //http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/answer/user/1?token=d695410c177356f1a622519a42bca6de
    public static final String ANSWER_GET = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/answer/user/";

    //资源
    //获取我的资源
    //http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/resource/user/1?token=d695410c177356f1a622519a42bca6de
    public static final String SOURCE_GET = "http://123.207.24.79/tple-spring-shiro-mybatis-rest/api/resource/user/";
}
