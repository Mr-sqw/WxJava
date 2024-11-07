package com.github.binarywang.wxpay.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author suqianwen
 * created on  2024-11-03 5:24 下午
 * <pre>
 *   直连商户小程序场景预约扣费类型签约的预签约 返回结果
 * </pre>
 */
@Data
@NoArgsConstructor
public class WxMaEntrustV3Result {

  /**
   * <pre>
   * 【预签约ID】 委托代扣签约会话ID，十分钟内有效，用于跳转签约流程的传入参数。
   * 必填
   * string(128)
   * </pre>
   */
  @SerializedName(value = "pre_entrustweb_id")
  private String preEntrustwebId;

  /**
   * <pre>
   * 【跳转签约小程序的AppID】 用于调用navigateToMiniProgram，进行跳转签约流程的传入参数。
   * 必填
   * string(64)
   * </pre>
   */
  @SerializedName(value = "redirect_appid")
  private String redirectAppid;

  /**
   * <pre>
   * 【跳转签约小程序的路径】 用于调用navigateToMiniProgram，进行跳转签约流程的传入参数。
   * 必填
   * string(256)
   * </pre>
   */
  @SerializedName(value = "redirect_path")
  private String redirectPath;

}
