package br.com.colombano.kafkapoc.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderPlacedDto(
        UUID clientId,
        BigDecimal totalPrice
) {
}
