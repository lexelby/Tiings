package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_210b
   extends TilingType
{
   public TilingTypeNC5_210b(){
      super( "NC5-210b", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 70, 40, 60};
      paramName = new String[]{ "Angle", "Relative length", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,3,4, 1},
            {1, 1,0, 1,0,1, 1},
            {0, 3,4, 2,1,2, 0},

            {0, 0,4, 0,1,0, 1},
            {1, 1,2, 4,3,4, 0},
            {1, 1,0, 5,0,1, 0},
            {0, 3,4, 6,1,2, 1},
      };
      info = "a=b+d\nc=e\nB=E\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.6;
      double lne = lnt * getParam(paramValues,1)/200;
      double lna = lnt - lne;
      double e = getParam(paramValues,0);

      double diag = calcSide(lna, lne,e);
      double a = 2 * calcAngle(diag,lna,lne);
      double mxd = Math.sin(e*DEG2RAD) * lne / Math.sin(a*DEG2RAD);
      double lnd = mxd * getParam(paramValues,2)/100;
      double lnb = lna - lnd;
      
      double x2 = lnb + lne * Math.cos((180-e) * DEG2RAD);
      double y2 =       lne * Math.sin((180-e) * DEG2RAD);
      double x4 =       lna * Math.cos(a * DEG2RAD);
      double y4 =       lna * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0, 0 );
      baseTile.setPoint(1,  lnb, 0 );
      baseTile.setPoint(2,  x2, y2 );
      baseTile.setPoint(3,  x2+lnd, y2 );
      baseTile.setPoint(4,  x4, y4 );
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[1].getY(3);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(0);
   }
}
