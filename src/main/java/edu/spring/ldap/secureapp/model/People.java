package edu.spring.ldap.secureapp.model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;


@Entry(base = "ou=people", 
		  objectClasses = { "organizationalPerson","inetOrgPerson","person", "top" })
public class People {
	
	@Id
    private Name id;
    
    private @Attribute(name = "cn") String name;
	private @Attribute(name = "uid") String uid;
    private @Attribute(name = "userPassword") String password;
    
    public People() {
    }
    
    public People(String name, String password, String uid) {
        this.name = name;
        this.password = password;
        this.uid = uid;
    }

    public Name getId() {
		return id;
	}

	public void setId(Name id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
