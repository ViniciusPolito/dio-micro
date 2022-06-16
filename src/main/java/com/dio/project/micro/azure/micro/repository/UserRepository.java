package com.dio.project.micro.azure.micro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dio.project.micro.azure.micro.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

}
