package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01g
   extends TilingType
{
   public TilingTypeN5_01g(){
      super( "N5-1g", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{120};
      paramDef = new int[]{ 90};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {1, 1,0, 0,3,2, 1},
            {1, 1,0, 1,3,2, 1},

            {0, 4,3, 2,2,3, 1},
            {0, 1,2, 4,2,1, 1},
            {1, 1,0, 4,3,2, 0},
            {1, 1,0, 5,3,2, 0},
      };
      info = "c=d=e\nA=90\nB+C=180\nB+2D=360\n(D+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .75;
      double f = paramValues[0];
      double d = 180-f/2;

      double x2 = ln-ln*Math.cos( d * DEG2RAD);
      double y2 =   ln*Math.sin( f * DEG2RAD);
      double y4 = y2 - ln*Math.sin( d * DEG2RAD);
      double x1 = x2 + ln*Math.cos( f * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x2-ln, y2);
      baseTile.setPoint(4,  0, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(3)-tiles[3].getX(3);
      offsets[3] = tiles[5].getY(3)-tiles[3].getY(3);
   }
}
