package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_15
   extends TilingType
{
   public TilingTypeNC5_15(){
      super( "NC5-15", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,0,1, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 0,1, 2,4,3, 0},

            {0, 3,4, 0,2,3, 1},
            {1, 4,3, 4,0,1, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 0,1, 6,4,3, 1},
      };
      info = "a=b=c=d=e\nA=108\nB=108\nC=36\nD=252\n(E=36)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .75;
      double x2 = ln + ln*Math.cos( 72 * DEG2RAD);
      double y2 =      ln*Math.sin( 72 * DEG2RAD);
      double x3 = x2 + ln*Math.cos( -144 * DEG2RAD);
      double y3 = y2 + ln*Math.sin( -144 * DEG2RAD);
      double x4 = x3 + ln*Math.cos( 144 * DEG2RAD);
      double y4 = y3 + ln*Math.sin( 144 * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(3);
   }
}
