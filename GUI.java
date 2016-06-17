
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JTextField;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	public GUI(String[] tagBefore, String[] tagAfter) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblHasBeenLoaded = new JLabel();
		lblHasBeenLoaded.setBounds(0, 22, 290, 14);
		
		JButton btnLoadInputFile = new JButton("Load Input File");
		btnLoadInputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname;
				fname = FileIO.openFileDialog("txt");
				lblHasBeenLoaded.setText(fname + " has been loaded.");
				Main.setContent(FileIO.readFile(fname));
			}
		});
		btnLoadInputFile.setBounds(0, 0, 521, 23);
		contentPane.add(btnLoadInputFile);
		contentPane.add(lblHasBeenLoaded);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 53, 521, 95);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblTagBeforeText = new JLabel("Tag before text");
		panel.add(lblTagBeforeText);
		
		final JComboBox comboBox = new JComboBox(tagBefore);
		panel.add(comboBox);
		
		JLabel lblTagAfterText = new JLabel("Tag after text");
		panel.add(lblTagAfterText);
		
		final JComboBox comboBox_1 = new JComboBox(tagAfter);
		panel.add(comboBox_1);
		
		JLabel lblTagIdentifier = new JLabel("Tag identifier");
		panel.add(lblTagIdentifier);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate txt file");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tagBefore = (String) comboBox.getSelectedItem();
				String tagAfter = (String) comboBox_1.getSelectedItem();
				String identifier = textField.getText();
				
				Main.generateTextFile(tagBefore,tagAfter,identifier);
			}
		});
		panel.add(btnGenerate);
	}
}
