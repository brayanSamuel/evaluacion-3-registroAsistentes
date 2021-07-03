package cl.inacap.asistentesModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.asistentesModel.dto.Asistente;

@Local
public interface AsistentesDAOLocal {
	
	void save(Asistente asistente);
	List<Asistente> getAll();
	void delete(Asistente asistente);
	List<Asistente> filterByestado(String estado);
	
}
