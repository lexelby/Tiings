package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_147
   extends TilingType
{
   public TilingTypeNC5_147(){
      super( "NC5-147", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,3, 0,1,3, 0},
            {0, 3,2, 1,2,3, 0},
            {1, 1,3, 2,0,3, 0},
      };
      info = "a=c\nd=e\nE=2A\nA=D\nC+E=360\n(A+B+D=180)";
   }

   class Func implements IFunction{
      double lnac, lnde;
      Func(double ac, double de){lnac = ac; lnde = de;}
      public double calculate(double a) {
         double diag = calcSide(lnac, lnde, a);
         double angx = calcAngle(lnac,diag,lnde);
         double b = a/2;
         double e = 2*(90-(b-angx));
         return b-e;
      }
   }
   
   public void recalcBase(double[] paramValues) {
      double lnt = 1.0;
      double lnac = lnt * getParam(paramValues,0)/100;
      double lnde = lnt - lnac;
      
      double a = Functions.BisectionMethod(new Func(lnac,lnde), 90, 180, 0.00001);
      double b = a/2;

      double x4 =      lnac * Math.cos(b*DEG2RAD);
      double y4 =      lnac * Math.sin(b*DEG2RAD);
      double x3 = x4 + lnde * Math.cos((b-180+a)*DEG2RAD);
      double y3 = y4 + lnde * Math.sin((b-180+a)*DEG2RAD);
      double x2 = x3 + lnde * Math.cos((b+a+b)*DEG2RAD);
      double y2 = y3 + lnde * Math.sin((b+a+b)*DEG2RAD);
      double x1 = x2 + lnac * Math.cos((180+b+b)*DEG2RAD);
      double y1 = y2 + lnac * Math.sin((180+b+b)*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}
