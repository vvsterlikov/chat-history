package com.example.controller;

import com.example.dto.EventDto;
import com.example.response.HistoryResponse;
import org.springframework.http.ResponseEntity;

public interface ChatHistoryController {
    ResponseEntity<HistoryResponse> getHistory(String userId);
    ResponseEntity<Void> saveEvent(EventDto eventDto);
}
