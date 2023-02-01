package com.example.googlelogin.modules.product.entity;

import com.example.googlelogin.entity.Audit;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends Audit<UUID> {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            insertable = false,
            columnDefinition = "uuid",
            updatable = false,
            nullable = false
    )
    private UUID id;

    private String name;

    @Column(
            name = "product_code"
    )
    private String productCode;

    private String description;

    private String image;

    private String brand;

    private double price;

    private String quantity;

    private String unit;

    private String type;

    private String status;
}
