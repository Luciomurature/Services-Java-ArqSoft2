package ar.edu.ucc.arqsoft.test.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaccion")
public class Transaccion extends ObjetoGenerico {

    @Column(name="fecha")
    private Date fecha;

    @Column(name="monto")
    private float monto;

    @Enumerated(EnumType.STRING)
    @Column(name="operacion")
    private Operacion operacion;

    @ManyToOne(fetch=FetchType.LAZY, targetEntity = Tarjeta.class)
    @JoinColumn(name="tarjeta")
    private Tarjeta tarjeta;


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
