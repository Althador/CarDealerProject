package yasin.ui.staff.management;

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
import yasin.dao.StaffDAO;
import yasin.main.MainScreen;
import yasin.models.CarModels;
import yasin.models.StaffModels;
import yasin.utils.MyUtil;

public class StaffScreen extends JFrame {

	private JTable table;
	private JTextField txtID;
	private JTextField txtIsim;
	private JTextField txtTck;
	private JTextField txtMaas;
	private JTextField txtSoyisim;
	private Long secilenId;

	public StaffScreen() {
		initialize();

	}

	private void initialize() {
		setTitle("Personel Yönetim Ekraný");
		setBounds(500, 500, 994, 342);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 542, 281);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(getTable_1());

		JButton btnDoldur = new JButton("Verileri Getir");
		btnDoldur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoldur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doldur();
			}
		});
		btnDoldur.setBounds(720, 212, 148, 35);
		getContentPane().add(btnDoldur);

		JComboBox cmbMevki = new JComboBox();
		cmbMevki.setBounds(720, 81, 148, 22);
		getContentPane().add(cmbMevki);
		cmbMevki.setModel(new DefaultComboBoxModel(
				new String[] { "Firma Sahibi", "Müdür", "Þef", "Danýþman", "Satýþ Elemaný", "Temizlik Görevlisi" }));

		JButton btnEkle = new JButton("Yeni Personel Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DbServicessBase<StaffModels> dao = new DbServicessBase<StaffModels>();
				StaffModels temp = new StaffModels();

				temp.setIsim(txtIsim.getText());
				temp.setSoyisim(txtSoyisim.getText());
				temp.setMevki(cmbMevki.getSelectedItem().toString());
				temp.setTckno(Long.parseLong(txtTck.getText()));
				temp.setMaas(txtMaas.getText());
				dao.save(temp);
				Doldur();

			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEkle.setBounds(562, 164, 148, 35);
		getContentPane().add(btnEkle);

		txtID = new JTextField();
		txtID.setText("Otomatik Verilecektir.");
		txtID.setEditable(false);
		txtID.setBounds(562, 31, 148, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(562, 11, 48, 14);
		getContentPane().add(lblId);

		JLabel lblIsim = new JLabel("\u0130sim");
		lblIsim.setBounds(720, 11, 48, 14);
		getContentPane().add(lblIsim);

		txtIsim = new JTextField();
		txtIsim.setColumns(10);
		txtIsim.setBounds(720, 31, 148, 20);
		getContentPane().add(txtIsim);

		JLabel lblTck = new JLabel("TCKNo");
		lblTck.setBounds(562, 113, 48, 14);
		getContentPane().add(lblTck);

		txtTck = new JTextField();
		txtTck.setColumns(10);
		txtTck.setBounds(562, 133, 148, 20);
		getContentPane().add(txtTck);

		JLabel lblMaas = new JLabel("Maa\u015F");
		lblMaas.setBounds(720, 113, 148, 14);
		getContentPane().add(lblMaas);

		txtMaas = new JTextField();
		txtMaas.setColumns(10);
		txtMaas.setBounds(720, 133, 148, 20);
		getContentPane().add(txtMaas);

		JLabel lblSoyisim = new JLabel("Soyisim");
		lblSoyisim.setBounds(562, 62, 95, 14);
		getContentPane().add(lblSoyisim);

		txtSoyisim = new JTextField();
		txtSoyisim.setColumns(10);
		txtSoyisim.setBounds(562, 82, 148, 20);
		getContentPane().add(txtSoyisim);

		JLabel lblMevki = new JLabel("Mevki");
		lblMevki.setBounds(720, 62, 48, 14);
		getContentPane().add(lblMevki);

		JButton btnGuncelle = new JButton("Personel Bilgi G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DbServicessBase<StaffModels> dao = new DbServicessBase<StaffModels>();
				StaffModels temp = new StaffModels();

				temp.setId(secilenId);
				temp.setIsim(txtIsim.getText());
				temp.setSoyisim(txtSoyisim.getText());
				temp.setMevki(cmbMevki.getSelectedItem().toString());
				temp.setTckno(Long.parseLong(txtTck.getText()));
				temp.setMaas(txtMaas.getText());
				dao.update(temp);
				Doldur();
			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuncelle.setBounds(562, 212, 148, 35);
		getContentPane().add(btnGuncelle);

		JButton btnCikis = new JButton("\u00C7IKI\u015E");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainScreen().setVisible(true);
				dispose();
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCikis.setBounds(562, 257, 306, 35);
		getContentPane().add(btnCikis);
		
		JButton btnSil = new JButton("Personel Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<StaffModels> dao = new DbServicessBase<StaffModels>();
				StaffModels temp = new StaffModels();

				temp.setId(secilenId);
				temp.setIsim(txtIsim.getText());
				temp.setSoyisim(txtSoyisim.getText());
				temp.setMevki(cmbMevki.getSelectedItem().toString());
				temp.setTckno(Long.parseLong(txtTck.getText()));
				temp.setMaas(txtMaas.getText());
				dao.delete(temp);
				Doldur();
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSil.setBounds(720, 164, 148, 35);
		getContentPane().add(btnSil);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilenId = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtIsim.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 1)));
				txtSoyisim.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 2)));
				txtMaas.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 3)));
				txtTck.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 4)));
				txtMaas.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 5)));

			}
		});
		
	}

	private JTable getTable_1() {
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Ýsim", "Soyisim", "Mevki", "TCKNo", "Maaþ" }) {
		});

		DbServicessBase<StaffModels> dao = new DbServicessBase<StaffModels>();
		StaffModels temp = new StaffModels();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { temp.getId(), temp.getIsim(), temp.getSoyisim(), temp.getMevki(), temp.getTckno(),
				temp.getMaas() });

		return table;

	}

	private void Doldur() {

		DbServicessBase<StaffModels> dao = new DbServicessBase<StaffModels>();
		StaffModels temp = new StaffModels();

		StaffDAO staffdao = new StaffDAO();
		List<StaffModels> liste = staffdao.getAllRows(new StaffModels());
		String[][] data = new String[liste.size()][11];
		String[] columns = { "ID", "Ýsim", "Soyisim", "Mevki", "TCKNo", "Maaþ" };
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = String.valueOf(liste.get(i).getIsim());
			data[i][2] = String.valueOf(liste.get(i).getSoyisim());
			data[i][3] = String.valueOf(liste.get(i).getMevki());
			data[i][4] = String.valueOf(liste.get(i).getTckno());
			data[i][5] = String.valueOf(liste.get(i).getMaas());

		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);

	}
}
