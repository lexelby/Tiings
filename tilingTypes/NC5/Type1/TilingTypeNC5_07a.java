package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_07a
   extends TilingType
{
   public TilingTypeNC5_07a(){
      super( "NC5-7a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 70, 30};
      paramName = new String[]{ "Relative Length", "Angle" };
   
      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,3, 0,3,0, 0},
            {0, 3,4, 0,3,4, 1},
            {0, 3,4, 1,3,4, 1},

            {0, 2,1, 1,4,0, 0},
            {1, 3,4, 4,3,4, 1},
            {1, 0,3, 5,3,0, 1},
            {0, 3,4, 6,3,4, 0},
      };
      info = "a=c\nb=d\nB+C=360\n(A+D+E=180)";
   }


   private class Func implements IFunction{
      private double ln, c;
      public Func(double ln0, double c0){ ln = ln0; c = c0; }
      public double calculate(double d){

         double x2 = 2 + ln* Math.cos( (180-d) * DEG2RAD);
         double y2 = 0 + ln* Math.sin( (180-d) * DEG2RAD);
         double x3 = ln* Math.cos( c * DEG2RAD);
         double y3 = ln* Math.sin( c * DEG2RAD);

         // get angle 0,0 - x3,y3 - x2,y2
         x2-=x3; y2-=y3;  // vector from p3 to p2
         x3=-x3; y3=-y3;  // vector from p2 to 0,0
         double ln1 = Math.sqrt( x3*x3+y3*y3 );
         x3 /=ln1; y3/=ln1;  // normalise first vector
         ln1 = Math.sqrt( x2*x2+y2*y2 );
         x2 /=ln1; y2/=ln1;  // normalise second vector
         double b = Math.acos(x2*x3+y2*y3) / DEG2RAD;

         return 2*b+c-d;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 1.5 * paramValues[0]/100;   // length of two sides
      double lna = (1.5 - lnb)/2; // length of two parallel sides
      double c = paramValues[1];
      double d = Functions.BisectionMethod(new Func(lnb/lna,c), 180, 360, 0.001);
      //double e = 360-d;
      //double b = (d-c)/2;
      //double a = 180-c-b;

      double x2 = lna- lnb * Math.cos( d * DEG2RAD);
      double y2 =      lnb * Math.sin( d * DEG2RAD);
      double x3 = x2 + lna;
      double y3 = y2;
      double x4 = lnb * Math.cos( c * DEG2RAD);
      double y4 = lnb * Math.sin( c * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lna,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[1].getX(4);
      offsets[1] = tiles[2].getY(0)-tiles[1].getY(4);
      offsets[2] = tiles[5].getX(4)-tiles[3].getX(2);
      offsets[3] = tiles[5].getY(4)-tiles[3].getY(2);
   }
}
