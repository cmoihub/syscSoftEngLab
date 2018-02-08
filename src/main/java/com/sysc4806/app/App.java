package com.sysc4806.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner addressBookDemo(AddressBookRepo addressBookRepo, BuddyInfoRepo buddyInfoRepo){
        return (args) -> {
//            Setup buddies
//            BuddyInfo b1 = new BuddyInfo("Bauer", "111111111");
//            BuddyInfo b2 = new BuddyInfo("Chloe", "222222222");
//            BuddyInfo b3 = new BuddyInfo("Kim", "333333333");
//            BuddyInfo b4 = new BuddyInfo("Bauer", "444444444");
//            BuddyInfo b5 = new BuddyInfo("Michelle", "555555555");
//            buddyInfoRepo.save(b1);
//            buddyInfoRepo.save(b2);
//            buddyInfoRepo.save(b3);
//            buddyInfoRepo.save(b4);
//            buddyInfoRepo.save(b5);

//            Setup addressbook
            AddressBook ab = new AddressBook();
//            ab.addBuddy(b1);
//            ab.addBuddy(b2);
//            ab.addBuddy(b3);
//            ab.addBuddy(b4);
//            ab.addBuddy(b5);
            addressBookRepo.save(ab);

//            logs(addressBookRepo, buddyInfoRepo, ab);
        };
    }

    public void logs(AddressBookRepo addressBookRepo, BuddyInfoRepo buddyInfoRepo, AddressBook ab){
      /*  log.info("Checking address book");
        log.info("-------------------------------");
        for(AddressBook addressBook : addressBookRepo.findAll()){
            log.info("Addressbook has " + ab.getBuddies().size() + " buddies") ;
        }
        log.info("");

        // fetch all buddies
        log.info("Buddies found with findAll():");
        log.info("-------------------------------");
        for (BuddyInfo customer : buddyInfoRepo.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        BuddyInfo customer = buddyInfoRepo.findOne(1L);
        log.info("Buddy found with findOne(1L):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");
*/
        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        for (BuddyInfo bauer : buddyInfoRepo.findByName("Bauer")) {
            log.info(bauer.toString());
        }
        log.info("");
    }
}
