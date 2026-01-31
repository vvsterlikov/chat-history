package com.example.controller.impl;

import com.example.controller.ChatHistoryController;
import com.example.dto.EventDto;
import com.example.response.HistoryResponse;
import com.example.service.EventDatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatHistoryControllerImpl implements ChatHistoryController {
    private final EventDatabaseService eventDatabaseService;
    @Override
    @GetMapping("/history/get")
    public ResponseEntity<HistoryResponse> getHistory(String userId) {
        log.info("Запрос истории по пользователю {}", userId);
        HistoryResponse historyResponse = eventDatabaseService.getHistory(userId);
        log.info("Сформирован ответ {}", historyResponse);
        return ResponseEntity.ok(historyResponse);
    }

    @Override
    @PostMapping("/history/save")
    public ResponseEntity<Void> saveEvent(@RequestBody EventDto eventDto) {
        log.info("Сохранение истории {}", eventDto);
        eventDatabaseService.save(eventDto);
        return ResponseEntity.ok(null);
    }
}
