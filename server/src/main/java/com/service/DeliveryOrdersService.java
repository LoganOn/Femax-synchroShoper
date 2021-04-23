package com.service;

import lombok.RequiredArgsConstructor;
import com.model.DeliveryOrders;
import org.springframework.stereotype.Service;
import com.repository.DeliveryOrdersRepository;

@Service
@RequiredArgsConstructor
public class DeliveryOrdersService {

    private final DeliveryOrdersRepository deliveryOrdersRepository;

    public DeliveryOrders save(DeliveryOrders deliveryOrders){
        return deliveryOrdersRepository.save(deliveryOrders);
    }
}
