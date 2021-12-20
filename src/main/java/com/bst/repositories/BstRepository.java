package com.bst.repositories;

import com.bst.models.Bst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "bst", path = "bst")
public interface BstRepository extends JpaRepository<Bst, Long> {

}
