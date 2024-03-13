package com.itb.lip2.academicologininf3bn.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "papeis")
public class Papel { 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePapel;
	private String descriçãoPapel;
	private boolean codStatusPapel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomePapel() {
		return nomePapel;
	}
	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}
	public String getDescriçãoPapel() {
		return descriçãoPapel;
	}
	public void setDescriçãoPapel(String descriçãoPapel) {
		this.descriçãoPapel = descriçãoPapel;
	}
	public boolean isCodStatusPapel() {
		return codStatusPapel;
	}
	public void setCodStatusPapel(boolean codStatusPapel) {
		this.codStatusPapel = codStatusPapel;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Papel other = (Papel) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
