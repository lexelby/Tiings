package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01an
   extends TilingType
{
   public TilingTypeN5_01an(){
      super( "N5-1an", 5, SymmetryType.pgg );

      paramMin = new int[]{ 47};
      paramMax = new int[]{ 90};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };
      
      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,1, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 2,1, 2,0,1, 0},

            {0, 4,0, 0,3,4, 1},
            {1, 0,1, 4,2,1, 1},
            {1, 2,1, 5,1,2, 1},
            {0, 2,1, 6,0,1, 1},
      };
      info = "a=e\nb=a+d\nc=b+d\nB+C=180\nA=B\n(A+D+E=360)";
   }

   private class Func implements IFunction{
      private double a;
      public Func( double a0 ){a = a0;}
      public double calculate(double lnc) {
         double lna=1+lnc;
         double lnb=lna+lnc;
         double dx = lna - (1+lnb)*Math.cos(a*DEG2RAD) - lnc;
         double dy = 2*lnc*Math.sin(a*DEG2RAD);
         return dx*dx+dy*dy - 1;
      }
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double lnd = .6;
      double lnc = lnd * Functions.BisectionMethod(new Func(a), 0, 1, 0.0001);
      double lna = lnd + lnc;
      double lnb = lna + lnc;

      double x2 = lna + lnb * Math.cos((180-a) * DEG2RAD);
      double y2 =       lnb * Math.sin((180-a) * DEG2RAD);
      double x4 =       lnd * Math.cos(a * DEG2RAD);
      double y4 =       lnd * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lna,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x2-lnc, y2);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(0);
   }
}
