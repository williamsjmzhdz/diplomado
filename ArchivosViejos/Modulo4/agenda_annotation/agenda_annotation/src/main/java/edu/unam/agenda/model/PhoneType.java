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
@Table(name = "phone_type")
public class PhoneType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_type_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private String status;

}
