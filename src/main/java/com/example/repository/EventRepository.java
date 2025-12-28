package com.example.repository;

import com.example.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
    List<EventEntity> getEventEntitiesByUserId(String userId);
}
