package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_18
   extends TilingType
{
   public TilingTypeN4_18(){
      super( "N4-18", 4, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 3,0, 0,3,2, 0},
            {1, 0,1, 2,0,1, 1},
            {0, 3,0, 2,3,2, 0},
            {1, 0,1, 4,0,1, 1},
            {0, 3,0, 4,3,2, 0},
            {1, 0,1, 6,0,1, 1},
      };
      info = "2a=d\nA=90\nB=45\nC=135\n(D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,3*ln,  0);
      baseTile.setPoint(2,2*ln, ln);
      baseTile.setPoint(3,   0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[0].getX(1);
      offsets[1] = tiles[2].getY(1)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[6].getX(1);
      offsets[3] = tiles[0].getY(1)-tiles[6].getY(1);
   }
}
