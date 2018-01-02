package com.nidhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nidhi.model.Country;
import com.nidhi.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;

    @GetMapping
    public List<Country> listCountries(){
    	List<Country> list = countryService.getAllCountries();
    	return list;
    }
    
    @GetMapping(path = "/{id}")
    public Country getCountryById(@PathVariable("id") int id){
    	Country country = countryService.getCountryById(id);
    	return country;
    }
    
    @PostMapping
    public void addCountry(@RequestBody Country country){
    	countryService.addCountry(country);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateCountry(@RequestBody Country country){
    	countryService.updatePopulation(country);
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteCountry(@PathVariable("id") int id){
    	countryService.deleteCountry(id);
    }
    
			
}
