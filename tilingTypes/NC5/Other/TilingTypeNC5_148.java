package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_148
   extends TilingType
{
   public TilingTypeNC5_148(){
      super( "NC5-148", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 25};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 3,1, 0,3,0, 0},
            {1, 0,1, 2,1,0, 0},
      };
      info = "a=c\nd=e\nA=D\nB=C\nC+E=360\n(2A+B=180)";
   }
   class Func implements IFunction{
      double r;
      Func(double r0){ r = r0; }
      public double calculate(double x) {
         double y = (360-7*x)/3;
         return r*Math.sin(x*DEG2RAD)-Math.sin(y*DEG2RAD);
      }
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.0;
      double lnb = lnt * getParam(paramValues, 0)/100;
      double lna = lnt - lnb;
      
      double x = Functions.BisectionMethod(new Func(lna/lnb), 0, 90, 0.00001);
      double d = (90-x)*2/3;
      double e = 180-2*d;
      
      double x4 =      lna*Math.cos(d*DEG2RAD);
      double y4 =      lna*Math.sin(d*DEG2RAD);
      double x3 = x4 + lnb*Math.cos((d+180-e)*DEG2RAD);
      double y3 = y4 + lnb*Math.sin((d+180-e)*DEG2RAD);
      double x2 = x3 + lnb*Math.cos((d-e+d)*DEG2RAD);
      double y2 = y3 + lnb*Math.sin((d-e+d)*DEG2RAD);
      double x1 = x2 + lna*Math.cos(-e*DEG2RAD);
      double y1 = y2 + lna*Math.sin(-e*DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[2].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[1].getX(1)-tiles[3].getX(4);
      offsets[3] = tiles[1].getY(1)-tiles[3].getY(4);
   }
}
