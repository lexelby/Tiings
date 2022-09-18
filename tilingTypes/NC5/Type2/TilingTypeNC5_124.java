package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_124
   extends TilingType
{
   public TilingTypeNC5_124(){
      super( "NC5-124", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,1, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 2,1, 2,0,1, 0},
            
            {0, 3,2, 0,1,0, 1},
            {1, 0,1, 4,2,1, 1},
            {1, 2,1, 5,1,2, 1},
            {0, 2,1, 6,0,1, 1},
      };
      info = "a=d\nb=d+e\nc=b+e\nA=B\nA+D=360\n(B+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double lnd = lntotal * paramValues[0]/300;
      lnd = Math.max(lnd,1e-6);
      double lnc = lntotal - lnd;
      double lna = lnc + lnd;
      double lnb = lna + lnd;

      double c1 = 2*lnc*(lnc+2*lnd);
      double c2 = -(2*lnc*lnc+3*lnc*lnd+2*lnd*lnd);
      double c3 = lnd*(lnc+2*lnd);
      
      double cs = (-c2 - Math.sqrt(c2*c2-4*c1*c3))/2/c1;
      double a = Math.acos(cs)/DEG2RAD;

      double x1 = lna;
      double y1 = 0;
      double x2 = x1 - lnb * Math.cos(a*DEG2RAD);
      double y2 = y1 + lnb * Math.sin(a*DEG2RAD);
      double x4 =      lnc * Math.cos(a*DEG2RAD);
      double y4 =      lnc * Math.sin(a*DEG2RAD);

      double diag = calcSide(lnc,lnd,a);
      double ang = Math.atan2(y2-y4,x2-x4)/DEG2RAD-calcAngle(diag,lnd,lnc);
      
      double x3 = x4 + lnd * Math.cos(ang*DEG2RAD);
      double y3 = y4 + lnd * Math.sin(ang*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(1);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(1);
   }
}
