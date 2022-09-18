package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_03
   extends TilingType
{
   public TilingTypeN3_03(){
      super( "N3-3", 3, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {1, 2,0, 1,0,2, 0},
            {0, 2,1, 2,1,2, 0},

            {0, 0,1, 0,0,2, 0},
            {1, 2,1, 4,1,2, 0},
            {1, 2,0, 5,0,2, 0},
            {0, 2,1, 6,1,2, 0},

            {0, 0,1, 4,0,2, 0},
            {1, 2,1, 8,1,2, 0},
            {1, 2,0, 9,0,2, 0},
            {0, 2,1,10,1,2, 0},
      };
      info = "a=2b\nA=120\n(B+C=60)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double h = Math.sqrt(3)/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[7].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[7].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[11].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[11].getY(0);
   }
}
