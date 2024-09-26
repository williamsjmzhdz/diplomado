package edu.unam.agenda.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "means_contact")
public class MeansContacts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "means_contact_id")
	private Integer id;

	@Column(name = "value")
	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id")
	private Contact contact;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_type_id")
	private PhoneType phoneType;

}
