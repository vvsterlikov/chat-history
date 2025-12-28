package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EVENT")
public class EventEntity {
    @Id
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "EVENT_TYPE")
    private String eventType;

    @Column(name = "MESSAGE")
    private String message;
}
