package br.com.minhascontas.dao;

import br.com.minhascontas.model.Lancamento;
import java.io.Serializable;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class LancamentoDao extends DaoAbstract<Lancamento> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public LancamentoDao() {
        super(Lancamento.class);
    }
    
}
