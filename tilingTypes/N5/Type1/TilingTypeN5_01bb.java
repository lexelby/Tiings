package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01bb
   extends TilingType
{
   public TilingTypeN5_01bb(){
      super( "N5-1bb", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 30, 60};
      paramName = new String[]{ "Relative length 1", "Relative length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,0,1, 1},
            {1, 1,0, 1,0,1, 1},
            {0, 0,1, 2,2,3, 0},

            {0, 4,3, 0,3,2, 1},
            {1, 2,3, 4,0,1, 0},
            {1, 1,0, 5,0,1, 0},
            {0, 0,1, 6,2,3, 1},
      };
      info = "d=a+e\nb=d+e\nB=C\nD+E=180\n(A+2B=360)";
   }
   
   private class Func implements IFunction{
      private double lna,lnb,lnd;
      Func( double a0, double b0, double d0 ){ lna = a0; lnb = b0; lnd = d0; }
      public double calculate(double b) {
         double diag = calcSide(lnb, lna, b);
         double c1 = calcAngle( diag,lnb,lna);
         double c2 = diag>2*lnd ? -370 : Math.acos(diag/2/lnd) / DEG2RAD;
         return c1+c2 - b;
      }
   }
   
   public void recalcBase(double[] paramValues) {
      double lnb = 1 * getParam(paramValues,0)*2/300.;
      double r = 1 - lnb;
      double lne = r * getParam(paramValues,1)/100./3;
      double lnd = r - lne;
      double lnc = lnd + lne;
      double lna = lnc + lne;
      double bc = Functions.BisectionMethod(new Func(lna,lnb,lnd), 5, 120, 0.0001);
      double a = 360-bc-bc;
      
      double x4 =       lne*Math.cos(a * DEG2RAD);
      double y4 =       lne*Math.sin(a * DEG2RAD);
      double x2 = lna + lnb*Math.cos((180-bc)* DEG2RAD);
      double y2 =       lnb*Math.sin((180-bc)* DEG2RAD);
      double x3 = x2 +  lnc*Math.cos((-bc-bc) * DEG2RAD);
      double y3 = y2 +  lnc*Math.sin((-bc-bc) * DEG2RAD);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lna,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(4);
   }
}
