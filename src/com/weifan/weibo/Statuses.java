package com.weifan.weibo;

import java.util.List;

import com.weifan.model.Status;

public class Statuses {
    private List<Status> statuses;
    private long total_number;

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public long getTotal_number() {
        return total_number;
    }

    public void setTotal_number(long total_number) {
        this.total_number = total_number;
    }

    @Override
    public String toString() {
        return "Statuses [statuses=" + statuses + ", total_number="
                + total_number + "]";
    }

}
