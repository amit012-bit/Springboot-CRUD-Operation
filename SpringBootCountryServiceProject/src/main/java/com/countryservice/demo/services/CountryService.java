package com.countryservice.demo.services;

import java.util.HashMap;

public class CountryService {
	static HashMap<Integer, Country> countryIdMap;

	public CountryService() {
		countryIdMap = new HashMap<Integer, Country>();
		Country indiaCountry = new Country(1, "India", "Delhi");
		Country usaCountry = new Country(2, "USA", "Washington");
		Country ukCountry = new Country(3, "UK", "London");
		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);
	}

	public List getAllCountries() {
		List countries = new ArrayList(countryIdMap.values());
		return countries;
	}

public Country getCountryby

	ID (int id)
{
Country country=countryIdMap.get(id); return country;
}

	public Country getCountrybyName(String countryName) {
		Country country = null;
		for (int i : countryIdMap.keySet()) {
			if (countryIdMap.get(i).getCountryName().equals(countryName))
				country = countryIdMap.get(i);
		}
		return country;
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);
		return country;
	}

// Utility method to get max id
public static int getMaxId()
{
int max=0;
for (int id:countryIdMap.keySet())
if(max<=id) {
	max=id;
}
return max+1;

}

public Country updateCountry(Country country) {
	if (country.getId() > 0)
		countryIdMap.put(country.getId(), country);
	return country;
}

public deleteCountry(int id)
{
countryIdMap.remove(id);
AddResponse res=new AddResponse();
res.setMsg("Country deleted...");
res.setId(id);
return res;
}