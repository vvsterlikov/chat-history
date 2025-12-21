package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EVENT")
public class EventEntity {
    @Id
    private Long id;

    @Column(name = "CHAT_ID")
    String chatId;

    @Column(name = "EVENT_TYPE")
    String eventType;

    @Column(name = "MESSAGE")
    String message;
}
