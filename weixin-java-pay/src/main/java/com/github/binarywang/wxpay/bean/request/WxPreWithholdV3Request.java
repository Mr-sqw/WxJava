package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.bean.result.WxPayAmount;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author suqianwen
 * created on  2024-11-03 5:24 下午
 *
 * <pre>
 *   直连商户预约扣费 请求参数
 * </pre>
 */
@Data
@NoArgsConstructor
public class WxPreWithholdV3Request implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * <pre>
   * 【应用ID】 商户在微信申请的公众号或移动应用AppID
   * 必填
   * string(32)
   * </pre>
   */
  @SerializedName(value = "appid")
  private String appId;

  /**
   * <pre>
   * 【预约的金额信息】 预约的金额信息
   * 必填
   * </pre>
   */
  @SerializedName(value = "schedule_amount")
  private WxPayAmount scheduleAmount;

}
