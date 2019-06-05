package com.example.geeknews.geeknews.bean;

import java.util.List;

public class RiBaoBean {

    /**
     * date : 20190604
     * stories : [{"ga_prefix":"060420","id":9712051,"images":["https://pic1.zhimg.com/v2-9fc379e14e5632ca6698fc7235e8b8c8.jpg"],"title":"为什么晚睡对大脑有害，却有那么多人晚睡？","type":0},{"ga_prefix":"060409","id":9712059,"images":["https://pic4.zhimg.com/v2-5d2226d35e9f082742443cb9558cd9c3.jpg"],"title":"为什么有人喜欢说「我觉得」「其实我觉得」？","type":0},{"ga_prefix":"060408","id":9712142,"images":["https://pic1.zhimg.com/v2-d2a9ad0e9e20deb3681a57be8daa8bd8.jpg"],"title":"旗帜鲜明地反对断骨增高手术","type":0},{"ga_prefix":"060407","id":9712095,"images":["https://pic1.zhimg.com/v2-04c581c22c2682c0b3d8d1c197593738.jpg"],"title":"Uniqlo x KAWS 的发售「乱象」，是怎么出现的？","type":0},{"ga_prefix":"060406","id":9712033,"images":["https://pic1.zhimg.com/v2-2928b159f262386e84a98e7fae2ad038.jpg"],"title":"瞎扯 · 如何正确地吐槽","type":0}]
     * top_stories : [{"ga_prefix":"060407","id":9712095,"image":"https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg","title":"Uniqlo x KAWS 的发售「乱象」，是怎么出现的？","type":0},{"ga_prefix":"060408","id":9712142,"image":"https://pic1.zhimg.com/v2-cbc334204e7ffb639735367122eff48c.jpg","title":"旗帜鲜明地反对断骨增高手术","type":0},{"ga_prefix":"060308","id":9712046,"image":"https://pic1.zhimg.com/v2-96666b0894871ab0dbcf76dcccac6c40.jpg","title":"结婚 5 年，双方父母没见面，过年各回各家，Papi 酱的婚姻模式适合你吗？","type":0},{"ga_prefix":"053108","id":9712013,"image":"https://pic3.zhimg.com/v2-c041e9c1e28edc3100309532742509f2.jpg","title":"百度最难捱的一夜：五名高管闪电辞职内幕","type":0},{"ga_prefix":"053008","id":9711876,"image":"https://pic1.zhimg.com/v2-548d3d615b68aa27421475875d2b410c.jpg","title":"高铁这么好的东西，美国人为什么不大力发展？","type":0}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * ga_prefix : 060420
         * id : 9712051
         * images : ["https://pic1.zhimg.com/v2-9fc379e14e5632ca6698fc7235e8b8c8.jpg"]
         * title : 为什么晚睡对大脑有害，却有那么多人晚睡？
         * type : 0
         */

        private String ga_prefix;
        private int id;
        private String title;
        private int type;
        private List<String> images;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * ga_prefix : 060407
         * id : 9712095
         * image : https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg
         * title : Uniqlo x KAWS 的发售「乱象」，是怎么出现的？
         * type : 0
         */

        private String ga_prefix;
        private int id;
        private String image;
        private String title;
        private int type;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
