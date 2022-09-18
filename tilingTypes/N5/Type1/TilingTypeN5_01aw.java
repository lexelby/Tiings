package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01aw
   extends TilingType
{
   public TilingTypeN5_01aw(){
      super( "N5-1aw", 5, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{110};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 3,4, 0,2,1, 0},
            {1, 4,0, 2,0,4, 0},
      };
      info = "d=e\na+c=b+d\nB=D\nB=E\nA+B=180\n(2B+C=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double a = getParam(paramValues,0);
      double cs = Math.cos(a*DEG2RAD);
      double sn = Math.sin(a*DEG2RAD);
      double lna = 1;
      double lnd =  1 - 2 * cs;
      double lne = lnd / 2;
      double lnc = lne + lna;
      
      double f = 2 / (lnd + lnc + lna);
      lna *= f;
      lnc *= f;
      lnd *= f;
      lne *= f;

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, lnd, 0);
      baseTile.setPoint(2, lnd-cs*lne, sn*lne);
      baseTile.setPoint(3, lna-cs*lnc, sn*lnc);
      baseTile.setPoint(4, -cs*lnc, sn*lnc);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[2].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[2].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[3] = tiles[0].getY(2)-tiles[1].getY(3);
   }
}
