import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ScrambleApp {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-160,501
	 */
	private final JLabel label = new JLabel("New label");
	private JTextField inputTextField;
	private JButton btnSubmit;
	private JTextArea textAreaOutput;

	private String s;
    private String permuteFinal;
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
		s = inputTextField.getText().toUpperCase().trim();
		//TASK 1: VALIDATE INPUT
        if (s.length() != 7) {
            JOptionPane.showMessageDialog(frame, "Error: Please enter exactly 7 letters.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!s.matches("[A-Z]+")) {
            JOptionPane.showMessageDialog(frame, "Error: Input must contain only letters.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TASK 2: PROCESS THE INPUT
        buildOutput();
	}

	 private void buildOutput() {
		 //TASK 1: INITIALIZE THE WORD
		 ScrambleAppMain scrambleWord = new ScrambleAppMain();
		 //TASK 2: CALL FUNCTION 
		 String outPut = scrambleWord.generateAllPermutations(s);
		 //TASK 3: DISPLAY OUTPUT
		 textAreaOutput.setText(outPut);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 188, 363, 78);
		frame.getContentPane().add(scrollPane);
		
		textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
	}
}
