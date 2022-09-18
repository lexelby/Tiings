package tilingTypes;

public class Tile
   implements ITile
{

   // Tiling type base
   private int colour;
   private double[] x;
   private double[] y;

   public Tile( int sz ){
      x = new double[sz];
      y = new double[sz];
   }

   public int size(){ return x.length; }
   public int getColour(){ return colour; }
   public double getX(int i){ return x[i]; }
   public double getY(int i){ return y[i]; }

   public void setColour(int c){ colour = c; }
   public void setPoint(int ix, double x0, double y0){
      x[ix] = x0;
      y[ix] = y0;
   }
   public double getPointX(int ix){
      return x[ix];
   }
   public double getPointY(int ix){
      return y[ix];
   }

   public void setPosition(ITile original){
      for( int i=0; i<original.size(); i++ ){
         x[i] = original.getX(i);
         y[i] = original.getY(i);
      }
   }
   public void translate( double dx, double dy){
      for( int i=0; i<size(); i++ ){
         x[i] += dx;
         y[i] += dy;
      }
   }
   public void rotate(double x0, double y0, double angleRad){
      double s = Math.sin(angleRad);
      double c = Math.cos(angleRad);
      for( int i=0; i<size(); i++ ){
         double x1 = x[i]-x0;
         double y1 = y[i]-y0;
         double x2 = x1*c-y1*s;
         double y2 = y1*c+x1*s;
         x[i] = x2+x0;
         y[i] = y2+y0;
      }
   }
   public void scale(double x0, double y0, double f){
      for( int i=0; i<size(); i++ ){
         x[i] = (x[i]-x0)*f+x0;
         y[i] = (y[i]-y0)*f+y0;
      }
   }

   public void mirror(double y2) {
      for( int i=0; i<size(); i++ ){
         y[i] = y2-(y[i]-y2);
      }
   }
}
