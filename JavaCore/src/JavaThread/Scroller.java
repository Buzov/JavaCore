package JavaThread;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;

public class Scroller extends Applet
{
  TextAutoScroller tas;
  TextAutoScroller tas1;
  TextAutoScroller tas2;

  // ============================================
  // init
  // ============================================
  public void init()
  {
    Dimension dimMinSize;
    setLayout(new GridLayout(0, 1));
    Graphics g = getGraphics();
    
    String ScrollingText = 
      " First scroller component";
    tas = new TextAutoScroller(ScrollingText, g);
    add(tas);
    
    ScrollingText = "";
    tas1 = new TextAutoScroller(ScrollingText, g);
    tas1.setFont(
      new Font("TimesRoman", Font.BOLD, 40));
    tas1.setDelay(20);
    add(tas1);
    tas1.setText(" Second scroller component");
    
    ScrollingText = " Last component";
    tas2 = new TextAutoScroller(ScrollingText, g);
    tas2.setDelay(5);
    tas2.setFont(
      new Font("Courier", Font.BOLD, 36));
    add(tas2);
  }  

  // ============================================
  // start
  // ============================================
  public void start()
  {
    tas.start();
    tas1.start();
    tas2.start();
  }

  // ============================================
  // stop
  // ============================================
  public void stop()
  {
    tas.stop();
    tas1.stop();
    tas2.stop();
  }
  
  // ============================================
  // getAppletInfo
  // ============================================
  public String getAppletInfo()
  {
    return "Name: Scroller";
  }
}

// ============================================
// Class TextAutoScroller
// ============================================
class TextAutoScroller extends Panel
  implements Runnable
{
  Thread tiktakThread = null;
  String ScrollingText = " ";
  int delay = 10;
  Dimension dimMinSize;
  Font fnt;

  // ============================================
  // TextAutoScroller
  // ============================================
  public TextAutoScroller(String s, Graphics g)
  {
    ScrollingText = s;
    
    fnt = new Font("Helvetica", Font.BOLD, 24);
    g.setFont(fnt);
        
    FontMetrics fm = g.getFontMetrics();
    int nTitileWidth = fm.stringWidth(ScrollingText);
    int nTitleHeight = fm.getAscent() - 
      fm.getLeading() - fm.getDescent();
      
    int nWindowWidth = nTitileWidth + 20;
    int nWindowHeight  = nTitleHeight + 20;
    
    dimMinSize = new Dimension(
      nWindowWidth, nWindowHeight);
  }
  
  // ============================================
  // setDelay
  // ============================================
  public void setDelay(int d)
  {
    delay = d;
  }
  
  // ============================================
  // setFont
  // ============================================
  public void setFont(Font f)
  {
    fnt = f;
  }
  
  // ============================================
  // setText
  // ============================================
  public void setText(String s)
  {
    ScrollingText = s;
  }
  
  // ============================================
  // paint
  // ============================================
  public void paint(Graphics g)
  {
    dimMinSize = getSize();
  }

  // ============================================
  // start
  // ============================================
  public void start()
  {
    if (tiktakThread == null)
    {
      tiktakThread = new Thread(this);
      tiktakThread.start();
    }
  }

  // ============================================
  // stop
  // ============================================
  public void stop()
  {
    if (tiktakThread != null)
    {
      tiktakThread.stop();
      tiktakThread = null;
    }
  }

  // ============================================
  // run
  // ============================================
  public void run()
  {
    int nCurrentChar = 0;

    Graphics g = getGraphics();
    g.setFont(fnt);
    FontMetrics fm = g.getFontMetrics();
    
    int nMaxCharWidth = fm.charWidth('W') + 5;
    int yPos = fm.getHeight() + 5;
    int nCurrentCharWidth;
    
    int rColor = (int)(255 * Math.random());
    int gColor = (int)(255 * Math.random());
    int bColor = (int)(255 * Math.random());
    g.setColor(new Color(rColor, gColor, bColor));
          
    while (true)
    {
      try
      {
         try
         {
           nCurrentCharWidth = 
             fm.charWidth(ScrollingText.charAt(
	     nCurrentChar));

           char[] ch;
           String s;
           ch = new char[1];
           ch[0] = 
	     ScrollingText.charAt(nCurrentChar);
           s = new String(ch);

           g.drawString(s, 
             dimMinSize.width - nMaxCharWidth,
	     yPos);

           nCurrentChar++;

           for(int i = 0; i < nCurrentCharWidth; i++)
           {
             g.copyArea(nMaxCharWidth / 2, 0,
               dimMinSize.width - nMaxCharWidth +
	       nCurrentCharWidth - i, 
               dimMinSize.height,
               -1, 0);
 
             g.clearRect(
               dimMinSize.width - nMaxCharWidth +
	       nCurrentCharWidth - i + 1, 0,
               nMaxCharWidth, dimMinSize.height);

             Thread.sleep(delay);
           }
         }
        
         catch (StringIndexOutOfBoundsException e)
         {
           nCurrentChar = 0;

           rColor = (int)(255 * Math.random());
           gColor = (int)(255 * Math.random());
           bColor = (int)(255 * Math.random());
           g.setColor(
	     new Color(rColor, gColor, bColor));
         }
      }
      catch (InterruptedException e)
      {
	stop();
      }
    }
  }
  
  // ===========================================
  // getPreferredSize
  // ===========================================
  public Dimension getPreferredSize()
  {
    return dimMinSize;
  }
  
  // ===========================================
  // getMinimumSize
  // ===========================================
  public Dimension getMinimumSize()
  {
    return dimMinSize;
  }
  
  // ===========================================
  // preferredSize
  // ===========================================
  public Dimension preferredSize()
  {
    return dimMinSize;
  }
  
  // ===========================================
  // minimumSize
  // ===========================================
  public Dimension minimumSize()
  {
    return dimMinSize;
  }
} 