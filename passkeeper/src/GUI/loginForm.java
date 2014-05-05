package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class loginForm {
	private static JTextField username;
	private static JTextField password;
	private JPanel contentPane;

	static LinkedList<String> credentials = new LinkedList<String>();

	@SuppressWarnings("resource")
	public void loadCredentials() throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("credent.txt"));
		
		String line = null;
		while ((line=br.readLine())!=null){
				credentials.add(line);
				System.out.println(credentials.toString());
		}
	}

	public loginForm() {

		final JFrame loginForm = new JFrame();

		loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginForm.setBounds(100, 100, 643, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginForm.setContentPane(contentPane);
		contentPane.setLayout(null);

		loginForm.getContentPane().setLayout(null);
		loginForm.setVisible(true);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(71, 41, 69, 14);
		contentPane.add(lblUsername);

		username = new JTextField();
		username.setBounds(71, 68, 305, 20);
		username.setColumns(10);
		contentPane.add(username);
		

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(71, 99, 46, 14);
		contentPane.add(lblPassword);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(71, 124, 305, 20);
		contentPane.add(password);
		
		

		try {
			loadCredentials();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(178, 180, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i =0;
				String user = username.getText();
				String pass = password.getText();
				
				for (i=0;i<credentials.size();i++){ 
					if(user.compareTo(credentials.get(i).split(" ")[0])==0)
						if(pass.compareTo(credentials.get(i).split(" ")[1])==0)
							System.out.println("Logged In");
						else
							System.out.println("Wrong pass");
				}
			}
		});
		

		//loginForm.add(contentPane);
		loginForm.setSize(575, 500);
		loginForm.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new loginForm();
	}
}
