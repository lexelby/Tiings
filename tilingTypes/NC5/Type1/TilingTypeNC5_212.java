package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_212
   extends TilingType
{
   public TilingTypeNC5_212(){
      super( "NC5-212", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,180,100};
      paramDef = new int[]{ 30, 80, 80};
      paramName = new String[]{ "Aspect", "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 1,0, 2,0,1, 0},

            {0, 3,2, 2,0,4, 1},
            {1, 1,0, 4,0,1, 1},
            {1, 4,1, 5,1,4, 1},
            {0, 1,0, 6,0,1, 1},
      };
      info = "c=e\nC+E=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;
      double b = getParam(paramValues,1);
      double c = Math.cos(b * DEG2RAD); 
      double s = Math.sin(b * DEG2RAD);

      double diag = calcSide(lna,lnb,b);
      double lnd = diag * getParam(paramValues,2)/100;
      
      double angc = Math.atan2((lnd+lna)*s, lnb - (lna+lnd)*c) / DEG2RAD;
      double m = 180-b-angc-angc;
      double dx = lnd/2 * Math.cos(m * DEG2RAD);
      double dy = lnd/2 * Math.sin(m * DEG2RAD);

      double lnb2 = lnb - lna*c; 
      double lna2 = lna*s;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb-lnb2/2 + dx, lna2/2+dy);
      baseTile.setPoint(3,  lnb-lnb2/2 - dx, lna2/2-dy);
      baseTile.setPoint(4,  lnb-lnb2, lna2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[3].getX(4);
      offsets[1] = tiles[4].getY(2)-tiles[3].getY(4);
      offsets[2] = tiles[0].getX(1)-tiles[7].getX(3);
      offsets[3] = tiles[0].getY(1)-tiles[7].getY(3);
   }
}
