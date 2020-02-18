package yasin.ui.accounting.management;

import javax.swing.JFrame;

import yasin.main.MainScreen;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountingMainScreen extends JFrame{
	public AccountingMainScreen() {
		setTitle("Muhasebe Ana Ekran\u0131");
		getContentPane().setLayout(null);
		setBounds(500, 500, 452, 293);
		
		JButton btnGelir = new JButton("Gelirleri G\u00F6r!");
		btnGelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IncomeScreen().setVisible(true);
				dispose();
			}
		});
		btnGelir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGelir.setBounds(10, 58, 176, 135);
		getContentPane().add(btnGelir);
		
		JButton btnGiderleriGr = new JButton("Giderleri G\u00F6r!");
		btnGiderleriGr.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGiderleriGr.setBounds(256, 58, 176, 135);
		getContentPane().add(btnGiderleriGr);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F Yap!");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainScreen().setVisible(true);
				dispose();
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCikis.setBounds(10, 217, 422, 29);
		getContentPane().add(btnCikis);
	}

}
