package cl.inacap.asistentesModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.asistentesModel.dto.Asistente;

/**
 * Session Bean implementation class AsistentesDAO
 */
@Stateless
@LocalBean
public class AsistentesDAO implements AsistentesDAOLocal {

		private static List<Asistente> asistentes = new ArrayList<>();
 
	@Override
	public void save(Asistente asistente) {
		asistentes.add(asistente); 
	}

	@Override
	public List<Asistente> getAll() {
		// TODO Auto-generated method stub
		return asistentes;
	}

	@Override
	public void delete(Asistente asistente) {
		asistentes.remove(asistente);
	}

	@Override
	public List<Asistente> filterByestado(String estado) {
		// TODO Auto-generated method stub
		return asistentes.stream().filter(e->e.getEstado().contains(estado)).collect(Collectors.toList());
	}

}