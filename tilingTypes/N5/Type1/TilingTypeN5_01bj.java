package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bj
   extends TilingType
{
   public TilingTypeN5_01bj(){
      super( "N5-1bj", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,1,0, 0},
            {2, 0,4, 1,3,4, 0},
            {2, 1,0, 1,2,3, 0},
            {0, 3,4, 3,0,4, 0},
            {1, 1,0, 4,0,1, 0},

            {1, 1,2, 1,1,2, 1},
            {0, 0,1, 6,1,0, 1},
            {2, 0,4, 7,3,4, 1},
            {2, 1,0, 7,2,3, 1},
            {0, 3,4, 9,0,4, 1},
            {1, 1,0,10,0,1, 1},
      };
      info = "a=e\nc=d\nA=60\nB=120\nC=120\nD=120\n(E=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.15;
      double h = ln * Math.sqrt(3);

      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1, 6*ln, 0);
      baseTile.setPoint(2, 7*ln, h);
      baseTile.setPoint(3, 6*ln, h*2);
      baseTile.setPoint(4, 2*ln, h*2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[6].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[6].getY(0);
      offsets[2] = tiles[11].getX(3)-tiles[3].getX(3);
      offsets[3] = tiles[11].getY(3)-tiles[3].getY(3);
   }
}
