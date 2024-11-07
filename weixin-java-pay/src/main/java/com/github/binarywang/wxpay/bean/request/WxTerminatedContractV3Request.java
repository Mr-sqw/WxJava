package com.github.binarywang.wxpay.bean.request;

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
 *   直连商户通过商户协议号解除委托代扣签约协议 请求
 * </pre>
 */
@Data
@NoArgsConstructor
public class WxTerminatedContractV3Request implements Serializable {

  /**
   * <pre>
   * 【解约备注】 解约原因的备注说明，如：签约信息有误，须重新签约。
   * 必填
   * string(256)
   * </pre>
   */
  @Required
  @SerializedName("contract_termination_remark")
  private String contractTerminationRemark;

}
