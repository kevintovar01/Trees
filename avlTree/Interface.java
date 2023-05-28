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
import javax.swing.ScrollPaneConstants;

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

		JScrollPane scrollPane = new JScrollPane(this,
		ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(55, 38, 317, 378);
		contentPane.add(scrollPane);
		
		JButton btnNewInsert = new JButton("Insert");
		btnNewInsert.addActionListener(this);
		btnNewInsert.setBounds(55, 427, 89, 23);
		contentPane.add(btnNewInsert);
		
		JButton btnNewDelete = new JButton("Delete");
		btnNewDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent d) {
        		tree.removeNode(Integer.parseInt(textField.getText()));
				repaint();
        		textField.setText("");
        		
        	}
        });
		btnNewDelete.setBounds(283, 427, 89, 23);
		contentPane.add(btnNewDelete);
		

		
		Canvas canvas = new Canvas();
		scrollPane.setRowHeaderView(canvas);
		
		TextField textField = new TextField();
		textField.setBounds(174, 427, 81, 22);
		contentPane.add(textField);
		
		Button button = new Button("clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tree= null;
				node=null;
				tree = new AvlTree<>();
				node = new AvlNode<>(null, null);
				repaint();
			}
		});
		button.setBounds(388, 49, 70, 22);
		contentPane.add(button);
	}


	@Override //al insertar
	public void actionPerformed(ActionEvent e) {
		if(node.getValue() == null) {
			node.setValue(Integer.parseInt(textField.getText()));
			tree.addNode(node);
		}else {		
			tree.insertNode(Integer.parseInt(textField.getText()));
		}
		textField.setText("");
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		if(node.getValue() == null) {
			tree.getRoot().arbolPreordenGrap(node, g, tree.getRoot());
		}
	}
}
