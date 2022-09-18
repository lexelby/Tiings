package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_09
   extends TilingType
{
   public TilingTypeN5_09(){
      super( "N5-9: Marjorie Rice, 1976", 5, SymmetryType.pgg );

      paramMin = new int[]{135};
      paramMax = new int[]{180};
      paramDef = new int[]{150};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,3,4, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 3,4, 2,2,3, 0},

            {0, 0,1, 0,2,3, 1},
            {1, 2,3, 4,3,4, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 3,4, 6,2,3, 1},
      };
      info = "b=c=d=e\n2A+C=360\nD+2E=360\n(2B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double d = getParam( paramValues,0);
      // find angle b s.t. angle e is correct
      double e = Functions.BisectionMethod(new Func(d), 60, 135, 0.001);
      double c = 360-2*d;
      double b = 360-2*e;
      double a = 540-b-c-d-e;

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
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(1);
      offsets[2] = tiles[7].getX(1)-tiles[2].getX(2);
      offsets[3] = tiles[7].getY(1)-tiles[2].getY(2);
   }

   private class Func implements IFunction{
      private double d;
      public Func(double d0){ d=d0; }
      public double calculate(double e){
         double b = 360-2*e;
         double c = 360-2*d;

         double y1 = 0;
         double y2 = y1 + Math.sin( (180-d) * DEG2RAD);
         double y3 = y2 + Math.sin( (180-d+180-c) * DEG2RAD);
         double y4 = y3 + Math.sin( (180-d+180-c+180-b) * DEG2RAD);
         return y4-Math.sin(e*DEG2RAD);
      }
   }
}
