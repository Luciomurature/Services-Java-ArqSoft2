package ar.edu.ucc.arqsoft.test.dto;


import ar.edu.ucc.arqsoft.test.model.Tarjeta;

public class RequestDto {
    private TarjetaDto tarjeta;
    private float monto;



    public RequestDto(TarjetaDto tarjeta, float monto) {
        super();
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public RequestDto(){

    }
    public Long getIDtarjeta(){
        return this.tarjeta.getId();
    }

    public TarjetaDto getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDto tarjeta) {
        this.tarjeta = tarjeta;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}