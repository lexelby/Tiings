package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_46
   extends TilingType
{
   public TilingTypeN4_46(){
      super( "N4-46", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,3, 1,2,3, 1},
            {1, 0,1, 2,0,1, 0},

            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 4,0,1, 1},
            {0, 0,3, 5,2,3, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "a=d\nB=90\nC+2D=360\n(D-A=90)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double lnb = ln * getParam(paramValues,0)/100.;
      double lna = ln - lnb;
      
      double a2 = Math.atan2(lnb,lna) / DEG2RAD;
      // d-a=90
      // a = a2 + (90-d/2)
      // a2 + (90-d/2) + 90 = d
      // (a2 + 180)*2/3 = d
      double d = a2 * 2/3 + 120;
      double a = d-90;
      double diag = Math.sqrt(lna*lna+lnb*lnb);
      double lnd = diag/2 / Math.sin(d/2*DEG2RAD);
      
      double x3 =      lnd * Math.cos(a * DEG2RAD);
      double y3 =      lnd * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1,lna,   0);
      baseTile.setPoint(2,lna, lnb);
      baseTile.setPoint(3, x3,  y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[6].getX(2)-tiles[1].getX(3);
      offsets[3] = tiles[6].getY(2)-tiles[1].getY(3);
   }
}
