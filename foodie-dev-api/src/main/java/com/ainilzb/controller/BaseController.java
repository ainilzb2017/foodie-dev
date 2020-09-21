package com.ainilzb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class BaseController {
    public static final String FOODIE_SHOPCART = "shopcart";


    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;

    //支付中心的调用地址
    String paymentUrl = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";

    //微信支付成功->支付中心->天天吃货平台
    //                       |->回调通知的url
    String payReturnUrl = "http://localhost:8088/orders/notifyMerchantOrderPaid";

    //用户上传头像的位置
//    public static final String IMAGE_USER_LOCATION = "C:\\Users\\dev3\\IdeaProjects\\images\\foodie\\faces";
    public static final String IMAGE_USER_LOCATION = "C:"+File.separator+"Users"+File.separator+"dev3"+File.separator+"IdeaProjects"+File.separator+"images"+File.separator+"foodie"+File.separator+"faces";



}
