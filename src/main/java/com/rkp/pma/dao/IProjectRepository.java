package com.rkp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rkp.pma.entities.Project;


//@Repository
public interface IProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	List<Project> findAll();

}
