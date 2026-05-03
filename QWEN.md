# Chat History Service

## Обзор проекта

**chat-history** — это RESTful микросервис на Spring Boot для сохранения и получения истории сообщений чата. Сервис хранит события (тип события, сообщение, идентификатор пользователя) и предоставляет два API-эндпоинта: получение истории по пользователю и сохранение нового события.

### Технологии и зависимости

| Технология | Версия | 
|---|---|
| Java | 22 |
| Spring Boot | 4.0.0 |
| Spring Data JPA | 4.0.0 |
| H2 Database | 2.4.240 (in-memory) |
| Liquibase | 5.0.0 |
| Lombok | 1.18.42 |
| SLF4J / Logback | 2.0.17 / 1.5.21 |

### Архитектура

Стандартная слоистая архитектура Spring Boot:

```
src/main/java/com/example/
├── App.java                          — точка входа
├── controller/
│   ├── ChatHistoryController.java    — интерфейс
│   └── impl/
│       └── ChatHistoryControllerImpl.java  — REST-контроллер
├── dto/EventDto.java                 — DTO
├── entity/EventEntity.java           — JPA-сущность (таблица EVENT)
├── mapper/EventMapper.java           — маппер DTO ↔ Entity
├── repository/EventRepository.java   — Spring Data CRUD repository
├── request/                          — (зарезервировано)
├── response/HistoryResponse.java     — ответ API
└── service/EventDatabaseService.java — бизнес-логика
```

### API

| Метод | Путь | Описание |
|---|---|---|
| `GET` | `/history/get` | Получить историю по `userId` (query parameter) |
| `POST` | `/history/save` | Сохранить событие (JSON body: `userId`, `eventType`, `message`) |

## Сборка и запуск

### Требования

- JDK 22+
- Maven 3.9+

### Команды

```bash
# Сборка (пропуск тестов)
mvn clean package -DskipTests

# Сборка с тестами
mvn clean package

# Запуск приложения (dev профиль, H2 in-memory)
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Создание Docker-образа через Jib
mvn jib:dockerBuild
```

### Docker

Многоэтапная сборка (Dockerfile):
1. **builder** — `maven:3.9-eclipse-temurin-22` → `mvn clean package`
2. **runtime** — `eclipse-temurin:22-jre-alpine` → запуск jar

Образ: `chat-history:latest`

### Kubernetes / Helm

Чарт находится в `helm/chat-history/`:

```bash
helm install chat-history ./helm/chat-history
```

## Конфигурация

| Файл | Описание |
|---|---|
| `src/main/resources/application.yaml` | Основной конфиг (пустой) |
| `src/main/resources/application-dev.yaml` | Dev-профиль: H2 in-memory, JPA, Liquibase |

Dev-профиль использует:
- **Datasource:** `jdbc:h2:mem:testdb`, user: `sa`, password: `123`
- **Liquibase:** миграции через `classpath:/config/liquibase/master.xml`

## Тесты

На текущий момент **тесты отсутствуют**. Для запуска:

```bash
mvn test
```

В `pom.xml` подключён `spring-boot-starter-webmvc-test`. Рекомендуется добавить unit- и integration-тесты в `src/test/java`.

## Особенности

- Liquibase `master.xml` содержит некорректное содержимое (`asfsdfsdf`) — требует исправления для корректной работы миграций.
- Контроллер принимает `userId` как query-параметр в GET-запросе (`/history/get?userId=...`).
