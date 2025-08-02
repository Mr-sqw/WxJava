package cn.binarywang.wx.miniapp.bean.shop.request.shipping;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author xzh
 * created on  2023/5/17 17:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxMaOrderShippingInfoUploadRequest implements Serializable {
  private static final long serialVersionUID = -334322216049787167L;


  /**
   * 必填
   * 订单，需要上传物流信息的订单
   */
  @SerializedName("order_key")
  private OrderKeyBean orderKey;

  /**
   * 必填
   * 物流模式，发货方式枚举值：1、实体物流配送采用快递公司进行实体物流配送形式 2、同城配送 3、虚拟商品，虚拟商品，例如话费充值，点卡等，无实体配送形式 4、用户自提。见枚举{@link LogisticsTypeEnum}
   */
  @SerializedName("logistics_type")
  private int logisticsType;

  /**
   * 必填
   * 发货模式，发货模式枚举值：1、UNIFIED_DELIVERY（统一发货）2、SPLIT_DELIVERY（分拆发货）。见枚举{@link DeliveryModeEnum}
   * 示例值: UNIFIED_DELIVERY
   */
  @SerializedName("delivery_mode")
  private int deliveryMode;

  /**
   * 分拆发货模式时必填，用于标识分拆发货模式下是否已全部发货完成，只有全部发货完成的情况下才会向用户推送发货完成通知。
   * 示例值: true/false
   */
  @SerializedName("is_all_delivered")
  private Boolean isAllDelivered;

  /**
   * 必填
   * 物流信息列表，发货物流单列表，支持统一发货（单个物流单）和分拆发货（多个物流单）两种模式，多重性: [1, 10]
   */
  @SerializedName("shipping_list")
  private List<ShippingListBean> shippingList;

  /**
   * 必填
   * 上传时间，用于标识请求的先后顺序 示例值: `2022-12-15T13:29:35.120+08:00
   */
  @SerializedName("upload_time")
  private String uploadTime;

  /**
   * 必填
   * 支付者，支付者信息
   */
  @SerializedName("payer")
  private PayerBean payer;

  //

  @RequiredArgsConstructor
  @Getter
  public enum LogisticsTypeEnum {

    /**
     * 实体物流配送采用快递公司进行实体物流配送形式
     */
    ENTITY_LOGISTICS(1, "实体物流配送采用快递公司进行实体物流配送形式"),

    /**
     * 同城配送
     */
    CITY_DELIVERY(2, "同城配送"),

    /**
     * 虚拟商品，虚拟商品，例如话费充值，点卡等，无实体配送形式
     */
    VIRTUAL_PRODUCT(3, "虚拟商品"),

    /**
     * 用户自提
     */
    SELF_PICKUP(4, "用户自提"),

    ;

    private final Integer code;

    private final String desc;

  }

  @RequiredArgsConstructor
  @Getter
  public enum DeliveryModeEnum {

    /**
     * 统一发货
     */
    UNIFIED_DELIVERY(1, "统一发货"),

    /**
     * 分拆发货
     */
    SPLIT_DELIVERY(2, "分拆发货"),

    ;

    private final Integer code;

    private final String desc;

  }

}
