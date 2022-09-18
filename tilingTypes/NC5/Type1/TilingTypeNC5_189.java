package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_189
   extends TilingType
{
   public TilingTypeNC5_189(){
      super( "NC5-189", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 80, 60};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,4,0, 0},
            {1, 0,1, 1,1,0, 0},
            {0, 0,4, 2,4,0, 0},

            {0, 3,4, 0,0,1, 1},
            {1, 0,4, 4,4,0, 1},
            {1, 0,1, 5,1,0, 1},
            {0, 0,4, 6,4,0, 1},
      };
      info = "c=d\nb=d+e\nB=D\nB+C=360\n(A+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnbc = lna * getParam(paramValues,1)/100 * (Math.sqrt(5)-1)/2;
      double lnd = lna - lnbc;
      double b = getParam(paramValues,0);

      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna-lnbc*c, lnbc*s);
      baseTile.setPoint(3, lna+lnbc-lnbc*c, lnbc*s);
      baseTile.setPoint(4, lna+lnbc-(lnbc+lnd)*c, (lnbc+lnd)*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(0);
   }
}
