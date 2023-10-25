package com.example.springdemo.newknowledge;

/**
 * @Author wb.guoqi
 * @create 2021/8/24 10:09
 */
public class format {

    public static void main(String[] args) {
        String messageTemplate = "【网易严选】【严选福礼】尊敬的客户：您的订单[%s}]已通过[%s]发出，快递单号为[%s}]，点击[%s}]查询物流信息。退订请回复【T】";
        String format = String.format(messageTemplate, "orderNo", "orderPacketInfo.getExpressCompany()",
            "orderPacketInfo.getExpressNo()", "url");
        System.out.println(messageTemplate);
        System.out.println("************************************************************");
        System.out.println(format);
    }
}
