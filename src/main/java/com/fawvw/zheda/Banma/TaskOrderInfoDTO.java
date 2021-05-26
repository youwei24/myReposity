package com.fawvw.zheda.Banma;

import java.util.List;

public class TaskOrderInfoDTO {
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 指令名称
     */
    private String orderName;
    /**
     * 指令类型
     */
    private String orderType;
    /**
     * 所属任务ID
     */
    private Integer taskId;
    /**
     * 选择的设备列表
     */
    private List<String> vins;


    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public List<String> getVins() {
        return vins;
    }

    public void setVins(List<String> vins) {
        this.vins = vins;
    }
}
