package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_116
   extends TilingType
{
   public TilingTypeNC5_116(){
      super( "NC5-116", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,1, 0,2,4, 1},
            {1, 4,2, 0,0,2, 0},
            {0, 4,2, 2,1,4, 1},
      };
      info = "a=c=d\nb=e\nA=B\nA+D=360\n(B+C+E=180)";
   }
   
   private class Func
      implements IFunction
   {
      private double ln;
      Func(double f){ ln = f; }
      public double calculate(double a) {
         double dx1 = ln - 2*Math.cos(a * DEG2RAD);
         double dx2 = calcSide(1,ln,a);
         return dx1-dx2;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln2 = lntotal * getParam(paramValues, 0)/100;
      double ln1 = lntotal - ln2;
      
      double a = Functions.BisectionMethod(new Func(ln2/ln1), 0, 180, 0.001);
      
      double diag = calcSide(ln1,ln2,a);
      double ang = calcAngle(ln1,diag,ln2);

      double x1 = ln2;
      double y1 = 0;
      double x4 = ln1 * Math.cos(a * DEG2RAD); 
      double y4 = ln1 * Math.sin(a * DEG2RAD);
      double x2 = x1 - x4; 
      double y2 = y4;
      double x3 = x2 - ln1 * Math.cos(ang * DEG2RAD); 
      double y3 = y2 - ln1 * Math.sin(ang * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(4);
   }
}
