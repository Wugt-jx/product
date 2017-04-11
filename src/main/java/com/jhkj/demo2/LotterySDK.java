package com.jhkj.demo2;

import com.jhkj.demo2.response.create_advanceToken.CreateAdvanceTokenResponse;
import com.jhkj.demo2.response.create_lotteryEX.CreateLotteryExResponse;
import com.jhkj.demo2.response.encash_toAccount.EncashToAccountResponse;
import com.jhkj.demo2.response.get_accountBalance.GetAccountBalanceResponse;
import com.jhkj.demo2.response.get_accountDetail.GetAccountDetailResponse;
import com.jhkj.demo2.response.get_awardInfo.GetAwardInfoResponse;
import com.jhkj.demo2.response.get_currentIssue.GetcurrentIssueResponse;
import com.jhkj.demo2.response.get_customerWinBalance.GetCustomerWinBalanceResponse;
import com.jhkj.demo2.response.get_issue.GetIssueResponse;
import com.jhkj.demo2.response.get_lotteryList.GetLotteryListResponse;
import com.jhkj.demo2.response.get_signkey.GetSignKeyResponse;
import com.jhkj.demo2.response.get_withdrawalList.GetWithdrawalListResponse;
import com.jhkj.demo2.service.*;

/**sdk总入口
 * Created by wgt on 2017/4/11.
 */
public class LotterySDK {

    /**
     * 初始化配置
     *
     * @param appId
     * @param secureKry
     * @param signKey
     */
    public static void initSDKConfigure(String appId, String secureKry, String signKey) {
        ApiConfig.setAppId(appId);
        ApiConfig.setSecureKey(secureKry);
        ApiConfig.setSignKey(signKey);
    }

    /**
     * 请求获取签名Key（signKey）
     *
     * @return 新的signKey
     * @throws Exception
     */
    public static GetSignKeyResponse getSignKey() throws Exception {
        return new GetSignKeyService().request();
    }

    /**
     * 请求获取一张彩票（出彩票）
     *
     * @param quantity   投注数量
     * @param amount     投注金额
     * @param customerId 投注用户名（自定义）
     * @param orderNo    订单号（自定义）
     * @return
     * @throws Exception
     */
    public static CreateLotteryExResponse createLotteryEx(int quantity, int amount, String customerId, String orderNo) {
        return new CreateLotteryExService().request(quantity, amount, customerId, orderNo);
    }

    /**
     * 查询中奖记录
     *
     * @param issue       查询中间记录期号
     * @param currentPage 获第几条记录开始，不小于1
     * @param showCount   需要展示的记录条数，1~20之间，如果过多可以进行分页获取
     * @return
     */
    public static GetAwardInfoResponse getAwardInfoEx(String issue, int currentPage, int showCount) {
        return new GetAwardInfoExService().request(issue, currentPage, showCount);
    }

    /**
     * 获取期号信息
     *
     * @param issue       查询指定期号，传入空字符串则是批量获取所有
     * @param currentPage 获第几条记录开始，不小于1
     * @param showCount   需要展示的记录条数，1~20之间，如果过多可以进行分页获取
     * @return
     */
    public static GetIssueResponse getIssue(String issue, int currentPage, int showCount) {
        return new GetIssueService().request(issue, currentPage, showCount);
    }

    /**
     * 获取当前期号信息
     * @param gameCode  游戏类型，双色球为201
     * @return
     */
    public static GetcurrentIssueResponse getCurrentIssue(int gameCode){
        return new GetCurrentIssueService().request(gameCode);
    }

    /**
     * 根据customerId（自定义）获取购彩记录
     * @param customerId    用户id（自定义）
     * @param currentPage 获第几条记录开始，不小于1
     * @param showCount   需要展示的记录条数，1~20之间，如果过多可以进行分页获取
     * @return
     */
    public static GetLotteryListResponse getLotteryListByCustomerId(String customerId, int currentPage, int showCount){
        return new GetLotteryListByCustomerIdService().request(customerId,currentPage,showCount);
    }

    /**
     * 根据orderNo（自定义）获取购彩记录
     * @param orderNo     订单号
     * @param currentPage 获第几条记录开始，不小于1
     * @param showCount   需要展示的记录条数，1~20之间，如果过多可以进行分页获取
     * @return
     */
    public static GetLotteryListResponse getLotteryListByOrderNo(String orderNo,int currentPage,int showCount){
        return new GetLotteryListByOrderNoService().request(currentPage,showCount,orderNo);
    }

    /**
     * 查看帐号余额
     * @return
     */
    public static GetAccountBalanceResponse getAccountBalance(){
        return new GetAccountBalanceService().request();
    }

    /**
     * 兑付用户中奖金额至帐号余额，注意：用户中奖余额必须大于等于要兑付的金额
     * @param amount        兑付金额
     * @param customerId    用户id（自定义）
     * @return
     */
    public static EncashToAccountResponse encashToAccount(int amount, String customerId){
        return new EncashToAccountService().request(amount,customerId);
    }

    /**
     * 查询用户赢取的奖金余额
     * @param customerId
     * @return
     */
    public static GetCustomerWinBalanceResponse getCustomerWinBalance(String customerId){
        return new GetCustomerWinBalanceService().request(customerId);
    }

    /**
     * 获取提现页所需的token
     * @param extra      自定义参数，会在回调地址原样返回.可为null值
     * @param customerId 自定义用户ID
     * @param bindIP     客户端IP，请输入客户端请求的真实IP
     * @param amount     提现金额（单位：分）, 至少100（1元）及以上
     * @param retcallUrl 回调地址
     * @return
     */
    public static CreateAdvanceTokenResponse createAdvanceToken(String extra, String customerId, String bindIP, int amount, String retcallUrl){
        return new CreateAdvanceTokenService().request(extra,customerId,bindIP,amount,retcallUrl);
    }

    /**
     * 获取提现记录
     * @param customerId    用户自定义Id
     * @param currentPage 获第几条记录开始，不小于1
     * @param showCount   需要展示的记录条数，1~20之间，如果过多可以进行分页获取
     * @return
     */
    public static GetWithdrawalListResponse getWithdrawalList(String customerId, int currentPage, int showCount){
        return new GetWithdrawalListService().request(customerId,currentPage,showCount);
    }

    /**
     *查看帐号出入明细
     * @param type 0位入账，1为出账
     * @return
     */
    public static GetAccountDetailResponse getAccountDetail(int type){
        return new GetAccountDetailService().request(type);
    }
}