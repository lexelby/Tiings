package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_59a
   extends TilingType
{
   public TilingTypeN4_59a(){
      super( "N4-59a", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{100, 20};
      paramName = new String[]{ "Angle", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,3,0, 1},
            {0, 2,3, 0,3,2, 0},
            {1, 3,0, 2,3,0, 1},
      };
      info = "C+2D=360\nB+C=180\n(A+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2.5 * (.5 + getParam(paramValues,1)/200.);  // base
      double h = 2.5 - w;
      double c = h*Math.cos(paramValues[0] * DEG2RAD);
      double s = h*Math.sin(paramValues[0] * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, 0);
      baseTile.setPoint(2, w+c, s);
      baseTile.setPoint(3, h+c, s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(0)-tiles[1].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[1].getY(1);
   }
}
