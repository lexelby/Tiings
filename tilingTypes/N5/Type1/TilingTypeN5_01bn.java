package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bn
   extends TilingType
{
   public TilingTypeN5_01bn(){
      super( "N5-1bn", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,4, 0,3,4, 1},
            {1, 2,3, 1,2,3, 0},
            {0, 1,0, 2,0,1, 0},
            {1, 2,3, 3,2,3, 1},
            {2, 4,3, 3,4,3, 1},

            {2, 2,1, 0,1,2, 0},
            {0, 3,4, 6,3,4, 1},
            {1, 2,3, 7,2,3, 0},
            {0, 1,0, 8,0,1, 0},
            {1, 2,3, 9,2,3, 1},
            {2, 4,3, 9,4,3, 1},
      };
      info = "b=2a+2c\nd=e\nA=60\nB=120\nC=90\nD=120\n(E=150)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.1;
      double h1 = ln * Math.sqrt(3);
      double h2 = h1 * 4/3;

      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1, 8*ln, 0);
      baseTile.setPoint(2, 9*ln, h1);
      baseTile.setPoint(3, 5*ln, h1+h2);
      baseTile.setPoint(4,   ln, h1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(2)-tiles[5].getX(1);
      offsets[3] = tiles[11].getY(2)-tiles[5].getY(1);
   }
}
