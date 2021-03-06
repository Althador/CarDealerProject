package yasin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Expense")
public class ExpenseModels {
	
	private Long id;
	private String miktar;
	private String tanim;
	private String sorumlukisi;
	
	@Id
	@SequenceGenerator(name = "seq_expense", allocationSize = 1, sequenceName = "seq_expense")
	@GeneratedValue(generator = "seq_expense", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMiktar() {
		return miktar;
	}
	public void setMiktar(String miktar) {
		this.miktar = miktar;
	}
	public String getTanim() {
		return tanim;
	}
	public void setTanim(String tanim) {
		this.tanim = tanim;
	}
	public String getSorumlukisi() {
		return sorumlukisi;
	}
	public void setSorumlukisi(String sorumlukisi) {
		this.sorumlukisi = sorumlukisi;
	}
	@Override
	public String toString() {
		return "IncomeModels [id=" + id + ", miktar=" + miktar + ", tanim=" + tanim + ", sorumlukisi=" + sorumlukisi
				+ "]";
	}
	
	

}
