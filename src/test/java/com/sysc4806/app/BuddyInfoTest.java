package com.sysc4806.app;

import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by CraigBook on 2018-01-11.
 */
public class BuddyInfoTest extends TestCase {
    BuddyInfo cmoi;
    public void setUp() throws Exception {
         cmoi = new BuddyInfo("Craig", "6139155344");
    }

    public void testGetName() throws Exception {
        assertEquals(cmoi.getName(), "Craig");
    }

    public void testSetName() throws Exception {
        cmoi.setName("Jake");
        assertEquals(cmoi.getName(), "Jake");
    }

    public void testGetPhoneNo() throws Exception {
        assertEquals(cmoi.getPhoneNo(), "6139155344");
    }

    public void testSetPhoneNo() throws Exception {
        cmoi.setPhoneNo("0");
        assertEquals(cmoi.getPhoneNo(), "0");
    }
}