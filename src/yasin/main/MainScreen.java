package yasin.main;

import javax.swing.JFrame;

import yasin.ui.accounting.management.AccountingMainScreen;
import yasin.ui.car.management.CarScreen;
import yasin.ui.staff.management.StaffScreen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {
	public MainScreen() {
		setTitle("Mak Cars Y\u00F6netim Ekran\u0131");
		setBounds(500, 500, 630, 388);
		getContentPane().setLayout(null);
		
		JButton btnEkle = new JButton("Ara\u00E7 Y\u00F6netimi");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CarScreen().setVisible(true);
				dispose();
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEkle.setBounds(10, 11, 200, 67);
		getContentPane().add(btnEkle);
		
		JButton btnMuhasebe = new JButton("Muhasebe Y\u00F6netimi");
		btnMuhasebe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccountingMainScreen().setVisible(true);
				dispose();
			}
		});
		btnMuhasebe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMuhasebe.setBounds(404, 11, 200, 67);
		getContentPane().add(btnMuhasebe);
		
		JButton btnPersonel = new JButton("Personel Y\u00F6netimi");
		btnPersonel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPersonel.setBounds(10, 270, 200, 67);
		getContentPane().add(btnPersonel);
		btnPersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffScreen().setVisible(true);
				dispose();
			}
		});
		
		JButton btnCikis = new JButton("\u00C7IKI\u015E");
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCikis.setBounds(404, 270, 200, 67);
		getContentPane().add(btnCikis);
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		JButton btnResim = new JButton("New button");
		btnResim.setBounds(212, 83, 188, 183);
		getContentPane().add(btnResim);
		btnResim.setIcon(new ImageIcon(
				"Photos\\bmw.png"));
	}
}
