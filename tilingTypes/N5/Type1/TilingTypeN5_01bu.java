package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bu
   extends TilingType
{
   public TilingTypeN5_01bu(){
      super( "N5-1bu", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,3,2, 0},
            {2, 3,2, 0,1,2, 0},

            {0, 3,4, 0,4,3, 0},
            {1, 2,3, 3,3,2, 0},
            {2, 3,2, 3,1,2, 0},
      };
      info = "a=c=d\ne=2a\nA=60\nB=120\nC=150\nD=60\n(E=150)";
   }

   public void recalcBase(double[] paramValues) {
      double c60 = .5;
      double s60 = Math.sqrt(0.75);

      double ln = .4;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(4, ln*c60,  ln*s60);
      baseTile.setPoint(3, ln*c60 + 2*ln*s60,  ln*s60 + 2*ln*c60);
      baseTile.setPoint(2, ln*c60 + 2*ln*s60,  ln*s60);
      baseTile.setPoint(1, 2*ln*s60, 0);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[2].getX(0);
      offsets[1] = tiles[5].getY(1)-tiles[2].getY(0);
      offsets[2] = tiles[5].getX(4)-tiles[4].getX(0);
      offsets[3] = tiles[5].getY(4)-tiles[4].getY(0);
   }
}
