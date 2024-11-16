package com.github.binarywang.wxpay.bean.result.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 预约扣费 签约场景/签约方式
 *
 * @author suqianwen
 */
@Getter
@AllArgsConstructor
public enum SignTypeEnum {
  /**
   * APP。API文档：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-app-scheduled-deduct-pre-sign.html">直连商户App场景预约扣费类型签约的预签约API</a>
   */
  APP("/v3/papay/scheduled-deduct-sign/contracts/pre-entrust-sign/app"),
  /**
   * JSAPI。API文档：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/jsapi-scheduled-deduct-pre-sign.html">直连商户JSAPI场景预约扣费类型签约的预签约API</a>
   */
  JSAPI("/v3/papay/scheduled-deduct-sign/contracts/pre-entrust-sign/jsapi"),
  /**
   * 小程序。API文档：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/mini-program-scheduled-deduct-pre-sign.html">直连商户小程序场景预约扣费类型签约的预签约API</a>
   */
  MINI_PROGRAM("/v3/papay/scheduled-deduct-sign/contracts/pre-entrust-sign/mini-program"),
  /**
   * H5。API文档：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-h5-scheduled-deduct-pre-sign.html">直连商户H5场景预约扣费类型签约的预签约API</a>
   */
  H5("/v3/papay/scheduled-deduct-sign/contracts/pre-entrust-sign/h5");

  /**
   * 直连商户预约扣费类型签约的预签约 base url
   */
  private final String baseUrl;

}
