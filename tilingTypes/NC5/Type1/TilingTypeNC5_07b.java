package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_07b
   extends TilingType
{
   public TilingTypeNC5_07b(){
      super( "NC5-7b", 5, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{120};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };
      
      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,2, 0,2,0, 0},
            {0, 2,1, 0,0,1, 0},
            {0, 2,1, 1,0,1, 0},

            {0, 3,4, 1,1,2, 1},
            {1, 1,0, 4,1,2, 1},
            {1, 2,0, 5,0,2, 1},
            {0, 2,1, 6,0,1, 1},
      };
      info = "a=d\nb=c=e\nD+E=360\n(A+B+C=180)";
   }

   private class Func implements IFunction{
      private double b;
      public Func(double b0){ b = b0; }
      public double calculate(double d){
         double base = 2*Math.sin(b/2 * DEG2RAD);
         double x = Math.asin( ( Math.sin(d*DEG2RAD)/base ) )/DEG2RAD;
         double a = 90-b/2 - x;
         double c = 90-b/2 + x;

         return a+2*c-d;
      }
   }

   public void recalcBase(double[] paramValues) {
      double b = paramValues[0];
      double d = b==60 ? 180 : Functions.BisectionMethod(new Func(b), 90, 180, 0.001);
      double e = 360-d;
      double base = 2*Math.sin(b/2 * DEG2RAD);
      double x = Math.asin( ( Math.sin(d*DEG2RAD)/base ) )/DEG2RAD;
      double a = 90-b/2 - x;
      double c = 90-b/2 + x;
      double ln2 = Math.sin((180-x-d)*DEG2RAD)/Math.sin(x*DEG2RAD)/2 ;

      double x4 =      ln2 * Math.cos( (a) * DEG2RAD);
      double y4 =      ln2 * Math.sin( (a) * DEG2RAD);
      double x3 = x4 +       Math.cos( (a-180+e) * DEG2RAD);
      double y3 = y4 +       Math.sin( (a-180+e) * DEG2RAD);
      double x2 = x3 + ln2 * Math.cos( (a+e+d) * DEG2RAD);
      double y2 = y3 + ln2 * Math.sin( (a+e+d) * DEG2RAD);
      double x1 = x2 +       Math.cos( (a-180+e+d+c) * DEG2RAD);
      double y1 = y2 +       Math.sin( (a-180+e+d+c) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[1].getX(1);
      offsets[1] = tiles[2].getY(0)-tiles[1].getY(1);
      offsets[2] = tiles[3].getX(3)-tiles[4].getX(1);
      offsets[3] = tiles[3].getY(3)-tiles[4].getY(1);
   }
}
