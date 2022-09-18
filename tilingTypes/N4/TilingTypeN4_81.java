package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_81
   extends TilingType
{
   public TilingTypeN4_81(){
      super( "N4-81", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,1,2, 0},
            {2, 2,1, 1,1,2, 0},
            {2, 3,0, 0,2,1, 0},
            {1, 1,2, 3,2,1, 0},
            {0, 1,2, 4,0,3, 0},

            {0, 0,1, 1,0,1, 1},
            {1, 0,3, 6,1,2, 1},
            {2, 2,1, 7,1,2, 1},
            {2, 3,0, 6,2,1, 1},
            {1, 1,2, 9,2,1, 1},
            {0, 1,2,10,0,3, 1},
      };
      info = "a=d\nc=2a\n(b=3a)\nA+D=180\nC+2D=360\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.4;
      double s = .25;
      double c = Math.sqrt(1-s*s);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 3*ln*c, ln*.75);
      baseTile.setPoint(2, ln*c, ln*1.25);
      baseTile.setPoint(3,  0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[5].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[5].getY(3);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(1);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(1);
   }
}
