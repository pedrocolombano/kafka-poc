package br.com.colombano.kafkapoc.event.publisher;

import br.com.colombano.kafkapoc.dto.response.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrderPlacedPublisher {

    private final KafkaTemplate<String, OrderDto> kafkaTemplate;

    public void sendOrderEvent(OrderDto orderDto) {
        log.info("Sending order placed event for order: {}", orderDto.orderId());
        kafkaTemplate.send("order-placed", orderDto);
    }

}
