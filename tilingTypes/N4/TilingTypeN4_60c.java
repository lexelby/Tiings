package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_60c
   extends TilingType
{
   public TilingTypeN4_60c(){
      super( "N4-60c", 4, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,1, 1,3,2, 0},
            {0, 0,1, 2,0,1, 1},
      };
      info = "2c=2a+d\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * getParam(paramValues,0)/100.;  // base
      double h = 1.5 - w;
      double h2= h + w / Math.sqrt(3);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, 0);
      baseTile.setPoint(2, w, h2);
      baseTile.setPoint(3, 0, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(3) + .5 * offsets[0];
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(3) + .5 * offsets[1];
   }
}
