package com.example.administrator.xyws_program.model;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:  网络请求工厂类
 * 创建人: XI
 * 创建时间: 2017/6/9 0009 8:43
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


public class HttpFactory {
    private static final int OKHTPP = 1;
    private static final int RETROFIT = 2;
    private static final int TYPE = RETROFIT;
    public static IHttp initParsing(){
        IHttp ihttp = null;
        switch(TYPE){
            case OKHTPP:
                break;
            case RETROFIT:
                ihttp = new RetrofitDemo();

                break;
        }
        return ihttp;
    }
}
