package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.ContactTypeDAO;
import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.model.ContactType;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ContactTypeDAOImpl implements ContactTypeDAO {

	private static ContactTypeDAOImpl instance;

	private ContactTypeDAOImpl() {
	}

	public static ContactTypeDAOImpl getInstance() {
		if (instance == null)
			instance = new ContactTypeDAOImpl();
		return instance;
	}
	
	@Override
	public ContactType getContactTypeById(Integer id) {
		ContactType contactType = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			contactType = session.get(ContactType.class, id);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return contactType;
	}
	
	@Override
	public List<ContactType> getAllContactType() {
		List<ContactType> contactTypeList = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			contactTypeList = session.createQuery("SELECT t FROM ContactType t WHERE t.status = 'ACTIVO' ", ContactType.class).getResultList();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return contactTypeList;
	}	
	
	@Override
	public Boolean insertContactType(ContactType contactType) {
		Boolean save = Boolean.FALSE;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(contactType);
			save = contactType.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return save;
	}
	
	@Override
	public Boolean updateContactType(ContactType contactType) {
		Boolean update = Boolean.FALSE;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.merge(contactType);
			update = contactType.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return update;
	}
	
	@Override
	public Boolean deleteContactType(ContactType contactType) {
		Boolean delete = Boolean.FALSE;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.remove(contactType);
			delete = contactType.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return delete;
	}
}
