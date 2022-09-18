package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_71
   extends TilingType
{
   public TilingTypeN4_71(){
      super( "N4-71", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {0, 2,3, 1,0,3, 1},
            {1, 1,2, 2,1,2, 0},

            {0, 3,0, 0,0,3, 0},
            {1, 1,2, 4,1,2, 1},
            {0, 2,3, 5,0,3, 1},
            {1, 1,2, 6,1,2, 0},
      };
      info = "a=d\nB=90\nA+2C=360\n(C-D=90)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnb = getParam(paramValues,0)/100.;
      double lna = 1 - lnb;
      
      double a2 = Math.atan2(lnb,lna) / DEG2RAD;
      // a+2d=180
      // a = a2 + (90-d/2)
      // a2 + (90-d/2) + 2d = 180
      // d = 60 - a2*2/3
      double d = 60 - a2 * 2/3;
      double a = 180-d-d;
      double diag = Math.sqrt(lna*lna+lnb*lnb);
      double lnd = diag/2 / Math.sin(d/2*DEG2RAD);
      
      // scale
      double f = 2.0 / (lnd + 1);
      lna *= f;
      lnb *= f;
      lnd *= f;
      
      double x3 =      lnd * Math.cos(a * DEG2RAD);
      double y3 =      lnd * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1,lna,   0);
      baseTile.setPoint(2,lna, lnb);
      baseTile.setPoint(3, x3,  y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(0);
      offsets[2] = tiles[6].getX(0)-tiles[2].getX(3);
      offsets[3] = tiles[6].getY(0)-tiles[2].getY(3);
   }
}
