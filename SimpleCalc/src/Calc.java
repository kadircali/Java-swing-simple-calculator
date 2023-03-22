import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calc extends JFrame {

	private JPanel contentPane;
	private JTextField txt_one;
	private JTextField txt_two;
	private JTextField txt_result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public float check(float n1,float n2,Object o)
	{
		
		float result=0;
		
		if(o.equals("+"))
			result = n1+n2;
		else if(o.equals("-"))
			result=n1-n2;
		else if (o.equals("*"))
			result=n1*n2;
		else if(o.equals("/"))
			result=n1/n2;
		else if(o.equals("%"))
			result=n1%n2;
			
		
		return result;
	}
	
	
	/**
	 * Create the frame.
	 */
	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_one = new JTextField();
		txt_one.setBounds(130, 70, 246, 38);
		contentPane.add(txt_one);
		txt_one.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Number 1:");
		lblNewLabel.setBounds(51, 72, 59, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumber = new JLabel("Number 2:");
		lblNumber.setBounds(51, 194, 59, 35);
		contentPane.add(lblNumber);
		
		txt_two = new JTextField();
		txt_two.setColumns(10);
		txt_two.setBounds(130, 192, 246, 38);
		contentPane.add(txt_two);
		
		JLabel lblNewLabel_1 = new JLabel("Operator:");
		lblNewLabel_1.setBounds(51, 131, 59, 35);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cb_operator = new JComboBox();
		cb_operator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cb_operator.setModel(new DefaultComboBoxModel(new String[] {" ", "+", "-", "*", "/", "%"}));
		cb_operator.setBounds(130, 137, 246, 22);
		contentPane.add(cb_operator);
		
		JLabel lblNewLabel_2 = new JLabel("Result:");
		lblNewLabel_2.setBounds(51, 293, 59, 35);
		contentPane.add(lblNewLabel_2);
		
		txt_result = new JTextField();
		txt_result.setBounds(130, 293, 246, 27);
		contentPane.add(txt_result);
		txt_result.setColumns(10);
		
		JButton btn_calc = new JButton("Calculate");
		btn_calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float n1=0;
				float n2=0;
				float result=0;
				
				
				
				try {
					 n1 = Float.parseFloat(txt_one.getText());
					 n2 = Float.parseFloat(txt_two.getText());
					 Object operator = cb_operator.getSelectedItem();
					 result= check(n1, n2, operator);
					 txt_result.setText(Float.toString(result));
				} catch (Exception e2) {
					txt_result.setText("error");
				}
				
				
				
				
				
			}
		});
		btn_calc.setBounds(131, 253, 243, 23);
		contentPane.add(btn_calc);
		
		JLabel lbl_error = new JLabel("");
		lbl_error.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_error.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_error.setBounds(130, 21, 246, 38);
		contentPane.add(lbl_error);
	}
}
