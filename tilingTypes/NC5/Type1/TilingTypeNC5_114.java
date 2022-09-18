package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_114
   extends TilingType
{
   public TilingTypeNC5_114(){
      super( "NC5-114", 5, SymmetryType.cmm );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,4, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 0,4, 2,0,4, 0},

            {0, 0,1, 0,0,1, 1},
            {1, 0,4, 4,0,4, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 0,4, 6,0,4, 1},
      };
      info = "c=d=e\nA=45\nB=90\nC=90\nD=270\n(E=45)";
   }

   public void recalcBase(double[] paramValues) {
      final double w = .3;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, 3*w,   0);
      baseTile.setPoint(2, 3*w,   w);
      baseTile.setPoint(3, 2*w,   w);
      baseTile.setPoint(4, 2*w, 2*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[3].getX(0);
      offsets[1] = tiles[0].getY(0)-tiles[3].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[3].getX(1);
      offsets[3] = tiles[0].getY(1)-tiles[3].getY(1);
   }
}
