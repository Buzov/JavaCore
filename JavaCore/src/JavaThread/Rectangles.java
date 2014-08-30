package JavaThread;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Rectangles extends Applet 
{
  RectPanel[] rp;
  
  // ============================================
  // init
  // ============================================
  public void init()
  {
    setLayout(new GridLayout(0, 3));
    
    rp = new RectPanel[9];
    
    for(int i = 0; i < 9; i++)
    {
      rp[i] = new RectPanel();
      add(rp[i]);
    }
  }
  
  // ============================================
  // getAppletInfo
  // ============================================
  public String getAppletInfo()
  {
    return "Name: Rectangles";
  }
      
  // ============================================
  // start
  // ============================================
  public void start()
  {
    for(int i = 0; i < 9; i++)
      rp[i].startThread();
  }

  // ============================================
  // stop
  // ============================================
  public void stop()
  {
    for(int i = 0; i < 9; i++)
      rp[i].stopThread();
  }
}

// ===========================================
// Class RectPanel
// ===========================================
class RectPanel extends Panel
  implements Runnable, MouseListener

{
  Dimension dm;
  Thread tiktak = null;
  
  // ===========================================
  // RectPanel
  // ===========================================
  public RectPanel()
  {
    tiktak = null;
    this.addMouseListener(this);
  }
  
  // ===========================================
  // paint
  // ===========================================
  public void paint(Graphics g)
  {
    dm = getSize();
    g.drawRect(0, 0, dm.width - 1, dm.height - 1);
  }
  
  // ===========================================
  // startThread
  // ===========================================
  public void startThread()
  {
    if(tiktak == null)
    {
      tiktak = new Thread(this);
      tiktak.start();
    }
  }
  
  // ===========================================
  // stopThread
  // ===========================================
  public void stopThread()
  {
    if(tiktak != null)
    {
      tiktak.stop();
      tiktak = null;
    }
  }
  
  // ===========================================
  // run
  // ===========================================
  public void run()
  {
    Graphics g = getGraphics();
    int rColor, gColor, bColor;
    int x, y, width, height;

    while(true)
    {
      if(dm != null)
      {
        x = (int)((dm.width + 1) * Math.random());
        y = (int)((dm.height + 1) * Math.random());
      
        width = (int)((dm.width - 2) * Math.random()) / 2;
	height = (int)((dm.height - 2)* Math.random()) / 2;
      
        rColor = (int)(255 * Math.random());
        gColor = (int)(255 * Math.random());
        bColor = (int)(255 * Math.random());
      
        g.setColor(new Color(rColor, gColor, bColor));
        g.fillRect(x, y, width, height);
      }	
      
      try
      {
	tiktak.sleep(10);
      }
      catch(InterruptedException ie)
      {
	tiktak.stop();
      }	
    }
  }
  
  // ============================================
  // mousePressed
  // ============================================
  public void mousePressed(MouseEvent e)
  {
    if(tiktak != null)
    {
      tiktak.stop();
      tiktak = null;
    }
  }

  // ============================================
  // mouseReleased
  // ============================================
  public void mouseReleased(MouseEvent e)
  {
    if(tiktak == null)
    {
      tiktak = new Thread(this);
      tiktak.start();
    }
  }
  
  // ============================================
  // mouseClicked
  // ============================================
  public void mouseClicked(MouseEvent e)
  {
  }
  
  // ============================================
  // mouseEntered
  // ============================================
  public void mouseEntered(MouseEvent e)
  {
    if(tiktak != null)
    {
      tiktak.setPriority(Thread.MIN_PRIORITY);
    }  
  }
  
  // ============================================
  // mouseExited
  // ============================================
  public void mouseExited(MouseEvent e)
  {
    if(tiktak != null)
    {
      tiktak.setPriority(Thread.NORM_PRIORITY);
    }  
  }
}
