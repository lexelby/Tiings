package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bt
   extends TilingType
{
   public TilingTypeN5_01bt(){
      super( "N5-1bt: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {2, 1,0, 1,3,2, 1},
            {2, 4,0, 1,1,2, 1},
            {1, 3,2, 3,1,0, 0},
            {0, 3,4, 4,4,3, 0},

            {0, 2,1, 4,1,0, 1},
            {1, 4,3, 6,3,4, 1},
            {2, 1,0, 7,3,2, 0},
            {2, 4,0, 7,1,2, 0},
            {1, 3,2, 9,1,0, 1},
            {0, 3,4,10,4,3, 1},
      };
      info = "a=c\nd=e\nc=b+d\nA=72\nB=108\nC=108\nD=108\n(E=144)";
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double lna = .5;
      double lncd = lna/2/c36;
      double lnbe = lna+lncd;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(4, lnbe*c72,  lnbe*s72);
      baseTile.setPoint(3, lnbe*c72+lncd*c36, lnbe*s72+lncd*s36);
      baseTile.setPoint(2, lna+lnbe*c72, lnbe*s72);
      baseTile.setPoint(1, lna, 0);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[11].getX(1)-tiles[4].getX(0);
      offsets[1] = tiles[11].getY(1)-tiles[4].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[8].getX(4);
      offsets[3] = tiles[0].getY(2)-tiles[8].getY(4);
   }
}
