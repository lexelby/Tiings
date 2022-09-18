package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_53b
   extends TilingType
{
   public TilingTypeN4_53b(){
      super( "N4-53b", 5, SymmetryType.pmg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 20};
      paramName = new String[]{ "Angle", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,3,2, 1},
            {1, 4,2, 1,2,4, 1},
            {0, 3,2, 2,0,4, 0},

            {0, 0,1, 0,0,1, 1},
            {1, 0,4, 4,3,2, 0},
            {1, 4,2, 5,2,4, 0},
            {0, 3,2, 6,0,4, 1},
      };
      info = "a=c\nb=d=2a\nA+B=180\n(C+D=180)";
      labels = new int[]{0,1,2,-1,3};
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.25;
      double h = w/2;

      double c = h*Math.cos( paramValues[0] * DEG2RAD );
      double s = h*Math.sin( paramValues[0] * DEG2RAD );
      double os = w * getParam(paramValues,1)/100;

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   w, 0);
      baseTile.setPoint(2, w+c, s);
      baseTile.setPoint(3,os+c, s);
      baseTile.setPoint(4,   c, s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(0);
   }
}
