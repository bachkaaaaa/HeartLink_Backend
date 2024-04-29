package ensitpfa.backendhl.Controllers;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.Patient;
import ensitpfa.backendhl.Services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }



    @PostMapping("/{mac}/connect")
    public void connect(@PathVariable String mac, @RequestBody Patient user) {
        deviceService.connect(mac, user);
    }

    @PostMapping("/{mac}/disconnect")
    public void disconnect(@PathVariable String mac) {
        deviceService.disconnect(mac);
    }

    @PostMapping("/{mac}/measurementInterval")
    public void setMeasurementInterval(@PathVariable String mac, @RequestBody Patient user, @RequestBody Period interval) {
        deviceService.setMeasurementIntervalle(mac, user, interval);
    }
}
