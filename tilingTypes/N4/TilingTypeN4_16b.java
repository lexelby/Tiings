package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_16b
   extends TilingType
{
   public TilingTypeN4_16b(){
      super( "N4-16b", 4, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,1,2, 0},
            {0, 1,0, 1,1,2, 0},
            {0, 1,0, 2,1,2, 0},
            {0, 1,0, 3,1,2, 0},
            {0, 1,0, 4,1,2, 0},
            
            {1, 0,3, 0,0,3, 1},
            {1, 0,3, 1,0,3, 1},
            {1, 0,3, 2,0,3, 1},
            {1, 0,3, 3,0,3, 1},
            {1, 0,3, 4,0,3, 1},
            {1, 0,3, 5,0,3, 1},
      };
      info = "c=2d\nA=90\nB=60\nC=120\n(D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .4;
      double h = w * Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,2*w,  0);
      baseTile.setPoint(2,  w,  h);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[6].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[8].getX(1)-tiles[4].getX(2);
      offsets[3] = tiles[8].getY(1)-tiles[4].getY(2);
   }
}
