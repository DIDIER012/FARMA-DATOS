package models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "Inventario")
public class inventarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "fecha_Vencimiento")
    private String fecha_vencimiento;

    @Column(name= "tipo_Medicamento")
    private String tipo_medicamento;

    @Column(name= "cantidad")
    private long cantidad;


    
    // Relación con proveedoresModel (Muchos productos pueden pertenecer a un solo proveedor)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id", nullable = false) // Nombre de la columna FK (foreign key)
    private proveedoresModel proveedor;  // El proveedor asociado a este producto del inventario



    public inventarioModel() {}  


    public Long getId() {  
        return id;  
    }  

    public void setId(Long id) {  
        this.id = id;  
    }  

    public String getNombre() {  
        return nombre;  
    }  

    public void setNombre(String nombre) {  
        this.nombre = nombre;  
    }  

    public String getFechaVencimiento() {  
        return fecha_vencimiento;  
    }  

    public void setFechaVencimiento(String fecha_vencimiento) {  
        this.fecha_vencimiento = fecha_vencimiento;  
    }  

    public String getTipoMedicamento() {  
        return tipo_medicamento;  
    }  

    public void setTipoMedicamento(String tipo_medicamento) {  
        this.tipo_medicamento = tipo_medicamento;  
    }  

    public long getCantidad() {  
        return cantidad;  
    }  

    public void setCantidad(long cantidad) {  
        this.cantidad = cantidad;  
    }  
}
