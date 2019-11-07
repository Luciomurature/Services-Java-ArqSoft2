package ar.edu.ucc.arqsoft.test.dto;

import ar.edu.ucc.arqsoft.test.model.Operacion;

import java.util.Date;

public class TransaccionDto {

    private Date fecha;

    private float monto;

    private Operacion operacion;

    private TarjetaDto tarjeta;

    public TransaccionDto(){}

    public TransaccionDto(Date fecha, float monto, Operacion operacion, TarjetaDto tarjeta) {
        super();
        this.fecha = fecha;
        this.monto = monto;
        this.operacion = operacion;
        this.tarjeta = tarjeta;
    }

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

    public TarjetaDto getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDto tarjeta) {
        this.tarjeta = tarjeta;
    }
}
