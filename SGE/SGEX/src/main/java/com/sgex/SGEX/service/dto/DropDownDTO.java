package com.sgex.SGEX.service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DropDownDTO extends CargoDTO implements Serializable {

    private Long value;

    private String label;

}
