package com.rkp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.rkp.pma.entities.Project;


//@Repository
public interface IProjectRepository extends CrudRepository<Project, Long>{

}
