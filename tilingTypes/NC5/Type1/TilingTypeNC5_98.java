package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_98
   extends TilingType
{
   public TilingTypeNC5_98(){
      super( "NC5-98", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,1, 1,1,4, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 4,0, 0,2,3, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 4,1, 5,1,4, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=d=2c\nc=e\nA=60\nB=60\nC=120\nD=240\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      final double w = .2;
      final double h = w * Math.sqrt(3);

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, 8*w, 0);
      baseTile.setPoint(2, 7*w, h);
      baseTile.setPoint(3, 3*w, h);
      baseTile.setPoint(4, 2*w, 2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(4);
   }
}
