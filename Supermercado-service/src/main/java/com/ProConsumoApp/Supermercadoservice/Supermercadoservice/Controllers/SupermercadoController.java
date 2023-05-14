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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/producto/save")
    public ResponseEntity<Producto> setProducto(@RequestBody ProductoDTO productoDTO){
        UserEntity user = userService.getUserByName(productoDTO.getNombreUsuario());

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUserEntity(user);

        supermercadoService.addProducto(producto);

        return ResponseEntity.ok(producto);
    }

}
