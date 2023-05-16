package com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Controllers;

import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.ProductoDTO;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserDTO;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.DTO.UserEntity;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Models.Producto;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.RabbitMQ.MQConfig;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.RabbitMQ.MessageResponse;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.RabbitMQ.RpcService;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Services.SupermercadoService;
import com.ProConsumoApp.Supermercadoservice.Supermercadoservice.Services.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.catalina.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {

    @Autowired
    private SupermercadoService supermercadoService;

    @Autowired
    private UserService userService;


    @Autowired
    private RpcService rpcService;


    @GetMapping("/productos")
    @RabbitListener(queues = MQConfig.queueName, concurrency = "3")
    public void obtenerProductos(String message,
                                              @Header(AmqpHeaders.CORRELATION_ID) String correlationId,
                                              @Header(AmqpHeaders.REPLY_TO) String replyTo){

        try {
            if(message.equalsIgnoreCase("getProductos") && replyTo != null && correlationId != null){
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

                // Enviar la respuesta al remitente original utilizando el reply-to pattern
                String responseJson = new Gson().toJson(productosDTO);

                rpcService.sendResponse(replyTo, correlationId, responseJson);

            }
        }catch (Exception e){
           e.printStackTrace();
        }


    }


    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoById(@PathVariable Integer id){
        Producto producto = supermercadoService.getProductoById(id);
        UserDTO userDTO = userService.getUserID(producto.getUserEntity().getId());
        ProductoDTO productoDTO = new ProductoDTO(producto, userDTO);


        return ResponseEntity.ok(productoDTO);
    }

    @PostMapping("/producto/save")
    @RabbitListener(queues = MQConfig.queueProductos)
    public ResponseEntity<Producto> setProducto(@RequestBody ProductoDTO productoDTO){
        System.out.println(productoDTO.toString());
        UserEntity user = userService.getUserByName(productoDTO.getNombreUsuario());

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUserEntity(user);

        System.out.println(producto.toString());
        supermercadoService.addProducto(producto);

        return ResponseEntity.ok(producto);
    }

}
