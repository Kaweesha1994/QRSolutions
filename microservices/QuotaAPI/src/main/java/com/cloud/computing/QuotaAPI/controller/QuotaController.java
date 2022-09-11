package com.cloud.computing.QuotaAPI.controller;

import com.cloud.computing.QuotaAPI.dto.QuotaDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class QuotaController {

    @RequestMapping("/update-quota/{vehicleNumber}")
    public void getVehicle(@RequestBody QuotaDto quotaDto, @PathVariable int vehicleNumber) {

        System.out.println("update quota : " + vehicleNumber + " : " + quotaDto.getVehicleNumber());

    }

}
