package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_104
   extends TilingType
{
   public TilingTypeNC5_104(){
      super( "NC5-104", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,1, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 0,1, 2,0,4, 0},

            {0, 2,4, 1,1,3, 1},
            {1, 0,4, 4,0,1, 1},
            {1, 4,3, 5,3,4, 1},
            {0, 0,1, 6,0,4, 1},
      };
      info = "a=b\nc=d=e\nA=90\nC+D=360\nB+C=180\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      final double h = .5;
      final double w = h*(4-Math.sqrt(7))/3;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, h*2, 0);
      baseTile.setPoint(2, 2*h-w, h);
      baseTile.setPoint(3, w, h);
      baseTile.setPoint(4, 0, 2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(3)-tiles[0].getX(4);
      offsets[1] = tiles[5].getY(3)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(4)-tiles[4].getX(1);
      offsets[3] = tiles[3].getY(4)-tiles[4].getY(1);
   }
}
