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
    	locationRepository.addLocation(location);
    	System.out.println("La nouvelle location est: " + location);
    }

    public Location getLocation(Integer id) {
        return locationRepository.getLocation(id);
    }

    public void updateLocation(Location location) {
        location=locationRepository.updateLocation(location);
        System.out.println("la location mise à jour est: " + location);
    }

    public void deleteLocation(Integer id) {
    	locationRepository.deleteLocation(id);
        System.out.println("la location a été supprimé");
    }

    public List<Location> getAllLocations() {
        return locationRepository.getAllLocations();
    }


}
