package tilingTypes.N5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_02g
   extends TilingType
{
   public TilingTypeN5_02g(){
      super( "N5-2g", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,1,2, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 1,2, 2,3,4, 0},

            {0, 3,4, 0,0,1, 1},
            {1, 3,4, 4,1,2, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 1,2, 6,3,4, 1},
      };
      info = "a+d=b\nb+d=c=e\nA+D=180\nB+D=180\n(C-D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = .5 * getParam(paramValues, 0) / 100.;
      double lnd = .5 - lna;
      double lnb = lna + lnd;
      double lnc = lnb + lnd;
      double a = Functions.BisectionMethod(new Func(lna/lnd), 90, 180, 0.0001);
      double diagAD = calcSide(lnc,lnd,180-a);
      double diagEB = calcSide(lna,lnb,a);
      double angDCE = calcAngle(diagAD,lnd,lnc);
      double angBCE = calcAngle(diagAD,lnc,diagEB);
      double c = angDCE + angBCE;

      double x4 =      lna*Math.cos( a * DEG2RAD);
      double y4 =      lna*Math.sin( a * DEG2RAD);
      double x1 = lnb;
      double y1 = 0;
      double x2 = x1 + lnc*Math.cos( (180-a) * DEG2RAD);
      double y2 = y1 + lnc*Math.sin( (180-a) * DEG2RAD);
      double x3 = x2 + lnd*Math.cos( (-a-c) * DEG2RAD);
      double y3 = y2 + lnd*Math.sin( (-a-c) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[7].getX(4);
      offsets[3] = tiles[1].getY(1)-tiles[7].getY(4);
   }

   private class Func
      implements IFunction
   {
      double lna;
      public Func(double lna0){ lna = lna0; }
      public double calculate(double a){
         double lnb = 1+lna;
         double lnc = 1+lnb;
         double diagEB = calcSide(lna,lnb,a);
         double angEBA = calcAngle(diagEB,lnb,lna);
         double diag1 = calcSide(diagEB,lnc,a-angEBA);
         double diag2 = calcSide(lnc,1,180-a);
         return diag1-diag2;
      }
   }
}
