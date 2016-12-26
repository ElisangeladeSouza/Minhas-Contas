package br.com.minhascontas.converters;

import br.com.minhascontas.exceptions.MinhasContasException;
import br.com.minhascontas.model.ComprasFuturas;
import br.com.minhascontas.services.ComprasFuturasService;
import br.com.minhascontas.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * A classe é capaz de converter uma string com o código de compras futuras 
 * em objeto do tipo ComprasFuturas.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = ComprasFuturas.class)
public class ComprasFuturasConverter implements Converter {
    
    private final ComprasFuturasService comprasFuturasService;

    public ComprasFuturasConverter() throws MinhasContasException {
        this.comprasFuturasService = CDIServiceLocator.getBean(ComprasFuturasService.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ComprasFuturas objectToReturn = null;
        
        if(value != null) {
            objectToReturn = this.comprasFuturasService.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            Long code = ((ComprasFuturas) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
