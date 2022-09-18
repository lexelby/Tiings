package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01ay
   extends TilingType
{
   public TilingTypeN5_01ay(){
      super( "N5-1ay: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 25};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,1,0, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 1,0, 2,4,0, 0},

            {0, 4,0, 0,1,2, 1},
            {1, 4,0, 4,1,0, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 1,0, 6,4,0, 1},
      };
      info = "a=c\n2a=b+d\nB=C\nD=E\nA+B=180\n(B+2E=360)";
   }
   
   private class Func implements IFunction{
      private double f;
      public Func( double f0 ){ f = f0; }
      public double calculate(double b) {
         double lnd = calcSide(f,1-f,b);
         double a2 = calcAngle(f,lnd,1-f);
         return 540-4*b-a2;
      }
      
   }
   
   public void recalcBase(double[] paramValues) {
      double f = getParam(paramValues,0)/100.;
      double bc = Functions.BisectionMethod(new Func(f), 120, 135, 0.0001);
      double ae = 360-bc-bc;
      double d = 180-ae;

      double lnb = 1-f;
      double lna = f;
      double lnd = calcSide(lna,lnb,bc);
      double lnc = (lnd+lna)/2;
      
      //scale
      f = 1.7 / (lnd + lnc);
      lna *= f;
      lnb *= f;
      lnc *= f;
      lnd *= f;
      
      double x4 =       lnc*Math.cos(d * DEG2RAD);
      double y4 =       lnc*Math.sin(d * DEG2RAD);
      double x2 = lnd + x4;
      double y2 =       y4;
      double x3 = x2 +  lna*Math.cos((-ae-ae) * DEG2RAD);
      double y3 = y2 +  lna*Math.sin((-ae-ae) * DEG2RAD);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnd,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[2].getX(3);
      offsets[1] = tiles[1].getY(2)-tiles[2].getY(3);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(1);
   }
}
