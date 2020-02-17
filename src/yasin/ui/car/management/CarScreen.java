package yasin.ui.car.management;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import yasin.dao.CarsDAO;
import yasin.dao.DbServicessBase;
import yasin.main.MainScreen;
import yasin.models.CarModels;
import yasin.utils.MyUtil;

public class CarScreen extends JFrame {

	private JTable table;
	private JTextField txtID;
	private JTextField txtMarka;
	private JTextField txtModel;
	private JTextField txtDonanim;
	private JTextField txtUretim;
	private JTextField txtRenk;
	private JTextField txtFiyat;
	private JTextField txtHasarKaydi;
	private Long secilenId;
	private JTextField txtKm;

	public CarScreen() {
		setTitle("Araç Yönetim Ekraný");
		setBounds(500, 500, 1014, 541);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 978, 259);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(getTable_1());

		JButton btnDoldur = new JButton("Verileri Getir");
		btnDoldur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoldur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doldur();
			}
		});
		btnDoldur.setBounds(179, 350, 159, 58);
		getContentPane().add(btnDoldur);

		JComboBox cmbDurum = new JComboBox();
		cmbDurum.setBounds(840, 403, 148, 22);
		getContentPane().add(cmbDurum);

		JComboBox cmbBoya = new JComboBox();
		cmbBoya.setBounds(524, 403, 148, 22);
		getContentPane().add(cmbBoya);

		JComboBox cmbDegisen = new JComboBox();
		cmbDegisen.setBounds(366, 402, 148, 22);
		getContentPane().add(cmbDegisen);

		cmbDurum.setModel(new DefaultComboBoxModel(new String[] { "YENÝ EKLENDÝ", "SATILDI", "SATILMADI" }));
		cmbBoya.setModel(new DefaultComboBoxModel(
				new String[] { "YOK", "1 PARÇA", "2 PARÇA", "3 PARÇA", "4 PARÇA", "5 PARÇA", "6 PARÇA" }));
		cmbDegisen.setModel(new DefaultComboBoxModel(
				new String[] { "YOK", "1 PARÇA", "2 PARÇA", "3 PARÇA", "4 PARÇA", "5 PARÇA", "6 PARÇA" }));

		JButton btnEkle = new JButton("Yeni Ara\u00E7 Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DbServicessBase<CarModels> dao = new DbServicessBase<CarModels>();
				CarModels temp = new CarModels();

				temp.setMarka(txtMarka.getText());
				temp.setModel(txtModel.getText());
				temp.setDonanimseviyesi(txtDonanim.getText());
				temp.setUretimyili(Long.valueOf(txtUretim.getText()));
				temp.setKm(txtKm.getText());
				temp.setRenk(txtRenk.getText());
				temp.setFiyat(txtFiyat.getText());
				temp.setDegisendurumu(cmbDegisen.getSelectedItem().toString());
				temp.setBoyadurumu(cmbBoya.getSelectedItem().toString());
				temp.setHasarkaydi(txtHasarKaydi.getText());
				temp.setDurum(cmbDurum.getSelectedItem().toString());
				dao.save(temp);
				Doldur();

			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEkle.setBounds(10, 281, 159, 58);
		getContentPane().add(btnEkle);

		txtID = new JTextField();
		txtID.setText("Otomatik Verilecektir.");
		txtID.setEditable(false);
		txtID.setBounds(366, 301, 148, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(366, 281, 48, 14);
		getContentPane().add(lblId);

		JLabel lblMarka = new JLabel("Marka");
		lblMarka.setBounds(524, 281, 48, 14);
		getContentPane().add(lblMarka);

		txtMarka = new JTextField();
		txtMarka.setColumns(10);
		txtMarka.setBounds(524, 301, 148, 20);
		getContentPane().add(txtMarka);

		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(682, 281, 48, 14);
		getContentPane().add(lblModel);

		txtModel = new JTextField();
		txtModel.setColumns(10);
		txtModel.setBounds(682, 301, 148, 20);
		getContentPane().add(txtModel);

		JLabel lblDonanim = new JLabel("Donan\u0131m Seviyesi");
		lblDonanim.setBounds(840, 281, 148, 14);
		getContentPane().add(lblDonanim);

		txtDonanim = new JTextField();
		txtDonanim.setColumns(10);
		txtDonanim.setBounds(840, 301, 148, 20);
		getContentPane().add(txtDonanim);

		JLabel lblUretim = new JLabel("\u00DCretim Y\u0131l\u0131");
		lblUretim.setBounds(366, 332, 95, 14);
		getContentPane().add(lblUretim);

		txtUretim = new JTextField();
		txtUretim.setColumns(10);
		txtUretim.setBounds(366, 352, 148, 20);
		getContentPane().add(txtUretim);

		JLabel lblRenk = new JLabel("Renk");
		lblRenk.setBounds(682, 332, 48, 14);
		getContentPane().add(lblRenk);

		txtRenk = new JTextField();
		txtRenk.setColumns(10);
		txtRenk.setBounds(682, 352, 148, 20);
		getContentPane().add(txtRenk);

		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setBounds(840, 332, 48, 14);
		getContentPane().add(lblFiyat);

		txtFiyat = new JTextField();
		txtFiyat.setColumns(10);
		txtFiyat.setBounds(840, 352, 148, 20);
		getContentPane().add(txtFiyat);

		JLabel lblDegisen = new JLabel("De\u011Fi\u015Fen");
		lblDegisen.setBounds(366, 383, 48, 14);
		getContentPane().add(lblDegisen);

		JLabel lblBoya = new JLabel("Boya");
		lblBoya.setBounds(524, 384, 48, 14);
		getContentPane().add(lblBoya);

		JLabel lblHasarKaydi = new JLabel("Hasar Kayd\u0131");
		lblHasarKaydi.setBounds(682, 384, 82, 14);
		getContentPane().add(lblHasarKaydi);

		txtHasarKaydi = new JTextField();
		txtHasarKaydi.setColumns(10);
		txtHasarKaydi.setBounds(682, 404, 148, 20);
		getContentPane().add(txtHasarKaydi);

		JButton btnAraBilgisiGncelle = new JButton("Ara\u00E7 Bilgisi G\u00FCncelle");
		btnAraBilgisiGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DbServicessBase<CarModels> dao = new DbServicessBase<CarModels>();
				CarModels temp = new CarModels();

				temp.setId(secilenId);
				temp.setMarka(txtMarka.getText());
				temp.setModel(txtModel.getText());
				temp.setDonanimseviyesi(txtDonanim.getText());
				temp.setUretimyili(Long.valueOf(txtUretim.getText()));
				temp.setKm(txtKm.getText());
				temp.setRenk(txtRenk.getText());
				temp.setFiyat(txtFiyat.getText());
				temp.setDegisendurumu(cmbDegisen.getSelectedItem().toString());
				temp.setBoyadurumu(cmbBoya.getSelectedItem().toString());
				temp.setHasarkaydi(txtHasarKaydi.getText());
				temp.setDurum(cmbDurum.getSelectedItem().toString());
				dao.update(temp);
				Doldur();
			}
		});
		btnAraBilgisiGncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAraBilgisiGncelle.setBounds(10, 350, 159, 58);
		getContentPane().add(btnAraBilgisiGncelle);

		JLabel lblDurum = new JLabel("Durum");
		lblDurum.setBounds(840, 384, 82, 14);
		getContentPane().add(lblDurum);

		JButton btnCikis = new JButton("\u00C7IKI\u015E");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainScreen().setVisible(true);
				dispose();
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCikis.setBounds(10, 419, 328, 58);
		getContentPane().add(btnCikis);

		txtKm = new JTextField();
		txtKm.setColumns(10);
		txtKm.setBounds(524, 352, 148, 20);
		getContentPane().add(txtKm);

		JLabel lblKM = new JLabel("Arac\u0131n Kilometresi");
		lblKM.setBounds(524, 332, 120, 14);
		getContentPane().add(lblKM);

		JButton btnSil = new JButton("Ara\u00E7 Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<CarModels> dao = new DbServicessBase<CarModels>();
				CarModels temp = new CarModels();

				temp.setId(secilenId);
				temp.setMarka(txtMarka.getText());
				temp.setModel(txtModel.getText());
				temp.setDonanimseviyesi(txtDonanim.getText());
				temp.setUretimyili(Long.valueOf(txtUretim.getText()));
				temp.setKm(txtKm.getText());
				temp.setRenk(txtRenk.getText());
				temp.setFiyat(txtFiyat.getText());
				temp.setDegisendurumu(cmbDegisen.getSelectedItem().toString());
				temp.setBoyadurumu(cmbBoya.getSelectedItem().toString());
				temp.setHasarkaydi(txtHasarKaydi.getText());
				temp.setDurum(cmbDurum.getSelectedItem().toString());
				dao.delete(temp);
				Doldur();
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSil.setBounds(179, 281, 159, 58);
		getContentPane().add(btnSil);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilenId = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtMarka.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 1)));
				txtModel.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 2)));
				txtDonanim.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 3)));
				txtUretim.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 4)));
				txtKm.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 5)));
				txtRenk.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 6)));
				txtFiyat.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 7)));
				txtHasarKaydi.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 10)));
			}
		});

	}

	private JTable getTable_1() {
		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Marka", "Model", "Donaným Seviyesi",
						"Üretim Yýlý", "Kilometre", "Renk", "Fiyat", "Deðiþen", "Boya", "Hasar Kaydý", "Durum" }) {
				});

		DbServicessBase<CarModels> dao = new DbServicessBase<CarModels>();
		CarModels temp = new CarModels();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { temp.getId(), temp.getMarka(), temp.getModel(), temp.getDonanimseviyesi(),
				temp.getUretimyili(), temp.getKm(), temp.getRenk(), temp.getFiyat(), temp.getDegisendurumu(),
				temp.getBoyadurumu(), temp.getHasarkaydi(), temp.getDurum() });

		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(11).setPreferredWidth(100);

		return table;

	}

	private void Doldur() {

		DbServicessBase<CarModels> dao = new DbServicessBase<CarModels>();
		CarModels temp = new CarModels();

		CarsDAO carsdao = new CarsDAO();
		List<CarModels> liste = carsdao.getAllRows(new CarModels());
		String[][] data = new String[liste.size()][12];
		String[] columns = { "ID", "Marka", "Model", "Donaným Seviyesi", "Üretim Yýlý", "Kilometre", "Renk", "Fiyat",
				"Deðiþen", "Boya", "Hasar Kaydý", "Durum" };
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = String.valueOf(liste.get(i).getMarka());
			data[i][2] = String.valueOf(liste.get(i).getModel());
			data[i][3] = String.valueOf(liste.get(i).getDonanimseviyesi());
			data[i][4] = String.valueOf(liste.get(i).getUretimyili());
			data[i][5] = String.valueOf(liste.get(i).getKm());
			data[i][6] = String.valueOf(liste.get(i).getRenk());
			data[i][7] = String.valueOf(liste.get(i).getFiyat());
			data[i][8] = String.valueOf(liste.get(i).getDegisendurumu());
			data[i][9] = String.valueOf(liste.get(i).getBoyadurumu());
			data[i][10] = String.valueOf(liste.get(i).getHasarkaydi());
			data[i][11] = String.valueOf(liste.get(i).getDurum());

			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(11).setPreferredWidth(100);

		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(11).setPreferredWidth(100);

	}
}
