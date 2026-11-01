package co.istad.restfulapi.dto;

import java.math.BigDecimal;

public record CreateProductRequest(

        String title,

        BigDecimal price,

        Integer qty

) {
}
