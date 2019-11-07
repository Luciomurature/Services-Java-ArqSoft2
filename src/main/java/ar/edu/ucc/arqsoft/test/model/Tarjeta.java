package ar.edu.ucc.arqsoft.test.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tarjeta")
public class Tarjeta extends ObjetoGenerico {

    @Column(name = "numero")
    private String numero;

    @Column(name="saldo")
    private float saldo;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
    @JoinColumn(name="usuario", nullable=true)
    private Usuario usuario;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "tarjeta")
    private Set<Transaccion> transacciones;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Set<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}
