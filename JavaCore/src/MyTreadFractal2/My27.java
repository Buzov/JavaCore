package MyTreadFractal2;



import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;




public class My27 extends Applet 
{
	MyPanel[] rp;
	
	 public void init()
	  {
	    
		 setLayout(new GridLayout(0, 3));
		 rp = new MyPanel[9];
	    
	    for(int i = 0; i < 9; i++)
	    {
	      rp[i] = new MyPanel();
	      add(rp[i]);
	    }
	  }
	 
	 public String getAppletInfo()
	  {
	    return "Name: Rectangles";
	  }
	 
	 public void start()
	  {
	    for(int i = 0; i < 9; i++)
	      rp[i].startThread();
	  }

}


class MyPanel extends Panel implements Runnable
{
	Dimension dm;
	Thread thr = null;
	
	
	MyPanel(){
		
		thr = null;
		
	}
		
	public void paint(Graphics g)
	{
		
		dm = getSize();
	    g.drawRect(0, 0, dm.width - 1, dm.height - 1);
		
		
		
		
	}
	public void startThread()
	{
	  if(thr == null)
	  {
	    thr = new Thread(this);
	    thr.start();
	    System.out.println("Поток создан");
	  }
	}
	
	public void stop()
	{
	  if(thr != null)
	  {
	    thr.stop();
	    thr = null;
	  }
	}
	@Override
	public void run() {
		
		Graphics g = getGraphics();
		int x1=22, y1=22, dx=44, dy=66;
		//g.drawLine(x1,y1,x1+dx,y1+dy);
	    
		
			 for(int i = 0; i<100; i++)
				{
					x1=x1+i; 
					y1=y1+i;
					
					System.out.println(i);
					g.drawLine(x1,y1,x1+dx,y1+dy);
					
					//g.fillRect(x1, y1, x1+dx,y1+dy);  
					//repaint();
					    try
					    {
						thr.sleep(1000);
					    }
					    catch(InterruptedException ie)
					    {
						stop();
					    }	
										
				}
	      
		   
		  
		
	}

}


		
		
