package gt.edu.umg.ingenieria.sistemas.parcial2.factura.dao;

import gt.edu.umg.ingenieria.sistemas.core.parcial2.core.model.CabeceraFacturaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeceraFacturaRepository extends CrudRepository<CabeceraFacturaEntity, Long> {
    
    @Query("select c from CabeceraFacturaEntity c where c.nit=?1 order by c.date ASC")
    List<CabeceraFacturaEntity> findAllCabeceraASC(String nit);
    
    @Query("select c from CabeceraFacturaEntity c where c.nit=?1 order by c.date DESC")
    List<CabeceraFacturaEntity> findAllCabeceraDESC(String nit);
}
