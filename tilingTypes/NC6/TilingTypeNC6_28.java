package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_28
   extends TilingType
{
   public TilingTypeNC6_28(){
      super( "NC6-28", 6, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{240};
      paramDef = new int[]{110};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {0, 5,0, 1,0,5, 1},
            {1, 0,1, 2,0,1, 0},

            {1, 1,2, 1,3,2, 1},
            {0, 0,1, 4,0,1, 0},
            {0, 5,0, 5,0,5, 0},
            {1, 0,1, 6,0,1, 1},
      };
      info = "a=c=d=e=f\nD+E=360\n2A+F=360\n2B=E\n(B+C=A)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.5;
      double b = getParam(paramValues, 0);

      double a = Functions.BisectionMethod(new Func(b), 0, 90, 0.0001);
      double f = 180-a/2;
      double c = 360-b;
      double d = (360-a-b)/2;
      
      double x5 =      ln * Math.cos( f * DEG2RAD );
      double y5 =      ln * Math.sin( f * DEG2RAD );
      double x4 = x5 + ln * Math.cos( (f-180+a) * DEG2RAD );
      double y4 = y5 + ln * Math.sin( (f-180+a) * DEG2RAD );
      double x3 = x4 + ln * Math.cos( (f+a+b) * DEG2RAD );
      double y3 = y4 + ln * Math.sin( (f+a+b) * DEG2RAD );
      double x2 = x3 + ln * Math.cos( (f+a+b-180+c) * DEG2RAD );
      double y2 = y3 + ln * Math.sin( (f+a+b-180+c) * DEG2RAD );
      double x1 = x2 + ln * Math.cos( (f+a+b+c+d) * DEG2RAD );
      double y1 = y2 + ln * Math.sin( (f+a+b+c+d) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(5);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(5);
      offsets[2] = tiles[2].getX(3)-tiles[7].getX(1);
      offsets[3] = tiles[2].getY(3)-tiles[7].getY(1);
   }
   private class Func implements IFunction{
      private double b;
      Func(double b0){ b = b0; }
      public double calculate(double a) {
         double f = 180-a/2;
         double c = 360-b;
         double d = (360-a-b)/2;
         
         double dy = Math.sin( f * DEG2RAD );
         dy += Math.sin( (f-180+a) * DEG2RAD );
         dy += Math.sin( (f+a+b) * DEG2RAD );
         dy += Math.sin( (f+a+b-180+c) * DEG2RAD );
         dy += Math.sin( (f+a+b+c+d) * DEG2RAD );
         return dy;
      }
   }   
}