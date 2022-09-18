package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_130
   extends TilingType
{
   public TilingTypeNC5_130(){
      super( "NC5-130", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,4,0, 1},
            {1, 0,4, 1,4,0, 1},
            {0, 4,0, 2,1,2, 0},

            {0, 2,1, 1,0,1, 1},
            {1, 1,2, 4,4,0, 0},
            {1, 0,4, 5,4,0, 0},
            {0, 4,0, 6,1,2, 1},
      };
      info = "b=d+e\na=c=b+e\nB+E=180\nB+D=360\n(A+C+E=180)";
   }
   class Func implements IFunction {
      private double lnc, lnd;
      Func(double c, double d){ lnc = c; lnd = d; }
      public double calculate(double b) {
         double diag1 = calcSide(lnc+lnd,lnc+2*lnd, b);
         double ce = calcSide(lnc,lnd,b);
         double ang = 180-b + calcAngle(lnd,ce,lnc);
         double diag2 = calcSide(ce,lnc+2*lnd,ang);
         return diag1-diag2;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 0.6;
      double lnc = lntotal * getParam(paramValues, 0)/100;
      double lnd = lntotal - lnc;
      double lna = lnc + lnd;
      double lnbe = lna + lnd;

      double b = Functions.BisectionMethod(new Func(lnc,lnd), 60, 120, 0.00001);

      double diag = calcSide(lna,lnbe, b);
      double ce = calcSide(lnc,lnd,b);
      double a = calcAngle(diag,lnbe,ce)+calcAngle(diag,lna,lnbe);
      
      double x1 = lna;
      double y1 = 0;
      double x2 = x1 + lnbe * Math.cos((180-b) * DEG2RAD);
      double y2 = y1 + lnbe * Math.sin((180-b) * DEG2RAD);
      double x4 =      lnbe * Math.cos(a * DEG2RAD);
      double y4 =      lnbe * Math.sin(a * DEG2RAD);
      double x3 = x4 + lnd * Math.cos((a-b)*DEG2RAD);
      double y3 = y4 + lnd * Math.sin((a-b)*DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(3);
   }
}
