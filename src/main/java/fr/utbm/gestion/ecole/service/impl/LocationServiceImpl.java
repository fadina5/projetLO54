package fr.utbm.gestion.ecole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.gestion.ecole.entity.Location;
import fr.utbm.gestion.ecole.repository.LocationRepository;
import fr.utbm.gestion.ecole.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    public LocationRepository locationRepository;

    public void addLocation(Location location) {
    	locationRepository.saveLocation(location);
    	System.out.println("La nouvelle location est: " + location.toString());
    }

    public Location getLocation(Integer id) {
    	Location location= locationRepository.findLocation(id);
    	System.out.println("la location correspondant à "+id+"est:" + location.toString());
        return location ;
    }

    public void updateLocation(Location location) {
        location=locationRepository.updateLocation(location);
        System.out.println("la location mise à jour est: " + location.toString());
    }

    public void deleteLocation(Integer id) {
    	locationRepository.deleteLocation(id);
        System.out.println("la location avec pour"+id+ "a été supprimé");
    }

    public List<Location> getAllLocations() {
    	List<Location> locations= locationRepository.findAllLocations(); 
    	System.out.println("la liste des locations : " + locations.toString());
        return locations ;
    }


}
