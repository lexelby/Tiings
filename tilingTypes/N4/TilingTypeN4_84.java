package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_84
   extends TilingType
{
   public TilingTypeN4_84(){
      super( "N4-84", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {2, 3,2, 1,3,0, 1},
            {2, 0,1, 2,1,0, 1},
            {1, 3,0, 3,3,2, 1},
            {0, 0,1, 4,0,1, 0},

            {0, 3,2, 1,2,3, 1},
            {1, 0,1, 6,0,1, 0},
            {2, 3,2, 7,3,0, 0},
            {2, 0,1, 8,1,0, 0},
            {1, 3,0, 9,3,2, 0},
            {0, 0,1,10,0,1, 1},
      };
      info = "d=2a\nA=90\nB=30\nC=120\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;
      double s60 = Math.sqrt(.75);

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, 6*ln*s60,  0);
      baseTile.setPoint(2, 2*ln*s60, 2*ln);
      baseTile.setPoint(3, 0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[7].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[7].getY(2);
      offsets[2] = tiles[11].getX(1)-tiles[2].getX(0);
      offsets[3] = tiles[11].getY(1)-tiles[2].getY(0);
   }
}
