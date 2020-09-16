package _0604.pojo;

import java.util.Date;

/**
 * @author sunyong
 * @date 2020/06/04
 * @description
 */
public class OrderHistory {
    private int hid;
    private int orderId;
    private String orderDetail;
    private Date dealTime;
    private Date confirmDate;
    private String rollbackTime;
    private String rollbackReason;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getRollbackTime() {
        return rollbackTime;
    }

    public void setRollbackTime(String rollbackTime) {
        this.rollbackTime = rollbackTime;
    }

    public String getRollbackReason() {
        return rollbackReason;
    }

    public void setRollbackReason(String rollbackReason) {
        this.rollbackReason = rollbackReason;
    }
}
