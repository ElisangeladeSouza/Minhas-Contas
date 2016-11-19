package br.com.minhascontas.converters;

import br.com.minhascontas.exceptions.MinhasContasException;
import br.com.minhascontas.model.Lancamento;
import br.com.minhascontas.services.LancamentoService;
import br.com.minhascontas.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * A classe é capaz de converter uma string com o código do lançamento em 
 * objeto do tipo Lançamento.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {
    
    private final LancamentoService lancamentoService;

    public LancamentoConverter() throws MinhasContasException {
        this.lancamentoService = CDIServiceLocator.getBean(LancamentoService.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Lancamento objectToReturn = null;
        
        if(value != null) {
            objectToReturn = this.lancamentoService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            Long code = ((Lancamento) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
