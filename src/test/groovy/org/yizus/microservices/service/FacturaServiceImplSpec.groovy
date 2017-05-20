package org.yizus.microservices.service

import org.yizus.microservices.business.FacturaServiceImpl
import org.yizus.microservices.modelo.FacturaCommand
import spock.lang.Specification

/**
 * Created by Administrator on 20/05/2017.
 */
class FacturaServiceImplSpec extends Specification {


    def 'Deberia guardar una factura'(){

        given:

        FacturaCommand command = new FacturaCommand(
                fecha: new Date(),
                ruc: '12345678901',
                razonSocial: 'Algo',
                montoTotal: 30,
                subTotal: 20,
                igv: 10,
                concepto: 'un producto');    FacturaServiceImpl service = new FacturaServiceImpl();


        def factura = service.guardarFactura(command);
        expect:
            factura

    }

    def 'Deberia fallar al enviar una factura en NULL'(){

        when:

            FacturaServiceImpl service = new FacturaServiceImpl();
            def factura = service.guardarFactura(null);
        then:

            NullPointerException error=thrown()
            error
            error.message =='La factura es requerida'
           // error.message==FacturaServiceImpl.ERROR_MONTO
    }

    def 'Deberia fallar al intentar guardar una factura con los montos incorrectos'(){

        when:
        FacturaServiceImpl service = new FacturaServiceImpl();
        FacturaCommand command = new FacturaCommand(
                fecha: new Date(),
                ruc: '12345678901',
                razonSocial: 'Algo',
                montoTotal: 30,
                subTotal: 20,
                igv: 10,
                concepto: 'un producto');
        def factura = service.guardarFactura(null);
        then:

        RuntimeException error=thrown()
        error
        error.message =='La factura es requerida Run'
        // error.message==FacturaServiceImpl.ERROR_MONTO
    }
}
