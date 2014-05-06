package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import passwordLoader.passwordLoader;

public class viewPasswords {

	private JPanel contentPane;
	String[] title;
	LinkedList<String> credentials = new LinkedList<String>();
	private JComboBox<String> cmbContent;

	// Constructor
	public viewPasswords() {
		final JFrame vp = new JFrame();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		vp.setContentPane(contentPane);
		vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel userlbl = new JLabel("Username:");
		userlbl.setBounds(10, 50, 210, 30);
		contentPane.add(userlbl);

		final JTextArea usertxt = new JTextArea();
		usertxt.setBounds(10, 75, 210, 30);
		contentPane.add(usertxt);

		JLabel passlbl = new JLabel("Password:");
		passlbl.setBounds(10, 115, 210, 30);
		contentPane.add(passlbl);

		final JTextArea passtxt = new JTextArea();
		passtxt.setBounds(10, 140, 210, 30);
		contentPane.add(passtxt);

		// The size of the list with passwords
		passwordLoader.main(null);
		int length = passwordLoader.passwords.size();
		title = new String[length];
		for (int i = 0; i < length; i++) {
			title[i] = passwordLoader.passwords.get(i).split(" ")[2];
			credentials.add(passwordLoader.passwords.get(i).split(" ")[0] + " "
					+ passwordLoader.passwords.get(i).split(" ")[1]);
		}

		System.out.println(title.toString());
		System.out.println(credentials.toString());

		cmbContent = new JComboBox<String>(title);
		cmbContent.setBounds(10, 10, 210, 30);
		cmbContent.setSelectedIndex(-1);
		cmbContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i =0;
				for (i = 0; i < title.length; i++) {
					if(title[i].compareTo((String) cmbContent.getSelectedItem())==0)
						break;
				}
				usertxt.setText(credentials.get(i).split(" ")[0]);
				passtxt.setText(credentials.get(i).split(" ")[1]);
			}
		});
		contentPane.add(cmbContent);

		vp.setSize(250, 250);
		vp.setVisible(true);

	}

	// Call the Constructor
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new viewPasswords();
	}

}
