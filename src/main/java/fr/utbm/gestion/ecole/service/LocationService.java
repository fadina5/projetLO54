package fr.utbm.gestion.ecole.service;

import java.util.List;

import fr.utbm.gestion.ecole.entity.Location;

public interface LocationService {
	
	public void addLocation(Location location);

	public Location getLocation(Integer id);

	public void updateLocation(Location location);

	public void deleteLocation(Integer id);

	public List<Location> getAllLocations();

}
