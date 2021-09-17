package lab.bigdaditor.mondrian_compositionb.controller;

import lab.bigdaditor.mondrian_compositionb.handler.MqttHandler;
import lab.bigdaditor.mondrian_compositionb.service.SparkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    SparkService sparkService;

    @RequestMapping(value = "/")
    public String home() {
       /* MqttHandler handler = new MqttHandler();
        handler.init("southgyu","dcdacapo77", "tcp://192.168.29.184:1883").subscribe("topic/v1");*/
        sparkService.getCount();
        return "index";
    }
}
