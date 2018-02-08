package com.sysc4806.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CraigBook on 2018-01-11.
 */
@Entity
public class AddressBook {
    private Long id;

    @OneToMany
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    private List <BuddyInfo> buddies;

    public AddressBook(List<BuddyInfo> buddies){
        this.buddies = buddies;
    }

    protected AddressBook(){
        this(new ArrayList<BuddyInfo>());
    }

    public void addBuddy(BuddyInfo bi){

        buddies.add(bi);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "buddies=" + buddies +
                '}' + '\n';
    }

    /**
     * Gets the id of this AddressBook. The persistence provider should
     * autogenerate a unique id for new objects
     * @return the id
     */
    @Id
    @GeneratedValue
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
