package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bk
   extends TilingType
{
   public TilingTypeN5_01bk(){
      super( "N5-1bk", 5, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{100};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 4,0, 0,3,2, 0},
            {1, 3,2, 1,2,3, 0},
            {1, 1,0, 2,0,1, 0},
            {0, 2,3, 3,3,2, 0},
            {2, 3,2, 4,4,0, 0},

            {2, 0,1, 3,4,0, 1},
            {0, 4,0, 6,3,2, 1},
            {1, 3,2, 7,2,3, 1},
            {1, 1,0, 8,0,1, 1},
            {0, 2,3, 9,3,2, 1},
            {2, 3,2,10,4,0, 1},
      };
      info = "a=d\nc=e\nb=a+c\nA+B=180\nA+E=180\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 0.6;
      double a = getParam(paramValues, 0);
      double cs = Math.cos(a * DEG2RAD);
      double sn = Math.sin(a * DEG2RAD);
      double lnce = lna * (1-2*cs) / (4-2*cs);
      double lnb = lna + lnce;

      double x4 =  lna * cs;
      double y4 =  lna * sn;
      double x3 =  x4 + lnce;
      double y3 =  y4;
      double x2 =  lnb + lnce * cs;
      double y2 =        lnce * sn;
      
      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,   x2, y2);
      baseTile.setPoint(3,   x3, y3);
      baseTile.setPoint(4,   x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[4].getX(2);
      offsets[1] = tiles[1].getY(1)-tiles[4].getY(2);
      offsets[2] = tiles[11].getX(0)-tiles[2].getX(4);
      offsets[3] = tiles[11].getY(0)-tiles[2].getY(4);
   }
}
