package com.example.administrator.bobomanhua.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10 0010.
 */
public class ImageShowBean {
    /**
     * status : 0
     * data : {"charpterId":1970028,"title":"009妈妈","sid":9,"updateTime":1467128674,"counts":8,"size":1.04,"addrs":["http://733dm.zgkouqiang.cn/2016/06/28/09/48157d37d8.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/48d0e1e416.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/489b067bb7.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/48aeb50778.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/486f742717.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/481ba6b258.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/4820a10e93.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/48335d44e9.jpg"],"surl":"http://m.733dm.com/mh/26790/309411.html","iszm":0}
     */

    private int status;
    /**
     * charpterId : 1970028
     * title : 009妈妈
     * sid : 9
     * updateTime : 1467128674
     * counts : 8
     * size : 1.04
     * addrs : ["http://733dm.zgkouqiang.cn/2016/06/28/09/48157d37d8.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/48d0e1e416.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/489b067bb7.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/48aeb50778.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/486f742717.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/481ba6b258.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/4820a10e93.jpg","http://733dm.zgkouqiang.cn/2016/06/28/09/48335d44e9.jpg"]
     * surl : http://m.733dm.com/mh/26790/309411.html
     * iszm : 0
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
        private int charpterId;
        private String title;
        private int sid;
        private int updateTime;
        private int counts;
        private double size;
        private String surl;
        private int iszm;
        private List<String> addrs;

        public int getCharpterId() {
            return charpterId;
        }

        public void setCharpterId(int charpterId) {
            this.charpterId = charpterId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public String getSurl() {
            return surl;
        }

        public void setSurl(String surl) {
            this.surl = surl;
        }

        public int getIszm() {
            return iszm;
        }

        public void setIszm(int iszm) {
            this.iszm = iszm;
        }

        public List<String> getAddrs() {
            return addrs;
        }

        public void setAddrs(List<String> addrs) {
            this.addrs = addrs;
        }
    }
}
