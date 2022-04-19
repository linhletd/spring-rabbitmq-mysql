package guru.springframework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
@Entity
@Data
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
}
