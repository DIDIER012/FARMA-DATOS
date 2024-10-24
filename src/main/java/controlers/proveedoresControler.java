package controlers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.proveedoresModel;
import services.proveedoresServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/proveedores")


public class proveedoresControler {

@Autowired
private proveedoresServices proveedoresServices;

@GetMapping("/all")
public List<proveedoresModel> getAllNombre() {
    return this.proveedoresServices.getAllProvedores();
}


@GetMapping("/{id}")
public ResponseEntity<Boolean> existeProducto(@PathVariable Long id) {
    boolean existeId = proveedoresServices.existeId(id);

    if(existeId) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    } else {
        System.err.println("!El usuario que buscas no existe!");
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}



@PostMapping("/crear")
public ResponseEntity<?> agregarProveedor(@RequestBody proveedoresModel proveedores) {
    this.proveedoresServices.crearProveedor(proveedores);
    return ResponseEntity.ok(proveedores);
}


@DeleteMapping("/borrar{id}")
public ResponseEntity<String> borrarProveedor(@PathVariable long id){
    proveedoresModel proveedores = new proveedoresModel();
    proveedores.setId(id);
    
    boolean eliminar = proveedoresServices.eliminarProveedor(proveedores);

    if(eliminar){ 
        return ResponseEntity.ok("Proveedor eliminado correctamente");
    } else {
        return ResponseEntity.ok("El proveedor que quieres eliminar no existe");
    }
}

}
