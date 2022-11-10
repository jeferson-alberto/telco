package br.com.alura.producer.customer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CustomerProducerMain {

    public static void main(String[] args) {
        var producer = new KafkaProducer<String, String>(properties());
        var key = "test1@aluno.com";
        var value = "Jeferson Silva, test1@aluno.com, 41984420408, Rua Londrina, Curitiba";
        var record = new ProducerRecord<>("NEW_CUSTOMER", value, value);
        producer.send(record);
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}
