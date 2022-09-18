package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_103
   extends TilingType
{
   public TilingTypeNC5_103(){
      super( "NC5-103", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,1,3, 0},
            {1, 0,1, 1,1,0, 0},
            {0, 1,3, 2,0,3, 0},

            {0, 4,0, 0,0,1, 1},
            {1, 0,3, 4,1,3, 1},
            {1, 0,1, 5,1,0, 1},
            {0, 1,3, 6,0,3, 1},
      };
      info = "a=c\nd=e\nb=a+2e\nD=90\nA+E=180\nA+B=90\n(E=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 0.3;
      double h = w*Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  2*h,0);
      baseTile.setPoint(2,  h,  w);
      baseTile.setPoint(3,  h,  h);
      baseTile.setPoint(4,  w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(4)-tiles[4].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(4);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(4);
   }
}
