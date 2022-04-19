package guru.springframework.services;

import guru.springframework.domain.Product;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductService {
    Product getById(Long id);
    void sendProductMessage(String id);
}
