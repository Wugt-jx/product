package com.jhkj.demo3;

/**
 * Created by wgt on 2017/3/26.
 */
public class LotteryApi extends BaseApi {


    private int amount ;    //投注金额
    private int quantity;   //投注数量
    private String orderNo; //订单号
    private String customerId;  //自定义ID

    public LotteryApi(APIConfig apiConfig) {
        super(apiConfig);
    }


    public String createLotteryEx(int amount,int quantity,String orderNo,String customerId )throws Exception{
        if (amount<10){
            throw new Exception("amount can't less 10");
        }
        if (amount>200&&amount<19800&&amount%2!=0){
            throw new Exception("amount must be power of 2");
        }
        if (quantity>10&&quantity<1){
            throw new Exception("quantity must bettwen 1 and 10");
        }
        if (orderNo.length()!=16){
            throw new Exception("orderNo len must be 16");
        }
        if (customerId.length()!=16){
            throw new Exception("customerid len must be 16");
        }

        return null;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
