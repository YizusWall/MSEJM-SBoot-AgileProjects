package org.yizus.microservices.modelo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 20/05/2017.
 */
@Getter
@Setter
public class FacturaCommand {

    private Long id;
    @NonNull
    @Past
    private Date fecha;
    @NotEmpty
    @Size(min = 11, max = 11)
    private String ruc;
    @NotBlank
    private String razonSocial;
    @Min(0)
    private BigDecimal montoTotal;
    @Min(0)
    private BigDecimal subTotal;
    @Min(0)
    private BigDecimal igv;
    @NotEmpty
    private String concepto;

}
