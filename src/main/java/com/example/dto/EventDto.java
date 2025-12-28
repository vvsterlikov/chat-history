package com.example.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EventDto {
    String userId;
    String eventType;
    String message;
}
