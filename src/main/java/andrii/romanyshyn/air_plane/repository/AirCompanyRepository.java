package andrii.romanyshyn.air_plane.repository;

import andrii.romanyshyn.air_plane.entity.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Integer> {
}
