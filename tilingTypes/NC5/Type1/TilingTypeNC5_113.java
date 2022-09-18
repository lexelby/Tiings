package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_113
   extends TilingType
{
   public TilingTypeNC5_113(){
      super( "NC5-113", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,1, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 0,1, 2,0,4, 0},

            {0, 0,4, 0,2,1, 1},
            {1, 0,4, 4,0,1, 1},
            {1, 4,1, 5,1,4, 1},
            {0, 0,1, 6,0,4, 1},
      };
      info = "a=b\nc=d=e\nA=B\nC+D=360\nD+E=180\n(2A+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      final double w = .3;
      final double h = w * Math.sqrt(7)/3;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, 4*w,   0);
      baseTile.setPoint(2, 3*w,   h);
      baseTile.setPoint(3, 4*w, 2*h);
      baseTile.setPoint(4, 3*w, 3*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(3);
      offsets[2] = tiles[4].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[4].getY(2)-tiles[0].getY(0);
   }
}
