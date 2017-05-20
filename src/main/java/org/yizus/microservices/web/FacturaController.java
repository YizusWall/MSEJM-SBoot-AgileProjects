package org.yizus.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yizus.microservices.business.FacturaService;
import org.yizus.microservices.modelo.FacturaCommand;

import javax.validation.Valid;

/**
 * Created by Administrator on 20/05/2017.
 */
@RestController
@RequestMapping("/v1/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService){
        this.facturaService=facturaService;
    }
    @PostMapping
    public FacturaCommand crearFactura(@Valid FacturaCommand factura, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("Error de validacion");
        }

        return facturaService.guardarFactura(factura);
    }




}
