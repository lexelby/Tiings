package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_40b
   extends TilingType
{
   public TilingTypeN4_40b(){
      super( "N4-40b: ssm paralellogram", 6, SymmetryType.pmg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,180,100,100};
      paramDef = new int[]{ 40, 80,  5, 30};
      paramName = new String[]{"Aspect", "Angle", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,4,3, 0},
            {1, 0,2, 1,0,2, 1},
            {0, 3,4, 2,4,3, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 3,4, 4,4,3, 0},
            {1, 0,2, 5,0,2, 1},
            {0, 3,4, 6,4,3, 1},
      };
      info = "a=c\nb=d\nA+B=180\n(C+D=180)";
      labels = new int[]{0,-1,1,2,-1,3};
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5 * getParam(paramValues,0)/100;
      double w = 1.5 - h;
      double dx = h * Math.cos( paramValues[1] * DEG2RAD );
      double dy = h * Math.sin( paramValues[1] * DEG2RAD );
      double os1 = w * getParam(paramValues,3)/100;
      double os2 = w * getParam(paramValues,2)/100;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, os1,  0);
      baseTile.setPoint(2, w,  0);
      baseTile.setPoint(3, w+dx, dy);
      baseTile.setPoint(4, os2+dx,  dy);
      baseTile.setPoint(5, dx, dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}
