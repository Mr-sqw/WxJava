package com.github.binarywang.wxpay.bean.notify;

import com.github.binarywang.wxpay.bean.result.WxSignContractV3;
import com.github.binarywang.wxpay.bean.result.WxSignStatusNotifyResult;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/contract-alter-notify.html">直连商户委托代扣签解约通知</a>
 *
 * @see WxSignStatusNotifyResult
 */
@Data
@NoArgsConstructor
public class WxSignStatusNotifyV3Result implements WxPayBaseNotifyV3Result<WxSignContractV3> {

  /**
   * 源数据
   */
  private OriginNotifyResponse rawData;
  /**
   * 解密后的数据
   */
  private WxSignContractV3 result;

}
