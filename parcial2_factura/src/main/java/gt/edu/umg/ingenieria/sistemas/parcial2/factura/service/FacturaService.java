package gt.edu.umg.ingenieria.sistemas.parcial2.factura.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.DetalleFacturaEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.CabeceraFacturaRepository;
import gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao.DetalleFacturaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private CabeceraFacturaRepository cabeceraFacturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    
    public List<CabeceraFacturaEntity> buscarTodasCabecerasFactura() {
        return (List<CabeceraFacturaEntity>) this.cabeceraFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura() {
        return (List<DetalleFacturaEntity>) this.detalleFacturaRepository.findAll();
    }
    
    public List<DetalleFacturaEntity> buscarTodosDetallesFactura(Long idCabeceraFactura) {
        return this.detalleFacturaRepository.findByHeader(idCabeceraFactura);
    }
    
    public CabeceraFacturaEntity crearFactura(CabeceraFacturaEntity factura){
        String nombre = factura.getClientName();
        nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        
        factura.setClientName(nombre);
        
        return this.cabeceraFacturaRepository.save(factura);
    }
    
    public DetalleFacturaEntity crearDetalleFactura(DetalleFacturaEntity detalle){
        return this.detalleFacturaRepository.save(detalle);
    }
    
    public List<CabeceraFacturaEntity> buscarPorNit(String nit,String orden){
        if(orden.toUpperCase()=="ASC"){
            return this.cabeceraFacturaRepository.findAllCabeceraASC(nit);
        }else{
            return this.cabeceraFacturaRepository.findAllCabeceraDESC(nit);
        }
    }
}
