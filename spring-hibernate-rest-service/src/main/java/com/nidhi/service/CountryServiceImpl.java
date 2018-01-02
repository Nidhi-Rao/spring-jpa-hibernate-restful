package com.nidhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nidhi.dao.CountryDao;
import com.nidhi.model.Country;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	@Transactional
	public List<Country> getAllCountries() {
		return countryDao.findAll();
	}

	@Override
	@Transactional
	public Country getCountryById(int id) {
		return countryDao.getCountryById(id);
	}

	@Override
	@Transactional
	public boolean addCountry(Country country) {
		boolean exists = true;
		if(countryDao.countryExists(country.getCountryName())){
			exists = false;
		}else{
			countryDao.addCountry(country);
			exists = true;
		}
		return exists;
	}

	@Override
	@Transactional
	public void updatePopulation(Country country) {
		boolean exists = false;
		if(countryDao.countryExists(country.getCountryName())){
			countryDao.updatePopulation(country);
		}
	}

	@Override
	@Transactional
	public void deleteCountry(int id) {
		countryDao.deleteCountry(id);
	}
}
