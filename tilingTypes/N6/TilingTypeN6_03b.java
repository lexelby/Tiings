package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN6_03b
   extends TilingType
{
   public TilingTypeN6_03b(){
      super( "N6-3b", 6, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 4,5, 0,1,2, 1},
            {2, 2,3, 0,2,3, 1},

            {1, 4,3, 0,3,4, 0},
            {0, 4,5, 3,1,2, 1},
            {2, 2,3, 3,2,3, 1},
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
      offsets[0] = tiles[4].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[4].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[2].getX(5)-tiles[0].getX(1);
      offsets[3] = tiles[2].getY(5)-tiles[0].getY(1);
   }
}