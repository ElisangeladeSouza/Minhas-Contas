package br.com.minhascontas.controllers;

import br.com.minhascontas.enumerations.TipoLancamento;
import br.com.minhascontas.exceptions.NegocioException;
import br.com.minhascontas.model.Lancamento;
import br.com.minhascontas.services.interfaces.LancamentoServiceIF;
import br.com.minhascontas.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class LancamentoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Lancamento lancamento;
    
    @Inject
    private LancamentoServiceIF lancamentoService;
    
    @Inject
    private Lancamento lancamentoSelecionado;
    
    private transient List<Lancamento> lancamentos;
    
    private transient List<TipoLancamento> tiposLancamentos = new ArrayList<>();

    public LancamentoBean() {
        this.tiposLancamentos = Arrays.asList(TipoLancamento.values());
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }
    
    @PostConstruct
    public void init() {
        this.lancamentos = lancamentoService.findAll();
    }
    
    public void salvar() {
        this.lancamentoService.save(lancamento);
        if(getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de lançamento '" + lancamento.getTipo() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaLancamento.xhtml");
        lancamento = new Lancamento();
    }
    
    public void excluir() throws NegocioException {
        this.lancamentoService.delete(lancamentoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaLancamento.xhtml");
    }
    
    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
    public boolean getEditando() {
        return this.lancamento.getId() != null;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public LancamentoServiceIF getLancamentoService() {
        return lancamentoService;
    }

    public void setLancamentoService(LancamentoServiceIF lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    public Lancamento getLancamentoSelecionado() {
        return lancamentoSelecionado;
    }

    public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
        this.lancamentoSelecionado = lancamentoSelecionado;
    }

    public List<TipoLancamento> getTiposLancamentos() {
        return tiposLancamentos;
    }

    public void setTiposLancamentos(List<TipoLancamento> tiposLancamentos) {
        this.tiposLancamentos = tiposLancamentos;
    }
    
}
