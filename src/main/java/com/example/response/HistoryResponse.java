package com.example.response;

import com.example.dto.EventDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class HistoryResponse {
    public static HistoryResponse of(List<EventDto> eventDto) {
        return new HistoryResponse(eventDto);
    }
    List<EventDto> eventDto;
}
