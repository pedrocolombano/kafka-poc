package br.com.colombano.kafkapoc.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderDto(
        UUID orderId,
        UUID clientId,
        BigDecimal totalPrice
) {
}
