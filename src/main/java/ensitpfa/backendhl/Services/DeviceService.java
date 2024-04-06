package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    public List<Device> getAllDevices() {
        return repository.findAll();
    }

    public Optional<Device> getDeviceById(String id) {
        return repository.findById(id);
    }

    public Device createDevice(Device device) {
        return repository.save(device);
    }

    public void updateDevice(String id, Device newDevice) {
        newDevice.setId(id); // Ensure the new device has the same ID as the existing one
        repository.save(newDevice);
    }

    public void deleteDevice(String id) {
        repository.deleteById(id);
    }
}
