package org.yizus.microservices.business;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.yizus.microservices.modelo.FacturaCommand;

import java.util.Objects;

/**
 * Created by Administrator on 20/05/2017.
 */
@Service
public class FacturaServiceImpl implements FacturaService {

    public static final String ERROR_MONTO="El monto total difiere del subtotal +IGV";

    @Override
    public FacturaCommand guardarFactura(FacturaCommand factura) {

        String message = "La factura es requerida";

        //clase no nulla
        Objects.requireNonNull(factura, message);
        Assert.notNull(factura, message);
     //   Assert.notNull(factura.getMontoTotal(),"El monto es requerido"); -- Lo reemplaza bean validation

        if (!factura.getMontoTotal()
                .equals(factura.getIgv()
                        .add(factura.getSubTotal()))) {
            throw new RuntimeException(ERROR_MONTO);
        }
        factura.setId(1L);
        return factura;
    }
}
