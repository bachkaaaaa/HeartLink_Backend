package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.Patient;
import ensitpfa.backendhl.Repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.*;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired

    private MeasurementService measurementService;



    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }


    public void updateDevice(String id, Device newDevice) {
        newDevice.setId(id);
        deviceRepository.save(newDevice);
    }



    public void connect(String mac, Patient user){
        Device device=deviceRepository.findDeviceById(mac);

        if((device!=null)
                &&(!device.isConnected())){

                    device.setConnected(true);
                    device.getConnectedUser().put(user,System.currentTimeMillis());
                    device.setMeasurementList(measurementService.findAllByDeviceId(mac));
                    updateDevice(mac,device);
                    user.setConnectedDevice(new ArrayList<>((Collection) device));
                }

        }

    public void disconnect(String mac){
        Device device=deviceRepository.findDeviceById(mac);
        if((device!=null)
                &&device.isConnected()){


                device.setConnected(false);
                device.setMeasurementList(null);
                updateDevice(mac,device);


        }

    }

    public void setMeasurementIntervalle(String mac, Patient user, Period interval ) {
        Device device=deviceRepository.findDeviceById(mac);
        if((device!=null)
                &&device.isConnected()){


                device.setMeasureIntervalle(interval);
                updateDevice(mac,device);


        }

    }
}
