package br.com.gustavo.consumer.rabbitmq.consumers;

import dtos.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static constants.RabbitMQConstants.QUEUE_PRODUCT_LOG;

@Component
public class ProductConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ProductConsumer.class);

    @RabbitListener(queues = {QUEUE_PRODUCT_LOG})
    public void consumerLog(ProductDTO productDTO){
        logger.info("Consumer has received a message {}", productDTO);
    }
}
