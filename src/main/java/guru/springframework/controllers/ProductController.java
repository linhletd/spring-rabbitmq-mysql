package guru.springframework.controllers;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jt on 1/10/17.
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/test")
    public void sendMessage(@RequestParam String id){
        log.info("id: {}", id);
        productService.sendProductMessage(id);
    }


}
