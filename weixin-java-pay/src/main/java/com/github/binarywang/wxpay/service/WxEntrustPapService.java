package com.github.binarywang.wxpay.service;

import com.github.binarywang.wxpay.bean.notify.SignatureHeader;
import com.github.binarywang.wxpay.bean.notify.WxSignStatusNotifyV3Result;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.exception.WxPayException;

/**
 * <pre>
 *   微信签约代扣相关接口.
 *   <a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter2_8.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter2_8.shtml</a>
 *  </pre>
 *
 * @author chenliang
 * created on  2021 -08-02 4:50 下午
 */
public interface WxEntrustPapService {

  /**
   * <pre>
   *   获取公众号纯签约链接,
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_1.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_1.shtml</a>
   *   该接口返回一个签约链接，该链接只能在微信内打开
   * </pre>
   *
   * @param wxMpEntrustRequest the wx mp entrust request
   * @return string
   * @throws WxPayException the wx pay exception
   */
  String mpSign(WxMpEntrustRequest wxMpEntrustRequest) throws WxPayException;

  /**
   * <pre>
   *   获取小程序纯签约参数json
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_3.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_3.shtml</a>
   *   返回一个json 前端用来拉起一个新的签约小程序进行签约
   * </pre>
   *
   * @param wxMaEntrustRequest the wx ma entrust request
   * @return string
   * @throws WxPayException the wx pay exception
   */
  String maSign(WxMaEntrustRequest wxMaEntrustRequest) throws WxPayException;

  /**
   * 直连商户小程序场景预约扣费类型签约的预签约
   * <pre>
   *   商户可调用本接口预先指定签约信息，生成预签约会话及对应的预签约ID，再携带预签约ID（pre_entrustweb_id）参数，通过小程序跳转参数调用navigateToMiniProgram跳转至微信支付的页面。跳转流程可参考唤起小程序签约API。用户可在微信支付客户端内的完成签约。
   *   若用户同意本次流程，则微信支付会通过商户指定的回调地址通知签约结果；若用户未同意或者流程执行失败，则不通知签约结果。
   *   商户签约协议号在进行签约后不能在重复使用，包括用户确认签约后因业务规则限制没有完成签约的协议、签约成功后已经解约的协议及签约成功生效中的协议。商户可通过查询协议接口确认商户侧协议号是否已经使用。
   *
   *   注意：商户获取的签约会话有效期为10分钟。
   *
   *   详见：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/mini-program-scheduled-deduct-pre-sign.html">https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/mini-program-scheduled-deduct-pre-sign.html</a>
   * </pre>
   *
   * @param request
   * @throws WxPayException
   */
  WxMaEntrustV3Result maSignV3(WxMaEntrustV3Request request) throws WxPayException;

  /**
   * <pre>
   *   获取h5纯签约支付跳转链接
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_4.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_4.shtml</a>
   *   返回一个签约链接  在浏览器请求链接拉起微信
   * </pre>
   *
   * @param wxH5EntrustRequest the wx h 5 entrust request
   * @return wx h 5 entrust result
   * @throws WxPayException the wx pay exception
   */
  WxH5EntrustResult h5Sign(WxH5EntrustRequest wxH5EntrustRequest) throws WxPayException;

  /**
   * <pre>
   *   支付中签约
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_5.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_5.shtml</a>
   *   请求微信 若微信内请求 需要构造json返回，
   *   若h5请求 直接使用mweb_url 链接即可拉起微信
   * </pre>
   *
   * @param wxPayEntrustRequest the wx pay entrust request
   * @return wx pay entrust result
   * @throws WxPayException the wx pay exception
   */
  WxPayEntrustResult paySign(WxPayEntrustRequest wxPayEntrustRequest) throws WxPayException;

  /**
   * 申请扣款
   * <pre>
   *   申请扣款
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_8.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_8.shtml</a>
   *   请求微信发起委托扣款，扣款额度和次数由使用的签约模板限制，
   *   该扣款接口是立即扣款 无延时 扣款前无消息通知。
   *
   *   • 特殊情况：周期扣费为通知后24小时扣费方式情况下，如果用户为首次签约（包含解约后重新签约），
   *   从用户签约成功时间开始算，商户在12小时内发起的扣款，会被立即执行，无延迟。商户超过12小时以后发起的扣款，都按24小时扣费规则执行
   * </pre>
   *
   * @param wxWithholdRequest the wx withhold request
   * @return wx withhold result
   * @throws WxPayException the wx pay exception
   */
  WxWithholdResult withhold(WxWithholdRequest wxWithholdRequest) throws WxPayException;

  /**
   * 直连商户受理扣款
   * <pre>
   * 接口说明
   * 商户调用「预约扣费」接口预约成功后，可调用本接口发起委托代扣扣款。系统受理扣款请求后，异步进行扣款，并通过商户指定的回调地址通知扣费结果。
   *
   * 规则说明
   * 在可扣费期（调用「预约扣费」接口预约成功后返回）的可扣费期内，商户可调用本接口接口发起扣费，扣款金额等于预约扣费金额。扣费失败可再次调用本接口发起重试扣费（重试次数由其他规则限制），直到扣费成功或者可扣费期结束。
   * 预约扣费金额：调用「预约扣费」接口时指定的金额。
   * 扣费结果将通过「委托代扣支付结果通知API」通知，也可调用<a href="https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_2.shtml">「查询订单」</a>接口获取订单状态
   *
   * 详见：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-create-transaction.html">https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-create-transaction.html</a>
   * </pre>
   *
   * @param request
   * @throws WxPayException
   */
  WxWithholdV3Result withholdV3(WxWithholdV3Request request) throws WxPayException;

  /**
   * 服务商模式的申请扣款
   * <pre>
   *   申请扣款
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter5_8.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter5_8.shtml</a>
   *   请求微信发起委托扣款，扣款额度和次数由使用的签约模板限制，
   *   该扣款接口是立即扣款 无延时 扣款前无消息通知。
   *
   *   • 特殊情况：周期扣费为通知后24小时扣费方式情况下，如果用户为首次签约（包含解约后重新签约），
   *   从用户签约成功时间开始算，商户在12小时内发起的扣款，会被立即执行，无延迟。商户超过12小时以后发起的扣款，都按24小时扣费规则执行
   * </pre>
   *
   * @param wxWithholdRequest the wx withhold request
   * @return wx withhold result
   * @throws WxPayException the wx pay exception
   */
  WxPayCommonResult withholdPartner(WxWithholdRequest wxWithholdRequest) throws WxPayException;

  /**
   * 预扣费通知
   * <pre>
   *   预扣费接口
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_10.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_10.shtml</a>
   *   商户进行委托代扣扣费前需要在可通知时间段内调用「预扣费通知」的接口为用户发送扣费提醒，
   *   并设定扣费持续天数和预计扣费金额，经过扣费等待期后，在可扣费期内可发起扣费，扣款金额不能高于预计扣费金额，
   *   扣费失败可主动发起重试扣费（重试次数由其他规则限制），直到扣费成功，或者可扣费期结束。
   *   商户只能在北京时间每天 6:00～22:00调用「预扣费通知」
   * </pre>
   *
   * @param wxPreWithholdRequest the wx pre withhold request
   * @return string
   * @throws WxPayException the wx pay exception
   */
  String preWithhold(WxPreWithholdRequest wxPreWithholdRequest) throws WxPayException;

  /**
   * 直连商户预约扣费
   * <pre>
   * 接口说明
   * 商户在进行委托代扣费前，需要提前在微信支付系统中预约扣费，预约成功后方可在约定时间内扣费。
   *
   * 规则说明
   * 预约扣费规则： 商户调用「受理扣款」接口进行委托代扣扣费前，需要指定委托代扣协议和扣费金额，扣费金额需要等于该周期指定的预计扣费金额，在可预约日的可预约时间段内调用「预约扣费」接口，系统将会在调用成功后的30分钟内，为用户发送预扣费通知，并返回可扣费日期。该协议不能再次调用「预约扣费」接口进行预约。 调用「预约扣费」接口成功后，商户可遵循下述扣费规则进行扣费。
   * 扣费规则： 在可扣费期内，商户可调用「受理扣款」接口发起扣费，扣费金额必须等于预约扣费时传入的扣费金额。扣费失败可再次调用「受理扣款」接口发起重试扣费（重试次数由其他规则限制），直到扣费成功或者可扣费期结束。若可扣费期结束时仍未扣费成功，则系统会在第二天的8点进行解约。
   * 可预约日：商户在跟用户签订委托代扣协议时指定预计扣费日期的前1个自然日当天。
   * 可预约时间段：为了不打扰用户，商户只能在北京时间每天 [8:00,19:30)内调用「预约扣费」接口。
   * 可扣费期：商户预约成功后，预约接口返回的可扣费开始日期至可扣费结束日期之间为可扣费期。注：目前可扣费期固定为一个自然日，即可扣费开始日期等于可扣费结束日期。
   *
   * 预约扣费示例
   * 假设商户跟用户签约时指定的预计扣费时间为2022-03-02，预计扣费金额为100元人民币
   * 该协议可预约日为2022-03-01，商户可以在2022-03-01 [8:00,19:30) ，指定协议ID、预计扣费金额100元人民币（必须等于100元人民币），调用「预约扣费」接口进行预约，系统将会在调用成功后的30分钟内，为用户发送预扣费通知，并返回可扣费期的开始日期2022-03-02 及结束日期2022-03-02，商户可以在[2022-03-02 00:00,2022-03-02 24:00)内，调用「受理扣款」接口进行委托代扣扣费，直到扣费成功。扣费成功后，系统将立即进行解约，该协议不能再次调用「预约扣费」接口和「受理扣款」接口。 若在2022-03-02 24:00前，仍未扣费成功，系统会在2022-03-03的8点进行解约。
   * 详见：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-schedule-deduction.html">https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-schedule-deduction.html</a>
   * </pre>
   *
   * @param contractId 【委托代扣协议ID】 签约成功后，微信返回的委托代扣协议ID。必填 string(32)
   * @param request
   * @return
   * @throws WxPayException
   */
  WxPreWithholdV3Result preWithholdV3(String contractId, WxPreWithholdV3Request request) throws WxPayException;

  /**
   * 直连商户查询扣费预约
   * <pre>
   * 接口说明
   * 商户调用「预约扣费」接口，因系统原因未能明确预约结果时，可使用本接口查询预约结果。
   * 详见：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-query-deduct-schedule.html">https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-query-deduct-schedule.html</a>
   * </pre>
   *
   * @param contractId【委托代扣协议ID】 签约成功后，微信返回的委托代扣协议ID。必填 string(32)
   * @return
   * @throws WxPayException
   */
  WxPreWithholdV3Result queryPreWithholdV3(String contractId) throws WxPayException;

  /**
   * 签约状态查询
   * <pre>
   *   签约状态查询
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_7.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_7.shtml</a>
   *   查询签约关系接口提供单笔签约关系查询。
   * </pre>
   *
   * @param wxSignQueryRequest the wx sign query request
   * @return wx sign query result
   * @throws WxPayException the wx pay exception
   */
  WxSignQueryResult querySign(WxSignQueryRequest wxSignQueryRequest) throws WxPayException;

  /**
   * 查询委托代扣签约协议
   * <pre>
   * 直连商户可通过本接口查询已经签订的委托代扣签约协议。
   * 前置条件：用户签约成功，商户已经成功获取过委托代扣签约协议。
   * 详见：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-get-contract-by-code.html">https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-get-contract-by-code.html</a>
   * </pre>
   *
   * @param planId          【委托代扣模板ID】 委托代扣模板ID，申请见接入指引中的接入流程相关内容。必填
   * @param outContractCode 【商户签约协议号】 商户侧的签约协议号，商户侧需保证唯一性。必填
   * @return
   * @throws WxPayException
   */
  WxSignContractV3 querySignV3(Integer planId, String outContractCode) throws WxPayException;

  /**
   * 申请解约
   * <pre>
   *   申请解约
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_9.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter3_9.shtml</a>
   *   商户与用户的签约关系有误或者商户主动要求与用户解除之前的签约协议时可调用此接口完成解约。
   *   商户可以在商户后台（pay.weixin.qq.com）设置解约回调地址，当发生解约关系的时候，微信服务器会向此地址通知解约信息，内容与签约返回一致
   * </pre>
   *
   * @param wxTerminatedContractRequest the wx terminated contract request
   * @return wx termination contract result
   * @throws WxPayException the wx pay exception
   */
  WxTerminationContractResult terminationContract(WxTerminatedContractRequest wxTerminatedContractRequest) throws WxPayException;

  /**
   * 解约委托代扣签约协议
   * <pre>
   *   直连商户可通过本接口解约委托代扣签约协议。
   *   前置条件 对应的委托代扣签约协议是已生效状态的委托代扣签约协议。
   *   详见：<a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-terminate-contract-by-code.html">https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/normal/normal-terminate-contract-by-code.html</a>
   * </pre>
   *
   * @param planId          【委托代扣模板ID】 委托代扣模板ID，申请见接入指引中的接入流程相关内容。必填
   * @param outContractCode 【商户签约协议号】 商户侧的签约协议号，商户侧需保证唯一性。必填
   * @param request
   * @return
   * @throws WxPayException
   */
  WxSignContractV3 terminationContractV3(Integer planId, String outContractCode, WxTerminatedContractV3Request request) throws WxPayException;

  /**
   * 直连商户委托代扣签解约通知
   * <pre>
   *   微信支付通过签解约通知接口将协议签解约结果通知给商户。
   *
   *   <a href="https://pay.weixin.qq.com/docs/merchant/apis/entrusted-payment/contract-alter-notify.html">详见</a>
   * </pre>
   *
   * @param notifyData 通知数据
   * @param header     通知头部数据，不传则表示不校验头
   * @return the wx pay order notify result
   * @throws WxPayException the wx pay exception
   * @see WxPayService#parseOrderNotifyV3Result(String, SignatureHeader)
   */
  WxSignStatusNotifyV3Result parseSignStatusNotifyV3Result(String notifyData, SignatureHeader header) throws WxPayException;

  /**
   * <pre>
   *   查询代扣订单
   *   详见：<a href="https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter4_5.shtml">https://pay.weixin.qq.com/wiki/doc/api/wxpay_v2/papay/chapter4_5.shtml</a>
   *   该接口仅提供微信扣款服务申请扣款接口创建的订单进行查询，商户可以通过该接口主动查询微信代扣订单状态，完成下一步的业务逻辑。
   *   ACCEPT等待扣款：为24小时延时扣费场景下独有的，当没有达到24小时前一直是这种状态；
   *   NOTPAY未支付：系统已经启动扣款流程，这个状态只是瞬间状态，很快会进入终态（SUCCESS、PAY_FAIL）
   *
   * </pre>
   *
   * @param wxWithholdOrderQueryRequest the wx withhold order query request
   * @return wx withhold order query result
   * @throws WxPayException the wx pay exception
   */
  WxWithholdOrderQueryResult papOrderQuery(WxWithholdOrderQueryRequest wxWithholdOrderQueryRequest) throws WxPayException;
}
