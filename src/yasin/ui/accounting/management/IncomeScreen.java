package yasin.ui.accounting.management;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import yasin.dao.CarsDAO;
import yasin.dao.DbServicessBase;
import yasin.dao.IncomeDAO;
import yasin.main.MainScreen;
import yasin.models.CarModels;
import yasin.models.IncomeModels;
import yasin.models.StaffModels;
import yasin.utils.MyUtil;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class IncomeScreen extends JFrame {
	private JTable table;
	private JTextField txtId;
	private JTextField txtMiktar;
	private JTextField txtTanim;
	private Long secilenId;

	public IncomeScreen() {
		DbServicessBase<IncomeModels> dao = new DbServicessBase<IncomeModels>();
		IncomeModels temp = new IncomeModels();
		initialize();
	}

	private void initialize() {
		setBounds(500, 500, 405, 558);
		getContentPane().setLayout(null);

		JComboBox cmbSorumlu = new JComboBox();
		cmbSorumlu.setBounds(220, 474, 167, 20);
		getContentPane().add(cmbSorumlu);
		
		DbServicessBase<StaffModels> dao = new DbServicessBase<StaffModels>();
		StaffModels staff = new StaffModels();
		List<StaffModels> personel = dao.getAllRows(new StaffModels());
		
		cmbSorumlu.setModel(new DefaultComboBoxModel(personel.toArray()));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 377, 350);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(getTable_1());

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		JButton btnEkle = new JButton("Gelir Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DbServicessBase<IncomeModels> dao = new DbServicessBase<IncomeModels>();
				IncomeModels temp = new IncomeModels();

				temp.setMiktar(txtMiktar.getText());
				temp.setTanim(txtTanim.getText());
				temp.setSorumlukisi(cmbSorumlu.getSelectedItem().toString());
				dao.save(temp);
				Doldur();

			}
		});
		btnEkle.setBounds(10, 372, 100, 23);
		getContentPane().add(btnEkle);

		JButton btnSil = new JButton("Gelir Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<IncomeModels> dao = new DbServicessBase<IncomeModels>();
				IncomeModels temp = new IncomeModels();

				temp.setId(secilenId);
				temp.setMiktar(txtMiktar.getText());
				temp.setTanim(txtTanim.getText());
				temp.setSorumlukisi(cmbSorumlu.getSelectedItem().toString());
				dao.delete(temp);
				Doldur();
			}
		});
		btnSil.setBounds(10, 406, 100, 23);
		getContentPane().add(btnSil);

		JButton btnGuncelle = new JButton("Gelir G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DbServicessBase<IncomeModels> dao = new DbServicessBase<IncomeModels>();
				IncomeModels temp = new IncomeModels();

				temp.setMiktar(txtMiktar.getText());
				temp.setTanim(txtTanim.getText());
				temp.setSorumlukisi(cmbSorumlu.getSelectedItem().toString());
				dao.update(temp);
				Doldur();
			}

		});
		btnGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuncelle.setBounds(10, 440, 100, 23);
		getContentPane().add(btnGuncelle);

		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen m = new MainScreen();
				m.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBounds(10, 474, 100, 23);
		getContentPane().add(btnCikis);

		txtId = new JTextField();
		txtId.setText("Otomatik Verilecektir.");
		txtId.setEditable(false);
		txtId.setBounds(220, 372, 167, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		txtMiktar = new JTextField();
		txtMiktar.setColumns(10);
		txtMiktar.setBounds(220, 406, 167, 20);
		getContentPane().add(txtMiktar);

		txtTanim = new JTextField();
		txtTanim.setColumns(10);
		txtTanim.setBounds(220, 440, 167, 20);
		getContentPane().add(txtTanim);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(155, 372, 55, 14);
		getContentPane().add(lblId);

		JLabel lblMiktar = new JLabel("Miktar");
		lblMiktar.setBounds(155, 406, 55, 14);
		getContentPane().add(lblMiktar);

		JLabel lblTanim = new JLabel("Tan\u0131m");
		lblTanim.setBounds(155, 440, 55, 14);
		getContentPane().add(lblTanim);

		JLabel lblSorumlu = new JLabel("Sorumlu");
		lblSorumlu.setBounds(155, 474, 55, 14);
		getContentPane().add(lblSorumlu);

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

		DbServicessBase<IncomeModels> dao = new DbServicessBase<IncomeModels>();
		IncomeModels temp = new IncomeModels();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { temp.getId(), temp.getMiktar(), temp.getTanim(), temp.getSorumlukisi() });

		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);

		return table;

	}

	private void Doldur() {

		DbServicessBase<IncomeModels> dao = new DbServicessBase<IncomeModels>();
		IncomeModels temp = new IncomeModels();

		IncomeDAO incomedao = new IncomeDAO();
		List<IncomeModels> liste = incomedao.getAllRows(new IncomeModels());
		String[][] data = new String[liste.size()][3];
		String[] columns = { "ID", "Miktar", "Taným"};
		for (int i = 0; i < liste.size(); i++) {
			data[i][0] = String.valueOf(liste.get(i).getId());
			data[i][1] = String.valueOf(liste.get(i).getMiktar());
			data[i][2] = String.valueOf(liste.get(i).getTanim());


		}
		DefaultTableModel model = new DefaultTableModel(data, columns);
		table.setModel(model);

	}
}
