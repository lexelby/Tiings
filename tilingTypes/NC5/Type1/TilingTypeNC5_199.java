package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_199
   extends TilingType
{
   public TilingTypeNC5_199(){
      super( "NC5-199", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,0, 1,0,4, 1},
            {0, 0,1, 2,0,1, 0},
      };
      info = "c=d+e\nA=B\nD+E=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnc = 0.5;
      double lnd = lnc * getParam(paramValues,1)/100;
      double lne = lnc - lnd;
      double lna = 2*lnc;

      double a = getParam(paramValues,0);
      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  (lna+lne-lnd+lnc)*c, 0);
      baseTile.setPoint(2,  (lna+lne-lnd)*c, (lna-lne-lnd)*s);
      baseTile.setPoint(3,  (lna+lne)*c, (lna-lne)*s);
      baseTile.setPoint(4,  lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[1].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(2);
   }
}
