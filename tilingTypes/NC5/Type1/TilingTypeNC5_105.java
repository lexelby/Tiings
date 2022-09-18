package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_105
   extends TilingType
{
   public TilingTypeNC5_105(){
      super( "NC5-105", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,4,3, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 4,3, 2,3,2, 0},

            {0, 0,1, 1,0,4, 1},
            {1, 3,2, 4,4,3, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 4,3, 6,3,2, 1},
      };
      info = "a=b\nc=d=2a\nA=90\nB+C=360\nC+D=180\n(B+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      final double ln = .3;
      final double y = 2*ln /Math.sqrt(10);
      final double x = 3*y;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, ln, 0);
      baseTile.setPoint(2, ln+x, -y);
      baseTile.setPoint(3, 3*ln+x, -y);
      baseTile.setPoint(4, 0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[2].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[7].getX(0)-tiles[2].getX(0);
      offsets[3] = tiles[7].getY(0)-tiles[2].getY(0);
   }
}
