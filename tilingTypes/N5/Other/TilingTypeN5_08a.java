package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_08a
   extends TilingType
{
   public TilingTypeN5_08a(){
      super( "N5-8a: Richard B. Kershner, 1968", 5, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{112};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,4, 1},
            {1, 2,3, 0,3,4, 1},
            {0, 0,4, 2,0,4, 0},

            {0, 1,0, 2,1,2, 1},
            {1, 0,4, 4,0,4, 0},
            {1, 2,3, 4,3,4, 0},
            {0, 0,4, 6,0,4, 1},
      };
      info = "b=c=d=e\n2B+C=360\nD+2E=360\n(2A+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double a = paramValues[0];
      double b = 360-2*a;
      // find angle b s.t. angle e is correct
      double d = Functions.BisectionMethod(new Func(a), 90, 180, 0.001);
      double c = 360-2*d;

      double x2 = ln + ln*Math.cos( (180-a) * DEG2RAD);
      double y2 =      ln*Math.sin( (180-a) * DEG2RAD);
      double x3 = x2 + ln*Math.cos( (-a-b) * DEG2RAD);
      double y3 = y2 + ln*Math.sin( (-a-b) * DEG2RAD);
      double x4 = x3 + ln*Math.cos( (-a-b+180-c) * DEG2RAD);
      double y4 = y3 + ln*Math.sin( (-a-b+180-c) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(1);
   }

   private class Func implements IFunction{
      private double a;
      public Func(double a0){ a=a0; }
      public double calculate(double d){
         double b = 360-2*a;
         double c = 360-2*d;

         double x1 = 1;
         double y1 = 0;
         double x2 = x1 + Math.cos( (180-a) * DEG2RAD);
         double y2 = y1 + Math.sin( (180-a) * DEG2RAD);
         double x3 = x2 + Math.cos( (180-a+180-b) * DEG2RAD);
         double y3 = y2 + Math.sin( (180-a+180-b) * DEG2RAD);
         double x4 = x3 + Math.cos( (180-a+180-b+180-c) * DEG2RAD);
         double y4 = y3 + Math.sin( (180-a+180-b+180-c) * DEG2RAD);
         double e = Math.atan2(y4,x4)/DEG2RAD;
         return a+b+c+d+e - 3*180;
      }
   }
}
