package cn.binarywang.wx.miniapp.bean.shop.request.shipping;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * @author xzh
 * @Description
 * @createTime 2023/07/10 10:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderKeyBean implements Serializable {
  private static final long serialVersionUID = -6322907878214196106L;

  /**
   * 必填
   * 订单单号类型，用于确认需要上传详情的订单。枚举值1，使用下单商户号和商户侧单号；枚举值2，使用微信支付单号。见枚举{@link OrderNumberTypeEnum}
   */
  @SerializedName("order_number_type")
  private int orderNumberType;
  /**
   * 原支付交易对应的微信订单号
   */
  @SerializedName("transaction_id")
  private String transactionId;
  /**
   * 支付下单商户的商户号，由微信支付生成并下发。
   */
  @SerializedName("mchid")
  private String mchId;
  /**
   * 商户系统内部订单号，只能是数字、大小写字母`_-*`且在同一个商户号下唯一
   */
  @SerializedName("out_trade_no")
  private String outTradeNo;

  public OrderKeyBean(String transactionId) {
    this.orderNumberType = OrderNumberTypeEnum.TRANSACTION_ID.getCode();
    this.transactionId = transactionId;
  }

  public OrderKeyBean(String mchId, String outTradeNo) {
    this.orderNumberType = OrderNumberTypeEnum.OUT_TRADE_NO.getCode();
    this.mchId = mchId;
    this.outTradeNo = outTradeNo;
  }

  @RequiredArgsConstructor
  @Getter
  public enum OrderNumberTypeEnum {

    /**
     * 商户号+商户侧单号
     */
    OUT_TRADE_NO(1, "商户号+商户侧单号"),

    /**
     * 微信支付订单号
     */
    TRANSACTION_ID(2, "微信支付订单号"),

    ;

    private final Integer code;

    private final String desc;

  }

}
