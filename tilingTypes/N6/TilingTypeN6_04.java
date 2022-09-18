package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN6_04
   extends TilingType
{
   public TilingTypeN6_04(){
      super( "N6-4", 6, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{240};
      paramDef = new int[]{155};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,2,3, 1},
            {0, 2,1, 0,1,2, 0},
            {1, 1,2, 2,2,3, 1},
            {0, 0,5, 1,4,5, 1},
            {1, 1,2, 4,2,3, 0},
            {0, 2,1, 4,1,2, 1},
            {1, 1,2, 6,2,3, 0},
      };
      info = "a=c=d=e=f\n2A+E=360\nD+2F=360\nC+D+E=360\n(A+B+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      // ~A+E+F=360~A+B-C-D=0~2C+E=360~2D+F=360
      double f = paramValues[0];
      double e = Functions.BisectionMethod(new Func(f), 0, 180, .001);
      double d = 180-f/2;
      double c = 180-e/2;
      double a = 360-f-e;

      double x5 =      ln * Math.cos( c * DEG2RAD);
      double y5 =      ln * Math.sin( c * DEG2RAD);
      double x4 = x5 + ln * Math.cos( (c+d-180) * DEG2RAD);
      double y4 = y5 + ln * Math.sin( (c+d-180) * DEG2RAD);
      double x3 = x4 + ln * Math.cos( (c+d+e) * DEG2RAD);
      double y3 = y4 + ln * Math.sin( (c+d+e) * DEG2RAD);
      double x2 = x3 + ln * Math.cos( (c+d+e+f-180) * DEG2RAD);
      double y2 = y3 + ln * Math.sin( (c+d+e+f-180) * DEG2RAD);
      double x1 = x2 + ln * Math.cos( (c+d+e+f+a) * DEG2RAD);
      double y1 = y2 + ln * Math.sin( (c+d+e+f+a) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[2].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[2].getY(3);
      offsets[2] = tiles[5].getX(0)-tiles[3].getX(4);
      offsets[3] = tiles[5].getY(0)-tiles[3].getY(4);
   }

   private class Func implements IFunction{
      private double f;
      public Func(double f0){ f=f0; }
      public double calculate(double e){
         // get angles  ~A+E+F=360~A+B-C-D=0~2C+E=360~2D+F=360
         double d = 180-f/2;
         double c = 180-e/2;
         double a = 360-f-e;

         // get vertical offset
         double dy = Math.sin(c * DEG2RAD);
         dy += Math.sin((c+d-180) * DEG2RAD);
         dy += Math.sin((c+d+e) * DEG2RAD);
         dy += Math.sin((c+d+e+f-180) * DEG2RAD);
         dy += Math.sin((c+d+e+f+a) * DEG2RAD);

         return dy;
      }
   }
}