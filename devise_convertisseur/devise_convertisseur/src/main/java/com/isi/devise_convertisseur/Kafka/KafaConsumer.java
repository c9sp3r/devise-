//package com.isi.devise_convertisseur.Kafka;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafaConsumer {
//
//    @KafkaListener(topics = "topicName")
//    public void listenWithHeaders(
//            @Payload String message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        System.out.println(
//                "Received Message: " + message"
//                        + "from partition: " + partition);
//    }
//
//
//}
