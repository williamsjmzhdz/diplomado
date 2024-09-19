package edu.unam.agenda.service.impl;

import edu.unam.agenda.dao.PhoneTypeDAO;
import edu.unam.agenda.dao.impl.PhoneTypeDAOImpl;
import edu.unam.agenda.model.PhoneType;
import edu.unam.agenda.service.PhoneTypeService;

import java.util.List;

public class PhoneTypeServiceImpl implements PhoneTypeService {
	private static PhoneTypeServiceImpl instance;
	private static final PhoneTypeDAOImpl phoneTypeDAO = PhoneTypeDAOImpl.getInstance();
	
	private PhoneTypeServiceImpl() {
	}
	
	public static PhoneTypeServiceImpl getInstance() {
		if (instance == null) {
			instance = new PhoneTypeServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<PhoneType> getAllPhoneTypes() {
		return phoneTypeDAO.findAll();
	}

	@Override
	public PhoneType getPhoneTypeById(Integer id) {
		return phoneTypeDAO.get(id);
	}
	
	@Override
	public Boolean insertPhoneType(PhoneType phoneType) {
		return phoneTypeDAO.save(phoneType);
	}
	
	@Override
	public Boolean updatePhoneType(PhoneType phoneType) {
		return phoneTypeDAO.save(phoneType);
	}
	
	@Override
	public Boolean deletePhoneType(PhoneType phoneType) {
		return phoneTypeDAO.delete(phoneType);
	}
}
