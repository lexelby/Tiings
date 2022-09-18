package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN4_68
   extends TilingType
{
   public TilingTypeN4_68(){
      super( "N4-68", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{"Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {0, 1,0, 1,2,3, 1},
            {1, 0,3, 2,0,3, 0},

            {0, 2,1, 0,1,2, 0},
            {1, 0,3, 4,0,3, 1},
            {0, 1,0, 5,2,3, 1},
            {1, 0,3, 6,0,3, 0},
      };
      info = "2b=d\nA=90\nB+2D=360\n(D-C=90)";
   }

   private class Func implements IFunction{
      private double h;
      public Func(double h0){ h=h0; }
      public double calculate(double d) {
         double dx = 2 * Math.sin(d * DEG2RAD) - 1;
         double dy = h - 2*Math.cos(d * DEG2RAD);
         double b = Math.atan2(dy,-dx) / DEG2RAD;
         return b+2*d-360;
      }
      
   }
   public void recalcBase(double[] paramValues) {
      double w = 1.0 * getParam(paramValues,0)/100;
      double h = 1.0 - w;
      
      double d = Functions.BisectionMethod(new Func(h/w), 90, 180, .0001);
      double dx = 2*w * Math.sin(d * DEG2RAD);
      double dy = -2*w * Math.cos(d * DEG2RAD);
      
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, dx, h+dy);
      baseTile.setPoint(3, 0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[3].getX(3);
      offsets[1] = tiles[1].getY(1)-tiles[3].getY(3);
      offsets[2] = tiles[2].getX(1)-tiles[6].getX(2);
      offsets[3] = tiles[2].getY(1)-tiles[6].getY(2);
   }
}
