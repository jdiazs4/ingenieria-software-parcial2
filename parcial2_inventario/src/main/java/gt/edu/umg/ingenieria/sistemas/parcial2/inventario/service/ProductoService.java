package gt.edu.umg.ingenieria.sistemas.parcial2.inventario.service;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.ProductoEntity;
import gt.edu.umg.ingenieria.sistemas.parcial2.inventario.dao.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    public List<ProductoEntity> buscarTodos() {
       return (List<ProductoEntity>) this.productoRepository.findAll();
       
    }
    
    public ProductoEntity registrarProducto(ProductoEntity producto){
        String nombre = producto.getName();
        nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        producto.setName(nombre);
        return this.productoRepository.save(producto);
    }
    
    public String actualizarStockIncrementar(long id, int cantidad){
        ProductoEntity p = this.productoRepository.findById(id).get();
        p.setStock(p.getStock() + cantidad);
        this.productoRepository.save(p);
        
        return "Stock actualizado ["+p.getName()+" "+p.getStock()+"]";
    }
    
    public String actualizarStockDecrementar(long id, int cantidad){
        ProductoEntity p = this.productoRepository.findById(id).get();
        p.setStock(p.getStock() - cantidad);
        this.productoRepository.save(p);
        
        return "Stock actualizado ["+p.getName()+" "+p.getStock()+"]";
    }
}
