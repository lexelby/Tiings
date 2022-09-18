package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_25c
   extends TilingType
{
   public TilingTypeN3_25c(){
      super( "N3-25c", 3, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,2, 0,0,1, 0},
            {1, 0,2, 1,0,1, 0},
            {1, 0,2, 2,0,1, 0},

            {0, 0,2, 0,1,2, 0},
            {0, 0,2, 1,1,2, 0},
            {0, 0,2, 2,1,2, 0},
            {0, 0,2, 3,1,2, 0},

            {2, 1,2, 4,1,0, 0},
            {2, 1,2, 5,1,0, 0},
            {2, 1,2, 6,1,0, 0},
            {2, 1,2, 7,1,0, 0},
      };
      info = "a=b\nA=90\nB=45\n(C=45)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1/Math.sqrt( 3 );

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  0,  w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(1)-tiles[6].getX(2);
      offsets[1] = tiles[4].getY(1)-tiles[6].getY(2);
      offsets[2] = tiles[5].getX(1)-tiles[7].getX(2);
      offsets[3] = tiles[5].getY(1)-tiles[7].getY(2);
   }
}
