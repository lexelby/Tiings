package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_66
   extends TilingType
{
   public TilingTypeN4_66(){
      super( "N4-66", 4, SymmetryType.p4 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{"Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 3,2, 2,2,3, 0},

            {0, 0,1, 0,0,3, 0},
            {1, 3,2, 4,2,3, 0},
            {1, 1,0, 5,0,1, 0},
            {0, 3,2, 6,2,3, 0},
      };
      info = "b=2a+2c\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.;
      double h1 = w/2 * getParam(paramValues,0)/100;
      double h2 = w/2-h1;
      
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h1);
      baseTile.setPoint(3, 0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[3].getX(0);
      offsets[1] = tiles[0].getY(0)-tiles[3].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[7].getX(1);
      offsets[3] = tiles[0].getY(1)-tiles[7].getY(1);
   }
}
