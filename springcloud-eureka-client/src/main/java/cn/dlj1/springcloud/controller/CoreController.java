package cn.dlj1.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class CoreController {

    @RequestMapping("")
    @ResponseBody
    public String index() {
        return "this is index!";
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "666";
    }

}
