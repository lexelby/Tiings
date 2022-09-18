package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_127
   extends TilingType
{
   public TilingTypeNC5_127(){
      super( "NC5-127", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 65};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,3,4, 0},
            {1, 3,0, 1,0,3, 0},
            {0, 3,4, 2,0,4, 0},

            {0, 2,3, 0,1,2, 1},
            {1, 0,4, 4,3,4, 1},
            {1, 3,0, 5,0,3, 1},
            {0, 3,4, 6,0,4, 1},
      };
      info = "a=e\nb=d\nc=a+2b\nB+C=360\nD=E\n(A+D+E=180)";
   }
   class Func implements IFunction{
      double lnab, lnce;
      Func(double ab, double ce){lnab = ab; lnce = ce;}
      public double calculate(double diag) {
         double ang = 2 * Math.asin(diag/2/lnab)/DEG2RAD;
         double ang2 = diag<=lnab ? 180 : calcAngle(diag,lnce*2,lnab+lnce*2);
         return ang2+90-ang*3/2;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.1;

      double lnce = lntotal * getParam(paramValues,0)/900;
      double lnab = lntotal - lnce;
      double lnd = lnab + 2*lnce;

      double diag = Functions.BisectionMethod(new Func(lnab,lnce), lnd-2*lnce, lnd +2*lnce, 0.00000001);
      double ang = calcAngle(diag,2*lnce,lnd);
      double h = Math.sqrt(lnab*lnab-diag*diag/4);

      double x1 = lnce * Math.cos(ang*DEG2RAD);
      double y1 = lnce * Math.sin(ang*DEG2RAD);
      double x3 = diag;
      double y3 = 0;
      double x2 = x3-x1;
      double y2 = y3-y1;
      double x4 = diag/2;
      double y4 = h;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(1);
   }
}
