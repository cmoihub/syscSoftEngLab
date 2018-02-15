package com.sysc4806.app;

import com.sun.xml.internal.ws.assembler.jaxws.AddressingTubeFactory;
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
//
//    @Autowired
//    AddressBookRepo addressBookRepo;

    private AddressBook addressBook;
    protected AddressBookController(){
        addressBook = new AddressBook();
//        addressBookRepo.save(addressBook);
    }

    @RequestMapping("/")
    public @ResponseBody String message(){
        return "Address Book";
    }


    @RequestMapping("/newBuddy")
    public @ResponseBody String newBuddy(@RequestParam("name") String name, @RequestParam("phoneNo") String phoneNo, Model model){
//        http://localhost:8080/newBuddy?name=craig&phoneNo=123
        BuddyInfo bi = new BuddyInfo(name, phoneNo);
        buddyInfoRepo.save(bi);
        addressBook.addBuddy(bi);
        model.addAttribute("newBuddy", bi.toString());
        return bi.toString();
    }

    @RequestMapping("/defaultBuddy")
    public @ResponseBody String newBuddy(Model model){
        BuddyInfo bi = new BuddyInfo("craig", "6139155344");
        buddyInfoRepo.save(bi);
        addressBook.addBuddy(bi);
        model.addAttribute("newBuddy", bi.toString());
        return bi.toString();
    }

    @GetMapping("/addBuddy")
    public String addBuddy(Model model){
        BuddyInfo bi = new BuddyInfo();
        model.addAttribute("addBuddy", bi);
        return "addBuddy";
    }

    @PostMapping("/addBuddyResults")
    public String allBuddies(@ModelAttribute (name = "buddy") BuddyInfo bi){
        buddyInfoRepo.save(bi);
        addressBook.addBuddy(bi);
        return "addBuddyResults";
    }

    @RequestMapping("/addressBook")
    public String addressBook(Model model){
        int i = 0;
        for (BuddyInfo buddyInfo : addressBook.getBuddies()){
            i++;
            model.addAttribute("buddy" + i, buddyInfo);
        }
        return "addressBook";
    }
}
