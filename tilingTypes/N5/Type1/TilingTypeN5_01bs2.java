package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bs2
   extends TilingType
{
   public TilingTypeN5_01bs2(){
      super( "N5-1bs2: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,4,3, 0},
            {2, 1,0, 1,3,2, 1},
            {2, 4,0, 1,1,2, 1},
            {1, 3,2, 3,1,0, 0},
            {0, 4,3, 4,3,4, 0},

            {0, 1,2, 4,0,1, 1},
            {1, 3,4, 6,4,3, 1},
            {2, 1,0, 7,3,2, 0},
            {2, 4,0, 7,1,2, 0},
            {1, 3,2, 9,1,0, 1},
            {0, 4,3,10,3,4, 1},
      };
      info = "a=b=c\nd=e\nA=72\nB=108\nC=108\nD=108\n(E=144)";
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double ln = .6;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln, 0);
      baseTile.setPoint(2, ln + ln*c72, ln*s72);
      baseTile.setPoint(3, ln*c72 + ln/2, ln*s72 + ln/2 * s36/c36);
      baseTile.setPoint(4, ln*c72,  ln*s72);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[11].getX(1);
      offsets[1] = tiles[1].getY(0)-tiles[11].getY(1);
      offsets[2] = tiles[7].getX(0)-tiles[5].getX(1);
      offsets[3] = tiles[7].getY(0)-tiles[5].getY(1);
   }
}
