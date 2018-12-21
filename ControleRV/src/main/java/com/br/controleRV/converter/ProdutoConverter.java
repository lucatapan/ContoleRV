package com.br.controleRV.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.br.controleRV.model.Produto;
import com.br.controleRV.repository.Produtos;

@FacesConverter(value = "produtoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter{
	
	@Inject
	private Produtos produtos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Produto retorno = null;
		
		if(value !=null && !"".equals(value)) {
			
			retorno = this.produtos.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null) {
			
			Produto produto = ((Produto) value);
			return produto.getId() == null ? null : produto.getId().toString();
		}
		return null;
	}
}
