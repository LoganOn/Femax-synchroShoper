package service;

import lombok.RequiredArgsConstructor;
import model.DeliveryOrders;
import org.springframework.stereotype.Service;
import repository.DeliveryOrdersRepository;

@Service
@RequiredArgsConstructor
public class DeliveryOrdersService {

    private final DeliveryOrdersRepository deliveryOrdersRepository;

    public DeliveryOrders save(DeliveryOrders deliveryOrders){
        return deliveryOrdersRepository.save(deliveryOrders);
    }
}
