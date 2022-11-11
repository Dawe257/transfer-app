# Сервис перевода денег

## Описание проекта

Сервис предоставляет интерфейс для перевода денег с одной карты на другую и является backend-частью приложения.
Frontend-часть доступна по адресу https://github.com/serp-ya/card-transfer

## Установка и запуск

1. Склонировать репозиторий `git clone https://github.com/Dawe257/transfer-app.git`
2. Перейти в каталог приложения `cd transfer-app`
3. Запустить сборку `./gradlew clean build`
4. Запустить сборку docker-образа `docker build --tag transfer-app:1.0 .`
5. Запустить приложение `docker-compose up`

Инструкцию по запуску frontend-части можно найти в соответствующем репозитории.

Контроллер /transfer получает запрос вида:

```json
{
  "cardFromNumber": "6356573576657656",
  "cardToNumber": "3215324532452346",
  "cardFromCVV": "123",
  "cardFromValidTill": "12/23",
  "amount": {
    "currency": "RUR",
    "value": 112300
  }
}
```

и возвращает operationId:

```json
{
  "operationId": 4
}
```

Контроллер /confirm принимает operationId полученный из запроса /transfer и подтверждает транзакцию