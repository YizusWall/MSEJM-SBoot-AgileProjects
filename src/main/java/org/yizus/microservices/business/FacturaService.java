package org.yizus.microservices.business;

import org.yizus.microservices.modelo.FacturaCommand;

/**
 * Created by Administrator on 20/05/2017.
 */
public interface FacturaService {

    FacturaCommand guardarFactura(FacturaCommand factura);
}
