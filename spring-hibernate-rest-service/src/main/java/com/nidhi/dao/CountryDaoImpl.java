package com.nidhi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nidhi.model.Country;

@Transactional
@Repository
public class CountryDaoImpl implements CountryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Country> findAll() {
		List<Country> resultList = (List<Country>) entityManager.createQuery("from Country").getResultList();
		return resultList;
	}

	@Override
	public Country getCountryById(int id) {
		Country c = entityManager.find(Country.class, id);
		return c;
	}

	@Override
	public boolean countryExists(String countryName) {
		String query = "select countryName from Country c where c.countryName = ?";
		int result = entityManager.createQuery(query).setParameter(1, countryName).getResultList().size();
		if(result > 0){
			return true;
		}
		return false;
	}

	@Override
	public void addCountry(Country country) {
		entityManager.persist(country);
	}

	@Override
	public void updatePopulation(Country country) {
		int id = entityManager.find(Country.class, country.getId()).getId();
		System.out.println("-----------" + country.getCountryName());
		Country c = entityManager.find(Country.class, id);
		c.setPopulation(country.getPopulation());
		entityManager.flush();
	}

	@Override
	public void deleteCountry(int id) {
		entityManager.remove(getCountryById(id));
	}
	
}
