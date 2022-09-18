package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_14
   extends TilingType
{
   public TilingTypeN4_14(){
      super( "N4-14", 4, SymmetryType.pgg );

      paramMin = new int[]{ 90};
      paramMax = new int[]{180};
      paramDef = new int[]{110};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 2,0,1, 1},

            {0, 1,2, 3,3,2, 1},      
            {0, 3,2, 4,2,3, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 0,1, 5,0,1, 0},
      };
      info = "a+c=d\nC+D=180\n2A+C=360\n(A+B=180)";
   }

   public void recalcBase(double[] paramValues) {
      double c = paramValues[0];
      double b = c/2;
      double sb = Math.sin(b*DEG2RAD);
      double cb = Math.cos(b*DEG2RAD);
      double lna = Math.sin(c*DEG2RAD) / sb;

      double x =  Math.sin((b+c)*DEG2RAD);
      double lnb = (sb+x)/2;
      double lnd = (sb-x)/2;

      double x2 = lna - lnb * cb/sb;
      double y2 = lnb;
      double x3 = - lnd * cb/sb;
      double y3 = + lnd;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lna,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[7].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[7].getY(3);
      offsets[2] = tiles[5].getX(1)-tiles[1].getX(3);
      offsets[3] = tiles[5].getY(1)-tiles[1].getY(3);
   }
}
