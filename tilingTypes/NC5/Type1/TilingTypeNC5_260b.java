package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_260b
   extends TilingType
{
   public TilingTypeNC5_260b(){
      super( "NC5-260b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 40};
      paramName = new String[]{ "Angle", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,4, 1},
            {1, 4,0, 1,0,4, 1},
            {1, 1,2, 2,2,1, 1},
            {0, 0,4, 3,4,0, 1},
            {2, 0,4, 4,1,0, 0},
      };
      info = "b=a+d\ne=2c\nB=E\nB+C=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 1.0;
      double lna = lnb * getParam(paramValues,1)/100;
      double a = getParam(paramValues,0);

      double dx = (lna * Math.cos(a * DEG2RAD) - lna)/3;
      double dy = lna * Math.sin(a * DEG2RAD) / 3;

      baseTile.setPoint(0,  0, 0 );
      baseTile.setPoint(1,  lnb, 0 );
      baseTile.setPoint(2,  lnb + dx, dy );
      baseTile.setPoint(3,  lna + dx, dy );
      baseTile.setPoint(4,  lna + dx*3, dy*3 );
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[1].getX(2);
      offsets[3] = tiles[0].getY(4)-tiles[1].getY(2);
   }
}
