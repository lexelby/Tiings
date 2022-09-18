package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_84
   extends TilingType
{
   public TilingTypeNC5_84(){
      super( "NC5-84", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,4, 1},
            {0, 4,3, 0,3,4, 0},
            {1, 1,0, 2,0,4, 1},

            {0, 2,1, 1,2,3, 1},
            {1, 1,0, 4,0,4, 0},
            {0, 4,3, 4,3,4, 1},
            {1, 1,0, 6,0,4, 0},
      };
      info = "a=b=2c=2d\nB=90\nC=90\nD=270\n(A=60)\n(E=30)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double h = w * Math.sqrt(3);
     
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, 2*w,  0);
      baseTile.setPoint(2, 2*w,  w);
      baseTile.setPoint(3,   w,  w);
      baseTile.setPoint(4,   w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[7].getX(2);
      offsets[1] = tiles[2].getY(2)-tiles[7].getY(2);
      offsets[2] = tiles[0].getX(2)-tiles[5].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[5].getY(2);
   }
}
