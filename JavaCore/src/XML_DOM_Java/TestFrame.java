package XML_DOM_Java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestFrame extends JFrame {

	private static final String SPACE = "   ";

	/**
	 * ������� ��������� ����������.
	 */
	public static void createGUI() {
		final JFrame frame = new JFrame("Test frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Font font = new Font("Verdana", Font.PLAIN, 13);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		final JTextArea textArea = new JTextArea(15, 10);
		panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
		textArea.setFont(font);

		JButton parseButton = new JButton("Parse XML");
		parseButton.setFont(font);
		panel.add(parseButton, BorderLayout.SOUTH);

		parseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Document doc = getDocument();
					showDocument(doc, textArea);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage());
				}
			}
		});

		frame.getContentPane().add(panel);

		frame.setPreferredSize(new Dimension(280, 220));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * ���������� ������ Document, ������� �������� ��������� ��������������
	 * XML ���������.
	 */
	private static Document getDocument() throws Exception {
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			f.setValidating(false);
			DocumentBuilder builder = f.newDocumentBuilder();
			return builder.parse(new File("test_DOM.xml"));
		} catch (Exception exception) {
			String message = "XML parsing error!";
			throw new Exception(message);
		}
	}

	private static void showDocument(Document doc, JTextArea textArea) {
		StringBuffer content = new StringBuffer();
		Node node = doc.getChildNodes().item(0);
		ApplicationNode appNode = new ApplicationNode(node);

		content.append("Application \n");

		List<ClassNode> classes = appNode.getClasses();

		for (int i = 0; i < classes.size(); i++) {
			ClassNode classNode = classes.get(i);
			content.append(SPACE + "Class: " + classNode.getName() + " \n");

			List<MethodNode> methods = classNode.getMethods();

			for (int j = 0; j < methods.size(); j++) {
				MethodNode methodNode = methods.get(j);
				content.append(SPACE + SPACE + "Method: "
						+ methodNode.getName() + " \n");
			}
		}

		textArea.setText(content.toString());
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				createGUI();
			}
		});
	}

	/**
	 * ��������� ������������� ����������.
	 */
	public static class ApplicationNode {

		Node node;

		public ApplicationNode(Node node) {
			this.node = node;
		}

		public List<ClassNode> getClasses() {
			ArrayList<ClassNode> classes = new ArrayList<ClassNode>();

			/**
			 * �������� ������ �������� ����� ��� ������� ���� XML, �������
			 * ������������� ���������� application. ����� ����� �������������
			 * ��� ���� Node, ������ �� ������� �������� ���������
			 * �������������� ���� class ��� �������� ���� application.
			 */
			NodeList classNodes = node.getChildNodes();

			for (int i = 0; i < classNodes.getLength(); i++) {
				Node node = classNodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					/**
					 * ������� �� ������ Node ���� ��� ���������
					 * ������������� ������.
					 */
					ClassNode classNode = new ClassNode(node);
					classes.add(classNode);
				}
			}

			return classes;
		}

	}

	/**
	 * ��������� ������������� ������.
	 */
	public static class ClassNode {

		Node node;

		/**
		 * ������� ����� ��������� ������� �� ������ Node ����.
		 */
		public ClassNode(Node node) {
			this.node = node;
		}

		/**
		 * ���������� ������ ������� ������.
		 */
		public List<MethodNode> getMethods() {
			ArrayList<MethodNode> methods = new ArrayList<MethodNode>();

			/**
			 * �������� ������ �������� ����� ��� ������� ���� XML, 
			 * ������� ������������� ������ class. ����� ����� ������������� 
			 * ��� ���� Node, ������ �� ������� �������� ��������� 
			 * �������������� ���� method ��� �������� ���� class.
			 */
			NodeList methodNodes = node.getChildNodes();

			for (int i = 0; i < methodNodes.getLength(); i++) {
				node = methodNodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					/**
					 * ������� �� ������ Node ���� ��� ��������� �������������
					 * ������.
					 */
					MethodNode methodNode = new MethodNode(node);
					methods.add(methodNode);
				}
			}

			return methods;
		}

		/**
		 * ��������� ��� ������.
		 */
		public String getName() {

			/**
			 * �������� �������� ���� ������.
			 */
			NamedNodeMap attributes = node.getAttributes();

			/**
			 * �������� ���� ���������.
			 */
			Node nameAttrib = attributes.getNamedItem("name");

			/**
			 * ���������� �������� ��������.
			 */
			return nameAttrib.getNodeValue();
		}
	}

	/**
	 * ��������� ������������� �������� ����� ������.
	 */
	public static class MethodNode {

		Node node;

		/**
		 * ������� ����� ��������� ������� �� ������ Node ����.
		 */
		public MethodNode(Node node) {
			this.node = node;
		}

		/**
		 * ���������� ��� ������.
		 */
		public String getName() {

			/**
			 * �������� �������� ���� ������.
			 */
			NamedNodeMap attributes = node.getAttributes();

			/**
			 * �������� ���� ���������.
			 */
			Node nameAttrib = attributes.getNamedItem("name");

			/**
			 * ���������� �������� ��������.
			 */
			return nameAttrib.getNodeValue();
		}

	}

}
