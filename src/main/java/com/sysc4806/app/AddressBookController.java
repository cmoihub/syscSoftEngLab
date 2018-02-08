package com.sysc4806.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by CraigBook on 2018-02-01.
 */
@Controller
public class AddressBookController {
//    @RequestMapping("/addresses")
//    public AddressBook addressBook(){
//        return new AddressBook();
//    }
    @Autowired
    BuddyInfoRepo buddyInfoRepo;

    private final AddressBookService service;

    public AddressBookController(AddressBookService service){
        this.service = service;
    }


    @RequestMapping("/message")
    public @ResponseBody String message(){
        return "Address Book";
    }

    @RequestMapping("/title")
    public @ResponseBody String message_(){
        return service.title();
    }

    @RequestMapping("/newBuddy")
    public BuddyInfo newBuddy(@RequestParam("name") String name, @RequestParam("phoneNo") String phoneNo, Model model){
        BuddyInfo bi = new BuddyInfo(name, phoneNo);
        buddyInfoRepo.save(bi);
        model.addAttribute("newBuddy", bi.toString());
        return bi;
    }

    @RequestMapping("/defaultBuddy")
    public BuddyInfo newBuddy(Model model){
        BuddyInfo bi = new BuddyInfo("craig", "6139155344");
        buddyInfoRepo.save(bi);
        model.addAttribute("newBuddy", bi.toString());
        return bi;
    }
}
