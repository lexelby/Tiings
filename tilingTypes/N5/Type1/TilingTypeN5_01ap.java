package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ap
   extends TilingType
{
   public TilingTypeN5_01ap(){
      super( "N5-1ap", 5, SymmetryType.p2 );

      paramMin = new int[]{ 90};
      paramMax = new int[]{135};
      paramDef = new int[]{110};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {0, 0,1, 0,2,1, 0},
            {0, 0,1, 1,2,1, 0},
      };
      info = "a+c=b\nd=e\nA+B=180\nA=E\nA=D\n(C+2D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double lnd = .9;
      double a2 = 5*a/2 - 270;
      double a3 = 180-a;
      double a4 = 180-a2-a3;
      double lnx = lnd / Math.sin(a4*DEG2RAD) * Math.sin(a2*DEG2RAD);
      double lne = (lnd-lnx)/2;
      double lnc = lnd - lne;
      double diag = calcSide(lnd,lnx,a3);
      double lna = diag / 2 / Math.sin(a/2 * DEG2RAD);

      double x2 = lnd + lnc * Math.cos(a * DEG2RAD);      
      double y2 =       lnc * Math.sin(a * DEG2RAD);
      double x4 =       lne * Math.cos(a * DEG2RAD);      
      double y4 =       lne * Math.sin(a * DEG2RAD);
      double x3 = x4 +  lna * Math.cos((a+a-180) * DEG2RAD);      
      double y3 = y4 +  lna * Math.sin((a+a-180) * DEG2RAD);
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, lnd,   0);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,  x3,  y3);
      baseTile.setPoint(4,  x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(3);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(3);
   }
}
