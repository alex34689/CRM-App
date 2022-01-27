package com.crm.institute.service;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyService<T, ID> extends Repository<T, ID> {

	List<T> findAll();

	Long count();

}
