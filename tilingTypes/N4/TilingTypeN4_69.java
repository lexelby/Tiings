package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN4_69
   extends TilingType
{
   public TilingTypeN4_69(){
      super( "N4-69", 4, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{"Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,1, 0},
            {0, 2,1, 1,2,3, 0},
            {1, 0,3, 2,0,1, 0},
      };
      info = "a=b\nB+D=180\nB+2C=360\n(A+C=180)";
   }
   
   private class Func implements IFunction{
      private double lnc;
      public Func( double lnc0 ){ lnc = lnc0; }
      public double calculate(double a) {
         double diag = 2*Math.sin(a/2*DEG2RAD);
         double b = a+a;
         double b2 = b - (90-a/2);
         double c = 180-a;
         double lnc2 = Math.sin(b2 * DEG2RAD) * diag / Math.sin(c*DEG2RAD);
         return lnc - lnc2;
      }
      
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1;
      double lnc = getParam(paramValues,0)/100.;
      double a = Functions.BisectionMethod(new Func(lnc), 30, 60, 0.001);
      lnc *= ln;
      double diag = 2*ln*Math.sin(a/2*DEG2RAD);
      double b = a+a;
      double d = 180-a-a;
      double d2 = d - (90-a/2);
      double c = 180-a;
      double lnb = Math.sin(d2 * DEG2RAD) * diag / Math.sin(c*DEG2RAD);

      double x2 = ln - lnb * Math.cos(b * DEG2RAD);
      double y2 =      lnb * Math.sin(b * DEG2RAD);
      double x3 =      ln  * Math.cos(a * DEG2RAD);
      double y3 =      ln  * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1,ln,  0);
      baseTile.setPoint(2,x2, y2);
      baseTile.setPoint(3,x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(1);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(3);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(3);
   }
}
