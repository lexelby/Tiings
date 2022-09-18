package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_100
   extends TilingType
{
   public TilingTypeNC5_100(){
      super( "NC5-100", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {1, 0,4, 1,4,0, 0},
            {0, 2,3, 2,2,1, 0},

            {0, 1,0, 0,0,4, 1},
            {1, 2,1, 4,2,3, 1},
            {1, 0,4, 5,4,0, 1},
            {0, 2,3, 6,2,1, 1},
      };
      info = "a=b\nc=d\nc+d+e=a\nB=90\nC=90\nD=270\n(A=45)\n(E=45)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .3;
      double h = w * (1 + Math.sqrt(2));
     
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, h+w,  0);
      baseTile.setPoint(2, h+w,  w);
      baseTile.setPoint(3,   h,  w);
      baseTile.setPoint(4,   h,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}
