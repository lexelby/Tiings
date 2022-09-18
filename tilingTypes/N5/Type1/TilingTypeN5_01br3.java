package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01br3
   extends TilingType
{
   public TilingTypeN5_01br3(){
      super( "N5-1br3: type 1&2", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,3,4, 0},
            {2, 4,3, 1,3,4, 0},
            {2, 3,2, 2,2,3, 0},
            {1, 3,4, 3,4,3, 0},
            {0, 3,4, 4,3,2, 0},
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
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(1)-tiles[1].getX(2);
      offsets[3] = tiles[4].getY(1)-tiles[1].getY(2);
   }
}
