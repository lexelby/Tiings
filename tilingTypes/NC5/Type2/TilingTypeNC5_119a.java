package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_119a
   extends TilingType
{
   public TilingTypeNC5_119a(){
      super( "NC5-119a", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,1,3, 1},
            {0, 3,4, 0,0,1, 1},
            {1, 3,0, 2,1,3, 0},
      };
      info = "a=d\nb=c=e\nA+C=180\nC+E=360\n(A+B+D=180)";
   }
   
   private class Func
      implements IFunction
   {
      private double ln;
      Func(double f){ ln = f; }
      public double calculate(double a) {
         double dx = ln * Math.cos(a*DEG2RAD);
         double h = dx>=1.5 ? 0 : Math.sqrt(1-(.5-dx)*(.5-dx));
         double ang = 180 - Math.atan2(h, .5-dx)/DEG2RAD;
         return ang+a+a-180;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double ln2 = lntotal * 2/3* getParam(paramValues, 0)/100;
      double ln1 = lntotal - ln2;

      double a = Functions.BisectionMethod(new Func(ln2/ln1), 30, 90, 0.001);
      double dx = ln2 * Math.cos(a*DEG2RAD);
      double dy = ln2 * Math.sin(a*DEG2RAD);
      double h = dy + Math.sqrt(ln1*ln1-(ln1/2-dx)*(ln1/2-dx));
      double diag = Math.sqrt(h*h+ln1*ln1/4);
      double ang = -90 + Math.asin(ln1/2/diag)/DEG2RAD + calcAngle(ln2,diag,ln1);

      double x1 = ln1;
      double y1 = 0;
      double x4 = dx; 
      double y4 = dy;
      double x3 = ln1/2; 
      double y3 = h;
      double x2 = x3 + ln2 * Math.cos(ang * DEG2RAD); 
      double y2 = y3 + ln2 * Math.sin(ang * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[2].getY(1)-tiles[0].getY(4);
   }
}
