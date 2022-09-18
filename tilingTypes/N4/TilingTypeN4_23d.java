package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_23d
   extends TilingType
{
   public TilingTypeN4_23d(){
      super( "N4-23d", 4, SymmetryType.pmg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,3, 0,0,1, 0},
            {0, 0,3, 1,1,2, 0},

            {1, 1,2, 2,1,2, 1},
            {0, 0,3, 3,0,1, 1},
            {0, 0,3, 4,1,2, 1},
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
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(1)-tiles[5].getX(1);
      offsets[3] = tiles[0].getY(1)-tiles[5].getY(1);
   }
}
