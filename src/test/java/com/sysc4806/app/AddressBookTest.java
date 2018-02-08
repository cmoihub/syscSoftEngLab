package com.sysc4806.app;

import junit.framework.TestCase;

import javax.persistence.*;
import java.util.List;

/**
 * Created by CraigBook on 2018-01-11.
 */
public class AddressBookTest extends TestCase {
    AddressBook ab;
//    EntityManagerFactory emf;
//    EntityManager em;
//    EntityTransaction tx;
//    BuddyInfo bi1;
//    BuddyInfo bi2;
    public void setUp() throws Exception {
        ab = new AddressBook();
//
//        bi1 = new BuddyInfo();
//        bi1.setName("Jay");
//
//        bi2 = new BuddyInfo();
//        bi2.setName("J");
//
//        emf = Persistence.createEntityManagerFactory("java-web");
//        em = emf.createEntityManager();
//        tx = em.getTransaction();
    }

    public void tearDown() throws Exception {
    }

    public void testGetBuddies() throws Exception {
        assertEquals(ab.getBuddies().size(), 0);
    }

    public void testAddBuddy() throws Exception {
        BuddyInfo bi = new BuddyInfo("Craig", "000");
        ab.addBuddy(bi);
        assertEquals(ab.getBuddies().size(), 1);
    }


    /*public void testPerformJPAAddressBook(){
//        // Connecting to the database through EntityManagerFactory
//        // connection details loaded from persistence.xml
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-web");
//
//        EntityManager em = emf.createEntityManager();
//
//        // Creating a new transaction
//        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the BuddyInfo objects
        em.persist(bi1);
        em.persist(bi2);

        ab.addBuddy(bi1);
        ab.addBuddy(bi2);

        em.persist(ab);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        AddressBook test = results.get(0);
        assertEquals(2, test.getBuddies().size());

        // Closing connection
        em.close();

        emf.close();
    }*/

}