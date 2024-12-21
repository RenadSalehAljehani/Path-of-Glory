![Path of glory-Class digram](https://github.com/user-attachments/assets/9b68722b-9d00-4708-a345-98810305604a)

Models:
1. Arena
2. Service
3. BookService
4. Event

Repositories: 
1. Arena
2. Service
3. BookService
4. Event

Services:
1. Arena
2. Service
3. BookService
4. Event

Controllers:
1. Arena
2. Service
3. BookService
4. Event

DTOS:
1. Arena
2. Service
3. BookService
4. Event

Extra Endpoints:
1. public void bookService(Integer serviceId, Integer athleteId, Date startDate, Date endDate) 
2. public void handleBookServiceRequest(Integer arenaId, Integer bookingId, boolean isAccepted) 
3. public List<BookServiceDTO> getAllAcceptedServiceBookings(Integer arenaId) 
4. public void handleEventHeldRequest(Integer arenaId, Integer eventHeldRequestId, boolean isAccepted)
5. public List<ServiceDTO> getServicesByPriceRange(Double minPrice, Double maxPrice)
6. public void cancelEventParticipation(Integer athlete_id,Integer eventNumber)
7. public List<EventDTO> searchUpcomingEventsForSponsor(Integer athleteId, Integer sponsorId) 
8. public List<ArenaDTO> searchArenasByAthleteCity(Integer athleteId) 
9. public List<EventDTO> getEventsByDateRange(Integer athleteId, Date startDate, Date endDate) 
10. public void requestSponsorship(Integer sponsorId, Integer athleteId, Integer eventId) 
11. public void handleSponsorshipRequest(Integer athleteId, Integer sponsorshipId, boolean isAccepted)
    
[Path of Glory.pdf](https://github.com/user-attachments/files/18193642/Path.of.Glory.pdf)
