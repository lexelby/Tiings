package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_17
   extends TilingType
{
   public TilingTypeN4_17(){
      super( "N4-17", 4, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {0, 0,1, 1,0,1, 0},
            {1, 1,2, 2,1,2, 1},
            {0, 0,1, 3,0,1, 0},
            {1, 1,2, 4,1,2, 1},
            {0, 0,1, 5,0,1, 0},
            {1, 1,2, 6,1,2, 1},
            {0, 0,1, 7,0,1, 0},
            {1, 1,2, 8,1,2, 1},
            {0, 0,1, 9,0,1, 0},
            {1, 1,2,10,1,2, 1},
      };
      info = "2a=d\nA=90\nB=30\nC=120\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double h = Math.sqrt(3)/4;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,3*h,  0);
      baseTile.setPoint(2,  h, .5);
      baseTile.setPoint(3,  0,.25);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[6].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[10].getX(2)-tiles[4].getX(3);
      offsets[3] = tiles[10].getY(2)-tiles[4].getY(3);
   }
}
