package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.Patient;
import ensitpfa.backendhl.Repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired

    private MeasurementService measurementService;



    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(String id) {
        return deviceRepository.findById(id);
    }

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public void updateDevice(String id, Device newDevice) {
        newDevice.setId(id);
        deviceRepository.save(newDevice);
    }

    public void deleteDevice(String id) {
        deviceRepository.deleteById(id);
    }


    public void connect(String mac, Patient user){
        Device device=deviceRepository.findDeviceById(mac);

        if((device!=null)
                &&(!device.isConnected())){

                    device.setConnected(true);
                    device.setConnectedUser(user);
                    device.setMeasurementList(measurementService.getMeasurementsByConnectedUserId(user.getId()));
                    updateDevice(mac,device);
                }

        }

    public void disconnect(String mac, Patient user){
        Device device=deviceRepository.findDeviceById(mac);
        if((device!=null)
                &&device.isConnected()){

            if (user.equals(device.getConnectedUser())){
                device.setConnected(false);
                device.setConnectedUser(null);
                device.setMeasurementList(null);
                updateDevice(mac,device);
            }

        }

    }

    public void setMeasurementIntervalle(String mac, Patient user, Period interval ) {
        Device device=deviceRepository.findDeviceById(mac);
        if((device!=null)
                &&device.isConnected()){

            if (user.equals(device.getConnectedUser())){
                device.setMeasureIntervalle(interval);
                updateDevice(mac,device);
            }

        }

    }
}
