package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_50
   extends TilingType
{
   public TilingTypeN4_50(){
      super( "N4-50", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,180};
      paramDef = new int[]{ 40, 35, 80};
      paramName = new String[]{ "Aspect", "Side ratio", "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 0,1, 1,1,0, 0},
            {0, 3,2, 2,2,3, 0},

            {0, 0,3, 0,1,0, 1},
            {1, 3,2, 4,2,3, 1},
            {1, 0,1, 5,1,0, 1},
            {0, 3,2, 6,2,3, 1},
      };
      info = "A+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 2.5 * getParam(paramValues,0)/100;
      double w = 2.5 - h;

      double h1 = h * getParam(paramValues,1)/100;
      double h2 = h - h1;

      double c = Math.cos( paramValues[2] * DEG2RAD );
      double s = Math.sin( paramValues[2] * DEG2RAD );

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w+h1*c, h1*s);
      baseTile.setPoint(3,   h2*c, h2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}
