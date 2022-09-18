package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_17b
   extends TilingType
{
   public TilingTypeNC5_17b(){
      super( "NC5-17b", 5, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{ 90};
      paramName = new String[]{ "Angle" };
      // 90.0 63.43 153.43 206.57 26.57

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,2,3, 1},
            {2, 0,1, 1,1,0, 1},
            {0, 4,0, 2,2,3, 0},
            {1, 4,0, 3,2,3, 1},
            {2, 0,1, 4,1,0, 1},
      };
      info = "a=b=d\nc=e\nC+D=360\nC+E=180\n(A+B+E=180)";
   }

   class Func implements IFunction{
      double a;
      Func(double a0){ a=a0; }
      public double calculate(double c0){
         double base = 2*Math.sin(a/2 * DEG2RAD);
         double x = Math.asin( ( Math.sin(c0*DEG2RAD)/base ) )/DEG2RAD;
         double e0 = 90-a/2 - x;
         return c0+e0-180;
      }
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];

      double c = a==60 ? 150 : Functions.BisectionMethod(new Func(a), 0, 180, 0.001);
      double d = 360-c;
      double e = 180-c;
      double b = 540-a-c-d-e;
      double base = 2*Math.sin(a/2 * DEG2RAD);
      double y = 180-c-Math.asin( ( Math.sin(c*DEG2RAD)/base ) )/DEG2RAD;
      double fac = calcSide(1,base,y)/2;

      double ln1 = 1 / (1+fac);
      double ln2 = fac*ln1;

      double x1 = ln1;
      double y1 = 0;
      double x2 = x1 + ln2 * Math.cos( (180-b) * DEG2RAD);
      double y2 = y1 + ln2 * Math.sin( (180-b) * DEG2RAD);
      double x4 =  ln1 * Math.cos( (a) * DEG2RAD);
      double y4 =  ln1 * Math.sin( (a) * DEG2RAD);
      double x3 = x4 + x1-x2;
      double y3 = y4 + y1-y2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[5].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[5].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(1);
   }
}
