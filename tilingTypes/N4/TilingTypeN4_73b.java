package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN4_73b
   extends TilingType
{
   public TilingTypeN4_73b(){
      super( "N4-73b", 4, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,1,0, 0},
            {0, 2,1, 1,1,0, 1},
            {1, 3,0, 2,1,0, 1},
      };
      info = "b=c+d\na=d\nA+C=180\n(B+D=180)";
   }
   private class Func implements IFunction{
      private double lnb;
      public Func(double lnb0){lnb = lnb0;}
      public double calculate(double b) {
         double diag = calcSide(1,lnb,b);
         double lnc = 1-lnb;
         double d = calcAngle(lnc,lnc,diag);
         return b+d-180;
      }
      
   }
   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double f = getParam(paramValues,0)/100;
      double lna = ln * (1 + f)/2;
      double lnb = ln - lna;
      double lnc = lna-lnb;
      double b = Functions.BisectionMethod(new Func(lnb/lna), 0, 180, 0.0001);
      double diag = calcSide(lna,lnb,b);
      double a = calcAngle(lna,diag,lnb) + calcAngle(diag,lnc,lnc);

      double x3 = lnc * Math.cos(a * DEG2RAD);
      double y3 = lnc * Math.sin(a * DEG2RAD);
      double x2 = lna - lnb * Math.cos(b * DEG2RAD);
      double y2 =       lnb * Math.sin(b * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[3].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[3].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(3);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(3);
   }
}
