package com.nidhi.dao;

import java.util.List;

import com.nidhi.model.Country;

public interface CountryDao{

	List<Country> findAll();

	Country getCountryById(int id);

	boolean countryExists(String countryName);

	void addCountry(Country country);

	void updatePopulation(Country country);

	void deleteCountry(int id);
}
