package avlTree;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Canvas;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class Interface extends JFrame implements ActionListener {

	private TextField textField;
	private JPanel contentPane;
	private Canvas canvas;

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
		

		
		canvas = new Canvas();
		canvas.setBounds(0, 0, 150, 100);
		
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
	
	public void paint(Graphics g) {
		super.paint(g);
 		if(node.getValue() != null) {
			tree.getRoot().arbolPreordenGrap(node, g, tree.getRoot());
		}
	}
}
