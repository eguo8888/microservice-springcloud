package microservice.eureka.microserviceorder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @RequestMapping("/order")
    public String order(){
        return "订单服务";
    }

}
