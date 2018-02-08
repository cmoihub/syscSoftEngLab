package com.sysc4806.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by CraigBook on 2018-01-31.
 */
@RepositoryRestResource(collectionResourceRel = "buddies", path = "buddies")
public interface BuddyInfoRepo extends CrudRepository<BuddyInfo, Long>{
    List<BuddyInfo> findByName(@Param("name") String name);
    List<BuddyInfo> findByPhoneNo(@Param("phoneNo") String phoneNo);

}
