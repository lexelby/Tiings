package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_80
   extends TilingType
{
   public TilingTypeN4_80(){
      super( "N4-80", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {2, 2,1, 1,3,2, 1},
            {2, 0,1, 1,1,2, 1},
            {1, 3,2, 3,2,1, 0},
            {0, 0,1, 4,1,0, 0},

            {0, 2,3, 0,3,0, 1},
            {1, 1,0, 6,0,1, 1},
            {2, 2,1, 7,3,2, 0},
            {2, 0,1, 7,1,2, 0},
            {1, 3,2, 9,2,1, 1},
            {0, 0,1,10,1,0, 1},
      };
      info = "c=d=2a\n(b=2c)\nA+D=180\nC+2D=360\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.4;
      double s = .25;
      double c = Math.sqrt(1-s*s);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 4*ln*c, ln);
      baseTile.setPoint(2, 2*ln*c, ln*1.5);
      baseTile.setPoint(3,  0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[6].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[6].getY(3);
      offsets[2] = tiles[5].getX(2)-tiles[11].getX(3);
      offsets[3] = tiles[5].getY(2)-tiles[11].getY(3);
   }
}
