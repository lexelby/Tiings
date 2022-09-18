package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_240
   extends TilingType
{
   public TilingTypeNC5_240(){
      super( "NC5-240", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,1, 0,0,3, 1},
            {1, 0,1, 1,1,0, 1},
            {1, 2,1, 2,1,2, 1},
            {0, 1,0, 3,0,1, 1},
            {2, 0,3, 4,3,1, 0},

            {2, 0,1, 0,2,3, 1},
            {0, 3,1, 6,0,3, 0},
            {1, 0,1, 7,1,0, 0},
            {1, 2,1, 8,1,2, 0},
            {0, 1,0, 9,0,1, 0},
            {2, 0,3,10,3,1, 1},
      };
      info = "b=2a\nc=e\na=d\nA=90\nB=45\nC=225\nD=45\n(E=135)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = .4;
      double lna = 2*lnb;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lna,  0);
      baseTile.setPoint(2, lnb, lnb);
      baseTile.setPoint(3, lnb, lna);
      baseTile.setPoint(4,   0, lnb);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[1].getX(4);
      offsets[1] = tiles[2].getY(4)-tiles[1].getY(4);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(2);
   }
}
