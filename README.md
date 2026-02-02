<p>&nbsp;</p>
<h1>📨 User mail sender microservice</h1>
<p>&nbsp;</p>

Microservice-based system responsible for user management and email notification delivery. It handles user registration and authentication while asynchronously sending emails through a message queue,

## 💡 Features

- User Management: User registration with a random password generation.

- Email notifications: Asynchronous email sending using SMTP and RabbitMq.

- Database Integration: Built using Spring Data JPA for persistence.

## 🔨 Tools

- ☕ Java

- 🌿 Spring Boot

- 🐘 PostgreSQL

- 🐳 Docker

- 📬 RabbitMQ

## ⚙️ Setup

### Prerequisites
Ensure the following are installed:

- Java 21+ (recommendation based on Spring Boot trends)

- PostgreSQL

- Maven

### Installation Steps

1. **Clone the repository:**

```bash
git clone git@github.com:Jaoovit/user-mail-sender-ms.git

cd budget-api
```

2. **Prepare environment variables:**

- Rename the _env file to .env


- Define the following variables in the .env file:

  - DB_EMAIL_URL
  - DB_EMAIL_USERNAME
  - DB_EMAIL_PASSWORD
  - DB_USER_URL
  - DB_USER_USERNAME
  - DB_USER_PASSWORD
  - SPRING_RABBITMQ_ADDRESSES
  - SPRING_RABBITMQ_USERNAME
  - SPRING_RABBITMQ_PASSWORD
  - SPRING_RABBITMQ_VIRTUAL_HOST
  - SPRING_MAIL_HOST
  - SPRING_MAIL_PORT
  - SPRING_MAIL_USERNAME
  - SPRING_MAIL_PASSWORD
  - SPRING_MAIL_PROPERTIES_MAIL_SMTP_AUTH
  - SPRING_MAIL_PROPERTIES_MAIL_SMTP_STARTTLS_ENABLE

3. **Run the project:**

```bash
docker compose build up -d --build
```