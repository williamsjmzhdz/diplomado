package edu.unam.hibernate.model;

import jakarta.persistence.*;

//POJO
@Entity
@Table(name = "table_1")
public class Table1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "data1")
	private String text;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Table{" +
				"id=" + id +
				", text='" + text + '\'' +
				'}';
	}
}
