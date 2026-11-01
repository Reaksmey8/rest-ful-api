package co.istad.restfulapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Integer id;

    private String title;

    private BigDecimal price;

    private Integer qty;

    private Boolean isActive;

}
