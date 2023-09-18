package br.com.gustavo.producer.services;

import dtos.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static constants.RabbitMQConstants.EXG_NAME_MARKETPLACE;
import static constants.RabbitMQConstants.RK_PRODUCT_LOG;

@Service
public record ProductService(RabbitTemplate rabbitTemplate) {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    public void createProduct(ProductDTO productDTO) {
        logger.info("Received message {}", productDTO);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, productDTO);
    }
}
