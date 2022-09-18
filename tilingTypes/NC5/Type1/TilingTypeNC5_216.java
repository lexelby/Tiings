package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_216
   extends TilingType
{
   public TilingTypeNC5_216(){
      super( "NC5-216", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,180,100};
      paramDef = new int[]{ 40, 60, 80};
      paramName = new String[]{ "Aspect", "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 4,0, 2,0,4, 0},

            {0, 1,0, 0,3,2, 1},
            {1, 4,0, 4,0,4, 1},
            {1, 4,1, 5,1,4, 1},
            {0, 4,0, 6,0,4, 1},
      };
      info = "c=e\nB=C\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;
      double a = getParam(paramValues,1);

      double diag = calcSide(lna,lnb,a);
      double lnd = diag * getParam(paramValues,2)/100;
      double r = lnd/diag;
      
      double b2 = calcAngle(lnb,diag,lna); 
      double c = Math.atan2(Math.sin(b2 * DEG2RAD), Math.cos(b2 * DEG2RAD)-r)/DEG2RAD;

      double m = 180-c-c;
      double dx = lnd/2 * Math.cos(m * DEG2RAD);
      double dy = lnd/2 * Math.sin(m * DEG2RAD);

      double lnb2 = lnb - lna*Math.cos(a*DEG2RAD); 
      double lna2 = lna*Math.sin(a*DEG2RAD);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb-lnb2/2 + dx, lna2/2+dy);
      baseTile.setPoint(3,  lnb-lnb2/2 - dx, lna2/2-dy);
      baseTile.setPoint(4,  lnb-lnb2, lna2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(1);
   }
}
