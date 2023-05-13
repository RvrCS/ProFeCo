package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Controllers;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.ProductoDTO;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserDTO;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserEntity;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.Producto;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Services.SupermercadoService;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {

    @Autowired
    private SupermercadoService supermercadoService;

    @Autowired
    private UserService userService;


    @GetMapping("/productos")
    public ResponseEntity<List<ProductoDTO>> obtenerProductos(){

        List<Producto> productos = supermercadoService.getAllProductos();
        List<UserDTO> users = userService.getUsers();
        Map<Integer, UserDTO> usersMap = new HashMap<>();

        for (UserDTO user : users) {
            usersMap.put(user.getIdUser(), user);
        }

        List<ProductoDTO> productosDTO = new ArrayList<>();
        for (Producto producto: productos) {
            productosDTO.add(new ProductoDTO(producto, usersMap.get(producto.getUserEntity().getId())));
        }




        return ResponseEntity.ok(productosDTO);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoById(@PathVariable Integer id){
        Producto producto = supermercadoService.getProductoById(id);
        UserDTO userDTO = userService.getUserID(producto.getUserEntity().getId());
        ProductoDTO productoDTO = new ProductoDTO(producto, userDTO);


        return ResponseEntity.ok(productoDTO);
    }

}
