package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bm
   extends TilingType
{
   public TilingTypeN5_01bm(){
      super( "N5-1bm", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {1, 1,0, 1,4,0, 1},
            {1, 4,0, 2,0,4, 1},
            {0, 4,0, 3,1,0, 1},
            {2, 0,1, 4,0,1, 0},

            {2, 3,4, 4,4,3, 1},
            {0, 0,1, 6,0,1, 0},
            {1, 1,0, 7,4,0, 0},
            {1, 4,0, 8,0,4, 0},
            {0, 4,0, 9,1,0, 0},
            {2, 0,1,10,0,1, 1},
      };
      info = "2a=b+e\nd=2c\nA=90\nB=135\nC=90\nD=135\n(E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.1;

      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1, 7*ln, 0);
      baseTile.setPoint(2, 9*ln, 2*ln);
      baseTile.setPoint(3, 5*ln, 6*ln);
      baseTile.setPoint(4,    0, 6*ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[5].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[5].getY(2);
      offsets[2] = tiles[5].getX(4)-tiles[7].getX(3);
      offsets[3] = tiles[5].getY(4)-tiles[7].getY(3);
   }
}
