package cat.itacademy.barcelonactiva.lopezriba.carlos.s04.t02.n01.domain;

import javax.persistence.*;

@Entity
@Table(name = "fruita")
public class Fruita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nom")
	private String nom;
	@Column(name = "quantitatQuilos")
	private int quantitatQuilos;
	
	public Fruita() {
		
	}
	
	public Fruita(String nom, int quantitatQuilos) {
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}
	
	public long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}

	@Override
	public String toString() {
		return "Fruita [id = " + id + ", nom = " + nom + ", quantitatQuilos = " + quantitatQuilos + "]";
	}

}
