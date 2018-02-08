package com.sysc4806.app;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CraigBook on 2018-02-01.
 */
public class TestController {
    private final AddressBookService service;

    public TestController(AddressBookService service){
        this.service = service;
    }

    @RequestMapping("/title")
    public @ResponseBody String title(){
        return service.title();
    }
}
