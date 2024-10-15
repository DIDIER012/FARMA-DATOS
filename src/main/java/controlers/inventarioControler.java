package controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.inventarioModel;
import services.inventarioServices;

@RestController
@RequestMapping("/inventario")

public class inventarioControler {
    @Autowired
    private inventarioServices inventarioServices;


    @GetMapping
    public List<inventarioModel> getAllInventarioModels() {
        return this.inventarioServices.getAllNombres();
    }


    @PostMapping("/crear")
    public ResponseEntity<?> agregarInventario(@RequestBody inventarioModel invetario){
        this.inventarioServices.creandoInventario(invetario);
        return ResponseEntity.ok(invetario);
    }


    @DeleteMapping("/borrar/{id}")  
    public ResponseEntity<String> borrarInventario(@PathVariable Long id) {  
        
        inventarioModel inventario = new inventarioModel();  
        inventario.setId(id);  
        
        
        boolean  eliminado = inventarioServices.borrarInventario(inventario);  
        
        if (eliminado) {  
            return ResponseEntity.ok("Inventario eliminado con éxito.");  
        } else {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El inventario que quieres eliminar no existe.");  
        }  
    }  



    @PutMapping("/actualizar/{id}")  
public ResponseEntity<String> actualizarInventario(@PathVariable Long id, @RequestBody inventarioModel inventarioActualizado) {   
    if (!inventarioServices.existePorId(id)) {  
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El inventario que quieres actualizar no existe.");  
    }  
    inventarioActualizado.setId(id);  

    inventarioServices.actualizarInventario(inventarioActualizado);  

    return ResponseEntity.ok("Inventario actualizado con éxito.");  
}
}
