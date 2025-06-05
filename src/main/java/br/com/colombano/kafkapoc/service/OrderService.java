package br.com.colombano.kafkapoc.service;

import br.com.colombano.kafkapoc.dto.request.OrderPlacedDto;
import br.com.colombano.kafkapoc.dto.response.OrderDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class OrderService {

    public OrderDto placeOrder(OrderPlacedDto orderRequest) {
        log.info("Order request: {}", orderRequest);
        UUID newOrderId = UUID.randomUUID();

        log.info("Order placed with id: {}", newOrderId);
        return new OrderDto(newOrderId, orderRequest.clientId(), orderRequest.totalPrice());
    }

}
