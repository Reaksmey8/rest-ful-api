package co.istad.restfulapi.dto;

import java.math.BigDecimal;

public record UpdateProductRequest(

        String title,

        BigDecimal price,

        Integer qty,

        Boolean isActive

) {
}
