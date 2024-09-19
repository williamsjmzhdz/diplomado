package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.PhoneTypeDAO;
import edu.unam.agenda.model.PhoneType;
import edu.unam.agenda.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class PhoneTypeDAOImpl extends GenericDAOImpl<PhoneType, Integer> implements PhoneTypeDAO {


	private static PhoneTypeDAOImpl instance;

	private PhoneTypeDAOImpl() {
	}

	public static PhoneTypeDAOImpl getInstance() {
		if (instance == null)
			instance = new PhoneTypeDAOImpl();
		return instance;
	}

}
