package br.com.minhascontas.dao;

import br.com.minhascontas.model.ComprasFuturas;
import java.io.Serializable;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ComprasFuturasDao extends DaoAbstract<ComprasFuturas> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public ComprasFuturasDao() {
        super(ComprasFuturas.class);
    }
    
}
