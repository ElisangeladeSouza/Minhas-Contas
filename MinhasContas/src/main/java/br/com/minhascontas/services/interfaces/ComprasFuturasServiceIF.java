package br.com.minhascontas.services.interfaces;

import br.com.minhascontas.model.ComprasFuturas;
import java.util.List;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public interface ComprasFuturasServiceIF {
    
    public List<ComprasFuturas> findAll();
    
    public void save(ComprasFuturas comprasFuturas);
    
    public void delete(ComprasFuturas compraSelecionada);
    
}
