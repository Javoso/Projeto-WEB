package br.com.projetoWEB.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projetoWEB.model.Turma;

@FacesConverter(forClass = Turma.class, value = "turmaConverter")
public class TurmaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.isEmpty())
			return null;
		return arg1.getAttributes().get(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		Turma turma = (Turma) object;
		if (turma == null || turma.getNomeDaTurma() == null)
			return null;
		arg1.getAttributes().put(String.valueOf(turma.getNomeDaTurma()), turma);
		return String.valueOf(turma.getNomeDaTurma());
	}
}
