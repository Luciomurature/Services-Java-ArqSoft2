package ar.edu.ucc.arqsoft.test.service;

import ar.edu.ucc.arqsoft.test.dao.DaoGenerico;
import ar.edu.ucc.arqsoft.test.dao.DaoGenericoImp;
import ar.edu.ucc.arqsoft.test.dto.ResponseDto;
import ar.edu.ucc.arqsoft.test.dto.TarjetaAltaDto;
import ar.edu.ucc.arqsoft.test.dto.TarjetaDto;
import ar.edu.ucc.arqsoft.test.dto.TransaccionDto;
import ar.edu.ucc.arqsoft.test.model.Tarjeta;
import ar.edu.ucc.arqsoft.test.model.Transaccion;
import ar.edu.ucc.arqsoft.test.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TarjetaService {

    @Autowired
    DaoGenerico<Tarjeta, Long> tarjetaDao;

    @Autowired
    DaoGenerico<Usuario, Long> usuarioDao;

    @Autowired
    DaoGenerico<Transaccion, Long> transaccionDao;


    public ResponseDto nuevaTarjeta(TarjetaAltaDto tarjetaDto){

        Tarjeta tarjeta = new Tarjeta();

        tarjeta.setSaldo(tarjetaDto.getSaldo());
        tarjeta.setNumero(tarjetaDto.getNumero());

        Usuario usuario = usuarioDao.load(tarjetaDto.getUsuarioID());
        if (usuario == null){
            return new ResponseDto("-1","Usuario no encontrado","-1");
        }
        tarjeta.setUsuario(usuario);

        tarjetaDao.saveOrUpdate(tarjeta);

        tarjetaDto.setId(tarjeta.getId());

        return new ResponseDto(tarjetaDto.getId().toString(), "ALTA", tarjetaDto.getId().toString());

    }

    public List<TransaccionDto> getAllTransacciones(TarjetaAltaDto dto) {

        List<Transaccion> transacciones = transaccionDao.getAll();
        List<TransaccionDto> transaccionesDto = new ArrayList<TransaccionDto>();

        for(Transaccion t : transacciones){
            if(t.getTarjeta().getId().equals(dto.getId())){
                TransaccionDto aux = new TransaccionDto();
                aux.setFecha(t.getFecha());
                aux.setMonto(t.getMonto());
                aux.setOperacion(t.getOperacion());
                TarjetaDto taux = new TarjetaDto();
                taux.setId(t.getTarjeta().getId());
                aux.setTarjeta(taux);
                transaccionesDto.add(aux);
            }
        }

        return transaccionesDto;

    }



}
