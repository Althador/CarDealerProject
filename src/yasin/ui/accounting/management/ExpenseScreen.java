package yasin.ui.accounting.management;

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

import yasin.dao.DbServicessBase;
import yasin.main.MainScreen;
import yasin.models.ExpenseModels;
import yasin.models.StaffModels;
import yasin.utils.MyUtil;

public class ExpenseScreen extends JFrame {
	private JTable table;
	private JTextField txtId;
	private JTextField txtMiktar;
	private JTextField txtTanim;
	private Long secilenId;

	public ExpenseScreen() {
		DbServicessBase<ExpenseModels> dao = new DbServicessBase<ExpenseModels>();
		ExpenseModels temp = new ExpenseModels();
		initialize();
	}

	private void initialize() {
		setBounds(700, 200, 476, 581);
		getContentPane().setLayout(null);

		JComboBox cmbSorumlu = new JComboBox();
		cmbSorumlu.setBounds(283, 474, 167, 20);
		getContentPane().add(cmbSorumlu);
		
		DbServicessBase<StaffModels> dao = new DbServicessBase<StaffModels>();
		StaffModels staff = new StaffModels();
		List<StaffModels> personel = dao.getAllRows(new StaffModels());
		
		cmbSorumlu.setModel(new DefaultComboBoxModel(personel.toArray()));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 440, 350);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(getTable_1());

		JButton btnEkle = new JButton("Gider Ekle");
		btnEkle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DbServicessBase<ExpenseModels> dao = new DbServicessBase<ExpenseModels>();
				ExpenseModels temp = new ExpenseModels();

				temp.setMiktar(txtMiktar.getText());
				temp.setTanim(txtTanim.getText());
				temp.setSorumlukisi(cmbSorumlu.getSelectedItem().toString());
				dao.save(temp);
				Doldur();

			}
		});
		btnEkle.setBounds(10, 372, 125, 23);
		getContentPane().add(btnEkle);

		JButton btnSil = new JButton("Gider Sil");
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<ExpenseModels> dao = new DbServicessBase<ExpenseModels>();
				ExpenseModels temp = new ExpenseModels();

				temp.setId(secilenId);
				temp.setMiktar(txtMiktar.getText());
				temp.setTanim(txtTanim.getText());
				temp.setSorumlukisi(cmbSorumlu.getSelectedItem().toString());
				dao.delete(temp);
				Doldur();
			}
		});
		btnSil.setBounds(10, 406, 125, 23);
		getContentPane().add(btnSil);

		JButton btnGuncelle = new JButton("Gider G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DbServicessBase<ExpenseModels> dao = new DbServicessBase<ExpenseModels>();
				ExpenseModels temp = new ExpenseModels();

				temp.setMiktar(txtMiktar.getText());
				temp.setTanim(txtTanim.getText());
				temp.setSorumlukisi(cmbSorumlu.getSelectedItem().toString());
				dao.update(temp);
				Doldur();
			}

		});
		btnGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuncelle.setBounds(10, 440, 125, 23);
		getContentPane().add(btnGuncelle);

		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen m = new MainScreen();
				m.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBounds(10, 508, 125, 23);
		getContentPane().add(btnCikis);

		txtId = new JTextField();
		txtId.setText("Otomatik Verilecektir.");
		txtId.setEditable(false);
		txtId.setBounds(283, 372, 167, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtMiktar = new JTextField();
		txtMiktar.setColumns(10);
		txtMiktar.setBounds(283, 406, 167, 20);
		getContentPane().add(txtMiktar);

		txtTanim = new JTextField();
		txtTanim.setColumns(10);
		txtTanim.setBounds(283, 440, 167, 20);
		getContentPane().add(txtTanim);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(218, 372, 55, 14);
		getContentPane().add(lblId);

		JLabel lblMiktar = new JLabel("Miktar");
		lblMiktar.setBounds(218, 406, 55, 14);
		getContentPane().add(lblMiktar);

		JLabel lblTanim = new JLabel("Tan\u0131m");
		lblTanim.setBounds(218, 440, 55, 14);
		getContentPane().add(lblTanim);

		JLabel lblSorumlu = new JLabel("Sorumlu");
		lblSorumlu.setBounds(218, 474, 55, 14);
		getContentPane().add(lblSorumlu);
		
		JButton btnDoldur = new JButton("Verileri Getir");
		btnDoldur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDoldur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doldur();
			}
		});
		btnDoldur.setBounds(10, 474, 125, 23);
		getContentPane().add(btnDoldur);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				secilenId = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtMiktar.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 1)));
				txtTanim.setText(MyUtil.getValue(table.getValueAt(table.getSelectedRow(), 2)));
			}
		});
	}

	private JTable getTable_1() {
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Miktar", "Taným", "Sorumlu" }) {
		});

		DbServicessBase<ExpenseModels> dao = new DbServicessBase<ExpenseModels>();
		ExpenseModels temp = new ExpenseModels();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { temp.getId(), temp.getMiktar(), temp.getTanim(), temp.getSorumlukisi() });

		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		return table;

	}
	private void Doldur() {

		DbServicessBase<ExpenseModels> dao = new DbServicessBase<ExpenseModels>();
		ExpenseModels temp = new ExpenseModels();

		List<ExpenseModels> liste = dao.getAllRows(new ExpenseModels());
		String[][] data = new String[liste.size()][4];
		String[] columns = { "ID", "Miktar", "Taným", "Sorumlu"};
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = String.valueOf(liste.get(i).getMiktar());
			data[i][2] = String.valueOf(liste.get(i).getTanim());
			data[i][3] = String.valueOf(liste.get(i).getSorumlukisi());


		}
		DefaultTableModel model1 = new DefaultTableModel(data, columns);
		table.setModel(model1);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		
	}
}
