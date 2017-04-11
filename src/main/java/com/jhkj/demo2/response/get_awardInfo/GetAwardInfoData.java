package com.jhkj.demo2.response.get_awardInfo;

import java.util.List;

/**
 * Created by wgt on 2017/4/10.
 */
public class GetAwardInfoData {
    private List<AwardInfo>lotterys;

    public GetAwardInfoData() {
    }

    public List<AwardInfo> getLotterys() {
        return lotterys;
    }

    public void setLotterys(List<AwardInfo> lotterys) {
        this.lotterys = lotterys;
    }
}
