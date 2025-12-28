package com.example.service;

import com.example.dto.EventDto;
import com.example.entity.EventEntity;
import com.example.mapper.EventMapper;
import com.example.repository.EventRepository;
import com.example.response.HistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventDatabaseService {
    private final EventRepository eventRepository;

    public void save(EventDto eventDto) {
        eventRepository.save(EventMapper.toEntity(eventDto));
    }

    public HistoryResponse getHistory(String userId) {
        List<EventEntity> events = eventRepository.getEventEntitiesByUserId(userId);
        List<EventDto> dtos = events.stream().map(EventMapper::toDto).toList();
        return HistoryResponse.of(dtos);
    }
}
