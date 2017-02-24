package com.victornieto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.victornieto.model.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "api/v1/user")
public interface UserRepository extends MongoRepository<User, String>{

	User findByNombre(String nombre);
	List<User> findByApellido(String apellido);

}
