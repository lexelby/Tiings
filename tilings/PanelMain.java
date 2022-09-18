package tilings;
//	Tile Puzzle Solver applet

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import tilings.UpdateChecker.IUpdateListener;

import javax.swing.JPanel;
import javax.swing.JLabel;

public final class PanelMain
	extends JPanel
	implements IUpdateListener, MouseListener
{
   private int[] m_version = new int[]{1,7};
   private String copyrightText = " Tilings v"+m_version[0]+"."+m_version[1]+", Written by Jaap Scherphuis, © 2009-2020";
   private String homeUrl = "https://www.jaapsch.net/tilings/"; 
   private String downloadUrl = homeUrl+"applet.htm";
   private String versionUrl = homeUrl+"version.txt";

   private JSplitPane split = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, true );
   PanelChooseTiling tabch;
   PanelShowTiling tabsh;
   private UpdateChecker updateChecker;
   private boolean updateCheckFailed;
   private boolean updateCheckSucceeded;
   private String[] updateInfo;
   JLabel copy;
   
	public PanelMain(boolean isApplet) {
		setPreferredSize(new Dimension(1000,800));
		setLayout(new BorderLayout());  

		tabch = new PanelChooseTiling(
		      new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		            tabsh.setTilingType(tabch.getSelectedTiling());
		         }
		      }
		   );
	   tabsh = new PanelShowTiling(isApplet);
      split.setLeftComponent(tabch);
      split.setRightComponent(tabsh);
      add(split);
      split.setDividerLocation(.5);
		
		JPanel southPanel = new JPanel(new BorderLayout());
		copy = new JLabel(copyrightText);
		southPanel.add(copy,BorderLayout.EAST);
      JLabel url = new JLabel(homeUrl);
      url.setToolTipText(" email: tilings@jaapsch.net");
      southPanel.add(url,BorderLayout.WEST);
		add(southPanel,BorderLayout.SOUTH);
		
      copy.addMouseListener(this);
      url.addMouseListener(this);
		
      updateChecker = new UpdateChecker(this, versionUrl, m_version);
      updateChecker.StartCheck();
	}
	
	void showInfo() {
	   String s = "<html><h2>Tiling Viewer</h2>By Jaap Scherphuis";
	   s+="<br><br>Version: "+m_version[0]+"."+m_version[1];
	   if( updateCheckFailed ) {
         s+="<br>Check for updates failed!";
	   }else if( updateCheckSucceeded ) {
	      if( updateInfo!=null) {
	         s+="<br>Version "+updateInfo[0]+" is available:";
	         s+="<blockquote>";
	         for(int i=1; i<updateInfo.length; i++) {
	            if( i>1) s+="<br>";
	            s+=updateInfo[i];
	         }
	         s+="</blockquote>";
	      }else {
            s+="<br>This is the latest version.";
	      }
	   }
      s+= "<br><br>Available from:<br><big>"+homeUrl+"</big></html>";
	   
      Object[] options = { "Visit Site" };
      int result = JOptionPane.showOptionDialog(null, s, "Tiling Viewer Info",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE ,
                  null, options, options[0]);
      
      if( result<0 ) return;
      
      if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
         try {
            Desktop.getDesktop().browse(new URI(downloadUrl));
         } catch (IOException e) {
         } catch (URISyntaxException e) {
         }
      }
	}

   @Override
   public void mouseClicked(MouseEvent arg0) { showInfo(); }
   @Override
   public void mouseEntered(MouseEvent arg0) {}
   @Override
   public void mouseExited(MouseEvent arg0) {}
   @Override
   public void mousePressed(MouseEvent arg0) {}
   @Override
   public void mouseReleased(MouseEvent arg0) {}
	
	
   void setFocus(){
      tabch.setFocus();
   }

   @Override
   public void CheckFailed() {updateCheckFailed = true;}

   @Override
   public void UpToDate() {updateCheckSucceeded = true;}

   @Override
   public void UpdateAvailable(String[] info) {
      updateCheckSucceeded = true;
      updateInfo = info;
      copy.setText("*** Update available ***  "+copyrightText);      
   }
}
