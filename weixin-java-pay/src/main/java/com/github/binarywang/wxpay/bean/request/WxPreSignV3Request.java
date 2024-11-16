package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.bean.result.WxPayAmount;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.annotation.Required;

/**
 * @author suqianwen
 * created on  2024-11-03 5:24 下午
 * <pre>
 *   直连商户预约扣费类型签约的预签约 请求参数
 * </pre>
 */
@Data
@NoArgsConstructor
public class WxPreSignV3Request {

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
   * 【用户在直连商户应用下的用户标示】 JSAPI和小程序签约必填，对应的用户需与实际在微信客户端中进行签约的用户一致。
   * 选填
   * string
   * </pre>
   */
  @SerializedName("openid")
  private String openId;

  /**
   * <pre>
   * 【委托代扣模板ID】 委托代扣模板ID
   * 必填
   * integer
   * </pre>
   */
  @SerializedName("plan_id")
  private Integer planId;

  /**
   * <pre>
   * 【商户签约协议号】 商户侧的签约协议号，商户侧需保证唯一性。
   * 必填
   * string(32)
   * </pre>
   */
  @SerializedName("out_contract_code")
  private String outContractCode;

  /**
   * <pre>
   * 【用户账户展示名称】 签约用户的名称，用于页面展示，在签约时由商户传入。
   * 必填
   * string(64)
   * </pre>
   */
  @SerializedName("contract_display_account")
  private String contractDisplayAccount;

  /**
   * <pre>
   * 【签约结果通知地址】 接收微信支付异步通知回调地址，通知URL必须为HTTPS且可直接可访问的URL，不能携带参数。
   * 必填
   * string(256)
   * </pre>
   */
  @Required
  @SerializedName("contract_notify_url")
  private String contractNotifyUrl;

  /**
   * <pre>
   * 【商户侧用户标识】 在多账号签约场景下使用。一个用户微信账号可能会在商户系统中存在多个账号，并开通多个签约协议。商户可以使用商户侧用户标识区分商户系统中的不同用户账号。注：使用多账号签约规则时，微信支付系统将限制相同的商户侧用户标识只能与同一个委托代扣模板签署一份生效中的协议。
   * 选填
   * string
   * </pre>
   */
  @SerializedName("out_user_code")
  private String outUserCode;

  /**
   * <pre>
   * 【用于预约扣费的预约信息】 用于预约扣费的预约信息，在使用预约扣费类型的模板进行预签约时，该值必填。
   * 选填
   * </pre>
   */
  @SerializedName("deduct_schedule")
  private DeductSchedule deductSchedule;

  /**
   * <pre>
   * 【跳转控制信息】 目前仅在H5签约场景生效。指定相关参数，可控制签约完成后跳转的路径。
   * 选填
   * </pre>
   */
  @SerializedName("jump_control")
  private JumpControl jumpControl;

  /**
   * 【用于预约扣费的预约信息】 用于预约扣费的预约信息，在使用预约扣费类型的模板进行预签约时，该值必填。
   */
  @Data
  @NoArgsConstructor
  public static class DeductSchedule {

    /**
     * <pre>
     * 【预计扣费的日期】 预约扣费场景下有效，预签约时指定的预计扣费的日期，遵循rfc3339标准格式，格式为yyyy-MM-DD，yyyy-MM-DD表示年月日，例如：2015-05-20表示，北京时间2015年5月20日。
     * 必填
     * string(32)
     * </pre>
     */
    @SerializedName("estimated_deduct_date")
    private String estimatedDeductDate;

    /**
     * <pre>
     * 【预计的扣费金额】 预约扣费场景下有效，预签约时指定的预计的扣费金额。
     * 必填
     * </pre>
     */
    @SerializedName("estimated_deduct_amount")
    private WxPayAmount estimatedDeductAmount;

    /**
     * <pre>
     * 【商品描述】 用户进行预约扣费购买的商品描述，将展示给用户
     * 必填
     * string
     * </pre>
     */
    @SerializedName("description")
    private String description;

  }

  /**
   * 【跳转控制信息】 目前仅在H5签约场景生效。指定相关参数，可控制签约完成后跳转的路径。
   */
  @Data
  @NoArgsConstructor
  public static class JumpControl {

    /**
     * <pre>
     * 【跳转的应用AppID】 仅H5签约场景生效。当商户已经申请H5签约完成后返回App的权限且指定跳转的应用AppID，签约完成后将返回该AppID对应的App应用。如果不填且签约发起时的来源UA可被微信识别，则跳转到UA对应的App应用，否则留在微信。识别UA并进行跳转的功能仅需绑定UA与回跳应用关系，无需申请跳转权限。申请跳转权限、绑定AppID与回跳应用关系、绑定UA与回跳应用关系的流程可参考指引文档中的接入前准备部分。
     * 选填
     * string
     * </pre>
     */
    @SerializedName("jump_appid")
    private String jumpAppid;

  }

}
