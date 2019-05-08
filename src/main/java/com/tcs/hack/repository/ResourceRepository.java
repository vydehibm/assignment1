package com.tcs.hack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.hack.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource,Integer>{
	List<Resource> findAll();
	Resource findByResourceId(Integer Id);
	//String deleteByResourceId(int resource_id);
//	@Override
//	default void delete(Resource entity) {
//		delete(entity);
//	}

	
	}
