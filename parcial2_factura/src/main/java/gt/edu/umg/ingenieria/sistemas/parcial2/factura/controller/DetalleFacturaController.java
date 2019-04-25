package gt.edu.umg.ingenieria.sistemas.parcial2.factura.controller;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleFactura")
public class DetalleFacturaController {
    @Autowired
    private FacturaService facturaService;
    
    @PostMapping("/crearDetalleFactura")
    public DetalleFacturaEntity crearDetalleFactura(@RequestBody(required = true) DetalleFacturaEntity detalle){
        return this.facturaService.crearDetalleFactura(detalle);
    }
}
