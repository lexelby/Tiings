package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_151
   extends TilingType
{
   public TilingTypeNC5_151(){
      super( "NC5-151", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 3,4, 1,4,3, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 0,4, 0,2,1, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 3,4, 5,4,3, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=d=2c\n2A=E\nC+E=360\nB=90\n(A+D=90)";
   }
   
   class Func implements IFunction{
      double lna, lnb;
      Func(double lna0, double lnb0){
         lna = lna0;
         lnb = lnb0;
      }
      public double calculate(double d) {
         double dy1 = lna * Math.sin(d*DEG2RAD) + lnb * Math.sin((180+3*d)*DEG2RAD);
         double dy2 = lna/2 - lna * Math.cos(2*d*DEG2RAD);
         return dy1-dy2;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lnb = lnt * (getParam(paramValues, 0)*2/100 + 1.0)/3; 
      double lnac = lnt - lnb;
      double lne = lnac / 2;

      double d = Functions.BisectionMethod(new Func(lnac, lnb), 40, 90, 0.00001); 
         
      double x4 = lnac * Math.cos(d*DEG2RAD);
      double y4 = lnac * Math.sin(d*DEG2RAD);
      double x3 = x4 + lnb * Math.cos((3*d-180)*DEG2RAD);
      double y3 = y4 + lnb * Math.sin((3*d-180)*DEG2RAD);
      double x2 = x3 + lnac * Math.cos((2*d+90)*DEG2RAD);
      double y2 = y3 + lnac * Math.sin((2*d+90)*DEG2RAD);
      double x1 = x2;
      double y1 = y2 - lne;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(0);
   }
}
