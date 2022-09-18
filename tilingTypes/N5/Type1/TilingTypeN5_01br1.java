package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01br1
   extends TilingType
{
   public TilingTypeN5_01br1(){
      super( "N5-1br1: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,4,3, 0},
            {1, 3,4, 1,4,3, 0},
            {0, 3,4, 2,3,2, 0},

            {0, 0,1, 3,1,2, 1},
            {1, 2,3, 4,4,3, 1},
            {1, 3,4, 5,4,3, 1},
            {0, 3,4, 6,3,2, 1},
      };
      info = "a=c=d=e\nA=72\nB=108\nC=108\nD=108\n(E=144)";
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double ln = .5;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(4, ln*c72,  ln*s72);
      baseTile.setPoint(3, ln*c72+ln*c36, ln*s72+ln*s36);
      baseTile.setPoint(2, ln*c72+2*ln*c36, ln*s72);
      baseTile.setPoint(1, 2*ln*c36, 0);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[2].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[2].getY(1);
      offsets[2] = tiles[7].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[7].getY(0)-tiles[0].getY(1);
   }
}