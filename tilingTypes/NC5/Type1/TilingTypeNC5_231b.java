package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_231b
   extends TilingType
{
   public TilingTypeNC5_231b(){
      super( "NC5-231b", 5, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {2, 1,2, 1,0,1, 1},
            
            {0, 0,1, 0,3,2, 0},
            {1, 2,1, 3,1,2, 0},
            {2, 1,2, 4,0,1, 1},

            {0, 0,1, 3,3,2, 0},
            {1, 2,1, 6,1,2, 0},
            {2, 1,2, 7,0,1, 1},

            {0, 0,1, 6,3,2, 0},
            {1, 2,1, 9,1,2, 0},
            {2, 1,2,10,0,1, 1},
      };
      info = "a=e\nb=d\na+c=2b\nA=90\nD=270\nE=90\n(B+C=90)";
   }
   public void recalcBase(double[] paramValues) {
      double lna = .3;
      double lnb = lna * (1+Math.sqrt(1.5));

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnb,  0);
      baseTile.setPoint(2, lna, lna+lnb);
      baseTile.setPoint(3, lna, lna);
      baseTile.setPoint(4,   0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[5].getX(4);
      offsets[1] = tiles[2].getY(4)-tiles[5].getY(4);
      offsets[2] = tiles[2].getX(4)-tiles[8].getX(4);
      offsets[3] = tiles[2].getY(4)-tiles[8].getY(4);
   }

}
