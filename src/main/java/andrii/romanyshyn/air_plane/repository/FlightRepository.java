package andrii.romanyshyn.air_plane.repository;

import andrii.romanyshyn.air_plane.entity.Flight;
import andrii.romanyshyn.air_plane.entity.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // Не працює з FlyWay
//    @Query("from Flight f join f.airCompanyId c where f.flightStatus = :flightStatus and c.name = :companyName")
//    List<Flight> findAirCompanyFlightsByCompanyNameAndStatus(@Param("flightStatus") FlightStatus flightStatus,
//                                                             @Param("companyName") String companyName);

    @Query(value = "SELECT * from flight f join air_company c where f.flight_status = :statusString and c.name=:companyName and c.id=f.air_company_id;", nativeQuery = true)
    List<Flight> findAirCompanyFlightsByCompanyNameAndStatus(@Param("statusString") String statusString, @Param("companyName") String companyName);


    @Query("from Flight f where f.flightStatus = :flightStatus")
    List<Flight> findFlightByActiveStatusMoreThan24Hours(@Param("flightStatus") FlightStatus flightStatus);

}
