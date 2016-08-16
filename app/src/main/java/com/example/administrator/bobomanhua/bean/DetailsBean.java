package com.example.administrator.bobomanhua.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class DetailsBean {
    /**
     * status : 0
     * data : {"title":"一拳超人","comicId":8115,"thumb":"http://csimg.dm300.com/images/spider/20150324/14271862469397.jpg","authorName":"村田雄介,ONE","comicType":"冒险,搞笑,武侠格斗","areaName":"日本","updateTime":"2016-07-11","comicSrc":[{"title":"7330","id":"8","lastCharpterTitle":"98话","lastCharpterId":"1983198","lastCharpterUpdateTime":1468242067},{"title":"热血动漫","id":"6","lastCharpterTitle":"98话","lastCharpterId":"1982690","lastCharpterUpdateTime":1468195204},{"title":"733dm","id":"10","lastCharpterTitle":"第97话","lastCharpterId":"1956864","lastCharpterUpdateTime":1466349740},{"title":"汗汗漫画(速度比较慢)","id":"11","lastCharpterTitle":"一拳超人 097集","lastCharpterId":"1956520","lastCharpterUpdateTime":1466334003},{"title":"吹雪漫画","id":"3","lastCharpterTitle":"第089话","lastCharpterId":"1820205","lastCharpterUpdateTime":1453621804},{"title":"动漫之家","id":"2","lastCharpterTitle":"第88话","lastCharpterId":"1803506","lastCharpterUpdateTime":1452308405}],"tucaos":"247","intro":"一拳超人漫画 ，主人公埼玉原本是一名整日奔波于求职的普通人。3年前的一天偶然遇到了要对淘气少年下杀手的异变螃蟹人后，回忆起年少年时\u201c想要成为英雄\u201d的梦想，最终拼尽全力救下了淘气少年。之后通过拼命锻炼，埼玉终于脱胎换骨获得了最强的力量，但同时失去了头发成了光头。在独自做了一段时间英雄后，正式加入英雄协会，与众多英雄一起开始了对抗各种怪人以及恶势力的生活\u2026\u2026动画官网地址：http://onepunchman-anime.net/\n","charpters":null}
     */

    private int status;
    /**
     * title : 一拳超人
     * comicId : 8115
     * thumb : http://csimg.dm300.com/images/spider/20150324/14271862469397.jpg
     * authorName : 村田雄介,ONE
     * comicType : 冒险,搞笑,武侠格斗
     * areaName : 日本
     * updateTime : 2016-07-11
     * comicSrc : [{"title":"7330","id":"8","lastCharpterTitle":"98话","lastCharpterId":"1983198","lastCharpterUpdateTime":1468242067},{"title":"热血动漫","id":"6","lastCharpterTitle":"98话","lastCharpterId":"1982690","lastCharpterUpdateTime":1468195204},{"title":"733dm","id":"10","lastCharpterTitle":"第97话","lastCharpterId":"1956864","lastCharpterUpdateTime":1466349740},{"title":"汗汗漫画(速度比较慢)","id":"11","lastCharpterTitle":"一拳超人 097集","lastCharpterId":"1956520","lastCharpterUpdateTime":1466334003},{"title":"吹雪漫画","id":"3","lastCharpterTitle":"第089话","lastCharpterId":"1820205","lastCharpterUpdateTime":1453621804},{"title":"动漫之家","id":"2","lastCharpterTitle":"第88话","lastCharpterId":"1803506","lastCharpterUpdateTime":1452308405}]
     * tucaos : 247
     * intro : 一拳超人漫画 ，主人公埼玉原本是一名整日奔波于求职的普通人。3年前的一天偶然遇到了要对淘气少年下杀手的异变螃蟹人后，回忆起年少年时“想要成为英雄”的梦想，最终拼尽全力救下了淘气少年。之后通过拼命锻炼，埼玉终于脱胎换骨获得了最强的力量，但同时失去了头发成了光头。在独自做了一段时间英雄后，正式加入英雄协会，与众多英雄一起开始了对抗各种怪人以及恶势力的生活……动画官网地址：http://onepunchman-anime.net/

     * charpters : null
     */

    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private int comicId;
        private String thumb;
        private String authorName;
        private String comicType;
        private String areaName;
        private String updateTime;
        private String tucaos;
        private String intro;
        private Object charpters;
        /**
         * title : 7330
         * id : 8
         * lastCharpterTitle : 98话
         * lastCharpterId : 1983198
         * lastCharpterUpdateTime : 1468242067
         */

        private List<ComicSrcBean> comicSrc;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getComicId() {
            return comicId;
        }

        public void setComicId(int comicId) {
            this.comicId = comicId;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getComicType() {
            return comicType;
        }

        public void setComicType(String comicType) {
            this.comicType = comicType;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getTucaos() {
            return tucaos;
        }

        public void setTucaos(String tucaos) {
            this.tucaos = tucaos;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public Object getCharpters() {
            return charpters;
        }

        public void setCharpters(Object charpters) {
            this.charpters = charpters;
        }

        public List<ComicSrcBean> getComicSrc() {
            return comicSrc;
        }

        public void setComicSrc(List<ComicSrcBean> comicSrc) {
            this.comicSrc = comicSrc;
        }

        public static class ComicSrcBean {
            private String title;
            private String id;
            private String lastCharpterTitle;
            private String lastCharpterId;
            private int lastCharpterUpdateTime;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLastCharpterTitle() {
                return lastCharpterTitle;
            }

            public void setLastCharpterTitle(String lastCharpterTitle) {
                this.lastCharpterTitle = lastCharpterTitle;
            }

            public String getLastCharpterId() {
                return lastCharpterId;
            }

            public void setLastCharpterId(String lastCharpterId) {
                this.lastCharpterId = lastCharpterId;
            }

            public int getLastCharpterUpdateTime() {
                return lastCharpterUpdateTime;
            }

            public void setLastCharpterUpdateTime(int lastCharpterUpdateTime) {
                this.lastCharpterUpdateTime = lastCharpterUpdateTime;
            }
        }
    }
}
