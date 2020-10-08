package com.rkp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rkp.pma.dto.IChartDto;
import com.rkp.pma.entities.Project;


//@Repository
public interface IProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	List<Project> findAll();

	@Query(nativeQuery=true, value="SELECT stage AS label,COUNT(*) AS value FROM project GROUP BY stage;") 
	public List<IChartDto> projectDataForPieChart();	

}
