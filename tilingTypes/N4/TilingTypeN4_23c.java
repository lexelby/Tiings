package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_23c
   extends TilingType
{
   public TilingTypeN4_23c(){
      super( "N4-23c", 4, SymmetryType.p31m );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,2,3, 0},
            {0, 1,2, 0,0,3, 0},

            {1, 1,2, 0,1,0, 0},
            {0, 1,0, 3,2,3, 0},
            {0, 1,2, 3,0,3, 0},

            {1, 1,2, 3,1,0, 0},
            {0, 1,0, 6,2,3, 0},
            {0, 1,2, 6,0,3, 0},
      };
      info = "a=b=c=d\nA=60\nB=120\nC=60\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .25;
      double h = w*Math.sqrt(3);
    
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  h, -w);
      baseTile.setPoint(2,h+h,  0);
      baseTile.setPoint(3,  h,  w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[5].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[5].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[8].getX(0);
      offsets[3] = tiles[3].getY(3)-tiles[8].getY(0);
   }
}
