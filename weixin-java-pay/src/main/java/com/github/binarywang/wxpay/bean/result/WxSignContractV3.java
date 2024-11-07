package com.github.binarywang.wxpay.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author suqianwen
 * created on  2024-11-02 5:40 下午
 *
 * <pre>
 *   委托代扣签约协议
 * </pre>
 */
@Data
@NoArgsConstructor
public class WxSignContractV3 extends BaseWxPayV3Result {

  private static final long serialVersionUID = 1L;

  //

  /**
   * <pre>
   * 【委托代扣协议ID】委托代扣协议的主键，唯一定义此资源的标识
   * 必填
   * string(32)
   * </pre>
   */
  @SerializedName(value = "contract_id")
  private String contractId;

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
   * 【委托代扣协议状态】 委托代扣协议状态。见枚举{@link ContractStateEnum}
   * 必填
   * string
   * </pre>
   */
  @SerializedName("contract_state")
  private String contractState;

  /**
   * <pre>
   * 【协议签署时间】 协议签署时间，当前协议状态为签约失败时不返回。按照使用rfc3339所定义的格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒
   * 选填
   * string(32)
   * </pre>
   */
  @SerializedName("contract_signed_time")
  private String contractSignedTime;

  /**
   * <pre>
   * 【协议到期时间】 协议到期时间，当前协议状态为签约失败时不返回。按照使用rfc3339所定义的格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒
   * 选填
   * string(32)
   * </pre>
   */
  @SerializedName("contract_expired_time")
  private String contractExpiredTime;

  /**
   * <pre>
   * 【协议解约信息】 协议解约信息，仅当contract_state=TERMINATED时，该值有效。
   * 选填
   * </pre>
   */
  @SerializedName("contract_terminate_info")
  private ContractTerminateInfo contractTerminateInfo;

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
   * 【预约扣费场景的预约信息】 预约扣费场景的预约信息，仅当模板类型为预约扣费时，该值有效。
   * 选填
   * </pre>
   */
  @SerializedName("deduct_schedule")
  private DeductSchedule deductSchedule;

  /**
   * 【协议解约信息】 协议解约信息，仅当contract_state=TERMINATED时，该值有效。
   */
  public static class ContractTerminateInfo {

    /**
     * <pre>
     * 【协议解约方式】 协议解约方式。见枚举{@link ContractTerminationModeEnum}
     * 必填
     * string
     * </pre>
     */
    @SerializedName("contract_termination_mode")
    private String contractTerminationMode;

    /**
     * <pre>
     * 【协议解约时间】 按照使用rfc3339所定义的格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒
     * 必填
     * string(32)
     * </pre>
     */
    @SerializedName("contract_terminated_time")
    private String contractTerminatedTime;

    /**
     * <pre>
     * 【解约备注】 解约原因的备注说明，如：签约信息有误，须重新签约。
     * 选填
     * string
     * </pre>
     */
    @SerializedName("contract_termination_remark")
    private String contractTerminationRemark;

  }

  /**
   * 【预约扣费场景的预约信息】 预约扣费场景的预约信息，仅当模板类型为预约扣费时，该值有效。
   */
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
     * 【扣费预约状态】 扣费预约状态。见枚举{@link ScheduleStateEnum}
     * 必填
     * string
     * </pre>
     */
    @SerializedName("schedule_state")
    private String scheduleState;

    /**
     * <pre>
     * 【已预约的扣费金额信息】 已预约的扣费金额信息，当状态为已预约或已扣费时有返回。
     * 选填
     * </pre>
     */
    @SerializedName("scheduled_amount")
    private WxPayAmount scheduledAmount;

    /**
     * <pre>
     * 【实际扣费金额】 实际扣费金额
     * 选填
     * </pre>
     */
    @SerializedName("deduct_amount")
    private WxPayAmount deductAmount;

    /**
     * <pre>
     * 【实际扣费的日期】 实际扣费的日期，遵循rfc3339标准格式，格式为yyyy-MM-DD，yyyy-MM-DD表示年月日，例如：2015-05-20表示，北京时间2015年5月20日。
     * 选填
     * string(32)
     * </pre>
     */
    @SerializedName("deduct_date")
    private String deductDate;

  }

  /**
   * 【委托代扣协议状态】 委托代扣协议状态 枚举
   */
  @RequiredArgsConstructor
  @Getter
  public enum ContractStateEnum {

    /**
     * 已签约。签约生效中
     */
    SIGNED("SIGNED", "已签约"),
    /**
     * 已解约。生效的签约协议已被解约。此时协议已经到达终态，该协议无法再次进行签约；可更换协议号再发起签约。
     */
    TERMINATED("TERMINATED", "已解约"),
    /**
     * 用户同意签约但因业务规则限制导致签约失败。如：签约中支付场景，没有完成首期支付。此时协议已经到达终态，该协议无法再次进行签约；可更换协议号再发起签约。
     */
    SIGN_FAILED("SIGN_FAILED", "签约失败"),
    /**
     * 可续期的协议到期后，等待商户传入扣费计划进行续期。
     */
    TO_BE_RENEWED("TO_BE_RENEWED", "待续期"),

    ;

    private final String code;

    private final String desc;

  }

  /**
   * 【协议解约方式】 协议解约方式 枚举
   */
  @RequiredArgsConstructor
  @Getter
  public enum ContractTerminationModeEnum {

    /**
     * 用户发起的解约
     */
    USER_TERMINATE("USER_TERMINATE", "用户发起的解约"),
    /**
     * 商户通过API发起的解约
     */
    MCH_API_TERMINATE("MCH_API_TERMINATE", "商户通过API发起的解约"),
    /**
     * 商户在商户平台发起的解约
     */
    WEPAY_WEB_TERMINATE("WEPAY_WEB_TERMINATE", "商户在商户平台发起的解约"),
    /**
     * 用户联系微信支付客服发起的解约
     */
    CUSTOMER_SERVICE_TERMINATE("CUSTOMER_SERVICE_TERMINATE", "用户联系微信支付客服发起的解约"),
    /**
     * 微信支付系统主动发起的解约
     */
    SYSTEM_TERMINATE("SYSTEM_TERMINATE", "微信支付系统主动发起的解约"),

    ;

    private final String code;

    private final String desc;

  }

  /**
   * 【扣费预约状态】 扣费预约状态 枚举
   */
  @RequiredArgsConstructor
  @Getter
  public enum ScheduleStateEnum {

    /**
     * 未进行预约
     */
    NO_SCHEDULED("NO_SCHEDULED", "未进行预约"),
    /**
     * 已预约成功，未发起扣费或已发起扣费但扣费失败。
     */
    SCHEDULED("SCHEDULED", "已预约成功，未发起扣费或已发起扣费但扣费失败。"),
    /**
     * 已发起扣费且扣费成功
     */
    PAID("PAID", "已发起扣费且扣费成功"),
    /**
     * 超过预计扣费时间且没有扣费成功。此时商户无法再进行预约或扣费。
     */
    EXPIRED("EXPIRED", "超过预计扣费时间且没有扣费成功。此时商户无法再进行预约或扣费。"),

    ;

    private final String code;

    private final String desc;

  }

}
