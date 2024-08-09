package edu.unam.agenda.dao;

import edu.unam.agenda.model.MeansContacts;

import java.util.List;
import java.util.Set;

public interface MeansContactsDAO {
	MeansContacts getMeansContactsById(Integer id);

	List<MeansContacts> getAllMeansContacts();

	Boolean insertMeansContacts(MeansContacts contact);

	Boolean updateMeansContacts(MeansContacts contact);

	Boolean deleteMeansContacts(MeansContacts contact);

	List<MeansContacts> getMeansContactsByContact(Integer id);

	Boolean deleteAllMeansContactsByContactId(Integer id);

	Set<MeansContacts> getAllMeansContactsByContactId(Integer id);
}
