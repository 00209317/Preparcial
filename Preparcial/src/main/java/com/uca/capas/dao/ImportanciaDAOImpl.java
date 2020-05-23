package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager importanciaManager;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		Query query = importanciaManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia>resulset=query.getResultList();
		return resulset;
	}

	@Override
	public Importancia findOne(Integer code) throws DataAccessException {
		Importancia importancia = importanciaManager.find(Importancia.class, code);
		return importancia;
	}

	@Override
	public void save(Importancia c) throws DataAccessException {
		// TODO Auto-generated method stub
		importanciaManager.persist(c);
		
	}

}
