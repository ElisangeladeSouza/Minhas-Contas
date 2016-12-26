package br.com.minhascontas.controllers;

import br.com.minhascontas.exceptions.NegocioException;
import br.com.minhascontas.model.ComprasFuturas;
import br.com.minhascontas.services.interfaces.ComprasFuturasServiceIF;
import br.com.minhascontas.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author elisangela <elisangeladesouza@gmail.com>
 */
@Model
public class ComprasFuturasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ComprasFuturas comprasFuturas;
    
    @Inject
    private ComprasFuturasServiceIF comprasFuturasService;
    
    @Inject
    private ComprasFuturas compraSelecionada;
    
    private DashboardModel model;
    
    private transient List<ComprasFuturas> compras;

    public ComprasFuturasBean() {
    }
    
    @PostConstruct
    public void init() {
        this.compras = comprasFuturasService.findAll();
        this.model = new DefaultDashboardModel();
    }
    
    public void salvar() {
        this.comprasFuturasService.save(comprasFuturas);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de compras '" + comprasFuturas.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaComprasFuturas.xhtml");
        comprasFuturas = new ComprasFuturas();
    }
    
    public void excluir() throws NegocioException {
        this.comprasFuturasService.delete(compraSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaComprasFuturas.xhtml");
    }
    
    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
    public boolean getEditando() {
        return this.comprasFuturas.getId() != null;
    }

    public ComprasFuturas getComprasFuturas() {
        return comprasFuturas;
    }

    public void setComprasFuturas(ComprasFuturas comprasFuturas) {
        this.comprasFuturas = comprasFuturas;
    }

    public ComprasFuturasServiceIF getComprasFuturasService() {
        return comprasFuturasService;
    }

    public void setComprasFuturasService(ComprasFuturasServiceIF comprasFuturasService) {
        this.comprasFuturasService = comprasFuturasService;
    }

    public ComprasFuturas getCompraSelecionada() {
        return compraSelecionada;
    }

    public void setCompraSelecionada(ComprasFuturas compraSelecionada) {
        this.compraSelecionada = compraSelecionada;
    }

    public List<ComprasFuturas> getCompras() {
        return compras;
    }

    public void setCompras(List<ComprasFuturas> compras) {
        this.compras = compras;
    }

    public DashboardModel getModel() {
        return model;
    }

    public void setModel(DashboardModel model) {
        this.model = model;
    }
    
}
