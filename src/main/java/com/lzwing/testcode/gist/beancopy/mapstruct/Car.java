package com.lzwing.testcode.gist.beancopy.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
 
    private String make;
    private int numberOfSeats;
    private CarType type;
}