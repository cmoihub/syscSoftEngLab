package com.sysc4806.app;

import javax.persistence.*;
import java.util.List;

/**
 * Created by CraigBook on 2018-01-11.
 */
@Entity
public class BuddyInfo {
//    The id will serve as the buddy info's primary key
    private Long id;

    private String name;

    private String phoneNo;

    protected BuddyInfo(){
        this("Craig", "6139155344");
    }

    public BuddyInfo(String name, String phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "\nBuddyInfo{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    /**
     * Gets the id of this BuddyInfo. The persistence provider should
     * autogenerate a unique id for new objects.
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
