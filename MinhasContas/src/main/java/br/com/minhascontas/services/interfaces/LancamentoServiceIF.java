package br.com.minhascontas.services.interfaces;

import br.com.minhascontas.model.Lancamento;
import java.util.List;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public interface LancamentoServiceIF {
    
    public List<Lancamento> findAll();
    
    public void save(Lancamento lancamento);
    
    public void delete(Lancamento lancamentoSelecionado);
    
}
