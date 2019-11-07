package ar.edu.ucc.arqsoft.test.dto;

public class TarjetaDto {
    private Long id;

    public TarjetaDto(){

    }

    public TarjetaDto(Long id){
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}