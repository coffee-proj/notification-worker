# Notification Worker

The Notification Worker is a component of the <a href="https://github.com/coffee-proj/notification">Coffee Notification System</a>. It acts as the final processing stage by consuming notification messages from Kafka, sending notifications to end users, and managing message statuses.

## Key Features

• Kafka Consumer: Reads notification messages from the notification topic.

• Notification Sender: Sends notifications based on consumed messages.

• Idempotency Handling: Uses Redis to detect and handle duplicate messages caused by Kafka's at-least-once delivery guarantee.

• Status Reporting: Publishes processing results to the status topic.

• Dead Letter Queue (DLQ): Sends messages that fail processing after retries to the dlq topic.

## Getting Started

You can run project with:

```zsh
docker compose up -d
```