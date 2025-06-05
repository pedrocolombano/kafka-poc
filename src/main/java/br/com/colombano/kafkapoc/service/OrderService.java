package br.com.colombano.kafkapoc.service;

import br.com.colombano.kafkapoc.dto.request.OrderPlacedDto;
import br.com.colombano.kafkapoc.dto.response.OrderDto;
import br.com.colombano.kafkapoc.event.publisher.OrderPlacedPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderPlacedPublisher orderPlacedPublisher;

    public OrderDto placeOrder(OrderPlacedDto orderRequest) {
        log.info("Order request: {}", orderRequest);
        UUID newOrderId = UUID.randomUUID();

        log.info("Order placed with id: {}", newOrderId);
        OrderDto orderDto = new OrderDto(newOrderId, orderRequest.clientId(), orderRequest.totalPrice());

        orderPlacedPublisher.sendOrderEvent(orderDto);
        return orderDto;
    }

}
