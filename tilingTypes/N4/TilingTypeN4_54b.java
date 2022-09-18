package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_54b
   extends TilingType
{
   public TilingTypeN4_54b(){
      super( "N4-54b", 4, SymmetryType.pmg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 30, 80};
      paramName = new String[]{ "Side ratio", "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,0,1, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 2,1,2, 0},

            {0, 0,3, 0,0,3, 1},
            {1, 1,2, 4,0,1, 0},
            {1, 3,2, 5,2,3, 0},
            {0, 0,1, 6,1,2, 1},
      };
      info = "b=a+c\nA+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.0;
      double w = h;

      double h1 = h * getParam(paramValues,0)/100;
      double h2 = h - h1;

      double c = Math.cos( paramValues[1] * DEG2RAD );
      double s = Math.sin( paramValues[1] * DEG2RAD );

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w+h1*c, h1*s);
      baseTile.setPoint(3,   h2*c, h2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[3].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[0].getX(2)-tiles[4].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[4].getY(2);
   }
}
