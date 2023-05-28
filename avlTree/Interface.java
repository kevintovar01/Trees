package avlTree;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class Interface extends JFrame implements ActionListener {

	private TextField textField;
	private JPanel contentPane;

	AvlTree<Integer> tree = new AvlTree<>();
	AvlNode<Integer> node = new AvlNode<>(null, null);
	
	
	
	public Interface() {
		setTitle("AvlTree");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewInsert = new JButton("Insert");
		btnNewInsert.setBounds(55, 427, 89, 23);
		contentPane.add(btnNewInsert);
		
		JButton btnNewDelete = new JButton("Delete");
		btnNewDelete.setBounds(283, 427, 89, 23);
		contentPane.add(btnNewDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 38, 317, 378);
		contentPane.add(scrollPane);
		
		Canvas canvas = new Canvas();
		scrollPane.setRowHeaderView(canvas);
		
		TextField textField = new TextField();
		textField.setBounds(174, 427, 81, 22);
		contentPane.add(textField);
		
		Button button = new Button("clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(388, 49, 70, 22);
		contentPane.add(button);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(node.getValue() == null) {
			node.setValue(Integer.parseInt(textField.getText()));
			tree.addNode(node);
		}else {			
			tree.insertNode(new AvlNode<>(Integer.parseInt(textField.getText())));
		}
		
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		if(node.getValue() == null) {
			tree.getRoot().arbolPreordenGrap(tree);
		}
	}
}
