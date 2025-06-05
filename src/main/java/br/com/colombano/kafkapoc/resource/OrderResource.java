package br.com.colombano.kafkapoc.resource;

import br.com.colombano.kafkapoc.dto.request.OrderPlacedDto;
import br.com.colombano.kafkapoc.dto.response.OrderDto;
import br.com.colombano.kafkapoc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderPlacedDto orderRequest) {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

}
