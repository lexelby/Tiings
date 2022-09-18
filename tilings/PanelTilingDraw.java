package tilings;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import tilingTypes.ITile;

public final class PanelTilingDraw extends JPanel
{
	final static private double SCALE = 200.;
	final static Color[] colors = {
         // semi-transparent colour used for unit parallelogram
	      new Color(255,0,0,190),
         // Colours used for each isohedrality class
	      new Color(255,255,128), new Color(128,128,255),
	      new Color(255,128,128), new Color(128,255,128),
         new Color(255,128,255), new Color(128,255,255)
	};
   private double[] offsets;
   private ITile[] tiles;
   private int[] labels;
	private boolean repeat = true;
   private boolean showPara = false;
   private boolean showFill = true;
   
	// bounding box of the repeated section
	double tileXMin, tileXMax, tileYMin, tileYMax;

	// the minimum/maximum distance of the tileset when projected onto v1/v2

	public PanelTilingDraw(){
		setLayout(new BorderLayout());
		// set default background colour
		setBackground(Color.WHITE);
	}

//	all screen output stuff
	// directions used when drawing the four quadrants of the tiling
	final int[][] dirsArray = { {1,0, 0,-1}, {-1,0,  0,1}, {0,1, 1,0}, {0,-1, -1,0} };

   public Image getImage(){
      int s = Math.min(getWidth(), getHeight());
      return getImage(s,s);
   }

   private Image getImage(int w, int h){
      Image image = createImage(w,h);
      paintComponentImpl(image.getGraphics(), w, h);
      return image;
   }

   public String getSvgImage(){
      int s = Math.min(getWidth(), getHeight());
      final StringBuilder sb = new StringBuilder();
      sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      sb.append("<svg width=\""+s+"\" height=\""+s+"\" viewBox=\"0 0 "+s+" "+s+"\" xmlns=\"http://www.w3.org/2000/svg\">\n");
      sb.append("<style type=\"text/css\" ><![CDATA[\n");
      if( showFill ) {
         sb.append("polygon.tile { stroke: #000000; stroke-width:3; stroke-linejoin:round }\n");
         sb.append("polygon.ih1 { fill: #ffff80 }\n");
         sb.append("polygon.ih2 { fill: #8080ff }\n");
         sb.append("polygon.ih3 { fill: #ff8080 }\n");
         sb.append("polygon.ih4 { fill: #80ff80 }\n");
         sb.append("polygon.ih5 { fill: #ff80ff }\n");
         sb.append("polygon.ih6 { fill: #80ffff }\n");
      }else {
         sb.append("polygon.tile { fill: #ffffff; stroke: #000000; stroke-width:3; stroke-linejoin:round }\n");
      }
      sb.append("polygon.para {opacity: 0.75; fill: #ff0000; stroke: #ff0000 }\n");
      sb.append("]]></style>\n");
      
      drawTiling(
            new ITileDrawing() {
               @Override
               public void drawPolygon(double[] x, double[] y, int numPoints, int colour) {
                  // <polygon class="tile ih1" points="200,10 250,190 160,210" />
                  sb.append("<polygon class=\"");
                  if(colour>0) sb.append("tile ih"+colour);
                  else sb.append("para");
                  sb.append("\" points=\"");
                  for( int i=0; i<numPoints; i++) {
                     if( i!=0) sb.append(" ");
                     sb.append(x[i]).append(",").append(y[i]);
                  }
                  sb.append("\" />\n");
               }
            },
            s, s);
      
      sb.append("</svg>");
      return sb.toString();
   }   
   
   public void paintComponent(final Graphics g) {
      super.paintComponent(g);  //paint background
      if( tiles!=null && offsets!=null){
         paintComponentImpl(g, getWidth(), getHeight());
      }
   }

   private void paintComponentImpl(final Graphics g, int w, int h) {
      Graphics2D g2 =(Graphics2D)g;
      g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
      g.setColor(Color.BLACK);
      final boolean fill = showFill;
      drawTiling(
            new ITileDrawing() {
               @Override
               public void drawPolygon(double[] x, double[] y, int numPoints, int colour) {
                  int[] x_int = new int[x.length];
                  int[] y_int = new int[y.length];
                  for( int i = 0; i<x.length; i++){
                      x_int[i] = (int)x[i];
                      y_int[i] = (int)y[i];
                  }
                  if( fill || colour==0 ) {
                     g.setColor(colors[colour]);
                     g.fillPolygon(x_int, y_int, numPoints);
                  }
                  if( colour>0 ) {
                     g.setColor(Color.BLACK);
                     g.drawPolygon(x_int, y_int, numPoints);
                  }
               }
            },
            w, h);
   }   
   
   interface ITileDrawing {
      public void drawPolygon(double[] x, double[]y, int numPoints, int colour);
   }
   
   private void drawTiling(ITileDrawing g, int w, int h) {
      double scale = ( h<w ? h: w )/SCALE;
      int ox = w/2;
      int oy = h/2;
      if( repeat ){
         double v1x = offsets[0];
         double v1y = offsets[1];
         double v2x = offsets[2];
         double v2y = offsets[3];
         drawTileSetNew(g, 0, 0, ox, oy, scale);
         for( int dir = 0; dir<4; dir++ ){
            int[] dirs = dirsArray[dir];
            // first coordinate of row to draw
            int from1 = 0 + dirs[2]-dirs[0];
            int from2 = 0 + dirs[3]-dirs[1];
            // last coordinate of row to draw
            int to1 = 0 + dirs[2];
            int to2 = 0 + dirs[3];
            int bound=50;
            while(bound>0){
               double x = from1 * v1x + from2 * v2x; 
               double y = from1 * v1y + from2 * v2y; 
               //shorten row if possible
               if( ox + (int)((x+tileXMax)*scale) <0 || ox + (int)((x+tileXMin)*scale) > w ||
                  oy + (int)((y+tileYMax)*scale) <0 || oy + (int)((y+tileYMin)*scale) > h )
               {
                  if( from1==to1 && from2==to2 ) break;  // whole row is off-screen
                  from1 += dirs[0];
                  from2 += dirs[1];
                  continue;
               }
               //shorten row if possible
               x = to1 * v1x + to2 * v2x; 
               y = to1 * v1y + to2 * v2y; 
               if( ox + (int)((x+tileXMax)*scale) <0 || ox + (int)((x+tileXMin)*scale) > w ||
                  oy + (int)((y+tileYMax)*scale) <0 || oy + (int)((y+tileYMin)*scale) > h )
               {
                  if( from1==to1 && from2==to2 ) break;  // whole row is off-screen
                  to1 -= dirs[0];
                  to2 -= dirs[1];
                  continue;
               }
               // draw row
               drawTileSetNew(g, from1, from2, ox, oy, scale);
               int c1 = from1, c2=from2;
               while( c1!=to1 || c2!=to2 ){
                  c1+=dirs[0];
                  c2+=dirs[1];
                  drawTileSetNew(g, c1, c2, ox, oy, scale);
               }
               // shift to next row
               from1 += dirs[2]-dirs[0];
               from2 += dirs[3]-dirs[1];
               // last coordinate of row to draw
               to1 += dirs[2]+dirs[0];
               to2 += dirs[3]+dirs[1];
               bound--;
            }
         }
      }else{
         drawTileSetNew(g, 0, 0, ox, oy, scale);
      }
      if( showPara )
         drawUnitParallelogramNew(g,ox,oy,scale);
   }

   private void drawTileSetNew( ITileDrawing g, int vx, int vy, int ox, int oy, double scale ){
      double ovx = vx * offsets[0] + vy * offsets[2];
      double ovy = vx * offsets[1] + vy * offsets[3];
      double[] x = new double[9];
      double[] y = new double[9];
      for( ITile t : tiles){
         int ix = 0;
         for( int i=0; i<t.size();  i++){
            if( labels[i]>=0 ){
               x[ix] = ox+((t.getX(i)+ovx)*scale);
               y[ix] = oy-((t.getY(i)+ovy)*scale);
               ix++;
            }
         }
         g.drawPolygon(x, y, ix, 1+t.getColour());
      }
   }

   private void drawUnitParallelogramNew( ITileDrawing g, int ox, int oy, double scale ){
      final double[] pgramx = new double[4];
      final double[] pgramy = new double[4];
      double dx = (-offsets[0]-offsets[2])/2;
      double dy = (-offsets[1]-offsets[3])/2;
      pgramx[0]= ox+(dx*scale);
      pgramy[0]= oy-(dy*scale);
      pgramx[1]= ox+((offsets[0]+dx)*scale);
      pgramy[1]= oy-((offsets[1]+dy)*scale);
      pgramx[3]= ox+((offsets[2]+dx)*scale);
      pgramy[3]= oy-((offsets[3]+dy)*scale);
      pgramx[2]= ox+((offsets[0]+offsets[2]+dx)*scale);
      pgramy[2]= oy-((offsets[1]+offsets[3]+dy)*scale);
      g.drawPolygon(pgramx, pgramy, 4, 0);
   }

	public void setRepeat( boolean r ){
		repeat = r;
	}
   public void setShowPara( boolean s ){
      showPara = s;
   }
   public void setShowFill( boolean s ){
      showFill = s;
   }

   public void setTiles(ITile[] tiles0, double[] offsets0, int[] labels0) {
      tiles = null;
      // recalculate bounding box
      if( tiles0!=null ){
         tileXMin = 0;
         tileXMax = 0;
         tileYMin = 0;
         tileYMax = 0;

         for( ITile tile : tiles0){
            for( int i=0; i<tile.size(); i++){
               if( labels0[i]>=0 ){
                  tileXMin = Math.min(tileXMin, tile.getX(i));
                  tileXMax = Math.max(tileXMax, tile.getX(i));
                  tileYMin = Math.min(tileYMin, tile.getY(i));
                  tileYMax = Math.max(tileYMax, tile.getY(i));
               }
            }
         }
         tiles = tiles0;
         offsets = offsets0;
         labels = labels0;
      }
      repaint();
   
   }
}
