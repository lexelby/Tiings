package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01h
   extends TilingType
{
   public TilingTypeN5_01h(){
      super( "N5-1h", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 1,2, 0,2,1, 0},
            {1, 0,1, 2,0,1, 1},

            {1, 3,4, 2,0,4, 0},
            {0, 0,1, 4,0,1, 1},
            {0, 1,2, 5,2,1, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "d=2a=2e\nC+D=180\n2B+C=360\nE=90\n(2A+D=360)";
   }

   private class Func implements IFunction{
      private double lnc;
      Func( double lnc0 ){ lnc = lnc0; }
      public double calculate(double a) {
         double dy = Math.sin(a*DEG2RAD) + (1-lnc)*Math.sin((a-90)*DEG2RAD) + 2*Math.sin((90-a)*DEG2RAD);
         return dy;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lnc = getParam( paramValues,0)/100. * (1+Math.sqrt(3));
      double a = Functions.BisectionMethod(new Func(lnc), 100, 135, 0.0001);
      double ln = .5;
      lnc *= ln;

      double x4 =      ln*Math.cos( (a) * DEG2RAD);
      double y4 =      ln*Math.sin( (a) * DEG2RAD);
      double x3 = x4 + ln*Math.cos( (a-90) * DEG2RAD);
      double y3 = y4 + ln*Math.sin( (a-90) * DEG2RAD);
      double x2 = x3 +2*ln* Math.cos( (90-a) * DEG2RAD);
      double y2 = y3 +2*ln* Math.sin( (90-a) * DEG2RAD);
      double x1 = x2 +lnc* Math.cos( (90+a) * DEG2RAD);
      double y1 = y2 +lnc* Math.sin( (90+a) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[7].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[7].getY(3)-tiles[0].getY(0);
   }
}
