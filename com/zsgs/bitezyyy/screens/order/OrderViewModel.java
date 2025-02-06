package com.zsgs.bitezyyy.screens.order;

import com.zsgs.bitezyyy.datalayer.BitezyyyRepository;
import com.zsgs.bitezyyy.dto.Order;

public class OrderViewModel {
    private OrderScreen orderScreen;

    OrderViewModel(OrderScreen orderScreen){
        this.orderScreen = orderScreen;
    }

    public Order getCurrOrder() {
        return BitezyyyRepository.getInstance().getOrder();
    }
}
