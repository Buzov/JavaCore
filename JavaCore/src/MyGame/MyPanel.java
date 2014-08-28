package MyGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	public String wordSteck;
	public List<String> wordsList;
	public int wordsNumber = 0;// ����� ���������� ����� �� �������
	public String fileFromName;// ������-���� � �����
	public String[] words;
	public String word;
	public int lengthWord;// ����� ���������� �����
	// public String wordArray="";
	public JTextField textInput;// ������ ����������� �����
	public JLabel textInputLabel, cahrInputLabel;
	public JButton pickFileButton; // ������ ������ ���� � ����� �� ������� ����
	public JTextField pathFile;// ���������� ���� � �����
	private JFileChooser file;
	public JButton startButton, test;// ������ ����
	public JButton inputButton;// ������ ����� ����
	public JButton exitButton;// ������ ������
	public int lengthDrawRoundRect;
	private static List<JLabel> labels = new ArrayList<JLabel>();
	public int gameOver = 0;
	public int gameWinner = 0;
	private int lengthLabelList = 0;// ������ ������� ��� ��������� �����
	public int index = 0;
	public int errorInput = 0;
	public int[] wordProverca;// ������ ��� �������� ��� ��������� ����

	public Font f = new Font("", Font.ITALIC, 25);

	// Action inputAction=new MyActionInput();

	public void paintComponent(Graphics g) {

		super.paintComponent(g);// ���������� ����� ����� �������� �������������
								// � ����
		g.setColor(Color.red);// ��������� �����
		int x1 = 22, y1 = 22, dx = 44, dy = 66, rx = 35, ry = 35; // �������
																	// ���������������
		for (int i = 0; i < lengthDrawRoundRect; i++) {
			g.drawRoundRect(x1 + i * 50, y1, dx, dy, rx, ry);// ������
																// �����������
																// ��������������
		}

		if (errorInput == 0) {
			g.drawLine(300, 100, 300, 250);// ������������ �����
			g.drawLine(280, 250, 320, 250);// ��������� ��������
			g.drawLine(300, 100, 380, 100);// �����������
			g.drawLine(380, 100, 380, 120);
		}// �������
		else if (errorInput == 1) {
			g.drawLine(300, 100, 300, 250);// ������������ �����
			g.drawLine(280, 250, 320, 250);// ��������� ��������
			g.drawLine(300, 100, 380, 100);// �����������
			g.drawLine(380, 100, 380, 120);
			g.drawOval(360, 120, 40, 40);
		}// ������
		else if (errorInput == 2) {
			g.drawLine(300, 100, 300, 250);// ������������ �����
			g.drawLine(280, 250, 320, 250);// ��������� ��������
			g.drawLine(300, 100, 380, 100);// �����������
			g.drawLine(380, 100, 380, 120);
			g.drawOval(360, 120, 40, 40);// ������
			g.drawLine(380, 160, 380, 200);
		}// ����
		else if (errorInput == 3) {
			g.drawLine(300, 100, 300, 250);// ������������ �����
			g.drawLine(280, 250, 320, 250);// ��������� ��������
			g.drawLine(300, 100, 380, 100);// �����������
			g.drawLine(380, 100, 380, 120);
			g.drawOval(360, 120, 40, 40);// ������
			g.drawLine(380, 160, 380, 200);// ����
			g.drawLine(380, 200, 360, 240);
		}// ����� ����
		else if (errorInput == 4) {
			g.drawLine(300, 100, 300, 250);// ������������ �����
			g.drawLine(280, 250, 320, 250);// ��������� ��������
			g.drawLine(300, 100, 380, 100);// �����������
			g.drawLine(380, 100, 380, 120);
			g.drawOval(360, 120, 40, 40);// ������
			g.drawLine(380, 160, 380, 200);// ����
			g.drawLine(380, 200, 360, 240);// ����� ����
			g.drawLine(380, 200, 400, 240);
		}// ������ ����
		else if (errorInput == 5) {
			g.drawLine(300, 100, 300, 250);// ������������ �����
			g.drawLine(280, 250, 320, 250);// ��������� ��������
			g.drawLine(300, 100, 380, 100);// �����������
			g.drawLine(380, 100, 380, 120);
			g.drawOval(360, 120, 40, 40);// ������
			g.drawLine(380, 160, 380, 200);// ����
			g.drawLine(380, 200, 360, 240);// ����� ����
			g.drawLine(380, 200, 400, 240);// ������ ����
			g.drawLine(380, 166, 360, 200);
		}// ����� ����
		else if (errorInput == 6) {
			g.drawLine(300, 100, 300, 250);// ������������ �����
			g.drawLine(280, 250, 320, 250);// ��������� ��������
			g.drawLine(300, 100, 380, 100);// �����������
			g.drawLine(380, 100, 380, 120);
			g.drawOval(360, 120, 40, 40);// ������
			g.drawLine(380, 160, 380, 200);// ����
			g.drawLine(380, 200, 360, 240);// ����� ����
			g.drawLine(380, 200, 400, 240);// ������ ����
			g.drawLine(380, 166, 360, 200);// ����� ����
			g.drawLine(380, 166, 400, 200);
		}// ������ ����

	}

	public MyPanel() {

		textInputLabel = new JLabel("���� ����");
		textInputLabel.setSize(80, 30);
		textInputLabel.setLocation(10, 100);
		add(textInputLabel);

		cahrInputLabel = new JLabel("��������� ����� ");
		cahrInputLabel.setSize(500, 30);
		cahrInputLabel.setLocation(10, 200);
		add(cahrInputLabel);

		pickFileButton = new JButton("����� �����");
		pickFileButton.setSize(120, 30);
		pickFileButton.setLocation(10, 300);
		add(pickFileButton);

		pathFile = new JTextField("E:/ZipJava/����.txt");
		pathFile.setSize(400, 30);
		pathFile.setLocation(140, 300);
		add(pathFile);

		exitButton = new JButton("�����");
		exitButton.setSize(100, 30);
		exitButton.setLocation(540, 300);
		add(exitButton);

		startButton = new JButton("�����");
		startButton.setSize(80, 30);
		startButton.setLocation(10, 150);
		add(startButton);

		textInput = new JTextField("", 10);
		textInput.requestFocus(true);
		textInput.setMaximumSize(textInput.getPreferredSize());
		textInput.setSize(80, 30);
		textInput.setLocation(80, 100);
		add(textInput);

		test = new JButton("����");
		test.setSize(80, 30);
		test.setLocation(100, 150);
		add(test);

		inputButton = new JButton("Enter");
		inputButton.setSize(80, 30);
		inputButton.setLocation(160, 100);
		add(inputButton);

		pickFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// �������� ������������� �����
				if (file == null) {
					file = new JFileChooser();
					file.setCurrentDirectory(new File("."));
					file.setFileFilter(new MyFilter());
				}
				// ���a� ���� � ���������� �����
				if (file.showDialog(null, "Select") == JFileChooser.APPROVE_OPTION)
					;
				// text.append(file.getSelectedFile().getPath()+"\n");
				pathFile.setText(file.getSelectedFile().getPath() + "\n");
			}
		});

		test.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent event) {
				// errorInput++;
				// repaint();
				System.out.println("lengthLabelList = " + lengthLabelList + "//������� ��������� �����");
				System.out.println("wordSteck = " + wordSteck);
				System.out.println("wordsList = " + wordsList);
				System.out.println("wordsNumber = " + wordsNumber + "//����� ���������� ����� �� �������");
				System.out.println("fileFromName = " + fileFromName + "//������-���� � �����");
				System.out.println("words = " + words);
				System.out.println("word = " + word);
				System.out.println("lengthWord = " + lengthWord + ";//����� ���������� �����");

				System.out.println("lengthDrawRoundRect = " + lengthDrawRoundRect);
				System.out.println("labels = " + labels);
				System.out.println("gameOver = " + gameOver);
				System.out.println("gameWinner = " + gameWinner);
				System.out.println("lengthLabelList = " + lengthLabelList + "//������ ������� ��� ��������� �����");
				System.out.println("index = " + index);
				System.out.println("errorInput = " + errorInput);
				System.out.println("wordProverca = " + wordProverca + "//������ ��� �������� ��� ��������� ����");
				System.out.println("-----------------------------------------");
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		MyActionStart actionStart = new MyActionStart();
		startButton.addActionListener(actionStart);

		MyActionInput actionInput = new MyActionInput();
		inputButton.addActionListener(actionInput);

		// Action inputAction=new MyActionInput();
		InputMap imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ENTER"), "Input.Input");
		ActionMap amap = getActionMap();
		amap.put("Input.Input", actionInput);

	}

	public void labelRemove(int lengthLabelList) {
		// ������� ��������� �����
		if (lengthLabelList > 0) {
			for (int j = 0; j < lengthLabelList; j++) {
				index = lengthLabelList - 1 - j;
				System.out.println(index);
				JLabel label = labels.remove(index);
				remove(label);
				repaint();
				revalidate();
			}
		}
		lengthLabelList = 0;
	}

	public class MyActionStart extends AbstractAction {
		public MyActionStart() {
			// putValue("Enter", aaTextInfo);
		}

		public void actionPerformed(ActionEvent event) {
			errorInput = 0;
			word = "";
			words = null;
			wordSteck = "";
			wordsList = new LinkedList<String>();
			wordProverca = new int[10];
			fileFromName = pathFile.getText();
			System.out.println(fileFromName);
			labelRemove(lengthLabelList);// ������� ��������� �����

			// ������ �����
			try {
				Scanner in = new Scanner(new BufferedInputStream(new FileInputStream(fileFromName)), "Cp1251");
				while (in.hasNext()) {
					// find next line
					wordSteck = in.next();
					wordsList.add(wordSteck);
				}
				in.close();
				words = wordsList.toArray(new String[0]);

				for (String s : words) {
					System.out.println(s);
				}

				int wordsArrayLength = words.length;// ����������� ����������
													// ���� � ������
				System.out.println("wordsArrayLength = " + wordsArrayLength);
				int wordNumber = (int) (Math.random() * wordsArrayLength);// ���������
																			// �����
				System.out.println("wordNumber = " + wordNumber);
				word = words[wordNumber];// ��������� ����� �� ������
				System.out.println("word = " + word);
				lengthWord = word.length();// ����������� ����� �����
				System.out.println("lengthWord = " + lengthWord);

				wordProverca = new int[lengthWord];
			} catch (IOException exception) {
			}

			lengthDrawRoundRect = lengthWord;// ��������� ��������
												// ��������������� ��� ����
			cahrInputLabel.setText("��������� ����� ");// ��������� ������� �
														// ���������� �������
			System.out.println(labels.size() + " ���������� ��������� �����");
			textInputLabel.requestFocus(true);
			repaint();
		}

	}

	public class MyActionInput extends AbstractAction {
		public MyActionInput() {
			// putValue("Enter", aaTextInfo);
		}

		public void actionPerformed(ActionEvent event) {

			// ��������� ������
			String bukva2 = textInput.getText();
			String bukva1 = bukva2.toLowerCase();// ���������� �������
			if (bukva2.length() == 0) {
				System.out.println("�����");
			}// �������� ������ ������
			else {
				// String bukva1=(String)mField.getValue();
				System.out.println(bukva1);
				int bukvaStart = 0;
				char bukva = bukva1.charAt(bukvaStart);
				System.out.println(bukva);
				textInput.requestFocus(true);// ����� ��������� ����
				for (int j = 0; j < lengthWord; j++)// �������� ��������� �����
				{
					int x2 = 22, y2 = 22;
					// int numberLabels = j+1;
					// Font f=new Font("",Font.ITALIC,25);//��������� ������
					JLabel label = new JLabel();
					label.setSize(80, 30);
					label.setLocation(x2 + j * 50 + 15, y2 + 15);
					label.setFont(f);// ���������� ������
					labels.add(label);
					add(label);
					revalidate();
				}
				;// �������� ��������� �����

				/*
				 * for (int j=0;j<lengthWord;j++){ ((JLabel)
				 * labels.get(j)).setText(""+j+bukva1.charAt(0));}
				 */

				lengthLabelList = labels.size();
				int www = 0;// ���������� ����������

				int charOpen = 0;
				for (int j = 0; j < lengthWord; j++)// ��������� ��������� �����
													// � ������� � �����
				{
					if (bukva == word.charAt(j)) {
						charOpen = 1;
						www++;
						System.out.println("wwww " + www);
						((JLabel) labels.get(j)).setText("" + bukva1.charAt(0));
						wordProverca[j]++;

						if (wordProverca[j] == 1) {
							gameWinner++;
						}

						System.out.println(labels.size() + " ���������� ��������� �����");
						if (gameWinner == lengthWord) {
							System.out.println("gameWinner");
							/*
							 * if (d1==null) d1=new MyDialog(null,true);
							 * d1.show();
							 */
							Object[] options = { "������", "��", "�����" };
							int selection = JOptionPane.showOptionDialog(null, "               ������!!!", "��������", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
							if (selection == JOptionPane.YES_OPTION) {
								// setBackground(backgroundColor);
								System.out.println("������");
								errorInput = 0;
								word = "";
								words = null;
								wordSteck = "";
								wordsList = new LinkedList<String>();
								wordProverca = new int[10];
								fileFromName = pathFile.getText();
								System.out.println(fileFromName);
								labelRemove(lengthLabelList);// �������
																// ���������
																// �����

								// ������ �����
								try {
									Scanner in = new Scanner(new FileInputStream(fileFromName), "Cp1251");
									while (in.hasNext()) {
										// find next line
										wordSteck = in.next();
										wordsList.add(wordSteck);
									}
									in.close();
									words = wordsList.toArray(new String[0]);

									for (String s : words) {
										System.out.println(s);
									}

									int wordsArrayLength = words.length;// �����������
																		// ����������
																		// ����
																		// �
																		// ������
									System.out.println("wordsArrayLength = " + wordsArrayLength);
									int wordNumber = (int) (Math.random() * wordsArrayLength);// ���������
																								// �����
									System.out.println("wordNumber = " + wordNumber);
									word = words[wordNumber];// ��������� �����
																// �� ������
									System.out.println("word = " + word);
									lengthWord = word.length();// �����������
																// ����� �����
									System.out.println("lengthWord = " + lengthWord);

									wordProverca = new int[lengthWord];
								} catch (IOException exception) {
								}

								lengthDrawRoundRect = lengthWord;// ���������
																	// ��������
																	// ���������������
																	// ��� ����
								cahrInputLabel.setText("��������� ����� ");// ���������
																			// �������
																			// �
																			// ����������
																			// �������
								System.out.println(labels.size() + " ���������� ��������� �����");

								repaint();
								textInputLabel.requestFocus(true);
							} else {
								System.out.println("��");
								lengthDrawRoundRect = 0; // �������
															// ��������������
								errorInput = 0;
								word = "";
								words = null;
								wordSteck = "";
								cahrInputLabel.setText("��������� ����� ");
								labelRemove(lengthLabelList);// �������
																// ���������
																// �����

								if (selection == JOptionPane.CANCEL_OPTION) {
									// setBackground(Color.white);
									System.out.println("�����");
									System.exit(0);
								}

							}
						}// Object[] options

						repaint();
					} else {
						System.out.print("���");
						System.out.println(j);

						// System.out.println("���");
						textInput.setText("");
					}// ������� ���� �����

				}
				;

				if (charOpen == 0) {
					errorInput++;
					repaint();
				}

				if (errorInput == 6) {
					System.out.print("�� ��������");
					Object[] options = { "������", "��", "�����" };
					int selection = JOptionPane.showOptionDialog(null, "           ���� ��������", "��������", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
					if (selection == JOptionPane.YES_OPTION) {
						// setBackground(backgroundColor);
						System.out.println("������");
						errorInput = 0;
						word = "";
						words = null;
						wordSteck = "";
						wordsList = new LinkedList<String>();
						wordProverca = new int[10];
						fileFromName = pathFile.getText();
						System.out.println(fileFromName);
						labelRemove(lengthLabelList);// ������� ��������� �����

						// ������ �����
						try {
							Scanner in = new Scanner(new FileInputStream(fileFromName), "Cp1251");
							while (in.hasNext()) {
								// find next line
								wordSteck = in.next();
								wordsList.add(wordSteck);
							}
							in.close();
							words = wordsList.toArray(new String[0]);

							for (String s : words) {
								System.out.println(s);
							}

							int wordsArrayLength = words.length;// �����������
																// ����������
																// ���� � ������
							System.out.println("wordsArrayLength = " + wordsArrayLength);
							int wordNumber = (int) (Math.random() * wordsArrayLength);// ���������
																						// �����
							System.out.println("wordNumber = " + wordNumber);
							word = words[wordNumber];// ��������� ����� ��
														// ������
							System.out.println("word = " + word);
							lengthWord = word.length();// ����������� �����
														// �����
							System.out.println("lengthWord = " + lengthWord);

							wordProverca = new int[lengthWord];
						} catch (IOException exception) {
						}

						lengthDrawRoundRect = lengthWord;// ��������� ��������
															// ���������������
															// ��� ����
						cahrInputLabel.setText("��������� ����� ");// ���������
																	// ������� �
																	// ����������
																	// �������
						System.out.println(labels.size() + " ���������� ��������� �����");

						repaint();
						textInputLabel.requestFocus(true);

					} else {
						System.out.println("��");
						errorInput = 0;// ������� �� ����������
						repaint();// ������� �� ����������
						lengthDrawRoundRect = 0; // ������� ��������������
						cahrInputLabel.setText("��������� ����� ");
						labelRemove(lengthLabelList);// ������� ��������� �����

						if (selection == JOptionPane.CANCEL_OPTION) {
							// setBackground(Color.white);
							System.out.println("�����");
							System.exit(0);
						}

					}

					String textLabel = cahrInputLabel.getText();
					cahrInputLabel.setText("" + textLabel + bukva + " ");
					// int bvbvbv=0;
					// if(www==0) {bvbvbv++; System.out.println("�� ������");};
				}
				;// �������� ������ ������
			}// public void actionPerformed(ActionEvent event)
		}// public class MyActionInput extends AbstractAction

		class MyDialog extends JDialog {
			@SuppressWarnings("unused")
			private boolean ok;

			public MyDialog(final JFrame frame, final boolean modal) {
				// ������� ����������� ������������� ����� true-���������������
				super(frame, "Dialog", modal);
				setSize(250, 100);
				Container pane = getContentPane();
				JPanel panel = new JPanel();
				pane.add(panel, BorderLayout.SOUTH);
				JButton b1 = new JButton("������");
				panel.add(b1);
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						ok = true;
						setVisible(false);
						// �������� ����������� ����
						// if (!modal) area.append(text.getText()+"\n");
					}

				});

				JButton b2 = new JButton("��");
				panel.add(b2);
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						setVisible(false);
					}
				});
				JButton b3 = new JButton("�����");
				panel.add(b3);
				b3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						// cancel();
						setVisible(false);
					}
				});

			}
		}
	}
}
