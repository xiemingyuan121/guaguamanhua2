package com.example.administrator.bobomanhua.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class ADBean {

    /**
     * status : 0
     * data : [{"title":"妖精的尾巴：第444话<皇帝斯普利玵>","recom_type":"0","recom_return":"39","thumb":"http://csimg.dm300.com/images/upload/20150714/14368443711916.jpg","recom_index":"5"},{"title":"一击男最新章节：第75话<别放回去！>","recom_type":"0","recom_return":"8115","thumb":"http://csimg.dm300.com/images/upload/20150714/14368422982708.jpg","recom_index":"4"},{"title":"《食戟之灵》一起羞耻地做美食吧~","recom_type":"0","recom_return":"7069","thumb":"http://csimg.dm300.com/images/upload/20150702/14358092989840.jpg","recom_index":"2"}]
     */

    private int status;
    /**
     * title : 妖精的尾巴：第444话<皇帝斯普利玵>
     * recom_type : 0
     * recom_return : 39
     * thumb : http://csimg.dm300.com/images/upload/20150714/14368443711916.jpg
     * recom_index : 5
     */

    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private String recom_type;
        private String recom_return;
        private String thumb;
        private String recom_index;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRecom_type() {
            return recom_type;
        }

        public void setRecom_type(String recom_type) {
            this.recom_type = recom_type;
        }

        public String getRecom_return() {
            return recom_return;
        }

        public void setRecom_return(String recom_return) {
            this.recom_return = recom_return;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getRecom_index() {
            return recom_index;
        }

        public void setRecom_index(String recom_index) {
            this.recom_index = recom_index;
        }
    }
}
