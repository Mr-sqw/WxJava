package com.github.binarywang.wxpay.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author suqianwen
 * created on  2024-11-03 5:24 下午
 */
@Data
public abstract class BaseWxPayV3Result {

  /**
   * <pre>
   * 【应用ID】 商户在微信申请的公众号或移动应用AppID
   * 必填
   * string(32)
   * </pre>
   */
  @SerializedName(value = "appid")
  private String appid;

  /**
   * <pre>
   * 微信支付分配的商户号
   * 必填
   * string(32)
   * </pre>
   */
  @SerializedName(value = "mchid")
  private String mchid;

  /**
   * <pre>
   * 【用户OpenID】 商户AppID下的用户唯一标识
   * 必填
   * string(64)
   * </pre>
   */
  @SerializedName("openid")
  private String openId;

}
