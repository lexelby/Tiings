package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_25
   extends TilingType
{
   public TilingTypeNC6_25(){
      super( "NC6-25", 7, SymmetryType.pgg );

      paramMin = new int[]{ 72};
      paramMax = new int[]{169};
      paramDef = new int[]{100};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {0, 2,3, 0,0,5, 0},
            {1, 0,1, 2,0,1, 1},

            {1, 3,4, 0,4,3, 0},
            {0, 0,1, 4,0,1, 1},
            {0, 2,3, 4,0,5, 0},
            {1, 0,1, 6,0,1, 1},
      };
      info = "a=c=d=e=f\nD+F=360\nD+2E=360\n2A+C=360\n(B+E=A)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.4;
      double f = getParam(paramValues, 0);
      double a = Functions.BisectionMethod(new Func(f), 70, 145, 0.0001);
      double b = a/2;
      double c = 360-a;
      double d = 360-f-f;

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
      offsets[0] = tiles[0].getX(1)-tiles[4].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[4].getY(2);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(2);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(2);
   }
   private class Func implements IFunction{
      private double f;
      Func(double f0){ f = f0; }
      public double calculate(double a) {
         double b = a/2;
         double c = 360-a;
         double d = 360-f-f;
         double dy = Math.sin(f*DEG2RAD);
         dy += Math.sin((f+a-180)*DEG2RAD);
         dy += Math.sin((f+a+b)*DEG2RAD);
         dy += Math.sin((f+a+b+c-180)*DEG2RAD);
         dy += Math.sin((f+a+b+c+d)*DEG2RAD);
         return dy;
      }
   }   
}