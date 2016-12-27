package com.Techolution;

/**
 * Created by shrikant on 28/12/2016.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping("/")
    public String index() {
        return "This is Hell's Kitchen !";
    }
}
