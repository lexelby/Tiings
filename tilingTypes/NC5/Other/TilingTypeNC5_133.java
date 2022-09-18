package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_133
   extends TilingType
{
   public TilingTypeNC5_133(){
      super( "NC5-133", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,3,2, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 3,2, 2,1,2, 0},

            {0, 2,1, 0,0,4, 1},
            {1, 1,2, 4,3,2, 1},
            {1, 3,2, 5,2,3, 1},
            {0, 3,2, 6,1,2, 1},
      };
      info = "a=c\nb=e\nd=a+b\nC+D=180\nB+D=360\n(A+C+E=180)";
   }
   class Func implements IFunction {
      private double lna, lnb;
      Func(double a, double b){ lna = a; lnb = b; }
      public double calculate(double c) {
         double dx = lna*Math.cos(c*DEG2RAD)+lnb-lna;
         double dy = (lna+2*lnb)*Math.sin(c*DEG2RAD);
         return dx*dx+dy*dy-lna*lna;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double lnbe = lntotal * getParam(paramValues, 0)/200;
      double lnac = lntotal - lnbe;
      double lnd = lnac + lnbe;

      double c = Functions.BisectionMethod(new Func(lnac,lnbe), 0, 60, 0.00001);
      double cs = Math.cos(c*DEG2RAD);
      double sn = Math.sin(c*DEG2RAD);
      
      double x1 = lnbe * cs;
      double y1 = lnbe * sn;
      double x2 = x1 + lnac;
      double y2 = y1;
      double x3 = x2 - lnd * cs;
      double y3 = y2 + lnd * sn;
      double x4 = x3 - lnbe;
      double y4 = y3;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[4].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(2);
   }
}
