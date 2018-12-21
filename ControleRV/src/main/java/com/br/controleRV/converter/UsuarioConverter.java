package com.br.controleRV.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.br.controleRV.model.Usuario;
import com.br.controleRV.repository.Usuarios;

@FacesConverter(value ="usuarioConverter", forClass =  Usuario.class)
public class UsuarioConverter implements Converter{
	
	@Inject
	private Usuarios usuarios;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Usuario retorno = null;
		
		if(value !=null && !"".equals(value)) {
			
			retorno = this.usuarios.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null) {
			
			Usuario usuario = ((Usuario) value);
			return usuario.getId() == null ? null : usuario.getId().toString();
		}
		return null;
	}
}
