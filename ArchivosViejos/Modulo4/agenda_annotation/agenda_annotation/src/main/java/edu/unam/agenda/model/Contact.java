package edu.unam.agenda.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private Integer age;

	@Column(name = "address")
	private String address;

	@ManyToOne(targetEntity = ContactType.class, optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_type_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private ContactType contactType;

	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private Set<MeansContacts> meansContacts;

}
