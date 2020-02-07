package Car.Management;

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


import DAO.CarsDAO;
import DAO.DbServicessBase;
import Models.CarModels;
import Utils.CarUtils;

public class CarScreen extends JFrame {

	DbServicessBase<CarModels> dao = new DbServicessBase<CarModels>();
	CarModels temp = new CarModels();

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

	public CarScreen() {
		setTitle("Araç Yönetim Ekraný");
		setBounds(500, 500, 994, 541);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 958, 259);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(getTable_1());
		
		JButton btnDoldur = new JButton("Verileri Getir");
		btnDoldur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoldur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doldur();
			}
		});
		btnDoldur.setBounds(10, 419, 159, 58);
		getContentPane().add(btnDoldur);
		
		
		JComboBox cmbDurum = new JComboBox();
		cmbDurum.setBounds(662, 402, 148, 22);
		getContentPane().add(cmbDurum);
		
		JComboBox cmbBoya = new JComboBox();
		cmbBoya.setBounds(346, 402, 148, 22);
		getContentPane().add(cmbBoya);
		
		JComboBox cmbDegisen = new JComboBox();
		cmbDegisen.setBounds(820, 351, 148, 22);
		getContentPane().add(cmbDegisen);
		
		cmbDurum.setModel(new DefaultComboBoxModel(new String[] {"YENÝ EKLENDÝ", "SATILDI", "SATILMADI"}));
		cmbBoya.setModel(new DefaultComboBoxModel(new String[] {"YOK", "1 PARÇA", "2 PARÇA", "3 PARÇA", "4 PARÇA", "5 PARÇA", "6 PARÇA"}));
		cmbDegisen.setModel(new DefaultComboBoxModel(new String[] {"YOK", "1 PARÇA", "2 PARÇA", "3 PARÇA", "4 PARÇA", "5 PARÇA", "6 PARÇA"}));
		
		JButton btnEkle = new JButton("Yeni Ara\u00E7 Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.setMarka(txtMarka.getText());
				temp.setModel(txtModel.getText());
				temp.setDonanimseviyesi(txtDonanim.getText());
				temp.setUretimyili(Long.valueOf(txtUretim.getText()));
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
		txtID.setBounds(346, 301, 148, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(346, 281, 48, 14);
		getContentPane().add(lblId);
		
		JLabel lblMarka = new JLabel("Marka");
		lblMarka.setBounds(504, 281, 48, 14);
		getContentPane().add(lblMarka);
		
		txtMarka = new JTextField();
		txtMarka.setColumns(10);
		txtMarka.setBounds(504, 301, 148, 20);
		getContentPane().add(txtMarka);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(662, 281, 48, 14);
		getContentPane().add(lblModel);
		
		txtModel = new JTextField();
		txtModel.setColumns(10);
		txtModel.setBounds(662, 301, 148, 20);
		getContentPane().add(txtModel);
		
		JLabel lblDonanim = new JLabel("Donan\u0131m Seviyesi");
		lblDonanim.setBounds(820, 281, 148, 14);
		getContentPane().add(lblDonanim);
		
		txtDonanim = new JTextField();
		txtDonanim.setColumns(10);
		txtDonanim.setBounds(820, 301, 148, 20);
		getContentPane().add(txtDonanim);
		
		JLabel lblUretim = new JLabel("\u00DCretim Y\u0131l\u0131");
		lblUretim.setBounds(346, 332, 95, 14);
		getContentPane().add(lblUretim);
		
		txtUretim = new JTextField();
		txtUretim.setColumns(10);
		txtUretim.setBounds(346, 352, 148, 20);
		getContentPane().add(txtUretim);
		
		JLabel lblRenk = new JLabel("Renk");
		lblRenk.setBounds(504, 332, 48, 14);
		getContentPane().add(lblRenk);
		
		txtRenk = new JTextField();
		txtRenk.setColumns(10);
		txtRenk.setBounds(504, 352, 148, 20);
		getContentPane().add(txtRenk);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setBounds(662, 332, 48, 14);
		getContentPane().add(lblFiyat);
		
		txtFiyat = new JTextField();
		txtFiyat.setColumns(10);
		txtFiyat.setBounds(662, 352, 148, 20);
		getContentPane().add(txtFiyat);
		
		JLabel lblDegisen = new JLabel("De\u011Fi\u015Fen");
		lblDegisen.setBounds(820, 332, 48, 14);
		getContentPane().add(lblDegisen);
		
		JLabel lblBoya = new JLabel("Boya");
		lblBoya.setBounds(346, 383, 48, 14);
		getContentPane().add(lblBoya);
		
		JLabel lblHasarKaydi = new JLabel("Hasar Kayd\u0131");
		lblHasarKaydi.setBounds(504, 383, 82, 14);
		getContentPane().add(lblHasarKaydi);
		
		txtHasarKaydi = new JTextField();
		txtHasarKaydi.setColumns(10);
		txtHasarKaydi.setBounds(504, 403, 148, 20);
		getContentPane().add(txtHasarKaydi);
		
		JButton btnAraBilgisiGncelle = new JButton("Ara\u00E7 Bilgisi G\u00FCncelle");
		btnAraBilgisiGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.setId(secilenId);
				temp.setMarka(txtMarka.getText());
				temp.setModel(txtModel.getText());
				temp.setDonanimseviyesi(txtDonanim.getText());
				temp.setUretimyili(Long.valueOf(txtUretim.getText()));
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
		lblDurum.setBounds(662, 383, 82, 14);
		getContentPane().add(lblDurum);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilenId = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtMarka.setText(CarUtils.getValue(table.getValueAt(table.getSelectedRow(), 1)));
				txtModel.setText(CarUtils.getValue(table.getValueAt(table.getSelectedRow(), 2)));
				txtDonanim.setText(CarUtils.getValue(table.getValueAt(table.getSelectedRow(), 3)));
				txtUretim.setText(CarUtils.getValue(table.getValueAt(table.getSelectedRow(), 4)));
				txtRenk.setText(CarUtils.getValue(table.getValueAt(table.getSelectedRow(), 5)));
				txtFiyat.setText(CarUtils.getValue(table.getValueAt(table.getSelectedRow(), 6)));
				txtHasarKaydi.setText(CarUtils.getValue(table.getValueAt(table.getSelectedRow(), 9)));
			}
		});
	
	}

	private JTable getTable_1() {
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Marka", "Model",
				"Donaným Seviyesi", "Üretim Yýlý", "Renk", "Fiyat", "Deðiþen", "Boya", "Hasar Kaydý", "Durum" }) {
		});

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { temp.getId(), temp.getMarka(), temp.getModel(), temp.getDonanimseviyesi(),
				temp.getUretimyili(), temp.getRenk(), temp.getFiyat(), temp.getDegisendurumu(), temp.getBoyadurumu(),
				temp.getHasarkaydi(), temp.getDurum() });

		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		table.getColumnModel().getColumn(9).setPreferredWidth(70);
		table.getColumnModel().getColumn(10).setPreferredWidth(45);
		return table;

	}
	private void Doldur() {
		CarsDAO carsdao = new CarsDAO();
		List<CarModels> liste = carsdao.getAllRows(new CarModels());
		String[][] data = new String[liste.size()][11];
		String[] columns = { "ID", "Marka", "Model",
				"Donaným Seviyesi", "Üretim Yýlý", "Renk", "Fiyat", "Deðiþen", "Boya", "Hasar Kaydý", "Durum"};
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = String.valueOf(liste.get(i).getMarka());
			data[i][2] = String.valueOf(liste.get(i).getModel());
			data[i][3] = String.valueOf(liste.get(i).getDonanimseviyesi());
			data[i][4] = String.valueOf(liste.get(i).getUretimyili());
			data[i][5] = String.valueOf(liste.get(i).getRenk());
			data[i][6] = String.valueOf(liste.get(i).getFiyat());
			data[i][7] = String.valueOf(liste.get(i).getDegisendurumu());
			data[i][8] = String.valueOf(liste.get(i).getBoyadurumu());
			data[i][9] = String.valueOf(liste.get(i).getHasarkaydi());
			data[i][10] = String.valueOf(liste.get(i).getDurum());
			
			
			
		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);

	}
}
