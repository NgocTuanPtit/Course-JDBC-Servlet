package com.tony_funny.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.tony_funny.dao.ICategoryDAO;
import com.tony_funny.model.CategoryModel;
import com.tony_funny.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
