package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_02a
   extends TilingType
{
   public TilingTypeN3_02a(){
      super( "N3-2a", 3, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,2,0, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 0,2, 2,2,0, 0},

            {0, 1,0, 3,1,2, 0},
            {1, 0,2, 4,2,0, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 0,2, 6,2,0, 0},

            {0, 1,0, 7,1,2, 0},
            {1, 0,2, 8,2,0, 0},
            {1, 2,1, 9,1,2, 0},
            {0, 0,2,10,2,0, 0},
      };
      info = "2b=c\nA=90\nB=60\n(C=30)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double h = Math.sqrt(3)/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(2);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(2);
      offsets[2] = tiles[0].getX(2)-tiles[8].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[8].getY(2);
   }
}
