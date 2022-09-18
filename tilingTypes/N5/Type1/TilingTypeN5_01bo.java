package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bo
   extends TilingType
{
   public TilingTypeN5_01bo(){
      super( "N5-1bo: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,2, 0,3,4, 0},
            {1, 3,4, 1,4,3, 0},
            {1, 2,3, 2,3,2, 0},
            {0, 4,3, 3,3,4, 0},
            {2, 3,4, 4,3,2, 0},

            {2, 4,0, 0,1,2, 1},
            {0, 3,2, 6,3,4, 1},
            {1, 3,4, 7,4,3, 1},
            {1, 2,3, 8,3,2, 1},
            {0, 4,3, 9,3,4, 1},
            {2, 3,4,10,3,2, 1},
      };
      info = "a=c\nd=e\n2a=b+c\nA+B=180\nB=C\nC=D\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double lna = .6;
      double lncd = lna/c36/2;
      double lnbe = (lna+lncd)/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lna,  0);
      baseTile.setPoint(2, lna+lnbe*c72, lnbe*s72);
      baseTile.setPoint(3, lnbe*c72 + lncd*c36, lnbe*s72 + lncd*s36);
      baseTile.setPoint(4, lnbe*c72, lnbe*s72);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(2)-tiles[5].getX(0);
      offsets[3] = tiles[11].getY(2)-tiles[5].getY(0);
   }
}
