package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_128
   extends TilingType
{
   public TilingTypeNC5_128(){
      super( "NC5-128", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 65, 60};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 4,0, 2,0,4, 0},

            {0, 3,2, 1,2,1, 1},
            {1, 4,0, 4,0,4, 1},
            {0, 1,0, 4,0,1, 1},
            {1, 4,0, 6,0,4, 1},
      };
      info = "c=d=e\nB+C=360\nB=D\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnb = lna * getParam(paramValues,1)/100;
      double a = getParam(paramValues,0)/2;

      double c = Math.cos( a * DEG2RAD);
      double s = Math.sin( a * DEG2RAD);

      double x1 = lna * c;
      double y1 = lna * s;
      double x2 = x1 - lnb * c;
      double y2 = y1 + lnb * s;
      double x3 = x2 + lnb * c;
      double y3 = y2 + lnb * s;
      double x4 = x3 - lnb * c;
      double y4 = y3 + lnb * s;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[7].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[5].getX(2);
      offsets[3] = tiles[0].getY(3)-tiles[5].getY(2);
   }
}
