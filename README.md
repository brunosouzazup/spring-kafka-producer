# Spring Boot with Kafka Producer

This Project covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic
## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic CUSTOMER_DATA`

## Consume from the Kafka Topic via Console
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic CUSTOMER_DATA --from-beginning`

## Publish message via WebService - GET
- `http://localhost:8081/kafka/publish/Bruno`
- `http://localhost:8081/kafka/publish/Gabriel`

## Publish message via WebService - POST
- `http://localhost:8081/kafka/publish/`
```json 
{
	"name":"Bruno Souza",
	"phone":"199999-9999",
	"email":"customer@zup.com.br",
	"address":"Av.Paulista São Paulo - SP"
}
```

