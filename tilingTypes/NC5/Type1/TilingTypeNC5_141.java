package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_141
   extends TilingType
{
   public TilingTypeNC5_141(){
      super( "NC5-141", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,2,3, 0},
            {1, 4,0, 1,0,4, 0},
            {0, 2,3, 2,4,3, 0},
            
            {0, 3,4, 0,4,0, 1},
            {1, 4,3, 4,2,3, 1},
            {1, 4,0, 5,0,4, 1},
            {0, 2,3, 6,4,3, 1},
      };
      info = "a=e=b+d\nb+c=d\nC=D\nB+C=360\n(A+D+E=180)";
   }

   private class Func implements IFunction{
      private double lna, lnb;
      Func(double lna0, double lnb0){ lna = lna0; lnb = lnb0; }
      public double calculate(double b) {
         double lnd = 2*lna+lnb;
         double dx = lnd - 2*(lna+lnb)*Math.cos(b*DEG2RAD);
         double dy = 2*lna*Math.sin(b*DEG2RAD);
         return dx*dx+dy*dy - lnd*lnd;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lnc = 0.7;
      double lnb = lnc * getParam(paramValues,0)/100;
      double lna = lnc - lnb;
      double lnd = lnc + lna;
      double b = Functions.BisectionMethod(new Func(lna,lnb), 0, 180, 0.00000001);

      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lna, 0);
      baseTile.setPoint(2,  lna - c*lnb, -s*lnb);
      baseTile.setPoint(3,  lna+lnc - c*lnb, -s*lnb);
      baseTile.setPoint(4,  lna+lnc - c*lnb-c*lnd, -s*lnb+s*lnd);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(0);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(0);
   }
}
