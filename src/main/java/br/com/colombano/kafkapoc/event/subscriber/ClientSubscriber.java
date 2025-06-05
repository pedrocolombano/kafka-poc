package br.com.colombano.kafkapoc.event.subscriber;

import br.com.colombano.kafkapoc.dto.response.OrderDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ClientSubscriber {

    @KafkaListener(
            topics = "order-placed",
            containerFactory = "clientContainerFactory"
    )
    public void consume(OrderDto order) {
        log.info("Client consumer running order: {}", order);
    }

}
