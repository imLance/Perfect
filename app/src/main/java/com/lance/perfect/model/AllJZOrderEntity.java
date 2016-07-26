package com.lance.perfect.model;

import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/7/22.
 */
public class AllJZOrderEntity {

    /**
     * code : 1
     * msg :
     * data : {"ordercount":7,"totalyong":12.15,"list":[{"listid":"63","userid":"10155425","nicheng":"用户昵称","facepicurl":"http://wx.qlogo.cn/mmopen/iapaFjvRTbCTcyZVjFDrYhTfNdyPLicyxg3vn4ZD5ZxhMiaF0K7wHBtpmGHtv6NMuDrzWa5VVN/0","shopid":"100050","categoryid":"132","categoryyong":"5","mobile":"15665758225","jzusertype":"1","ordertype":"3","orderfwtype":"4","title":"全部 - 服务订单","goodsnum":"1","goodsprice":"3.00","price":"0.30","priceyong":"0.15","priceshop":"2.85","rebateday":"6.00","rebate":"11.00","mone":"额外我","status":"0","isact":"0","clienttype":"1","createdate":"2016-05-23 16:48:03","finishdate":"","cgname":"全部","isbtnzuofei":"0","isbtnduizhang":"0","isbtnshouxin":"1"}]}
     */

    private String code;
    private String msg;
    /**
     * ordercount : 7
     * totalyong : 12.15
     * list : [{"listid":"63","userid":"10155425","nicheng":"用户昵称","facepicurl":"http://wx.qlogo.cn/mmopen/iapaFjvRTbCTcyZVjFDrYhTfNdyPLicyxg3vn4ZD5ZxhMiaF0K7wHBtpmGHtv6NMuDrzWa5VVN/0","shopid":"100050","categoryid":"132","categoryyong":"5","mobile":"15665758225","jzusertype":"1","ordertype":"3","orderfwtype":"4","title":"全部 - 服务订单","goodsnum":"1","goodsprice":"3.00","price":"0.30","priceyong":"0.15","priceshop":"2.85","rebateday":"6.00","rebate":"11.00","mone":"额外我","status":"0","isact":"0","clienttype":"1","createdate":"2016-05-23 16:48:03","finishdate":"","cgname":"全部","isbtnzuofei":"0","isbtnduizhang":"0","isbtnshouxin":"1"}]
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String ordercount;
        private String totalyong;
        /**
         * listid : 63
         * userid : 10155425
         * nicheng : 用户昵称
         * facepicurl : http://wx.qlogo.cn/mmopen/iapaFjvRTbCTcyZVjFDrYhTfNdyPLicyxg3vn4ZD5ZxhMiaF0K7wHBtpmGHtv6NMuDrzWa5VVN/0
         * shopid : 100050
         * categoryid : 132
         * categoryyong : 5
         * mobile : 15665758225
         * jzusertype : 1
         * ordertype : 3
         * orderfwtype : 4
         * title : 全部 - 服务订单
         * goodsnum : 1
         * goodsprice : 3.00
         * price : 0.30
         * priceyong : 0.15
         * priceshop : 2.85
         * rebateday : 6.00
         * rebate : 11.00
         * mone : 额外我
         * status : 0
         * isact : 0
         * clienttype : 1
         * createdate : 2016-05-23 16:48:03
         * finishdate :
         * cgname : 全部
         * isbtnzuofei : 0
         * isbtnduizhang : 0
         * isbtnshouxin : 1
         */

        private List<JZOrderEntity> list;

        public String getOrdercount() {
            return ordercount;
        }

        public void setOrdercount(String ordercount) {
            this.ordercount = ordercount;
        }

        public String getTotalyong() {
            return totalyong;
        }

        public void setTotalyong(String totalyong) {
            this.totalyong = totalyong;
        }

        public List<JZOrderEntity> getList() {
            return list;
        }

        public void setList(List<JZOrderEntity> list) {
            this.list = list;
        }

        public static class JZOrderEntity {
            private String listid;
            private String userid;
            private String nicheng;
            private String facepicurl;
            private String shopid;
            private String categoryid;
            private String categoryyong;
            private String mobile;
            private String jzusertype;
            private String ordertype;
            private String orderfwtype;
            private String title;
            private String goodsnum;
            private String goodsprice;
            private String price;
            private String priceyong;
            private String priceshop;
            private String rebateday;
            private String rebate;
            private String mone;
            private String status;
            private String isact;
            private String clienttype;
            private String createdate;
            private String finishdate;
            private String cgname;
            private String isbtnzuofei;
            private String isbtnduizhang;
            private String isbtnshouxin;

            public String getListid() {
                return listid;
            }

            public void setListid(String listid) {
                this.listid = listid;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getNicheng() {
                return nicheng;
            }

            public void setNicheng(String nicheng) {
                this.nicheng = nicheng;
            }

            public String getFacepicurl() {
                return facepicurl;
            }

            public void setFacepicurl(String facepicurl) {
                this.facepicurl = facepicurl;
            }

            public String getShopid() {
                return shopid;
            }

            public void setShopid(String shopid) {
                this.shopid = shopid;
            }

            public String getCategoryid() {
                return categoryid;
            }

            public void setCategoryid(String categoryid) {
                this.categoryid = categoryid;
            }

            public String getCategoryyong() {
                return categoryyong;
            }

            public void setCategoryyong(String categoryyong) {
                this.categoryyong = categoryyong;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getJzusertype() {
                return jzusertype;
            }

            public void setJzusertype(String jzusertype) {
                this.jzusertype = jzusertype;
            }

            public String getOrdertype() {
                return ordertype;
            }

            public void setOrdertype(String ordertype) {
                this.ordertype = ordertype;
            }

            public String getOrderfwtype() {
                return orderfwtype;
            }

            public void setOrderfwtype(String orderfwtype) {
                this.orderfwtype = orderfwtype;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getGoodsnum() {
                return goodsnum;
            }

            public void setGoodsnum(String goodsnum) {
                this.goodsnum = goodsnum;
            }

            public String getGoodsprice() {
                return goodsprice;
            }

            public void setGoodsprice(String goodsprice) {
                this.goodsprice = goodsprice;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPriceyong() {
                return priceyong;
            }

            public void setPriceyong(String priceyong) {
                this.priceyong = priceyong;
            }

            public String getPriceshop() {
                return priceshop;
            }

            public void setPriceshop(String priceshop) {
                this.priceshop = priceshop;
            }

            public String getRebateday() {
                return rebateday;
            }

            public void setRebateday(String rebateday) {
                this.rebateday = rebateday;
            }

            public String getRebate() {
                return rebate;
            }

            public void setRebate(String rebate) {
                this.rebate = rebate;
            }

            public String getMone() {
                return mone;
            }

            public void setMone(String mone) {
                this.mone = mone;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIsact() {
                return isact;
            }

            public void setIsact(String isact) {
                this.isact = isact;
            }

            public String getClienttype() {
                return clienttype;
            }

            public void setClienttype(String clienttype) {
                this.clienttype = clienttype;
            }

            public String getCreatedate() {
                return createdate;
            }

            public void setCreatedate(String createdate) {
                this.createdate = createdate;
            }

            public String getFinishdate() {
                return finishdate;
            }

            public void setFinishdate(String finishdate) {
                this.finishdate = finishdate;
            }

            public String getCgname() {
                return cgname;
            }

            public void setCgname(String cgname) {
                this.cgname = cgname;
            }

            public String getIsbtnzuofei() {
                return isbtnzuofei;
            }

            public void setIsbtnzuofei(String isbtnzuofei) {
                this.isbtnzuofei = isbtnzuofei;
            }

            public String getIsbtnduizhang() {
                return isbtnduizhang;
            }

            public void setIsbtnduizhang(String isbtnduizhang) {
                this.isbtnduizhang = isbtnduizhang;
            }

            public String getIsbtnshouxin() {
                return isbtnshouxin;
            }

            public void setIsbtnshouxin(String isbtnshouxin) {
                this.isbtnshouxin = isbtnshouxin;
            }
        }
    }
}
