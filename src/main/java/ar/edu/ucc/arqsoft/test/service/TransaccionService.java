package ar.edu.ucc.arqsoft.test.service;

import ar.edu.ucc.arqsoft.test.dao.DaoGenerico;
import ar.edu.ucc.arqsoft.test.dto.RequestDto;
import ar.edu.ucc.arqsoft.test.dto.ResponseDto;
import ar.edu.ucc.arqsoft.test.model.Operacion;
import ar.edu.ucc.arqsoft.test.model.Tarjeta;
import ar.edu.ucc.arqsoft.test.model.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

@Service
@Transactional
public class TransaccionService {

    @Autowired
    DaoGenerico<Tarjeta, Long> tarjetaDao;

    @Autowired
    DaoGenerico<Transaccion, Long> transaccionDao;


    public ResponseDto debitar(RequestDto reqDto){

        Tarjeta tarjeta = tarjetaDao.load(reqDto.getIDtarjeta());

       if(tarjeta.getSaldo() < reqDto.getMonto()){
           return new ResponseDto(reqDto.getTarjeta().getId().toString(),"RECHAZADA",reqDto.getTarjeta().getId().toString() );
       }

       Transaccion transaccion = new Transaccion();
       Date fecha = Calendar.getInstance().getTime();
       transaccion.setFecha(fecha);
       transaccion.setMonto(reqDto.getMonto());
       transaccion.setOperacion(Operacion.DEBITO);
       transaccion.setTarjeta(tarjeta);

       transaccionDao.saveOrUpdate(transaccion);

       tarjeta.setSaldo((tarjeta.getSaldo()-reqDto.getMonto()));

       tarjetaDao.saveOrUpdate(tarjeta);

       return new ResponseDto(reqDto.getTarjeta().getId().toString(),"APROBADA", reqDto.getTarjeta().getId().toString());

    }


    public ResponseDto creditar(RequestDto reqDto){

        Tarjeta tarjeta = tarjetaDao.load(reqDto.getTarjeta().getId());

        if(tarjeta == null){
            return new ResponseDto("-1", "Tarjeta no autorizada", "-1");
        }

        Transaccion transaccion = new Transaccion();

        transaccion.setTarjeta(tarjeta);
        transaccion.setOperacion(Operacion.CREDITO);
        transaccion.setMonto(reqDto.getMonto());
        Date fecha = Calendar.getInstance().getTime();
        transaccion.setFecha(fecha);

        transaccionDao.saveOrUpdate(transaccion);

        tarjeta.setSaldo(tarjeta.getSaldo()+reqDto.getMonto());

        tarjetaDao.saveOrUpdate(tarjeta);

        return new ResponseDto(reqDto.getTarjeta().getId().toString(), "APROBADA" , reqDto.getTarjeta().getId().toString());


    }
}
