package tilings;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import tilingTypes.ITile;

public final class PanelTilingInfo extends JPanel
{
   final static Color[] colors = { new Color(255,255,128), new Color(128,128,255), new Color(255,128,128)};
   ITile tile;
   int[] labels;
   final int lettersize = 10;

   private JTextArea textPanel = new JTextArea();
   private JScrollPane textPanelScrollPane = new JScrollPane(textPanel);
   private JTextArea textPanel2 = new JTextArea();
   private JScrollPane textPanel2ScrollPane = new JScrollPane(textPanel2);
   static final char cornlabel ='A';
   static final char edgelabel ='a';
   
   private JPanel tilePanel = new JPanel(){
      public void paintComponent(Graphics g) {
         super.paintComponent(g);  //paint background
         if( tile==null ) return;

         Graphics2D g2 =(Graphics2D)g;
         g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
         int w = getWidth();
         int h = getHeight();
         int ox = w/2;
         int oy = h/2;

         double minX=0, maxX=0, minY=0, maxY=0;
         boolean first = true;
         for( int i=0; i<tile.size();  i++){
            if( labels==null || labels[i]>=0 ){
               if( first ){
                  minX = tile.getX(i);
                  maxX = tile.getX(i);
                  minY = tile.getY(i);
                  maxY = tile.getY(i);
                  first = false;
               }else{
                  minX = Math.min(minX, tile.getX(i));
                  maxX = Math.max(maxX, tile.getX(i));
                  minY = Math.min(minY, tile.getY(i));
                  maxY = Math.max(maxY, tile.getY(i));
               }
            }
         }
         double midX = (minX+maxX)/2;
         double midY = (minY+maxY)/2;
         double radX = (maxX-minX)/2;
         double radY = (maxY-minY)/2;
         double scaleX = (ox-lettersize*1.5)/radX;
         double scaleY = (oy-lettersize*1.5)/radY;
         double scale = Math.min(scaleX, scaleY)*.95;

         int[] x = new int[tile.size()];
         int[] y = new int[tile.size()];
         int cx = 0;
         int cy = 0;
         int n=0;
         for( int i=0; i<tile.size();  i++){
            if( labels==null || labels[i]>=0 ){
               x[n] = ox+(int)((tile.getX(i)-midX)*scale);
               y[n] = oy-(int)((tile.getY(i)-midY)*scale);
               cx += x[n];
               cy += y[n];
               n++;
            }
         }
         cx /= n; // centroid
         cy /= n;

         g.setColor(colors[0]);
         g.fillPolygon(x, y, n);
         g.setColor(Color.gray);
         g.drawPolygon(x, y, n);

         if( labels!=null ){
            g.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            // find last labelled corner
            int prevX=x[n-1], prevY=y[n-1];

            int ix = 0;
            for(int i=0; i<labels.length; i++){
               if( labels[i]>=0 ){
                  // do Corner label
                  printLabel( g, x[ix], y[ix], cx, cy, (char)(cornlabel+labels[i]) );
                  // do Edge label
                  printLabel( g, (prevX+x[ix])/2, (prevY+y[ix])/2, cx, cy, (char)(edgelabel+labels[i]) );

                  prevX=x[ix];
                  prevY=y[ix];
                  ix++;
               }
            }
         }
      }
      private void printLabel( Graphics g, int x, int y, int cx, int cy, char c ){
         int dx = x-cx;
         int dy = y-cy;
         double ln = Math.sqrt(dx*dx+dy*dy+0.1);
         dx = (int)(.5 + dx*(ln+lettersize)/ln - lettersize*.5 );
         dy = (int)(.5 + dy*(ln+lettersize)/ln + lettersize*.5 );
         g.drawString(""+c, cx+dx, cy+dy);
      }
   };
   

   private final double precision = 10000.;

   private String getValueText(double[] ofst){
      if( tile==null ) return "";

      StringBuilder sbText = new StringBuilder();
      if( ofst!=null){
         double ln1 = Math.sqrt(ofst[0]*ofst[0]+ofst[1]*ofst[1]);
         double ln2 = Math.sqrt(ofst[2]*ofst[2]+ofst[3]*ofst[3]);
         double ang = Math.acos((ofst[0]*ofst[2]+ofst[1]*ofst[3])/ln1/ln2);
         double r = ln1/ln2;
         ang *= 180/Math.PI;
         if( r <= 0.995 ){
            r = 1/r;
            ang = 180-ang;
         }
         ang = Math.round(ang*precision)/precision;
         r = Math.round(r*precision)/precision;
         sbText.append("Unit ratio=").append(r).append("\n");
         sbText.append("Unit angle=").append(ang).append("\n");
      }
      
      double[] x = new double[tile.size()+2];
      double[] y = new double[tile.size()+2];
      int[] lab = new int[tile.size()+1];
      int n=1;
      for( int i=0; i<tile.size();  i++){
         if( labels==null || labels[i]>=0 ){
            x[n] = tile.getX(i);
            y[n] = tile.getY(i);
            lab[n]=labels==null ? n-1 : labels[i];
            n++;
         }
      }
      x[n]=x[1];
      y[n]=y[1];
      x[0] = x[n-1];
      y[0] = y[n-1];
      
      StringBuilder sbAngles = new StringBuilder();
      StringBuilder sbSides = new StringBuilder();
      for( int i=1; i<n; i++){
         // calc angle and length
         double dx1 = x[i+1]-x[i];
         double dy1 = y[i+1]-y[i];
         double dx2 = x[i-1]-x[i];
         double dy2 = y[i-1]-y[i];
         double len2 = Math.sqrt(dx2*dx2+dy2*dy2);
         double angle1 = Math.atan2(dy1,dx1);
         double angle2 = Math.atan2(dy2,dx2);
         double angle = (angle2-angle1)*180/Math.PI;
         if( angle<0 ) angle += 360;
         angle = Math.round(angle*precision)/precision;
         len2 = Math.round(len2*precision*100)/precision;
         // output result
         if( i>1 ){
            sbSides.append("\n");
            sbAngles.append("\n");
         }
         sbSides.append((char)(edgelabel+lab[i])).append("=").append(len2);
         sbAngles.append((char)(cornlabel+lab[i])).append("=").append(angle);
      }
      sbText.append(sbAngles).append("\n").append(sbSides);
      return sbText.toString();
   }
   

   public PanelTilingInfo(){
      tilePanel.setBackground(Color.WHITE);
      tilePanel.setPreferredSize( new Dimension(0,lettersize*12) );
      setLayout(new BorderLayout());
      
      JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
      split2.setDividerSize(6);
      split2.setLeftComponent(textPanelScrollPane);
      split2.setRightComponent(textPanel2ScrollPane);
      split2.setResizeWeight(.5);
      split2.setBorder(null);
      textPanel.setEditable(false);
      textPanel2.setEditable(false);
      DefaultCaret caret = (DefaultCaret)textPanel.getCaret();
      caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);      
      caret = (DefaultCaret)textPanel2.getCaret();
      caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);      
      
      JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
      split.setDividerSize(8);
      split.setLeftComponent(tilePanel);
      split.setRightComponent(split2);
      split.setResizeWeight(1./3);
      split.setBorder(null);
      add(split);
      
      textPanel2.setRows(10);
   }
   public void setTile(ITile tile0, String info, int[] labels0, double[] parallelogram){
      tile = tile0;
      labels = labels0;
      textPanel.setText(info);
      textPanel2.setText(getValueText(parallelogram));
      repaint();
   }
}