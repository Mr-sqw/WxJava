package com.github.binarywang.wxpay.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WxPayAmount {

  /**
   * 【金额】 总金额，单位为分，只能为整数。
   */
  @SerializedName("total")
  private Integer total;

  /**
   * <pre>
   * 【货币类型】 枚举类型，符合ISO 4217标准的三位字母代码，默认为CNY，目前只支持CNY。
   * 可选取值：
   * CNY: 扣费货币类型-人民币
   * </pre>
   */
  @SerializedName("currency")
  private String currency;

}
