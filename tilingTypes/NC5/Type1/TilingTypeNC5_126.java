package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_126
   extends TilingType
{
   public TilingTypeNC5_126(){
      super( "NC5-126", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 65};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {1, 0,1, 1,1,0, 1},
            {0, 1,2, 2,2,3, 0},

            {0, 4,0, 0,3,4, 1},
            {1, 2,3, 4,1,2, 0},
            {1, 0,1, 5,1,0, 0},
            {0, 1,2, 6,2,3, 1},
      };
      info = "c=d\na=b=e\nB+C=360\nA+B=180\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.1;

      double lnbc = lntotal * getParam(paramValues,0)/300;
      double lnade = lntotal - lnbc;
      double a = calcAngle(lnade+lnbc,lnade-lnbc,lnade);
      double c = Math.cos(a*DEG2RAD);
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lnade, 0);
      baseTile.setPoint(2, lnade+lnbc*c, lnbc*s);
      baseTile.setPoint(3, lnade+lnbc*(c+1), lnbc*s);
      baseTile.setPoint(4, lnade*c, lnade*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(4);
   }
}
