package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN4_07
   extends TilingType
{
   public TilingTypeN4_07(){
      super( "N4-7", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Angle 1" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 3,0, 0,1,2, 1},
            {1, 0,1, 2,0,1, 0},

            {1, 2,1, 2,2,3, 1},
            {0, 0,1, 4,0,1, 0},
            {0, 3,0, 5,1,2, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "2a=c\nA=90\n2B+D=180\n(2C+D=360)";
   }

   private class Func implements IFunction{
      private double lna;
      Func(double lna0){ lna = lna0; }
      public double calculate(double b) {
         double dx = 1-2*lna*Math.cos(b*DEG2RAD);
         double dy = 2*lna*Math.sin(b*DEG2RAD)-lna;
         return Math.atan2(dy,dx)/DEG2RAD + 2*b - 90;
      }
      
   }
   public void recalcBase(double[] paramValues) {
      double lnb = 1.5;
      double lna = getParam( paramValues,0)/100 * lnb /Math.sqrt(3);
      double b = Functions.BisectionMethod(new Func(lna/lnb), 0, 90, 0.0001);

      double x2 = lnb - 2*lna*Math.cos( b * DEG2RAD);
      double y2 = 2*lna*Math.sin( b * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lnb,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3,  0,lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[2].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[0].getX(2)-tiles[7].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[7].getY(2);
   }
}
