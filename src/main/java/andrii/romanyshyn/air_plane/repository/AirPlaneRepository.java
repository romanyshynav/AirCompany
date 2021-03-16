package andrii.romanyshyn.air_plane.repository;

import andrii.romanyshyn.air_plane.entity.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirPlaneRepository extends JpaRepository<AirPlane, Integer> {
}
