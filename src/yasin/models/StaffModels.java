package yasin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")
public class StaffModels {
	
	private Long id;
	private String isim;
	private String soyisim;
	private String mevki;
	private Long tckno;
	private String maas;
	
	@Id
	@SequenceGenerator(name = "seq_staff", allocationSize = 1, sequenceName = "seq_staff")
	@GeneratedValue(generator = "seq_staff", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getSoyisim() {
		return soyisim;
	}
	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}
	public String getMevki() {
		return mevki;
	}
	public void setMevki(String mevki) {
		this.mevki = mevki;
	}
	public Long getTckno() {
		return tckno;
	}
	public void setTckno(Long tckno) {
		this.tckno = tckno;
	}
	public String getMaas() {
		return maas;
	}
	public void setMaas(String maas) {
		this.maas = maas;
	}
	
	
	@Override
	public String toString() {
		return isim+" "+soyisim;
	}
	
	

}
