package andrii.romanyshyn.air_plane.repository;

import andrii.romanyshyn.air_plane.entity.Flight;
import andrii.romanyshyn.air_plane.entity.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("from Flight f join f.airCompanyId c where f.flightStatus = :flightStatus and c.name = :companyName")
    List<Flight> findAirCompanyFlightsByCompanyNameAndStatus(@Param("flightStatus") FlightStatus flightStatus,
                                                             @Param("companyName") String companyName);

    @Query("from Flight f where f.flightStatus = :flightStatus")
    List<Flight> findFlightByActiveStatusMoreThan24Hours(@Param("flightStatus") FlightStatus flightStatus);


}