package com.albo.controlop.service;

import java.util.List;
import java.util.Optional;

public interface IService<T, V> {

//	Collection<T> findAll();
	List<T> findAll();

	Optional<T> findById(V id);

	T saveOrUpdate(T t);

	Boolean deleteById(V id);
}
