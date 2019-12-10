package br.com.projetoWEB.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projetoWEB.model.DiasDaSemana;

@FacesConverter(forClass = DiasDaSemana.class, value = "diasConverter")
public class DiasConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.isEmpty())
			return null;
		return arg1.getAttributes().get(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		DiasDaSemana dias = (DiasDaSemana) object;
		if (dias == null || dias.getDiaDaSemana() == null)
			return null;
		arg1.getAttributes().put(String.valueOf(dias.getDiaDaSemana()), dias);
		return String.valueOf(dias.getDiaDaSemana());
	}
}
