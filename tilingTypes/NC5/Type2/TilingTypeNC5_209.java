package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_209
   extends TilingType
{
   public TilingTypeNC5_209(){
      super( "NC5-209", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 70, 40, 60};
      paramName = new String[]{ "Angle", "Aspect", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 4,0, 2,0,4, 0},

            {0, 1,0, 1,3,2, 1},
            {1, 4,0, 4,0,4, 1},
            {1, 2,1, 5,1,2, 1},
            {0, 4,0, 6,0,4, 1},
      };
      info = "c=e\nB+C=180\nB+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.6;
      double lna = lnt * getParam(paramValues,1)/100;
      double lnh = lnt - lna;
      double lnd = lnh * getParam(paramValues,2)/100;
      double a = getParam(paramValues,0);

      double dx = lna/2 * Math.cos(a * DEG2RAD);
      double dy = lna/2 * Math.sin(a * DEG2RAD);
      double lnb = dx*2+lnd;

      baseTile.setPoint(0,  0, 0 );
      baseTile.setPoint(1,  lnb, 0 );
      baseTile.setPoint(2,  dx+lnh, dy );
      baseTile.setPoint(3,  dx+lnh - lnd, dy );
      baseTile.setPoint(4,  2*dx, 2*dy );
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(4);
      offsets[2] = tiles[2].getX(3)-tiles[7].getX(1);
      offsets[3] = tiles[2].getY(3)-tiles[7].getY(1);
   }
}
