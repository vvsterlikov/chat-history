package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "EVENT")
public class EventEntity {
    @Id
    private Long id;

    @Column(name = "USER_ID")
    String userId;

    @Column(name = "EVENT_TYPE")
    String eventType;

    @Column(name = "MESSAGE")
    String message;
}
