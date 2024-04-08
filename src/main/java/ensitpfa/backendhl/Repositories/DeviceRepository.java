package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {
    Device findDeviceById(String id);
}
