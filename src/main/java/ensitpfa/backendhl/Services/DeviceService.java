package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.User;
import ensitpfa.backendhl.Repositories.DeviceRepository;
import ensitpfa.backendhl.Repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Date;
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

    public Device addDevice(Device device) {
        return repository.save(device);
    }

    public void updateDevice(String id, Device newDevice) {
        newDevice.setId(id);
        repository.save(newDevice);
    }

    public void deleteDevice(String id) {
        repository.deleteById(id);
    }


    public void connect(String mac, User user){
        Device device=repository.findDeviceById(mac);

        if((device!=null)
                &&(!device.isConnected())){

                    device.setConnected(true);
                    device.setConnectedUser(user);
                    updateDevice(mac,device);
                }

        }

    public void disconnect(String mac, User user){
        Device device=repository.findDeviceById(mac);
        if((device!=null)
                &&device.isConnected()){

            if (user.equals(device.getConnectedUser())){
                device.setConnected(false);
                device.setConnectedUser(null);
                updateDevice(mac,device);
            }

        }

    }

    public void setMeasurementIntervalle(String mac, User user,Period interval ) {
        Device device=repository.findDeviceById(mac);
        if((device!=null)
                &&device.isConnected()){

            if (user.equals(device.getConnectedUser())){
                device.setMeasureIntervalle(interval);
                updateDevice(mac,device);
            }

        }

    }
}
