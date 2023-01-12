package com.example.googlelogin.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@MappedSuperclass
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Audited
public abstract class Audit<U extends UUID> implements Serializable {

    @CreatedBy
    @Column(name = "created_by", updatable = false, columnDefinition = "uuid")
    private U createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", updatable = false, columnDefinition = "uuid")
    private U lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date", updatable = false)
    private LocalDateTime lastModifiedDate;

    @Version
    private Long version;
}
