package ar.edu.ucc.arqsoft.test.controller;


import ar.edu.ucc.arqsoft.test.dto.ResponseDto;
import ar.edu.ucc.arqsoft.test.dto.TarjetaAltaDto;
import ar.edu.ucc.arqsoft.test.dto.TransaccionDto;
import ar.edu.ucc.arqsoft.test.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TarjetaController {

    @Autowired
    TarjetaService tarjetaService;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/tarjeta", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> grabarTarjeta(@RequestBody TarjetaAltaDto dto){
        System.out.println(dto.toString());
        ResponseDto res = tarjetaService.nuevaTarjeta(dto);

        return new ResponseEntity<Object>(res, HttpStatus.CREATED);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/transacciones", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> verTransacciones(@RequestBody TarjetaAltaDto dto){
        List<TransaccionDto> transaccionesDto = tarjetaService.getAllTransacciones(dto);

        return new ResponseEntity<Object>(transaccionesDto, HttpStatus.CREATED);
    }
}
