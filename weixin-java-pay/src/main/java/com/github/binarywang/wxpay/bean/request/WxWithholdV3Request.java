package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.bean.result.WxPayAmount;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.annotation.Required;

import java.io.Serializable;

/**
 * @author suqianwen
 * created on  2024-11-03 5:24 下午
 *
 * <pre>
 *   直连商户受理扣款 请求
 * </pre>
 */
@Data
@NoArgsConstructor
public class WxWithholdV3Request implements Serializable {

  /**
   * <pre>
   * 【应用ID】 商户在微信申请的公众号或移动应用AppID
   * 必填
   * string(32)
   * </pre>
   */
  @Required
  @SerializedName(value = "appid")
  private String appid;

  /**
   * <pre>
   * 【商户订单号】 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一。
   * 必填
   * string(32)
   * </pre>
   */
  @Required
  @SerializedName("out_trade_no")
  private String outTradeNo;

  /**
   * <pre>
   * 【商品描述】 商品描述。
   * 必填
   * string(127)
   * </pre>
   */
  @Required
  @SerializedName("description")
  private String description;

  /**
   * <pre>
   * 【通知地址】 异步接收微信支付结果通知的回调地址，通知URL必须为外网可访问的URL，不能携带参数。 公网域名必须为HTTPS，如果是走专线接入，使用专线NAT IP或者私有回调域名可使用HTTP
   * 必填
   * string(256)
   * </pre>
   */
  @Required
  @SerializedName("transactionNotifyUrl")
  private String transaction_notify_url;

  /**
   * <pre>
   * 【委托代扣协议ID】 签约成功后，微信返回的委托代扣协议ID。
   * 必填
   * string(32)
   * </pre>
   */
  @Required
  @SerializedName("contract_id")
  private String contractId;

  /**
   * <pre>
   * 【扣费金额信息】 扣费金额信息，必须等于预约时传入的预约金额。
   * 必填
   * </pre>
   */
  @Required
  @SerializedName("amount")
  private WxPayAmount amount;

  /**
   * <pre>
   * 【订单优惠标记】 订单优惠标记
   * 选填
   * string(32)
   * </pre>
   */
  @SerializedName("goods_tag")
  private String goodsTag;

  /**
   * <pre>
   * 【附加数据】 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
   * 选填
   * string(128)
   * </pre>
   */
  @SerializedName("attach")
  private String attach;

}
