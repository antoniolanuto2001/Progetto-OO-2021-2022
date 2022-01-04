package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.MonthDay;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Controller.Controller;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Register extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private Controller controller;
	private JTextField NomeField;
	private JTextField CognomeField;
	private JTextField CodfiscaleField;
	private JTextField Emailfield;
	private JTextField PasswordField;
	/**
	 * Create the frame.
	 */
	public Register(Controller c,JFrame frameChiamante) 
	{
		frame=this;
		controller=c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 800);
		ImageIcon logo = new ImageIcon(this.getClass().getResource("/logoPrincipale.png"));
		frame.setIconImage(logo.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 255));
		panel.setBounds(0, 0, 1064, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel PanelViewInformation = new JPanel();
		PanelViewInformation.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(65, 105, 225), new Color(123, 104, 238)));
		PanelViewInformation.setForeground(new Color(173, 216, 230));
		PanelViewInformation.setBackground(new Color(135, 206, 250));
		PanelViewInformation.setBounds(355, 27, 275, 71);
		panel.add(PanelViewInformation);
		PanelViewInformation.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'> Register View </div></html>");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(85, 11, 108, 45);
		PanelViewInformation.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		
		JButton IndietroButton = new JButton("Indietro");
		IndietroButton.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		IndietroButton.setVerticalAlignment(SwingConstants.TOP);
		IndietroButton.setBounds(860, 27, 149, 57);
		panel.add(IndietroButton);
		ImageIcon imgAccopuIcon = new ImageIcon(this.getClass().getResource("/backIcona.png"));
		IndietroButton.setIcon(imgAccopuIcon);
		
		JPanel PanelRegistrazione = new JPanel();
		PanelRegistrazione.setBackground(Color.WHITE);
		PanelRegistrazione.setBounds(0, 126, 1064, 635);
		contentPane.add(PanelRegistrazione);
		PanelRegistrazione.setLayout(null);
		
		JPanel FormRegistrazione = new JPanel();
		FormRegistrazione.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(123, 104, 238), new Color(100, 149, 237)));
		FormRegistrazione.setBackground(new Color(204, 204, 255));
		FormRegistrazione.setBounds(258, 92, 523, 520);
		PanelRegistrazione.add(FormRegistrazione);
		FormRegistrazione.setLayout(null);
		
		JLabel NomeLabel = new JLabel("<html><body style='text-align: center;'> Nome : </body></html>");
		NomeLabel.setBounds(60, 58, 73, 27);
		NomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		FormRegistrazione.add(NomeLabel);
		
		NomeField = new JTextField();
		NomeField.setBounds(110, 59, 293, 29);
		NomeField.setFont(new Font("Tahoma", Font.BOLD, 13));
		NomeField.setColumns(10);
		FormRegistrazione.add(NomeField);
		
		JLabel CognomeLabel = new JLabel("Cognome :");
		CognomeLabel.setBounds(35, 96, 82, 30);
		FormRegistrazione.add(CognomeLabel);
		CognomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		CognomeField = new JTextField();
		CognomeField.setBounds(110, 96, 293, 29);
		FormRegistrazione.add(CognomeField);
		CognomeField.setFont(new Font("Tahoma", Font.BOLD, 13));
		CognomeField.setColumns(10);
		
		JLabel CodFiscaleLabel = new JLabel("CodFiscale : ");
		CodFiscaleLabel.setBounds(35, 140, 82, 29);
		FormRegistrazione.add(CodFiscaleLabel);
		CodFiscaleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		CodfiscaleField = new JTextField();
		CodfiscaleField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int position=CodfiscaleField.getCaretPosition();
				CodfiscaleField.setText(CodfiscaleField.getText().toUpperCase());
				CodfiscaleField.setCaretPosition(position);
			}
		});
		
		CodfiscaleField.setBounds(110, 136, 293, 29);
		FormRegistrazione.add(CodfiscaleField);
		CodfiscaleField.setFont(new Font("Segoe UI", Font.BOLD, 13));
		CodfiscaleField.setColumns(10);
		
		JLabel DataDiNascitaLabel = new JLabel("Data Di Nascita :");
		DataDiNascitaLabel.setBounds(19, 180, 107, 29);
		FormRegistrazione.add(DataDiNascitaLabel);
		DataDiNascitaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		String spinnerRiferimentoString= String.valueOf(java.time.Year.now());
	    int YearGraficoSpinner=Integer.parseInt(spinnerRiferimentoString);
		SpinnerModel model1=new SpinnerNumberModel(1,1,31,1);
		SpinnerModel model2=new SpinnerNumberModel(1,1,12,1);
		SpinnerModel model3=new SpinnerNumberModel(2003,1900,YearGraficoSpinner,1);
		JSpinner GiornoSpinner = new JSpinner(model1);
		GiornoSpinner.setBounds(122, 208, 44, 29);
		FormRegistrazione.add(GiornoSpinner);
		
		JSpinner MeseSpinner = new JSpinner(model2);
		MeseSpinner.setBounds(216, 208, 44, 29);
		FormRegistrazione.add(MeseSpinner);
		
		JSpinner YearSpinner = new JSpinner(model3);
		YearSpinner.setBounds(311, 208, 67, 29);
		FormRegistrazione.add(YearSpinner);
		
		JLabel GiornoLabel = new JLabel("Giorno :");
		GiornoLabel.setBounds(120, 183, 46, 14);
		FormRegistrazione.add(GiornoLabel);
		
		JLabel MeseLabel = new JLabel("Mese :");
		MeseLabel.setBounds(216, 183, 46, 14);
		FormRegistrazione.add(MeseLabel);
		
		JLabel YearLabel = new JLabel("Anno :");
		YearLabel.setBounds(311, 183, 46, 14);
		FormRegistrazione.add(YearLabel);
		
		JLabel EmailLabel = new JLabel("Email :");
		EmailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		EmailLabel.setBounds(65, 242, 57, 27);
		FormRegistrazione.add(EmailLabel);
		
		Emailfield = new JTextField();
		
		Emailfield.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Emailfield.setBounds(110, 242, 293, 29);
		FormRegistrazione.add(Emailfield);
		Emailfield.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password : ");
		PasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		PasswordLabel.setBounds(40, 280, 67, 27);
		FormRegistrazione.add(PasswordLabel);
		
		PasswordField = new JTextField();
		PasswordField.setToolTipText("la password deve contenere un carattere speciale una maiuscola un numero e una minuscola");
		PasswordField.setBounds(110, 280, 293, 29);
		FormRegistrazione.add(PasswordField);
		PasswordField.setColumns(10);
		
		ButtonGroup docenteStudenteButtonGroup = new ButtonGroup();
		JCheckBox StudenteCheckBox = new JCheckBox("Studente");
		
		StudenteCheckBox.setBackground(new Color(204, 204, 255));
		StudenteCheckBox.setBounds(110, 316, 107, 27);
		docenteStudenteButtonGroup.add(StudenteCheckBox);
		FormRegistrazione.add(StudenteCheckBox);
		
		JCheckBox DocenteCheckBox = new JCheckBox("Docente");
		
		
		DocenteCheckBox.setBackground(new Color(204, 204, 255));
		DocenteCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DocenteCheckBox.setBounds(251, 316, 116, 27);
		docenteStudenteButtonGroup.add(DocenteCheckBox);
		FormRegistrazione.add(DocenteCheckBox);
		
		
		String [] Dipartimenti = new String[50];
		controller.Recuperadipartimenti(Dipartimenti);
		
		JComboBox DiparmenticomboBox = new JComboBox(Dipartimenti);
		DiparmenticomboBox.setBackground(Color.WHITE);
		DiparmenticomboBox.setBounds(110, 350, 293, 27);
		FormRegistrazione.add(DiparmenticomboBox);
		
		JButton SubmitButton = new JButton("Iscriviti");
		
		
		SubmitButton.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		SubmitButton.setBounds(189, 457, 116, 41);
		FormRegistrazione.add(SubmitButton);
		String [] CorsoDilaurea = new String[50];
		controller.RecuperaCDL(CorsoDilaurea);
		
		JComboBox CorsoDiLaureaComboBox = new JComboBox(CorsoDilaurea);
		CorsoDiLaureaComboBox.setVisible(false);
		CorsoDiLaureaComboBox.setBackground(Color.WHITE);
		CorsoDiLaureaComboBox.setBounds(110, 388, 293, 27);
		CorsoDiLaureaComboBox.setEditable(true);
		FormRegistrazione.add(CorsoDiLaureaComboBox);
		
		String[] maschioFemminaString= {"M", "F","N"};
		JComboBox SessoComboBox = new JComboBox(maschioFemminaString);
		SessoComboBox.setForeground(Color.BLACK);
		SessoComboBox.setBounds(441, 244, 44, 24);
		FormRegistrazione.add(SessoComboBox);
		
		JLabel SessoLabel = new JLabel("Sesso : ");
		SessoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SessoLabel.setBounds(441, 223, 46, 14);
		FormRegistrazione.add(SessoLabel);
		StudenteCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(StudenteCheckBox.isSelected())
				{
					CorsoDiLaureaComboBox.setVisible(true);
				}
				
			}
		});
		DocenteCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(DocenteCheckBox.isSelected())
				{
					CorsoDiLaureaComboBox.setVisible(false);
				}
				
			}
		});
		SubmitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				Boolean passBoolean=isValid((String)PasswordField.getText());
				Boolean emailBoolean=isValidEmail((String)Emailfield.getText());;
				if(passBoolean==false)
				{
					JOptionPane.showMessageDialog(null,"Passowrd Invalida","Errore Password",JOptionPane.INFORMATION_MESSAGE);
				}
				else if (emailBoolean==false)
				{
					JOptionPane.showMessageDialog(null,"Email Invalida","Errore email",JOptionPane.INFORMATION_MESSAGE);
				}
				else 
				{
					if(StudenteCheckBox.isSelected())
					{
						
					}
					else if(DocenteCheckBox.isSelected())
					{
						
					}
				}
			}
		});
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frameChiamante.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}
	public boolean isValidEmail(String passwordhere) {

	    Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	    boolean flag=true;
	    if (!specailCharPatten.matcher(passwordhere).find()) {
	    	//System.out.println("Password must have atleast one specail character !!");
	        flag=false;
	    }
	    return flag;
	}
	    public boolean isValid(String passwordhere) {

	    Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	    Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
	    boolean flag=true;

	    if (passwordhere.length() < 8) 
	    {
	        //System.out.println("Password lenght must have alleast 8 character !!");
	        flag=false;
	    }
	    if (!specailCharPatten.matcher(passwordhere).find()) {
	    	//System.out.println("Password must have atleast one specail character !!");
	        flag=false;
	    }
	    if (!UpperCasePatten.matcher(passwordhere).find()) {
	    	//System.out.println("Password must have atleast one uppercase character !!");
	        flag=false;
	    }
	    if (!lowerCasePatten.matcher(passwordhere).find()) {
	    	//System.out.println("Password must have atleast one lowercase character !!");
	        flag=false;
	    }
	    if (!digitCasePatten.matcher(passwordhere).find()) {
	    	//System.out.println("Password must have atleast one digit character !!");
	        flag=false;
	    }

	    return flag;

	}
}

