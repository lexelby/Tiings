package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_99
   extends TilingType
{
   public TilingTypeNC5_99(){
      super( "NC5-99", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,0, 0,2,4, 1},
            {0, 1,0, 0,0,4, 1},
            {1, 2,4, 2,3,0, 0},

            {1, 2,1, 2,2,3, 1},
            {0, 3,0, 4,2,4, 0},
            {0, 1,0, 4,0,4, 0},
            {1, 2,4, 6,3,0, 1},
      };
      info = "a=d=e=2c\nA+E=180\nB=C\nD+E=360\n(E=2B)";
   }

   public void recalcBase(double[] paramValues) {
      final double h = .08;
      final double w = 3*Math.sqrt(7)*h;

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, 3*w,-3*h);
      baseTile.setPoint(2, 3*w, h);
      baseTile.setPoint(3, 2*w, 0);
      baseTile.setPoint(4,   w, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(2)-tiles[1].getX(2);
      offsets[3] = tiles[7].getY(2)-tiles[1].getY(2);
   }
}
