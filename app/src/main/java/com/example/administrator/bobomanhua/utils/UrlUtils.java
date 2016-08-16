package com.example.administrator.bobomanhua.utils;

/**
 * Created by Administrator on 2016/8/6 0006.
 */
/*
广告栏：http://csapi.dm300.com:21889/android/recom/editorrecomlist?pagesize=4&platform_id=0

热门：http://csapi.dm300.com:21889/android/recom/hotlist?pagesize=30&page=%d

小编推荐：http://csapi.dm300.com:21889/android/recom/editorlist?pagesize=30&page=%d

港漫：http://csapi.dm300.com:21889/android/recom/hothklist?pagesize=30&page=%d

最近更新:http://csapi.dm300.com:21889/android/search/recentupdate?pagesize=30&page=%d
* */
public class UrlUtils {
    // 分类URL
    public static final String fenLeiUrl = "http://csapi.dm300.com:21889/android/search/category";
    // 广告Url
    public static final String guangGaoUrl= "http://csapi.dm300.com:21889/android/recom/editorrecomlist?pagesize=4&platform_id=0";
    // 热门URL
    public static final String hotUrl= "http://csapi.dm300.com:21889/android/recom/hotlist?pagesize=30&page=0";
    // 推荐URl
    public static final String tuiJianUrl = "http://csapi.dm300.com:21889/android/recom/editorlist?pagesize=30&page=0";
    // 港漫Url
    public static final  String gangManUrl = "http://csapi.dm300.com:21889/android/recom/hothklist?pagesize=30&page=0";
    // 更新URl
    public static  final String upDateUrl = "http://csapi.dm300.com:21889/android/search/recentupdate?pagesize=30&page=0";
   // 详情 URL
    public static final String xiangQingURL = "http://csapi.dm300.com:21889/android/comic/info?comicsrcid=0&comicid=";
   // 评论 URL
    public static final String chatUrl = "http://csapi.dm300.com:21889/android/comment/getCommentList?parent_id=0&pagesize=30&page=1&root_id=0&comicid=";
   // 章节URL
    public static final String zhangJieUrl = "http://csapi.dm300.com:21889/android/comic/charpterlist?comicsrcid=%id&comicid=%comicId";
    // 分类URl
    public static final String SearchUrl = "http://csapi.dm300.com:21889/android/search/query?pagesize=30&page=1&keyword=";
   // 图片显示URL
    public static final String imageShowUrl = "http://csapi.dm300.com:21889/android/comic/charpterinfo?charpterid=";
   // 分类2 URL
    public static final String Search2Url = "http://csapi.dm300.com:21889/android/search/categorylistcateId=%cateid&pagesize=30&tophot=1&page=1";
    /*
    * 该放方法用于获取 分类2 URl
    * */
    public static String getSearch2Url(String page,int p){
        String data1 = "http://csapi.dm300.com:21889/android/search/categorylist?cateId=";
        String data2 = "&pagesize=30&tophot=1&page=";
        return data1+page+data2+p;
    }
    /*
   * 该放方法用于获取 热门 URl
   * */
    public static String getHotUrl(int page){
        String data = "http://csapi.dm300.com:21889/android/recom/hotlist?pagesize=30&page=";
        return data+page;
    }
    /*
       * 该放方法用于获取 推荐 URl
       * */
    public static String getTuiJianUrl(int page){
        String data = "http://csapi.dm300.com:21889/android/recom/editorlist?pagesize=30&page=";
        return data+page;
    }
    /*
   * 该放方法用于获取 港漫 URl
   * */
    public static String getGangManUrl(int page){
        String data = "http://csapi.dm300.com:21889/android/recom/hothklist?pagesize=30&page=";
        return data+page;
    }

    /*
   * 该放方法用于获取 更新 URl
   * */
    public static String getUpDateUrl(int page){
        String data = "http://csapi.dm300.com:21889/android/search/recentupdate?pagesize=30&page=";
        return data+page;
    }
    /*
       * 该放方法用于获取 详情 URl
       * */
    public static String getXiangQingURL(String page){
        return  xiangQingURL+page;
    }
    /*
       * 该放方法用于获取 评论 URl
       * */
    public static String getChatUrl(String page){
        return chatUrl+page;
    }
    /*
       * 该放方法用于获取 章节 URl
       * */
    public static String getZhangJieUrl(String id ,String page){
        String data = "http://csapi.dm300.com:21889/android/comic/charpterlist?comicsrcid=" ;
        String data1 = "&comicid=";
        return data+id+data1+page;
    } /*
    * 该放方法用于获取 分类 URl
    * */
    public static String getSearchUrl(String data , int page){
        return "http://csapi.dm300.com:21889/android/search/query?pagesize=30&page="+page+"&keyword="+data;
    }
    /*
       * 该放方法用于获取 图片详情 URl
       * */
    public static String getImageShowUrl(String page){
        return  imageShowUrl+page;
    }
}

