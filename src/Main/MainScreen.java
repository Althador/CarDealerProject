package Main;

import javax.swing.JFrame;

import Car.Management.CarScreen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {
	public MainScreen() {
		setTitle("Mak Cars Y\u00F6netim Ekran\u0131");
		setBounds(500, 500, 630, 387);
		getContentPane().setLayout(null);
		
		JButton btnEkle = new JButton("Ara\u00E7 Y\u00F6netimi");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CarScreen().setVisible(true);
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEkle.setBounds(10, 11, 200, 67);
		getContentPane().add(btnEkle);
		
		JButton btnMuhasebe = new JButton("Muhasebe Y\u00F6netimi");
		btnMuhasebe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMuhasebe.setBounds(404, 11, 200, 67);
		getContentPane().add(btnMuhasebe);
		
		JButton btnPersonel = new JButton("Personel Y\u00F6netimi");
		btnPersonel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPersonel.setBounds(10, 270, 200, 67);
		getContentPane().add(btnPersonel);
		
		JButton btnCikis = new JButton("\u00C7IKI\u015E");
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCikis.setBounds(404, 270, 200, 67);
		getContentPane().add(btnCikis);
		
		JButton btnResim = new JButton("New button");
		btnResim.setBounds(212, 83, 188, 183);
		getContentPane().add(btnResim);
		btnResim.setIcon(new ImageIcon(
				"C:\\Users\\pc\\Desktop\\JAVA\\yasinmurat\\workspace1\\MakCarDealer\\Photos\\bmw.png"));
	}
}
