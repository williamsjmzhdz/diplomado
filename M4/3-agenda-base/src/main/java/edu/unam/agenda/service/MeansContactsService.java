package edu.unam.agenda.service;

import edu.unam.agenda.model.MeansContacts;

import java.util.List;
import java.util.Set;

public interface MeansContactsService {
	MeansContacts getMeansContactsById(Integer id);
	List<MeansContacts> getAllMeansContacts();
	Boolean insertMeansContacts(MeansContacts contacto);
	Boolean updateMeansContacts(MeansContacts contacto);
	Boolean deleteMeansContacts(MeansContacts contacto);
	List<MeansContacts> getMeansContactsByContact(Integer id);
	Boolean deleteAllMeansContactsByContactId(Integer id);
	Set<MeansContacts> getAllMeansContactsByContactId(Integer id);
}
