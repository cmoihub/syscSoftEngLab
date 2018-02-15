package com.sysc4806.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by CraigBook on 2018-02-01.
 */
@Controller
public class AddressBookController {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    BuddyInfoRepo buddyInfoRepo;


    @RequestMapping("/")
    public @ResponseBody String message(){
        return "Address Book";
    }


    @RequestMapping("/newBuddy")
    public @ResponseBody String newBuddy(@RequestParam("name") String name, @RequestParam("phoneNo") String phoneNo, Model model){
//        http://localhost:8080/newBuddy?name=craig&phoneNo=123
        BuddyInfo bi = new BuddyInfo(name, phoneNo);
        buddyInfoRepo.save(bi);
        model.addAttribute("newBuddy", bi.toString());
        return bi.toString();
    }

    @RequestMapping("/defaultBuddy")
    public @ResponseBody String newBuddy(Model model){
        BuddyInfo bi = new BuddyInfo("craig", "6139155344");
        buddyInfoRepo.save(bi);
        model.addAttribute("newBuddy", bi.toString());
        return bi.toString();
    }

    @GetMapping("/addBuddy")
    public String addBuddy(Model model){
        BuddyInfo bi = new BuddyInfo();
        model.addAttribute("addBuddy", bi);
        buddyInfoRepo.save(bi);

        return "addBuddy";
    }

    @PostMapping("/addressBookPage")
    public String allBuddies(@ModelAttribute BuddyInfo bi){
        log.info(bi.toString());
        return "addressBookPage";
    }
}
