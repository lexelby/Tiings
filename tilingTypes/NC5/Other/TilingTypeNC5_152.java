package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_152
   extends TilingType
{
   public TilingTypeNC5_152(){
      super( "NC5-152", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 0,1, 2,0,1, 0},
            
            {0, 2,1, 1,4,0, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "d=e\nc=a+2d\nD=90\nE=2B\nC+E=360\n(A+B=90)";
   }
   class Func implements IFunction{
      double lnc,lnd;
      Func(double lnc0, double lnd0){ lnc = lnc0; lnd = lnd0; }
      public double calculate(double c) {
         double lna =lnc+2*lnd; 
         double y4 =      lnc * Math.sin(c*DEG2RAD);
         double y3 = y4 + lnd * Math.sin(-c*DEG2RAD);
         double y2 = y3 + lnd * Math.sin((-c-90)*DEG2RAD);
         double y1 = y2 + lna * Math.sin((c-90)*DEG2RAD);
         return y1;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnde = lna * getParam(paramValues, 0)/600;
      double lnc = lna - 2*lnde;
      
      double c = Functions.BisectionMethod(new Func(lnc,lnde), 0, 90, 0.00001);
     
      double x4 =      lnc * Math.cos(c*DEG2RAD);
      double y4 =      lnc * Math.sin(c*DEG2RAD);
      double x3 = x4 + lnde* Math.cos(-c*DEG2RAD);
      double y3 = y4 + lnde* Math.sin(-c*DEG2RAD);
      double x2 = x3 + lnde* Math.cos((-c-90)*DEG2RAD);
      double y2 = y3 + lnde* Math.sin((-c-90)*DEG2RAD);
      double x1 = x2 + lna * Math.cos((c-90)*DEG2RAD);
      double y1 = y2 + lna * Math.sin((c-90)*DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[5].getX(4);
      offsets[3] = tiles[0].getY(2)-tiles[5].getY(4);
   }
}
