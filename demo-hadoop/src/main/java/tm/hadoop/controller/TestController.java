package tm.hadoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tm.hadoop.config.HadoopTemplate;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private HadoopTemplate hadoopTemplate;

    @GetMapping(value = "test")
    public Object test1(){
        System.out.println(hadoopTemplate);
        return "ok";
    }

}
