package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.proveedoresModel;
import repositories.proveedoresRepositori;

@Service

public class proveedoresServices {


    @Autowired
    private proveedoresRepositori proveedoresRepositori;

    public List<proveedoresModel> getAllProvedores() {
        return proveedoresRepositori.findAll();
    }

    public boolean existeId(Long id){
        return this.proveedoresRepositori.existsById(id);
    }

    public void crearProveedor(proveedoresModel proveedor){
        proveedoresRepositori.save(proveedor);
    }

    public boolean eliminarProveedor(proveedoresModel eliminarProveedor) {
        if(this.proveedoresRepositori.existsById(eliminarProveedor.getId())) {
            this.proveedoresRepositori.delete(eliminarProveedor);
            return true;
        } else {
            System.err.println("El proveedor que quieres eliminar no existe");
            return false;
        }
    }
}
