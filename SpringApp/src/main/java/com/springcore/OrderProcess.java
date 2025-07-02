package com.springcore;

public class OrderProcess {
    private int orderId;
    private Order order;
    // interface reference
    private Payment paymentMode;
    // private UPI upi;
    //private NetBanking netBanking;


    public OrderProcess() {
    }

    public OrderProcess(int orderId, Order order, Payment paymentMode) {
        this.orderId = orderId;
        this.order = order;
        this.paymentMode = paymentMode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Payment paymentMode) {
        this.paymentMode = paymentMode;
    }



}
