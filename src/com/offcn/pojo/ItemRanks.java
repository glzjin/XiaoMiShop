package com.offcn.pojo;

public class ItemRanks extends ItemRanksKey {
    private Byte rankScore;

    private String rankDetail;

    public Byte getRankScore() {
        return rankScore;
    }

    public void setRankScore(Byte rankScore) {
        this.rankScore = rankScore;
    }

    public String getRankDetail() {
        return rankDetail;
    }

    public void setRankDetail(String rankDetail) {
        this.rankDetail = rankDetail == null ? null : rankDetail.trim();
    }
}