package com.sysc4806.app;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by CraigBook on 2018-02-01.
 */
@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressBookRepo extends CrudRepository<AddressBook, Long> {
//    void addBuddy();
//    void removeBuddy(@Param("name")String name, @Param("phoneNo") String phoneNo);
}