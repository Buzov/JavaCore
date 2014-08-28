package Kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reader extends JFrame{
	
	JButton b, b1, b2, b3, b4, b5, b6, b7, b8, b9, p, m, d, u, z, r, t, c;
	static JTextField l1;
	static int i;
	static String a, numS = "0";
	static double num, numB, numF;
	static boolean plus, minus, dev, mult;
	
	eHandler handler = new eHandler();

	public Reader(String s){
		super(s);
		
		setLayout(new FlowLayout());
		c = new JButton("С");
		b= new JButton("0");
		b1= new JButton("1");
		b2= new JButton("2");
		b3= new JButton("3");
		b4= new JButton("4");
		b5= new JButton("5");
		b6= new JButton("6");
		b7= new JButton("7");
		b8= new JButton("8");
		b9= new JButton("9");
		p= new JButton("+");
		m= new JButton("-");
		d= new JButton("/");
		u= new JButton("*");
		z= new JButton("+/-");
		t= new JButton(".");
		r= new JButton("=");
		l1= new JTextField(5);
		l1.setEditable(false);
		add(b7);
		add(b8);
		add(b9);
		add(u);
		add(b4);
		add(b5);
		add(b6);
		add(d);
		add(b1);
		add(b2);
		add(b3);
		add(m);
		add(z);
		add(b);
		add(p);
		add(c);
		add(r);
		add(t);
		add(l1);
		b.addActionListener(handler);
		r.addActionListener(handler);
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		b4.addActionListener(handler);
		b5.addActionListener(handler);
		b6.addActionListener(handler);
		b7.addActionListener(handler);
		b8.addActionListener(handler);
		b9.addActionListener(handler);       
		p.addActionListener(handler);
		m.addActionListener(handler);
		u.addActionListener(handler);
		d.addActionListener(handler);
		z.addActionListener(handler);
		t.addActionListener(handler);
		c.addActionListener(handler);
		
	}
			
public class eHandler implements ActionListener{

	public void actionPerformed(ActionEvent e){
		
		if((Double.parseDouble(numS))>=999999){
			l1.setText(null);
			numS="0";
			numB=0;
			JOptionPane.showMessageDialog(null, "Слишком длинное число");
		}
		
		if(e.getSource()==z){
			if(Double.parseDouble(numS) - (int)Double.parseDouble(numS)!=0){
				numS=Double.toString(-Double.parseDouble(numS));
				double numOut = Double.parseDouble(numS);
				if(numOut - (int)numOut!=0){
					l1.setText(Double.toString(numOut));
				}else{
					i = (int)numOut;
					l1.setText(Integer.toString(i));
				}
			}else{
				numS=Double.toString((int)-Double.parseDouble(numS));
				double numOut = Double.parseDouble(numS);
				if(numOut - (int)numOut!=0){
					l1.setText(Double.toString(numOut));
				}else{
					i = (int)numOut;
					l1.setText(Integer.toString(i));
				}
			}
		}
		
		if(e.getSource()==c){
			l1.setText(null);
			numS="0";
			numB=0;
		}
		
		if(e.getSource()==t){
			numS += ".";
		}
						
		if(e.getSource()==p){
			numB = Double.parseDouble(numS);
			numS="0";
			plus = true;
			minus = false;
			mult = false;
			dev = false;
		}
		
		if(e.getSource()==m){
			numB = Double.parseDouble(numS);
			numS="0";
			plus = false;
			minus = true;
			mult = false;
			dev = false;
		}
		
		if(e.getSource()==d){
			numB = Double.parseDouble(numS);
			numS="0";
			plus = false;
			minus = false;
			mult = false;
			dev = true;
		}
		
		if(e.getSource()==u){
			numB = Double.parseDouble(numS);
			numS="0";
			plus = false;
			minus = false;
			mult = true;
			dev = false;
		}
			
					if(e.getSource()==b){
						numS = calc.count(numS, 0);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b1){
						numS = calc.count(numS, 1);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b2){
						numS = calc.count(numS, 2);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b3){
						numS = calc.count(numS, 3);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b4){
						numS = calc.count(numS, 4);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b5){
						numS = calc.count(numS, 5);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b6){
						numS = calc.count(numS, 6);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b7){
						numS = calc.count(numS, 7);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b8){
						numS = calc.count(numS, 8);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
					
					if(e.getSource()==b9){
						numS = calc.count(numS, 9);
						double numOut = Double.parseDouble(numS);
						if(numOut - (int)numOut!=0){
							l1.setText(Double.toString(numOut));
						}else{
							i = (int)numOut;
							l1.setText(Integer.toString(i));
						}
					}
			
			if(e.getSource()==r){
				num = Double.parseDouble(numS);
				Reader.equals(numB,num);
			}
		}
	}

	public static void equals(double x1, double x2){
		if(plus){

			numF = x1 + x2;
			if(numF - (int)numF!=0){
				numF = numF * 10000;
				numF = (int)numF;
				numF = numF / 10000;
				a = Double.toString(numF);
				l1.setText(a);
			}else{
				i = (int)numF;
				l1.setText(Integer.toString(i));
			}
			num=0;
			numB=0;
			numS="0";
			plus = false;
		}
		if(minus){
			numF = x1 - x2;
			if(numF - (int)numF!=0){
				numF = numF * 10000;
				numF = (int)numF;
				numF = numF / 10000;
				a = Double.toString(numF);
				l1.setText(a);
			}else{
				i = (int)numF;
				l1.setText(Integer.toString(i));
			}
			num=0;
			numB=0;
			numS="0";
			minus = false;
		}
		if(mult){
			numF = x1 * x2;
			if(numF - (int)numF!=0){
				numF = numF * 10000;
				numF = (int)numF;
				numF = numF / 10000;
				a = Double.toString(numF);
				l1.setText(a);
			}else{
				i = (int)numF;
				l1.setText(Integer.toString(i));
			}
			num=0;
			numB=0;
			numS="0";
			mult=false;
		}
		if(dev){
			numF = x1 / x2;
			if(numF - (int)numF!=0){
				numF = numF * 10000;
				numF = (int)numF;
				numF = numF / 10000;
				a = Double.toString(numF);
				l1.setText(a);
			}else{
				i = (int)numF;
				l1.setText(Integer.toString(i));
			}
			num=0;
			numB=0;
			numS="0";
			dev=false;
		}
	}
}