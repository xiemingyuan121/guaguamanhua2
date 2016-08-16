package com.example.administrator.bobomanhua.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class TypeBean {

    /**
     * status : 0
     * data : [{"title":"国产","thumb":"http://csimg.dm300.com/images/icon_cn.jpg","cateId":-101},{"title":"港漫","thumb":"http://csimg.dm300.com/images/icon_hk.jpg","cateId":-102},{"title":"日漫","thumb":"http://csimg.dm300.com/images/icon_jp.jpg","cateId":-103},{"title":"美漫","thumb":"http://csimg.dm300.com/images/icon_usa.jpg","cateId":-104},{"title":"魔幻","thumb":"http://csimg.dm300.com/images/upload/20150326/14273640364370.jpg","cateId":"8"},{"title":"武侠格斗","thumb":"http://csimg.dm300.com/images/upload/20150326/14273640821272.jpg","cateId":"5"},{"title":"热血","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641003091.jpg","cateId":"16"},{"title":"耽美BL","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641107206.jpg","cateId":"15"},{"title":"后宫","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641326765.jpg","cateId":"17"},{"title":"爱情","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641403456.jpg","cateId":"1"},{"title":"搞笑","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641517009.jpg","cateId":"4"},{"title":"科幻","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641604295.jpg","cateId":"2"},{"title":"萌系","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641697019.jpg","cateId":"19"},{"title":"百合","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641797548.jpg","cateId":"13"},{"title":"历史战争","thumb":"http://csimg.dm300.com/images/upload/20150326/14273641959413.jpg","cateId":"18"},{"title":"伪娘","thumb":"http://csimg.dm300.com/images/upload/20150326/14273642111839.jpg","cateId":"14"},{"title":"生活","thumb":"http://csimg.dm300.com/images/upload/20150326/14273642289905.jpg","cateId":"12"},{"title":"四格","thumb":"http://csimg.dm300.com/images/upload/20150326/14273642412482.jpg","cateId":"11"},{"title":"恐怖","thumb":"http://csimg.dm300.com/images/upload/20150326/14273642516678.jpg","cateId":"10"},{"title":"校园","thumb":"http://csimg.dm300.com/images/upload/20150326/14273642675817.jpg","cateId":"9"},{"title":"竞技","thumb":"http://csimg.dm300.com/images/upload/20150326/14273642815560.jpg","cateId":"7"},{"title":"侦探","thumb":"http://csimg.dm300.com/images/upload/20150326/14273642964536.jpg","cateId":"6"},{"title":"冒险","thumb":"http://csimg.dm300.com/images/upload/20150326/14273643063886.jpg","cateId":"3"},{"title":"综合其他","thumb":"http://csimg.dm300.com/images/upload/20150326/14273643181576.jpg","cateId":"20"}]
     */

    private int status;
    /**
     * title : 国产
     * thumb : http://csimg.dm300.com/images/icon_cn.jpg
     * cateId : -101
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
        private String thumb;
        private int cateId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }
    }
}
