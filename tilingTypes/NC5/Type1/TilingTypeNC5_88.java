package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_88
   extends TilingType
{
   public TilingTypeNC5_88(){
      super( "NC5-88", 5, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 4,3, 0,4,0, 0},
            {1, 4,3, 1,4,0, 0},
            {1, 4,3, 2,4,0, 0},

            {0, 2,3, 0,0,1, 1},
            {0, 2,3, 1,0,1, 1},
            {0, 2,3, 2,0,1, 1},
            {0, 2,3, 3,0,1, 1},
      };
      info = "b=c=d\na=e\nB=90\nC=270\nE=90\n(A+D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
     
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,   w,  0);
      baseTile.setPoint(2,   w,  w);
      baseTile.setPoint(3, 2*w,  w);
      baseTile.setPoint(4, w/2,3*w/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(4)-tiles[4].getX(4);
      offsets[1] = tiles[5].getY(4)-tiles[4].getY(4);
      offsets[2] = tiles[7].getX(4)-tiles[4].getX(4);
      offsets[3] = tiles[7].getY(4)-tiles[4].getY(4);
   }
}
