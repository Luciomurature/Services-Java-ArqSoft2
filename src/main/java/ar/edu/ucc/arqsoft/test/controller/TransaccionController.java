package ar.edu.ucc.arqsoft.test.controller;


import ar.edu.ucc.arqsoft.test.dto.RequestDto;
import ar.edu.ucc.arqsoft.test.dto.ResponseDto;
import ar.edu.ucc.arqsoft.test.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;


    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value="/debitar", method = RequestMethod.POST, produces ="application/json" )
    public ResponseEntity<?> debitar(@RequestBody RequestDto requestDto){
        ResponseDto res = transaccionService.debitar(requestDto);

        return new ResponseEntity<Object>(res, HttpStatus.OK);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value="/creditar", method = RequestMethod.POST, produces ="application/json" )
    public ResponseEntity<?> creditar(@RequestBody RequestDto requestDto){


        ResponseDto res = transaccionService.creditar(requestDto);

        return new ResponseEntity<Object>(res, HttpStatus.OK);
    }

}
