import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ScrambleApp {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-160,501
	 */
	private final JLabel label = new JLabel("New label");
	private JTextField inputTextField;
	private JButton btnSubmit;
	private JTextArea textAreaOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrambleApp window = new ScrambleApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScrambleApp() {
		initialize();
		buttonEvent();
	}

	private void buttonEvent() {
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionInput();
			}
		});
		
	}
	
	public void actionInput() {
		String input = inputTextField.getText().toUpperCase();
		
		
		if (input.length() != 7) {
			textAreaOutput.setText("Please enter exactly 7 letters.");
		} 
		else if (!input.matches("[A-Z]{7}")) {
			textAreaOutput.setText("Please enter only letters!");
		}
		else {
			String output = "";
			for (int i = 0; i < input.length(); i++) {
				output += input.charAt(i);
			}
			textAreaOutput.setText(output);

		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputTextField = new JTextField();
		inputTextField.setHorizontalAlignment(SwingConstants.CENTER);
		inputTextField.setBounds(88, 28, 296, 44);
		frame.getContentPane().add(inputTextField);
		inputTextField.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(169, 132, 117, 29);
		frame.getContentPane().add(btnSubmit);
		
		textAreaOutput = new JTextArea();
		textAreaOutput.setBounds(55, 173, 355, 80);
		frame.getContentPane().add(textAreaOutput);
		textAreaOutput.setEditable(false);
	}
}
