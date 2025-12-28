package com.example.mapper;

import com.example.dto.EventDto;
import com.example.entity.EventEntity;

public class EventMapper {
    public static EventEntity toEntity(EventDto eventDto) {
        if (eventDto == null) {
            return null;
        }
        return EventEntity.builder()
                .eventType(eventDto.getEventType())
                .userId(eventDto.getUserId())
                .message(eventDto.getMessage())
                .build();
    }

    public static EventDto toDto(EventEntity eventEntity) {
        if (eventEntity == null) {
            return null;
        }
        return EventDto.builder()
                .eventType(eventEntity.getEventType())
                .message(eventEntity.getMessage())
                .userId(eventEntity.getUserId())
                .build();
    }
}
