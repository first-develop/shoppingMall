package com.xzy.controller;

import com.xzy.services.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EvaluateController {
    @Autowired
    private EvaluateService em;

    @RequestMapping("/allevaluate")
    public void findPage(int gid) {


    }


}
