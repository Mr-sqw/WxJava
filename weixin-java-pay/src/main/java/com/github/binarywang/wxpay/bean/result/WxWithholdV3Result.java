package com.github.binarywang.wxpay.bean.result;

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
 *   直连商户受理扣款 返回结果
 * </pre>
 */
@Data
@NoArgsConstructor
public class WxWithholdV3Result implements Serializable {

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
   * 【扣费金额信息】 实际进行的扣费信息
   * 必填
   * </pre>
   */
  @Required
  @SerializedName("amount")
  private WxPayAmount amount;

}
