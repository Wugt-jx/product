package com.jhkj.demo3.response;

import com.jhkj.demo3.domain.GetAwardInfoEx_Lottery;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wgt on 2017/4/7.
 */
public class GetAwardInfoExResponse implements Serializable {

    private static final long serialVersionUID = -6099851322628340859L;

    private List<GetAwardInfoEx_Lottery> lotterys;

    public GetAwardInfoExResponse() {
    }

    public List<GetAwardInfoEx_Lottery> getLotterys() {
        return lotterys;
    }

    public void setLotterys(List<GetAwardInfoEx_Lottery> lotterys) {
        this.lotterys = lotterys;
    }
}
