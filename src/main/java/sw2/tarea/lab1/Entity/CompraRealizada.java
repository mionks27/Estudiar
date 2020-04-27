package sw2.tarea.lab1.Entity;

import javax.persistence.*;

@Entity
@Table(name ="compras_realizadas")
public class CompraRealizada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcompra;
    @Column(nullable = false)
    private int cantidadproducto;
    @Column(nullable = false)
    private double preciototal;
    @Column(nullable = false)
    private String metododepago;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String fechadelacompra;
    @Column(nullable = false)
    private int productoidproducto;
    @Column(nullable = false)
    private String mall;


    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(int cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public String getMetododepago() {
        return metododepago;
    }

    public void setMetododepago(String metododepago) {
        this.metododepago = metododepago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechadelacompra() {
        return fechadelacompra;
    }

    public void setFechadelacompra(String fechadelacompra) {
        this.fechadelacompra = fechadelacompra;
    }

    public int getProductoidproducto() {
        return productoidproducto;
    }

    public void setProductoidproducto(int productoidproducto) {
        this.productoidproducto = productoidproducto;
    }

    public String getMall() {
        return mall;
    }

    public void setMall(String mall) {
        this.mall = mall;
    }
}
