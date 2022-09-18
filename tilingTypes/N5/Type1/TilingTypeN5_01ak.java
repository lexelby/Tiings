package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ak
   extends TilingType
{
   public TilingTypeN5_01ak(){
      super( "N5-1ak: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{120};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };
      
      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,3,2, 0},
            {1, 0,1, 1,1,0, 0},
            {0, 3,2, 2,4,0, 0},
            
            {0, 0,1, 2,2,3, 1},
            {1, 4,0, 4,3,2, 1},
            {1, 0,1, 5,1,0, 1},
            {0, 3,2, 6,4,0, 1},
      };
      info = "b=d=a+c\na=c+e\nA+B=180\nA=D\nC=E\n(D+2E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c = paramValues[0];
      double e2 = 180-3*c/2;
      double diag = calcSide(1,1,e2);
      double a2 = c - (90-e2/2);
      
      double lnc = .8;
      double lna = lnc * diag / 2 / Math.cos(a2 * DEG2RAD);
      double lnb = (lna + lnc)/2;
      double lnd = lnc - lnb;

      double x2 = lnc + lnd * Math.cos(c * DEG2RAD);
      double y2 =       lnd * Math.sin(c * DEG2RAD);
      double x4 =       lnb * Math.cos(c * DEG2RAD);
      double y4 =       lnb * Math.sin(c * DEG2RAD);
      double x3 = x4 +  lna * Math.cos(c/2 * DEG2RAD);
      double y3 = y4 +  lna * Math.sin(c/2 * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lnc,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(4);
      offsets[2] = tiles[1].getX(2)-tiles[7].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[7].getY(0);
   }
}
