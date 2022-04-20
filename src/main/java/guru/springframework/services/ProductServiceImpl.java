package guru.springframework.services;

import com.github.icovn.queue.service.QueueService;
import guru.springframework.SpringBootRabbitMQApplication;
import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private QueueService queueService;


    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    @Override
    public void sendProductMessage(String id) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("id", id);
        log.info("Sending the index request through queue message");
        queueService.push(actionmap, SpringBootRabbitMQApplication.SFG_MESSAGE_QUEUE);
    }
}
