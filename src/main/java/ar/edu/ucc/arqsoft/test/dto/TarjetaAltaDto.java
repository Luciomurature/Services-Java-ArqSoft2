package ar.edu.ucc.arqsoft.test.dto;

public class TarjetaAltaDto {

    private String numero;

    private Long id;

    private float saldo;

    private UsuarioDto usuario;

    public TarjetaAltaDto(){}

    public TarjetaAltaDto(String numero, float saldo, UsuarioDto usuario) {
        super();
        this.numero = numero;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "TarjetaAltaDto{" +
                "numero='" + numero + '\'' +
                ", id=" + id +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                '}';
    }

    public Long getUsuarioID(){
        return this.usuario.getId();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
