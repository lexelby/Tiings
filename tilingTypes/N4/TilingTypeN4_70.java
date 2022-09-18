package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN4_70
   extends TilingType
{
   public TilingTypeN4_70(){
      super( "N4-70", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{"Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 2,1, 0,1,2, 0},
            {1, 0,1, 2,0,1, 1},

            {0, 0,3, 3,2,3, 1},
            {1, 0,1, 4,0,1, 0},
            {0, 2,1, 4,1,2, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "a=d\nD=90\n2A+C=180\n(B-A=90)";
   }
   
   private class Func implements IFunction{
      private double lnb;
      public Func( double lnb0 ){ lnb = lnb0; }
      public double calculate(double b) {
         double diag = calcSide(1,lnb,b);
         double a = calcAngle(1,diag,lnb);
         return b-a-135;
      }
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double lnb = ln * getParam(paramValues,0)/100.;
      double lna = ln - lnb;
      double b = Functions.BisectionMethod(new Func(lnb/lna), 135, 180, 0.001);

      double a = b-90;
      double diag = calcSide(lna,lnb,b);
      double lnd = diag/Math.sqrt(2);

      double x2 = lna- lnb * Math.cos(b * DEG2RAD);
      double y2 =      lnb * Math.sin(b * DEG2RAD);
      double x3 =      lnd * Math.cos(a * DEG2RAD);
      double y3 =      lnd * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1,lna,  0);
      baseTile.setPoint(2,x2, y2);
      baseTile.setPoint(3,x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(3)-tiles[0].getX(3);
      offsets[1] = tiles[7].getY(3)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(3)-tiles[2].getX(3);
      offsets[3] = tiles[5].getY(3)-tiles[2].getY(3);
   }
}
