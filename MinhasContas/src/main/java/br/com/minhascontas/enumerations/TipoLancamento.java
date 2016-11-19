package br.com.minhascontas.enumerations;

/**
 * Classe que representa o tipo de lançamento. Se o cadastro é uma despesa a
 *  ser paga ou gera uma receita (entrada de dinheiro, ex: salário).
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public enum TipoLancamento {
    
    RECEITA ("Receita"), 
    DESPESA ("Despesa");
    
    private final String descricao;

    private TipoLancamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
