# Weekly Menu Planner

Десктопное приложение (Swing) для планирования меню на неделю. Требования к интерфейсу — в [Documentation/doc.md](Documentation/doc.md).

## Стек

- Java 17
- Spring Boot 3.5 (DI, JPA)
- H2 (локальная БД для пользователей)
- Swing (UI)

## Запуск

```bash
./mvnw spring-boot:run
```

Или из IDE: `WeeklyMenuPlannerApplication.main`. Профиль `desktop` включается автоматически и поднимает главное окно.

## Сборка и тесты

```bash
./mvnw verify
```

Интеграционные тесты используют профиль `test` (без Swing UI, in-memory H2).

## Конфигурация

Основные параметры — `src/main/resources/application.properties`:

- `window.width`, `window.height` — размер окна
- `ui.calendar.weight`, `ui.dishes.weight` — пропорции календаря и списка блюд
- `ui.dish.columns`, `ui.dish.rows` — сетка плиток блюд
- `ui.debug-borders` — цветные рамки для отладки вёрстки

## Структура пакетов

| Пакет | Назначение |
|-------|------------|
| `ui` | Окно, layout, плитки, строки интерфейса |
| `logic` | Модель недели и demo-данные (`WeekMenuService`) |
| `service` / `repository` | JPA-слой пользователей |
| `data` | JPA-сущности |
