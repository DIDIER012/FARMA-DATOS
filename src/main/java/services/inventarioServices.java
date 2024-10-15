package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.inventarioModel;
import repositories.inventarioRepositori;

@Service
public class inventarioServices {


    @Autowired
    private inventarioRepositori inventarioRepositori;

    public List<inventarioModel> getAllNombres() {
        return inventarioRepositori.findAll();
    }



    public void creandoInventario(inventarioModel inventario) {
        this.inventarioRepositori.save(inventario);
    }


    public boolean borrarInventario(inventarioModel invetario) {
        if(this.inventarioRepositori.existsById(invetario.getId())) {
            this.inventarioRepositori.delete(invetario);
            return true;
        } else {
            System.err.println("El cliente que quieres eliminar no existe!");
            return false;
        }
    }


    public void actualizarInventario(inventarioModel inventario) { 
        if (this.inventarioRepositori.existsById(inventario.getId())) {  
            this.inventarioRepositori.save(inventario);  
        } else {  
            System.err.println("El inventario que quieres actualizar no existe!");  
        }  
    }  
    
    public boolean existePorId(Long id) {  
        return this.inventarioRepositori.existsById(id);  
    }
}
