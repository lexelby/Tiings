package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_78b
   extends TilingType
{
   public TilingTypeN4_78b(){
      super( "N4-78b", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 1,2, 1,2,1, 1},
            {0, 0,1, 2,0,1, 0},
            {2, 1,0, 0,3,0, 0},
            {2, 0,3, 4,3,0, 0},

            {0, 2,3, 2,3,2, 1},
            {1, 0,1, 6,0,1, 0},
            {1, 1,2, 7,2,1, 0},
            {0, 0,1, 8,0,1, 1},
            {2, 1,0, 6,3,0, 1},
            {2, 0,3,10,3,0, 1},
      };
      info = "a=2d\nb=3d\nA=90\nD=90\nC=45\n(D=135)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.3;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln*3, 0);
      baseTile.setPoint(2, ln, ln*2);
      baseTile.setPoint(3,  0, ln*2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[5].getX(1);
      offsets[1] = tiles[3].getY(3)-tiles[5].getY(1);
      offsets[2] = tiles[1].getX(3)-tiles[9].getX(2);
      offsets[3] = tiles[1].getY(3)-tiles[9].getY(2);
   }
}
