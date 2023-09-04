# Тестовое задание на должность Java Developer 

Дынный сервис имеет возможности:

- генерирует временный JWT токен на корректные логин/пароль
- сохраняет сообщения в базу данных при обращении с валидным токеном и именем пользователя
- позволяет получить "n" последних сообщений из базы данных при запросе с валижным токеном и именем пользователя

### Запуск:
git clone https://github.com/Viktor2308/JWT-TASK.git
mvn clean install
docker compose -f docker-compose.yml up
Сервис запускается на порту: 8088

---------------------------------------------------
### Авторизация:
***POST*** localhost:8088/login
**curl:**
curl -X POST http://localhost:8088/login -H "Content-Type: application/json" -d "{\"name\": \"user@test.ru\", \"password\": \"password\"}"

Запрос:
<pre>json
{
    "name" :"user@test.ru",
    "password" :"password"
}
</pre>
Ответ:
<pre>json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQHRlc3QucnUiLCJpYXQiOjE2OTM3NjI2ODEsImV4cCI6MTY5Mzc2NjI4MX0.uOr4mLAXsPVd4NwMWz4vjWNFDM3AJ0EHMQa6_-bmIR0"
}
</pre>

### Сохранить сообщение в базу данных:
***POST*** localhost:8088/api/message
**curl:**
curl -H "Content-Type: application/json" -H "Authorization: Bearer_${указать активный токен}" -X POST http://localhost:8088/api/message -d "{\"username\":\"user@test.ru\",\"message\":\"тестовое сообщение\"}"

Запрос:
<pre>json
{
    "name" :"user@test.ru",
    "message" :"тестовое сообщение"
}
</pre>
Ответ:
<pre>json
{
    "messages": [
        "тестовое сообщение"
    ]
}
</pre>

### Получить n последних сообщений из базы двнных:
***POST*** localhost:8088/api/message
**curl:**
curl -H "Content-Type: application/json" -H "Authorization: Bearer_${указать активный токен}" -X POST http://localhost:8088/api/message -d "{\"username\":\"user@test.ru\",\"message\":\"history 5\"}"

Запрос:
<pre>json
{
    "name" :"user@test.ru",
    "message" :"history 5"
}
</pre>
Ответ:
<pre>json
{
    "messages": [
        "тестовое сообщение",
        "message 12",
        "message 11",
        "message 10",
        "message 9"
    ]
}
</pre>

## Стэк технологий:
- Java 17
- Spring Boot 3.1.3
- Spring WEB
- Spring JPA
- Postgresql
- Liquibase
- Jakarta validation
- jjwt 
- Bcrypt
- Lombok
- Junit tests
