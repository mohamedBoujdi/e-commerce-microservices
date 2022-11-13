package org.sid.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RefreshScope // This annotation is used to refresh the configuration
public class CustomerConfigTestController {
    @Value("${customer.name}")  // injecter la valeur de la propriété customer.name
 private String name;
    @Value("${customer.port}")  // injecter la valeur de la propriété customer.port
 private String port;
    @Value("${global.params.p1}")
 private String p1;
    @Value("${global.params.p2}")
 private String p2;

    //we map the url /config to this method
    @GetMapping("/config")
    public Map<String,String> getConfig() {
      LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("customer.name",name);
        map.put("customer.port",port);
        map.put("global.params.p1",p1);
        map.put("global.params.p2",p2);
        return map;
    }

}
