package br.com.minhascontas.exceptions;

/**
 * Classe destinada a servir de ponte para tratar exceções da camada de dados.
 *
 * @author elisangela <elisangeladesouza@gmail.com>
 */
public class DaoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DaoException(String message) {
        super(message);
    }
}
