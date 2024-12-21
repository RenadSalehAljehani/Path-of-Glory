package com.example.PathOfGlory.Service;
import com.example.PathOfGlory.ApiResponse.ApiException;
import com.example.PathOfGlory.DTO.ServiceDTO;
import com.example.PathOfGlory.Model.Arena;
import com.example.PathOfGlory.Model.Service;
import com.example.PathOfGlory.Repository.ArenaRepository;
import com.example.PathOfGlory.Repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService { //Renad
    // 1. Declare a dependency for using Dependency Injection
    private final ServiceRepository serviceRepository;

    private final ArenaRepository arenaRepository;

    // 2. CRUD
    // 2.1 GET
    public List<ServiceDTO> getAllServices() {
        List<Service> services = serviceRepository.findAll();
        List<ServiceDTO> serviceDTOS = new ArrayList<>();
        for (Service service : services) {
            ServiceDTO serviceDTO = new ServiceDTO(service.getName(), service.getDescription(), service.getPricePerDay());
            serviceDTOS.add(serviceDTO);
        }
        return serviceDTOS;
    }

    // 2.2 POST
    public void addService(Service service) {
        serviceRepository.save(service);
    }

    // 2.3 UPDATE
    public void updateService(Integer id, Service service) {
        Service oldService = serviceRepository.findServiceById(id);
        if (oldService == null) {
            throw new ApiException("Service Not Found.");
        }
        oldService.setName(service.getName());
        oldService.setDescription(service.getDescription());
        oldService.setPricePerDay(service.getPricePerDay());
        serviceRepository.save(oldService);
    }

    // Assign a service to an arena
    public void assignServiceToArena(Integer serviceId, Integer arenaId) {
        Service service = serviceRepository.findServiceById(serviceId);
        Arena arena = arenaRepository.findArenaById(arenaId);

        if (service == null && arena == null) {
            throw new ApiException("Cant Assign. Service and Arena Not Found.");
        }
        if (service == null) {
            throw new ApiException("Cant Assign. Service Not Found.");
        }
        if (arena == null) {
            throw new ApiException("Cant Assign. Arena Not Found");
        }

        // Validate that the Arena is activated
        if (!"activated".equalsIgnoreCase(arena.getIsActivated())) {
            throw new ApiException("Cannot assign. Arena is not activated.");
        }

        service.setArena(arena);
        serviceRepository.save(service);
    }

    // Extra endpoint:
    // Get services by price
    public List<ServiceDTO> getServicesByPriceRange(Double minPrice, Double maxPrice){
        List<Service> servicesByPriceRange = serviceRepository.getServicesByPriceRange(minPrice,maxPrice);

        if (servicesByPriceRange.isEmpty()){
            throw new ApiException("There Are No Services Within This Price Range.");
        }

        List<ServiceDTO> serviceDTOS = new ArrayList<>();
        for (Service service : servicesByPriceRange) {
            ServiceDTO serviceDTO = new ServiceDTO(service.getName(), service.getDescription(), service.getPricePerDay());
            serviceDTOS.add(serviceDTO);
        }
        return serviceDTOS;
    }
}