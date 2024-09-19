package edu.unam.agenda.model;


import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.units.qual.C;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact_type")
public class ContactType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_type_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private String status;

}
