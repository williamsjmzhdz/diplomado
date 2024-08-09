package edu.unam.agenda.dao.impl;

import edu.unam.agenda.dao.ContactDAO;
import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.model.Contact;
import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.model.MeansContacts;
import edu.unam.agenda.model.PhoneType;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
	private static ContactDAOImpl instance;

	private ContactDAOImpl() {
	}

	public static ContactDAOImpl getInstance() {
		if (instance == null)
			instance = new ContactDAOImpl();
		return instance;
	}

	@Override
	public Contact getContactById(Integer id) {
		Contact contact = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			contact = session.get(Contact.class, id);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			contactList = session.createQuery("SELECT t FROM Contact t", Contact.class).getResultList();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return contactList;
	}

	@Override
	public Boolean insertContact(Contact contact) {
		Boolean save = Boolean.FALSE;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(contact);
			save = contact.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return save;
	}

	@Override
	public Boolean updateContact(Contact contact) {
		Boolean update = Boolean.FALSE;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.merge(contact);
			update = contact.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return update;
	}

	@Override
	public Boolean deleteContact(Contact contact) {
		Boolean delete = Boolean.FALSE;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			// Verificar si el contacto existe antes de intentar eliminarlo
			Contact existingContact = session.get(Contact.class, contact.getId());
			if (existingContact != null) {
				session.remove(existingContact);
				delete = true;
			}

			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}

		return delete;
	}


	@Override
	public List<MeansContacts> getPhoneTypes(PhoneType phoneType) {
		List<MeansContacts> meansContactsList = null;
		// completar
		return meansContactsList;
	}
}
