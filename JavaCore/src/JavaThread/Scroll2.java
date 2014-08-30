package JavaThread;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

public class Scroll2 extends Applet
  implements Runnable
{
  Thread timerThread = null;
  String szScrolledText = 
    "Welcome to Java applets!";
  int nStrLength;
  int nPosition;
  int nTitleHeight;
  Image mImg;
      
  // ============================================
  // init
  // ============================================
  public void init()
  {
    Graphics g = getGraphics();
    nPosition = getSize().width;
    
    g.setFont(
      new Font("Helvetica", Font.BOLD, 50));
    
    FontMetrics fm = 
      getFontMetrics(g.getFont());
      
    nStrLength = fm.stringWidth(szScrolledText);
    nTitleHeight = fm.getHeight();
    
    setBackground(Color.green);
  }

  // ============================================
  // update
  // ============================================
  public void update(Graphics g)
  {
    Graphics gImg = null;
    Dimension dmImg = null;
    
    Dimension dm = getSize();
    int wndWidth = dm.width;
    int wndHeight = dm.height;

    if((dmImg == null) ||
       (dmImg.width != wndWidth) ||
       (dmImg.height != wndHeight))
    {
      dmImg = new Dimension(wndWidth, wndHeight);
      mImg = createImage(wndWidth, wndHeight);
      gImg = mImg.getGraphics();
    }

    Color fg = getForeground();
    Color bg = getBackground();
    gImg.setColor(bg);

    gImg.fillRect(0, 0, 
      dmImg.width, dmImg.height);

    gImg.setColor(fg);

    gImg.setFont(
      new Font("Helvetica", Font.BOLD, 50));
    gImg.drawString(szScrolledText,
      nPosition, nTitleHeight + 10);
      
    nPosition--;
    if(nPosition < -nStrLength)
       nPosition = getSize().width;

    paint(g);
  }

  // ============================================
  // paint
  // ============================================
  public void paint(Graphics g)
  {
    if(mImg != null)
      g.drawImage(mImg, 0, 0, null);
  }

  // ============================================
  // start
  // ============================================
  public void start()
  {
    if(timerThread == null)
    {
      timerThread = new Thread(this);
      timerThread.start();
    }
  }
  
  // ============================================
  // stop
  // ============================================
  public void stop()
  {
    if(timerThread != null)
    {
      timerThread.stop();
      timerThread = null;
    }
  }

  // ============================================
  // run
  // ============================================
  public void run()
  {
    while(true)
    {
      try
      {
        repaint();
        Thread.sleep(5);
      }
      catch(InterruptedException ie)
      {
        stop();
      }
    }
  }
  
  // ============================================
  // getAppletInfo
  // ============================================
  public String getAppletInfo()
  {
    return "Name: Scroll2";
  }
} 