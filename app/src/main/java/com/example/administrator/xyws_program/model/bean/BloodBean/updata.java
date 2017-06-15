package com.example.administrator.xyws_program.model.bean.BloodBean;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/15 13:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */


public class updata {

    /**
     * app_data : temp_automactily_device_identify
     * app_user_id :
     * datatime : 1497503220
     * heart : 0.0
     * high : 120.0
     * low : 110.0
     * shou_data : temp_handly_device_identify
     * xywy_userid : 116925765
     */

    private String app_data;
    private String app_user_id;
    private int datatime;
    private double heart;
    private double high;
    private double low;
    private String shou_data;
    private String xywy_userid;

    public String getApp_data() {
        return app_data;
    }

    public void setApp_data(String app_data) {
        this.app_data = app_data;
    }

    public String getApp_user_id() {
        return app_user_id;
    }

    public void setApp_user_id(String app_user_id) {
        this.app_user_id = app_user_id;
    }

    public int getDatatime() {
        return datatime;
    }

    public void setDatatime(int datatime) {
        this.datatime = datatime;
    }

    public double getHeart() {
        return heart;
    }

    public void setHeart(double heart) {
        this.heart = heart;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public String getShou_data() {
        return shou_data;
    }

    public void setShou_data(String shou_data) {
        this.shou_data = shou_data;
    }

    public String getXywy_userid() {
        return xywy_userid;
    }

    public void setXywy_userid(String xywy_userid) {
        this.xywy_userid = xywy_userid;
    }
}
