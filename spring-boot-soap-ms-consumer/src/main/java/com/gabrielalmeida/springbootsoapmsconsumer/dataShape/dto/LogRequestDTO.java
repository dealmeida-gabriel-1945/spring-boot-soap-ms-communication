package com.gabrielalmeida.springbootsoapmsconsumer.dataShape.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogRequestDTO {
    private String yearOfConstruction;
    private String plateNumber;
    private boolean personSex;
}
