package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.RabbitMQ;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.ProductoDTO;

import java.io.Serializable;
import java.util.List;

public class MessageResponse implements Serializable {

    private List<ProductoDTO> productosDTO;

    public MessageResponse() {
        // Constructor vacío necesario para la deserialización del mensaje
    }

    public MessageResponse(List<ProductoDTO> productosDTO) {
        this.productosDTO = productosDTO;
    }

    public List<ProductoDTO> getProductosDTO() {
        return productosDTO;
    }

    public void setProductosDTO(List<ProductoDTO> productosDTO) {
        this.productosDTO = productosDTO;
    }

}
