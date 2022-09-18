package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_215
   extends TilingType
{
   public TilingTypeNC5_215(){
      super( "NC5-215", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 40};
      paramName = new String[]{"Aspect", "Relative length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,2,4, 1},
            {1, 0,4, 1,4,0, 1},
            {0, 2,4, 2,0,2, 0},

            {0, 4,0, 0,1,2, 1},
            {1, 0,2, 4,2,4, 0},
            {1, 0,4, 5,4,0, 0},
            {0, 2,4, 6,0,2, 1},
      };
      info = "a=c\nd=e\nA=D\nB=C\nC+E=360\n(2A+B=180)";
   }

   private class Func implements IFunction{
      private double angr, r;
      Func(double angr0, double r0){ r=r0; angr = angr0; }
      public double calculate(double y) {
         return r * Math.sin(y * DEG2RAD) - (1-r)*Math.sin((angr-y-y)*DEG2RAD);
      }
      
   }
   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double lnh = lnt * getParam(paramValues, 0)/100;
      double lna = lnt - lnh;
      double r = Math.atan2(lnh,lna/2)/DEG2RAD;
      double rl = getParam(paramValues, 1)/100;
      double y = Functions.BisectionMethod(new Func(r,rl), 0, r/2, 0.00001);
      double x = r-y-y;
      double a = r+x;
      double e = 180-x-y;
      double d = 180-r-r-x+y;
      double diag = Math.sqrt(lna*lna/4 + lnh*lnh);
      double lnbd = diag/Math.sin(e*DEG2RAD)*Math.sin(x*DEG2RAD);
      double lnce = diag/Math.sin(e*DEG2RAD)*Math.sin(y*DEG2RAD);

      double x4 =      0;
      double y4 =      lna;
      double x3 = x4 + lnce * Math.cos((a-90)*DEG2RAD);
      double y3 = y4 + lnce * Math.sin((a-90)*DEG2RAD);
      double x2 = x3 + lnbd * Math.cos((a+e+90)*DEG2RAD);
      double y2 = y3 + lnbd * Math.sin((a+e+90)*DEG2RAD);
      double x1 = x2 + lnce * Math.cos((a+e+d-90)*DEG2RAD);
      double y1 = y2 + lnce * Math.sin((a+e+d-90)*DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[4].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(1);
   }
}
