package tm.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tm.elasticsearch.dao.DemoRepository;

/**
 * @auther: zhangyi
 * @date: 2019/5/27
 * @Description: Es demo控制层
 */
@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;



}
