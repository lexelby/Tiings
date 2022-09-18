package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_260a
   extends TilingType
{
   public TilingTypeNC5_260a(){
      super( "NC5-260a", 5, SymmetryType.pgg);

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 40};
      paramName = new String[]{ "Angle", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 4,0, 1,0,4, 0},
            {1, 3,4, 2,4,3, 0},
            {0, 4,0, 3,0,4, 0},
            {2, 3,2, 4,2,3, 0},

            {2, 0,4, 1,1,0, 1},
            {0, 3,2, 6,2,3, 1},
            {1, 4,0, 7,0,4, 1},
            {1, 3,4, 8,4,3, 1},
            {0, 4,0, 9,0,4, 1},
            {2, 3,2,10,2,3, 1},
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
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(1)-tiles[11].getX(0);
      offsets[3] = tiles[4].getY(1)-tiles[11].getY(0);
   }
}
