package guru.springframework.listener;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;

/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class ProductMessageListener {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger log = LogManager.getLogger(ProductMessageListener.class);


    /**
     * This method is invoked whenever any new message is put in the queue.
     * See {@link guru.springframework.SpringBootRabbitMQApplication} for more details
     * @param message
     */
    @RabbitListener
    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
        var product = new Product();
        product.setDescription("xxxx");
        productRepository.save(product);
        log.info("Message processed...");
    }
}
