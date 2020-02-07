package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
public class CarModels {

	private Long id;
	private String marka;
	private String model;
	private String donanimseviyesi;
	private Long uretimyili;
	private String renk;
	private String fiyat;
	private String degisendurumu;
	private String boyadurumu;
	private String hasarkaydi;
	private String durum;

	@Id
	@SequenceGenerator(name = "seq_cars", allocationSize = 1, sequenceName = "seq_cars")
	@GeneratedValue(generator = "seq_cars", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDonanimseviyesi() {
		return donanimseviyesi;
	}

	public void setDonanimseviyesi(String donanimseviyesi) {
		this.donanimseviyesi = donanimseviyesi;
	}

	public Long getUretimyili() {
		return uretimyili;
	}

	public void setUretimyili(Long uretimyili) {
		this.uretimyili = uretimyili;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public String getFiyat() {
		return fiyat;
	}

	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}

	public String getDegisendurumu() {
		return degisendurumu;
	}

	public String getBoyadurumu() {
		return boyadurumu;
	}

	public String getHasarkaydi() {
		return hasarkaydi;
	}

	public void setHasarkaydi(String hasarkaydi) {
		this.hasarkaydi = hasarkaydi;
	}

	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}

	public void setDegisendurumu(String degisendurumu) {
		this.degisendurumu = degisendurumu;
	}

	public void setBoyadurumu(String boyadurumu) {
		this.boyadurumu = boyadurumu;
	}
	
	@Override
	public String toString() {
		return "CarModels [id=" + id + ", marka=" + marka + ", model=" + model + ", donanimseviyesi=" + donanimseviyesi
				+ ", uretimyili=" + uretimyili + ", renk=" + renk + ", fiyat=" + fiyat + ", degisendurumu="
				+ degisendurumu + ", boyadurumu=" + boyadurumu + ", hasarkaydi=" + hasarkaydi + ", durum=" + durum
				+ "]";
	}
}
