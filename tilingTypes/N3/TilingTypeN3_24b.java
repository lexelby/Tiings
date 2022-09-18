package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_24b
   extends TilingType
{
   public TilingTypeN3_24b(){
      super( "N3-24b", 3, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 1,0, 0,2,1, 1},
            {1, 2,1, 1,1,2, 1},
            {2, 2,0, 1,0,2, 1},
            {1, 2,1, 3,1,2, 1},
            {0, 2,1, 3,1,0, 0},

            {0, 0,2, 2,0,1, 1},
            {2, 1,0, 6,2,1, 0},
            {1, 2,1, 7,1,2, 0},
            {2, 2,0, 7,0,2, 0},
            {1, 2,1, 9,1,2, 0},
            {0, 2,1, 9,1,0, 1},
      };
      info = "2b=a+c\nA=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .20;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,4*w,  0);
      baseTile.setPoint(2,  0,3*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[8].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[8].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(2)-tiles[6].getX(1);
      offsets[3] = tiles[5].getY(2)-tiles[6].getY(1);
   }
}
