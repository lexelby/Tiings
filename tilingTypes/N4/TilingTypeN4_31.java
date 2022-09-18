package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_31
   extends TilingType
{
   public TilingTypeN4_31(){
      super( "N4-31", 4, SymmetryType.pmg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,1,2, 0},
            {1, 3,2, 1,1,2, 0},
            {0, 0,1, 2,0,3, 0},
            {1, 3,2, 3,1,2, 0},
            {0, 3,2, 4,1,2, 0},
            };
      info = "a=b\nc=d\nA=60\nB=90\nC=120\n(D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double h = Math.sqrt(3);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  1, 0);
      baseTile.setPoint(2,  1, h/3);
      baseTile.setPoint(3, .5, h/2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(1);
   }
}
