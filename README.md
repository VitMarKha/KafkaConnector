# KafkaConnector

Implementing sending and receiving Kafka messages using Spring.

## Usage

1) Running a container - `docker-compose -f docker-compose-kafka.yaml up -d`
2) Go to the container - `docker exec -ti [id_container] sh`
3) Go to folder with kafka - `cd opt/kafka/bin/`
4) Create a topic inside a container - `kafka-topics.sh --zookeeper zookeeper:2181 --create --topic test_topic --partitions 3 --replication-factor 1`
5) You can send a message by going to the producer - `kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic test_topic`
6) Open the consumer (if you sent messages through the producer, they should be displayed) - `kafka-console-consumer.sh --topic test_topic --from-beginning -bootstrap-server 127.0.0.1:9092`
7) Launch Spring project
8) Follow the link and look at the new message in the consumer's terminal - `http://localhost:8080/publish?message=Hello`
