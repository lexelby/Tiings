package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_161
   extends TilingType
{
   public TilingTypeNC5_161(){
      super( "NC5-161", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,0,4, 0},
            {1, 4,0, 1,0,4, 0},
            {0, 0,4, 2,3,4, 0},
      };
      info = "a=e\nb=c+d\nD=E\nB+C=360\nB+E=180\n(A+D=B)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double lnc = lna * getParam(paramValues,0)/200;
      double lnd = Math.sqrt(2*lna*(lna-lnc)) - lna;
      double lne = lnc + lnd;
      
      double c = (lna+lnd)/2/lna;
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lne, 0);
      baseTile.setPoint(2, lne+lnd*c, s*lnd);
      baseTile.setPoint(3, lne+lnc+lnd*c, s*lnd);
      baseTile.setPoint(4, lne+lnc+lnd*c-lna*c, s*lnd+s*lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[1].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[1].getY(1);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(2);
   }
}
