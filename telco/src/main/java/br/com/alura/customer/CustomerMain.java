package br.com.alura.customer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CustomerMain {

    /*
     *  Método para chamar o Producer
     *  Valores: NOME_COMPLETO, EMAIL (key), TELEFONE, NOME DA RUA, CIDADE
     */
    public static void main(String[] args) {
        var producer = new KafkaProducer<String, String>(properties());
        var key = "jef@email.com";
        var value = "Jeferson Silva,jef@email.com,(41) 99123-0123,Rua Toczek,Curitiba";
        var record = new ProducerRecord<>("NEW_CUSTOMER", key, value);
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
