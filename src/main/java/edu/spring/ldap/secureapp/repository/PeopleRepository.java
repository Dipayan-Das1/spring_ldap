package edu.spring.ldap.secureapp.repository;

import java.util.List;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import edu.spring.ldap.secureapp.model.People;

@Repository
public interface PeopleRepository extends LdapRepository<People>{
	People findByName(String name);
	People findByUid(String uid);
	People findByNameAndPassword(String name, String password);
    List<People> findByNameLikeIgnoreCase(String name);
}
