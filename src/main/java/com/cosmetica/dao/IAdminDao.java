package com.cosmetica.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Admin;


@Repository
public interface IAdminDao  extends JpaRepository<Admin , Integer>{
	
	Optional<Admin> findByUsernameOrEmail(String username, String email);
	List<Admin> findByEmailOrUsernameContaining(String email, String username);
	List<Admin> findByLastnameContaining(String lastname);
	List<Admin> findByFirstnameContaining(String firstname);
	List<Admin> findByUsernameContaining(String username);
	Optional<Admin> findByEmail(String email);
	
}
