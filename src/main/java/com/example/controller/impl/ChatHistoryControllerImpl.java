package com.example.controller.impl;

import com.example.controller.ChatHistoryController;
import com.example.dto.EventDto;
import com.example.response.HistoryResponse;
import com.example.service.EventDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatHistoryControllerImpl implements ChatHistoryController {
    private final EventDatabaseService eventDatabaseService;
    @Override
    @GetMapping("/history/get")
    public ResponseEntity<HistoryResponse> getHistory(String userId) {
        HistoryResponse historyResponse = eventDatabaseService.getHistory(userId);
        return ResponseEntity.ok(historyResponse);
    }

    @Override
    @PostMapping("/history/save")
    public ResponseEntity<Void> saveEvent(EventDto eventDto) {
        eventDatabaseService.save(eventDto);
        return ResponseEntity.ok(null);
    }
}
