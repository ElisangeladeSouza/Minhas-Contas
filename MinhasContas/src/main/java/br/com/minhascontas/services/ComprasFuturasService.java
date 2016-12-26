package br.com.minhascontas.services;

import br.com.minhascontas.dao.ComprasFuturasDao;
import br.com.minhascontas.exceptions.NegocioException;
import br.com.minhascontas.model.ComprasFuturas;
import br.com.minhascontas.services.interfaces.ComprasFuturasServiceIF;
import br.com.minhascontas.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ComprasFuturasService implements ComprasFuturasServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ComprasFuturasDao comprasFuturasDao;

    public ComprasFuturasService() {
    }
    
    @Transactional
    @Override
    public void save(ComprasFuturas comprasFuturas) {
        if (comprasFuturas != null) {
            this.comprasFuturasDao.salvar(comprasFuturas);
        }
    }
    
    @Transactional
    @Override
    public void delete(ComprasFuturas comprasFuturas) throws NegocioException {
        comprasFuturasDao.delete(findById(comprasFuturas.getId()));
    }
    
    public ComprasFuturas findById(Long id) {
        return comprasFuturasDao.findById(id);
    }
    
    @Override
    public List<ComprasFuturas> findAll() {
        return comprasFuturasDao.findAll();
    }

    
}
