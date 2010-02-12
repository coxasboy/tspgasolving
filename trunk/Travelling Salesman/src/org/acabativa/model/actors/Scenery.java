package org.acabativa.model.actors;

import java.util.HashSet;
import java.util.Set;

public class Scenery {

	Set<City> citys = new HashSet<City>();

	public Set<City> getCitys() {
		return citys;
	}

	public void setCitys(Set<City> citys) {
		this.citys = citys;
	}
	
	public void addCity(City city){
		this.citys.add(city);
	}
	
}
