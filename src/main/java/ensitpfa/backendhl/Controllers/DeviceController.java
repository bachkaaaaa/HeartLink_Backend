package ensitpfa.backendhl.Controllers;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.User;
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

    @GetMapping("/{id}")
    public Optional<Device> getDeviceById(@PathVariable String id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PutMapping("/{id}")
    public void updateDevice(@PathVariable String id, @RequestBody Device newDevice) {
        deviceService.updateDevice(id, newDevice);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable String id) {
        deviceService.deleteDevice(id);
    }

    @PostMapping("/{mac}/connect")
    public void connect(@PathVariable String mac, @RequestBody User user) {
        deviceService.connect(mac, user);
    }

    @PostMapping("/{mac}/disconnect")
    public void disconnect(@PathVariable String mac, @RequestBody User user) {
        deviceService.disconnect(mac, user);
    }

    @PostMapping("/{mac}/measurementInterval")
    public void setMeasurementInterval(@PathVariable String mac, @RequestBody User user, @RequestBody Period interval) {
        deviceService.setMeasurementIntervalle(mac, user, interval);
    }
}
