package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_61
   extends TilingType
{
   public TilingTypeNC5_61(){
      super( "NC5-61", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 42};
      paramName = new String[]{ "Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 3,2, 1,3,4, 1},
            {1, 0,1, 2,0,1, 0},

            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 4,0,1, 0},
            {0, 3,2, 4,3,4, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "c=2a\nd=e\nA=90\nC+E=360\nE=2D\n(B+D=90)";
   }
   
   private class Func implements IFunction{
      private double lna;
      Func(double lna0){ lna = lna0; }
      public double calculate(double d) {
         /*
          * suppose a,b,D given.
          *   Want E=2D
          *     AEC + CED = 2D
          *     AEC + 90-D/2 = 2D
          */
         double b = 90-d;
         double xec = 1-2*lna*Math.cos(b*DEG2RAD);
         double yec = lna - 2*lna*Math.sin(b*DEG2RAD);
         double aec = Math.atan2(xec,yec)/DEG2RAD;
         return aec+90-d/2 - 2*d;
      }
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 1.5;
      double lna = getParam( paramValues,0)/100 * lnb/Math.sqrt(3);
      double d = Functions.BisectionMethod(new Func(lna/lnb), 0, 90, 0.001);

      double xc = lnb - 2*lna * Math.cos( (90-d) * DEG2RAD);
      double yc =     2*lna * Math.sin( (90-d) * DEG2RAD);
      double ec = Math.sqrt(xc*xc+(lna-yc)*(lna-yc));
      double lne = ec/2 / Math.sin(d/2 * DEG2RAD);
      double xd =       lne * Math.cos( (d*2-90) * DEG2RAD);
      double yd = lna + lne * Math.sin( (d*2-90) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lnb,  0);
      baseTile.setPoint(2, xc, yc);
      baseTile.setPoint(3, xd, yd);
      baseTile.setPoint(4,  0,lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[2].getY(4);
      offsets[2] = tiles[0].getX(3)-tiles[7].getX(2);
      offsets[3] = tiles[0].getY(3)-tiles[7].getY(2);
   }
}
