package com.cloud.computing.VehicleAPI.controller;

import com.cloud.computing.VehicleAPI.dto.QuotaDto;
import com.cloud.computing.VehicleAPI.dto.VehicleDto;
import com.cloud.computing.VehicleAPI.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from vehicle api Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping(value = "/getVehicle", method = RequestMethod.POST)
    public void getVehicle(@RequestBody VehicleDto vehicleDto) {

        vehicleService.generateQR(vehicleDto);

    }

    @RequestMapping("/update-quota")
    public void updateQuota(@RequestBody VehicleDto vehicleDto) {

        QuotaDto quotaDto = new QuotaDto();

        quotaDto.setVehicleNumber(vehicleDto.getVehicleNumber());

        restTemplate.postForEntity("http://QuotaAPI/update-quota/1", quotaDto, void.class);

    }

    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }

}
