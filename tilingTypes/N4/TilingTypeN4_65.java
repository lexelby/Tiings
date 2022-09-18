package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_65
   extends TilingType
{
   public TilingTypeN4_65(){
      super( "N4-65", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{"Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 1,2, 0,3,2, 0},
            {1, 1,0, 2,2,3, 0},

            {0, 0,1, 2,3,0, 1},
            {0, 2,1, 4,1,2, 1},
            {1, 1,2, 4,3,2, 1},
            {1, 1,0, 6,2,3, 1},
      };
      info = "b+d=2a=2c\nA=B\nC=D\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double s = .75;
      double w1 = 2*s * getParam(paramValues,0)/100;
      double i = w1-s;
      double h = Math.sqrt(s*s-i*i);
      
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w1,  0);
      baseTile.setPoint(2, w1-i, h);
      baseTile.setPoint(3, i, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[2].getX(0);
      offsets[1] = tiles[3].getY(3)-tiles[2].getY(0);
      offsets[2] = tiles[6].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[6].getY(3)-tiles[0].getY(0);
   }
}
