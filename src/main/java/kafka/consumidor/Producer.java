package kafka.consumidor;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Scanner;

public class Producer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try(KafkaProducer<String, String > producer = new KafkaProducer<>(props)){
            Scanner sc = new Scanner(System.in);

            //System.out.println("Digite pedidos (para sair digite 'sair')");

            while (true){
                //String pedido = sc.nextLine();
               // if(pedido.equalsIgnoreCase("sair")) break;


                for (int i = 0; i < 1000; i++) {
                    ProducerRecord<String, String> record = new ProducerRecord<>("pedidos", String.valueOf(i));
                    producer.send(record);
                    System.out.println("Pedido enviado: "+ i);
                }
            }
        }
    }
}
