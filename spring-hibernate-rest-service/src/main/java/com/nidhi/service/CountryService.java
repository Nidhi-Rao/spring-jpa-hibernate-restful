package com.nidhi.service;

import java.util.List;

import com.nidhi.model.Country;

public interface CountryService {

	List<Country> getAllCountries();

	Country getCountryById(int id);

	boolean addCountry(Country country);

	void updatePopulation(Country country);

	void deleteCountry(int id);
}
