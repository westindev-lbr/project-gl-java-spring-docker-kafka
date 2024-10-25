package com.fil.sra.bdd.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fil.sra.bdd.data.PriceUpdatedArticle;
import com.fil.sra.ports.IArticleUseCases;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {

    private IArticleUseCases articleUseCases;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "price_update_topic", groupId = "product-group")
    public void consume(String message) {
        try {
            System.out.println("Message received: " + message);
            
            PriceUpdatedArticle priceUpdatedArticle = objectMapper.readValue(message, PriceUpdatedArticle.class);
            log.info("Price updated for article with [ EAN: " + priceUpdatedArticle.ean() + ", actualPrice : " + priceUpdatedArticle.actualPrice() + ", originalPrice : " + priceUpdatedArticle.originalPrice() + " ]");
            // articleUseCases.updatePrice(priceUpdatedArticle.ean(), priceUpdatedArticle.actualPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
