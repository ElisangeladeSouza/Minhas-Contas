package br.com.minhascontas.services;

import br.com.minhascontas.dao.LancamentoDao;
import br.com.minhascontas.exceptions.NegocioException;
import br.com.minhascontas.model.Lancamento;
import br.com.minhascontas.services.interfaces.LancamentoServiceIF;
import br.com.minhascontas.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class LancamentoService implements LancamentoServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private LancamentoDao lancamentoDao;

    public LancamentoService() {
    }
    
    @Transactional
    @Override
    public void save(Lancamento lancamento) {
        if (lancamento != null) {
            this.lancamentoDao.salvar(lancamento);
        }
    }

    @Transactional
    @Override
    public void delete(Lancamento lancamento) throws NegocioException {
        lancamentoDao.delete(findById(lancamento.getId()));
    }
    
    public Lancamento findById(Long id) {
        return lancamentoDao.findById(id);
    }
     
    @Override
    public List<Lancamento> findAll() {
        return lancamentoDao.findAll();
    }
}
