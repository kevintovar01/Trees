package avlTree;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InterfaceAvl extends JPanel implements ActionListener {
	private JTextField textField;
	AvlTree<Integer> tree = new AvlTree<>();
	int conta;

	/**
	 * Create the panel.
	 */
	public InterfaceAvl() {

		setBorder(null);

		JScrollPane frameScroll = new JScrollPane(this,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frameScroll.setLocation(15, 11);
		frameScroll.setSize(581, 547);
		// aqui se define el jframe donde se grafica los arbolesAVL

		JFrame.setDefaultLookAndFeelDecorated(false);
		JFrame JFrameAVL = new JFrame("AvlTree");
		JFrameAVL.setTitle("AvlTree");
		JFrameAVL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrameAVL.getContentPane().setLayout(null);
		JFrameAVL.getContentPane().add(frameScroll);
		JFrameAVL.setSize(1256, 660);
		JFrameAVL.setLocationRelativeTo(null);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tree = null;
				tree = new AvlTree<>();
				repaint();
			}
		});
		btnClear.setBounds(606, 45, 89, 42);
		JFrameAVL.getContentPane().add(btnClear);

		textField = new JTextField();
		textField.setBounds(209, 580, 183, 39);
		JFrameAVL.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				try {
					tree.removeNode(Integer.parseInt(textField.getText()));
					repaint();
					textField.setText("");
				} catch (Exception ex) {
					mostrarError("Por favor ingrese un valor");
				}

			}
		});
		btnDelete.setBounds(57, 580, 121, 39);
		JFrameAVL.getContentPane().add(btnDelete);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnInsert.setBounds(422, 580, 121, 39);
		JFrameAVL.getContentPane().add(btnInsert);
		JFrameAVL.setSize(732, 669);
		JFrameAVL.setLocationRelativeTo(null);

		JFrameAVL.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tree.insertNode(Integer.parseInt(textField.getText()));
		conta=1;
		repaint();
		textField.setText("");
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (conta==1) {
			tree.arbolPreordenGrap(tree.getRoot(), g);
		}
	}

	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
