package com.github.binarywang.wxpay.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author suqianwen
 * created on  2024-11-03 5:40 下午
 *
 * <pre>
 *   直连商户预约扣费 返回结果
 * </pre>
 * @see WxSignContractV3.DeductSchedule
 */
@Data
@NoArgsConstructor
public class WxPreWithholdV3Result {

  /**
   * <pre>
   * 【扣费预约状态】 扣费预约状态。见枚举{@link WxSignContractV3.ScheduleStateEnum}
   * 必填
   * string
   * </pre>
   */
  @SerializedName("schedule_state")
  private String scheduleState;

  /**
   * <pre>
   * 【可扣费开始日期】 可扣费的开始日期，当状态为已预约或已扣费时有返回。遵循rfc3339标准格式，格式为yyyy-MM-DD，yyyy-MM-DD表示年月日，例如：2015-05-20表示，北京时间2015年5月20日。
   * 选填
   * string(32)
   * </pre>
   */
  @SerializedName("deduct_start_date")
  private String deductStartDate;

  /**
   * <pre>
   * 【可扣费结束日期】 可扣费结束日期，当状态为已预约或已扣费时有返回。遵循rfc3339标准格式，格式为yyyy-MM-DD，yyyy-MM-DD表示年月日，例如：2015-05-20表示，北京时间2015年5月20日。
   * 选填
   * string(32)
   * </pre>
   */
  @SerializedName("deduct_end_date")
  private String deductEndDate;

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
   * 【实际扣费金额】 实际扣费金额，当预约状态为已扣费时有返回
   * 选填
   * </pre>
   */
  @SerializedName("deduct_amount")
  private WxPayAmount deductAmount;

  /**
   * <pre>
   * 【实际扣费的日期】 实际扣费的日期，当预约状态为已扣费时有返回。遵循rfc3339标准格式，格式为yyyy-MM-DD，yyyy-MM-DD表示年月日，例如：2015-05-20表示，北京时间2015年5月20日。
   * 选填
   * string(32)
   * </pre>
   */
  @SerializedName("deduct_date")
  private String deductDate;

}
