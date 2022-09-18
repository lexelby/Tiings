package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_82
   extends TilingType
{
   public TilingTypeN4_82(){
      super( "N4-82", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 40, 80};
      paramName = new String[]{"Aspect", "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,3,2, 0},
            {0, 0,1, 1,1,0, 0},

            {0, 0,1, 0,1,2, 1},
            {1, 2,3, 3,3,2, 1},
            {0, 0,1, 4,1,0, 1},
      };
      info = "a=c\nb=d\nA+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5 * getParam(paramValues,0)/100;
      double w = 1.5 - h;
      double dx = h * Math.cos( paramValues[1] * DEG2RAD );
      double dy = h * Math.sin( paramValues[1] * DEG2RAD );

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w+dx, dy);
      baseTile.setPoint(3, dx, dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(0)-tiles[3].getY(1);
      offsets[2] = tiles[5].getX(2)-tiles[2].getX(3);
      offsets[3] = tiles[5].getY(2)-tiles[2].getY(3);
   }
}
