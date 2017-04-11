package com.jhkj.demo2.exception;


/**
 * Created by wgt on 2017/3/28.
 */

public class LotteryApiException extends RuntimeException {

    public LotteryApiException(String message) {
        super(message);
    }

    public LotteryApiException(String message, Throwable cause){super(message,cause);}

    public LotteryApiException(Throwable cause){super(cause);}

    public LotteryApiException(){super();};
}
