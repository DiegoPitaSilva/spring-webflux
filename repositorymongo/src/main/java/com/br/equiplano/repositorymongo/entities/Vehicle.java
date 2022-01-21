package com.br.equiplano.repositorymongo.entities;

import com.br.equiplano.entity.VehicleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Vehicle {
    private  String boardVehicle;



    public VehicleEntity toEntity(){
        var vehicle = new VehicleEntity();
        vehicle.setBoardVehicle(this.boardVehicle);
        return vehicle;

    }

}
