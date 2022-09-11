package com.cloud.computing.VehicleAPI.service.impl;

import com.cloud.computing.VehicleAPI.dto.VehicleDto;
import com.cloud.computing.VehicleAPI.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    public void generateQR(VehicleDto vehicleDto) {
        System.out.println("generate vehicle QR");
    }

}
