package com.br.controleRV.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.br.controleRV.model.Estoque;
import com.br.controleRV.repository.Estoques;

@FacesConverter(value ="estoqueConverter", forClass = Estoque.class)
public class EstoqueConverter implements Converter{
	
	@Inject
	private Estoques estoques;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Estoque retorno = null;
		
		if(value !=null && !"".equals(value)) {
			
			retorno = this.estoques.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null) {
			
			Estoque  estoque = ((Estoque) value);
			return estoque.getId() == null ? null : estoque.getId().toString();
		}
		return null;
	}
}
