package JavaThread;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Multi1 extends Applet implements Runnable

{
Thread thr = null;
int rColor, gColor, bColor;

// ============================================
// start
// ============================================
public void start()
{
  if(thr == null)
  {
    thr = new Thread(this);
    thr.start();
  }
}

// ============================================
// stop
// ============================================
public void stop()
{
  if(thr != null)
  {
    thr.stop();
    thr = null;
  }
}

// ============================================
// run
// ============================================
public void run()
{
  while(true)
  {
    rColor = (int)(255 * Math.random());
    gColor = (int)(255 * Math.random());
    bColor = (int)(255 * Math.random());

    repaint();
    
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

// ============================================
// paint
// ============================================
public void paint(Graphics g)
{
  String s;
  g.setColor(new Color(rColor, gColor, bColor));
  
  s = "(R, G, B) = (" + rColor + ", " + 
    gColor + ", " + bColor + ")";
    
  g.setFont(new Font("Courier", Font.PLAIN, 12));
    
  g.drawString(s, 10, 30);    
}

// ============================================
// getAppletInfo
// ============================================
public String getAppletInfo()
{
  return "Name: Multi1";
}
}

