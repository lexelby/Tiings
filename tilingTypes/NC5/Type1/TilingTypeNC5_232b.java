package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_232b
   extends TilingType
{
   public TilingTypeNC5_232b(){
      super( "NC5-232b", 5, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,1, 1},
            {2, 3,2, 1,0,1, 1},
            
            {0, 0,1, 0,3,2, 0},
            {1, 3,2, 3,2,1, 1},
            {2, 3,2, 4,0,1, 1},

            {0, 0,1, 3,3,2, 0},
            {1, 3,2, 6,2,1, 1},
            {2, 3,2, 7,0,1, 1},

            {0, 0,1, 6,3,2, 0},
            {1, 3,2, 9,2,1, 1},
            {2, 3,2,10,0,1, 1},
      };
      info = "a=e\nb=d\nc=d+2e\nA=90\nD=270\nE=90\n(B+C=90)";
   }
   public void recalcBase(double[] paramValues) {
      double lna = .2;
      double lnb = lna * (2+Math.sqrt(6));

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnb,  0);
      baseTile.setPoint(2, lna, lna+lnb);
      baseTile.setPoint(3, lna, lna);
      baseTile.setPoint(4,   0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[5].getX(2);
      offsets[1] = tiles[2].getY(2)-tiles[5].getY(2);
      offsets[2] = tiles[2].getX(2)-tiles[8].getX(2);
      offsets[3] = tiles[2].getY(2)-tiles[8].getY(2);
   }

}
