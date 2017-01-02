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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author elisangela <elisangeladesouza@gmail.com>
 */
@Model
public class ComprasFuturasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    @Getter
    @Setter
    private ComprasFuturas comprasFuturas;
    
    @Inject
    @Getter
    @Setter
    private ComprasFuturasServiceIF comprasFuturasService;
    
    @Inject
    @Getter
    @Setter
    private ComprasFuturas compraSelecionada;
    
    @Getter
    @Setter
    private transient List<ComprasFuturas> compras;

    public ComprasFuturasBean() {
    }
    
    @PostConstruct
    public void init() {
        this.compras = comprasFuturasService.findAll();
    }
    
    public void salvar() throws NegocioException {
        this.comprasFuturasService.save(comprasFuturas);
        FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
//        if (getEditando()) {
//            FacesUtil.mensagemSucesso("Cadastro de compras '" + comprasFuturas.getNome() + "' atualizado com sucesso!");
//        } else {
//            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
//        }
        FacesUtil.redirecionaPara("CadastroComprasFuturas.xhtml");
        comprasFuturas = new ComprasFuturas();
    }
    
    public void excluir() throws NegocioException {
        this.comprasFuturasService.delete(compraSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("CadastroComprasFuturas.xhtml");
    }
    
    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
//    public boolean getEditando() {
//        return this.comprasFuturas.getId() != null;
//    }

}
