package com.example.springdemo.Entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import lombok.Data;

/**
 * @author wb.wuzhihai01@mesg.corp.netease.com
 */
@Data
public class OrderQueryDetailResultVo {
    // 订单ID
    private long orderId;
    // 用户ID
    private long userId;
    // 订单创建时间
    private long createTime;
    private long cancelTime;
    // 订单状态 eg: PAYED
    private String status;
    //eg: NORMAL
    private String cancelStatus;
    //订单地址信息
    private OrderAddress orderAddress;
    // 支付方式 eg: ALIPAY
    private String paymethod;
    private Long payTime;
    //包裹相关信息，含sku信息
    private List<PackageBean> pkgBeanList;
    //总金额相关信息
    private CostBean cost;

    private ProductBean product;

    @Data
    public static class OrderAddress {
        private Long id;
        private Long orderId;
        private Long userId;
        //北京市
        private String provinceName;
        //北京市
        private String cityName;
        //昌平区
        private String districtName;
        //城北街道
        private String townName;
        //叶言
        private String address;
        //北京市北京市昌平区城北街道叶言
        private String fullAddress;
        private String zipCode;
        //用户姓名
        private String name;
        //用户手机号
        private String mobile;
        private Long modifyTimes;
    }

    @Data
    public static class PackageBean {
        private Long id;
        //eg: COMMENTED
        private String status;
        private Long confirmTime;
        private Long expCreateTime;
        private PkgDelivery pkgDelivery;
        private List<SkuBean> skuBeanList;

        @Data
        public static class PkgDelivery {
            // 包裹ID
            private Long packageId;
            //出库批次号 Osf-20220414-0000127
            private String outNums;
            //仓库id
            private Long storeHouseId;
            //仓库名 杭州顺丰仓
            private String storeHouseName;
            //物流公司 京东
            private String expressCom;
            // 物流单号 "202204192542065"
            private String express;
        }

        @Data
        public static class SkuBean {
            private Long skuId;
            private Long itemId;
            private Integer count = 0;
            private String name;
            private String picUrl;
            private List<String> specValueList;
            //FREE_PRICE_THRESHOLD_99
            private String skuFreightType;
            //100.00
            private BigDecimal originPrice = BigDecimal.ZERO;
            //100.00
            private BigDecimal retailPrice = BigDecimal.ZERO;
            //80.00
            private BigDecimal actualPrice = BigDecimal.ZERO;
            //640.00
            private BigDecimal subtotalPrice = BigDecimal.ZERO;
            //0
            private Integer purchaseType;
            //0
            private Integer type;
            // [业务身份]sku维度扩展
            private WelfareSkuExtBean welfareSkuExtParamBean;
        }

        @Data
        public static class WelfareSkuExtBean{
            //商品id
            private Long commodityId;
            // 商品实付--现金 140.00
            private BigDecimal orderItemCashPrice = BigDecimal.ZERO;
            // 商品实付--福利 500.00
            private BigDecimal orderItemWelfarePrice = BigDecimal.ZERO;
            //实付福点数 500.0
            private Double welfareNum = 0.0;
            //福粒批次号 "20220411191648450688"
            private List<String> batchNumbers;
            //结算折扣 10企业折扣
            private Double settlementDiscount;
            //商品折扣 10.0
            private Double discount;
            //礼包标识 false
            private Boolean giftbag;
            //商城折扣 20.00满减
            private BigDecimal corpCoupon = BigDecimal.ZERO;
            //sku级别满减优惠金额(该sku小计) 0.00
            private BigDecimal concessionsPrice = BigDecimal.ZERO;
            //锁定库存key "welfare-v50044352-s10948000"
            private String stockLockKey;
            //共享库存数量 8
            private Long sharedStockNum;
        }
    }

    @Data
    public static class CostBean {
        //800.00
        private BigDecimal totalPrice = BigDecimal.ZERO;
        //640.00
        private BigDecimal realPrice = BigDecimal.ZERO;
        //160.00
        private BigDecimal activityPrice = BigDecimal.ZERO;
        //640.00
        private BigDecimal actualPrice = BigDecimal.ZERO;
        //0.00
        private BigDecimal freightPrice = BigDecimal.ZERO;
        //0.00
        private BigDecimal expUserPrice = BigDecimal.ZERO;
        //0.00
        private BigDecimal couponPrice = BigDecimal.ZERO;
        //0
        private BigDecimal payFavorPrice = BigDecimal.ZERO;
        //0.00
        private BigDecimal corpCouponPrice = BigDecimal.ZERO;
        //0.00
        private BigDecimal giftCardPrice = BigDecimal.ZERO;
    }

    @Data
    public static class ProductBean {
        private WelfareOrderExtParamBean welfareOrderExtParamBean;

        @Data
        public static class WelfareOrderExtParamBean {
            //50044352
            private Long channelId;
            //满减活动id集合
            private Set<Long> promotionActId;
            //0.00
            private BigDecimal logisticsCashPrice = BigDecimal.ZERO;
            //0.00
            private BigDecimal logisticsWelfarePrice = BigDecimal.ZERO;
            //运费实付福粒数 0.0
            private Double logisticsWelfareNum = 0.0;
            //兑换比例 1.0
            private Double moneyRate;
            //企业折扣优惠金额 160.00
            private BigDecimal corpCoupon = BigDecimal.ZERO;
            //满减优惠金额 0.00
            private BigDecimal promotionActConcessions = BigDecimal.ZERO;
            //福粒支付比例 0.78
            private Double payRate;
            //企业折扣 0.8折
            private Double enterpriseDiscount;
            /**
             * 支付渠道
             * <p>
             * PAYMENT_ADVANCE(1, "先款后货"),
             * ADVANCE_DEPOSIT(2, "预存款支付"),
             * MONTHLY(3, "月结授信"),
             * INSTALLMENT(4, "分批付款"),
             * DELIVERY_ADVANCE(5, "先货后款");
             */
            private Integer payWay;
            //渠道的结算方式（-1无，0按订单支付时间，1按订单发货时间，2按确认收货时间，3多点结算）
            private Integer accountType;
            //newRoute
            private String welfareOrderTag;
        }
    }

}
