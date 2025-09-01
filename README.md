# 🚀 Spring Data Demo Project

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0+-6DB33F.svg)
![H2 Database](https://img.shields.io/badge/H2-Database-blue.svg)
![Lombok](https://img.shields.io/badge/Lombok-Data_Class-pink.svg)

</div>

## 📖 Описание

Проект демонстрирует работу с **Spring Data JPA** и встроенной базой данных H2. Включает в себя базовые операции с сущностью Account (счёт) через JpaRepository и нативные SQL-запросы.

## ✨ Особенности

- 🎯 Java 21
- 🍃 Spring Boot 3.0+
- 📊 H2 In-Memory Database
- 🔍 Spring Data JPA
- ⚡ Lombok для сокращения boilerplate-кода
- 🎨 Консоль H2 доступна по адресу `/h2-console`

## 🏗️ Структура проекта

```
src/
├── main/
│   ├── java/org/example/springdata/
│   │   ├── entity/Account.java      🎯 Сущность Account
│   │   ├── repository/AccountRepository.java  📦 Репозиторий
│   │   └── SpringDataApplication.java         🚀 Главный класс
│   └── resources/
│       └── application.yml          ⚙️ Конфигурация
```

## 🚀 Запуск проекта

1. Клонируйте репозиторий:
```bash
git clone <your-repo-url>
cd spring-data
```

2. Запустите приложение:
```bash
mvn spring-boot:run
```

3. Откройте консоль H2 по адресу:  
   🔗 http://localhost:8080/h2-console  
   Параметры подключения:
   ```
   JDBC URL: jdbc:h2:mem:mydb
   User: sa
   Password: password
   ```

## 📊 Примеры работы

При запуске автоматически создаются тестовые данные:
- Создаются 10 тестовых аккаунтов
- Выполняется поиск по имени
- Обновление имени аккаунта
- Поиск по имени и балансу

## ⚙️ Настройки

Основные настройки в `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:mydb
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
  h2:
    console:
      enabled: true
```

## 🛠️ Технологии

| Технология | Версия |
|------------|--------|
| Java | 21 |
| Spring Boot | 3.0+ |
| H2 Database | 2.1+ |
| Lombok | 1.18+ |
| Maven | 3.6+ |

## 📝 Примеры запросов

Репозиторий поддерживает:
- Автогенерируемые методы Spring Data
- Нативные SQL-запросы
- Кастомные update-операции

```java
accountRepository.findAccountByName("Lori1");
accountRepository.setNameFor(6L, "Baxter");
accountRepository.findAccountBy("Lori5", 5000);
```

---

## 📄 Лицензия

Этот проект создан в учебных целях.
