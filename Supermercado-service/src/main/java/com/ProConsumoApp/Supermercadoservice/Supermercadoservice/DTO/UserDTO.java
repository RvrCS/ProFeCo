package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Integer idUser;
    private String nombreEmpresa;

    public UserDTO(UserEntity user){
        this.idUser = user.getId();
        this.nombreEmpresa = user.getNombre();

    }

}