package com.cosmetica.controllers;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.dto.RoleDTO;
import com.cosmetica.entities.Role;
import com.cosmetica.entities.User;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IRoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class RoleController {

	@Autowired
	IRoleService roleservice;
	
	@GetMapping("/role/all")							//get all roles 
	 public List<Role > allRoles() {
		return roleservice.getAll();
		 
	 }
	 
	 @GetMapping("/role/{roleId}")					//get role by id, id_role is given in parameters
	 public Optional <Role> oneRole(@PathVariable("roleId")int roleId){
		 
		 if(!roleservice.getOneById(roleId).isPresent())
	         throw new CosmeticaException(roleId );
		 return roleservice.getOneById(roleId);
		 
	 }

	 @PostMapping("/superadmin/add/role")						//add a role, new role is given in parameters
	 public void addRole(@RequestBody RoleDTO source) {
		 Role target = new Role();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 roleservice.saveOrUpdate(target);
		 
		 
	 }
	 @PutMapping("/superadmin/role/modify")						//modify a role, new role is given in parameters
	 public void modifyRole(@RequestBody RoleDTO source) {
		 Role target = new Role();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 roleservice.saveOrUpdate(target);
		 
	 }
	 @DeleteMapping("/superadmin/role/remove/{roleId}")		//delete a role, new role is given in parameters
	 public void removeRole(@PathVariable("role_id")int roleId) {
		 if(!roleservice.getOneById(roleId).isPresent())
	         throw new CosmeticaException(roleId );
		 Role role = roleservice.getOneById(roleId).orElseThrow(() -> new CosmeticaException(roleId));
		 roleservice.delete(role); 
		 
	 }
	 
	 @GetMapping("/superadmin/role/{roleId}")					// all users that have a certain role, role_id is given in parameters
	 public List<User> allClientsWithRole(@PathVariable("role_id")int roleId) {
		 if(!roleservice.getOneById(roleId).isPresent())throw new CosmeticaException(roleId);
		 Role role = roleservice.getOneById(roleId).orElseThrow(() -> new CosmeticaException(roleId));
		return roleservice.getUsersWithRole(role);
		 
	 }

	
}
