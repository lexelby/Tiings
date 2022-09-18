package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_64a
   extends TilingType
{
   public TilingTypeN4_64a(){
      super( "N4-64a", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{"Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,1,0, 0},
            {0, 2,1, 1,1,0, 1},
            {1, 3,0, 2,1,0, 1},

            {0, 3,0, 0,0,3, 0},
            {1, 3,0, 4,1,0, 0},
            {0, 2,1, 5,1,0, 1},
            {1, 3,0, 6,1,0, 1},
      };
      info = "b=c+d\na=c\nA=60\nB=60\nC=120\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5;
      double s = w * getParam(paramValues,0)/100 / 2;
      double h = s * Math.sqrt(3);
      
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w-s, h);
      baseTile.setPoint(3, s, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(1);
      offsets[2] = tiles[2].getX(0)-tiles[6].getX(3);
      offsets[3] = tiles[2].getY(0)-tiles[6].getY(3);
   }
}
