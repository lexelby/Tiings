package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN6_03a
   extends TilingType
{
   public TilingTypeN6_03a(){
      super( "N6-3a: type 1&2", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,4,5, 1},
            {0, 4,3, 0,3,4, 0},
            {1, 3,4, 2,4,5, 1},

            {0, 1,2, 1,0,5, 1},
            {1, 3,4, 4,4,5, 0},
            {0, 4,3, 4,3,4, 1},
            {1, 3,4, 6,4,5, 0},
      };
      info = "a=b=c=e=f\nA=120\nB=120\nE+F=240\n(C+D=240)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double h = ln*Math.sqrt(3)/2;
      double a = paramValues[0];

      double x5 = -ln/2;
      double y5 = h;
      double x4 = x5 - ln * Math.cos( a * DEG2RAD);
      double y4 = y5 + ln * Math.sin( a * DEG2RAD);
      double x3 = x4 + ln;
      double y3 = y4;
      double x1 = ln;
      double y1 = 0;
      double x2 = x1 + ln/2;
      double y2 = h;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[2].getX(1);
      offsets[1] = tiles[0].getY(0)-tiles[2].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[5].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[5].getY(0);
   }
}