package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_110
   extends TilingType
{
   public TilingTypeNC5_110(){
      super( "NC5-110", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {1, 0,2, 1,2,0, 0},
            {0, 0,1, 2,2,1, 0},

            {0, 1,2, 0,3,4, 1},
            {1, 2,1, 4,0,1, 1},
            {1, 0,2, 5,2,0, 1},
            {0, 0,1, 6,2,1, 1},
      };
      info = "a=d\nb=c=e\nA=B\nD+E=360\nC+E=180\n(E=2B)";
   }

   public void recalcBase(double[] paramValues) {
      final double ln = .12;
      final double c = 0.25;
      final double s = Math.sqrt(15)/4;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, 8*ln,  0);
      baseTile.setPoint(2, 8*ln*(1-c), 8*ln*s);
      baseTile.setPoint(3, ln*(8-9*c), 7*ln*s);
      baseTile.setPoint(4, ln*c, ln*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[4].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[4].getY(3);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(1);
   }
}
