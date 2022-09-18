package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_81
   extends TilingType
{
   public TilingTypeNC5_81(){
      super( "NC5-81", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,4,3, 0},
            {0, 4,0, 1,4,3, 0},
            {1, 4,0, 2,4,3, 0},

            {0, 0,1, 0,2,3, 1},
            {1, 4,0, 4,4,3, 1},
            {0, 4,0, 5,4,3, 1},
            {1, 4,0, 6,4,3, 1},
      };
      info = "a=e\nb=2c=2d\nB=90\nC=270\nE=90\n(A+D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .4;
     
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, 2*w,  0);
      baseTile.setPoint(2, 2*w,  w);
      baseTile.setPoint(3, 3*w,  w);
      baseTile.setPoint(4,   w,2*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(1);
      offsets[2] = tiles[1].getX(2)-tiles[6].getX(1);
      offsets[3] = tiles[1].getY(2)-tiles[6].getY(1);
   }
}
