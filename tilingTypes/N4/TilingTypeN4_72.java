package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_72
   extends TilingType
{
   public TilingTypeN4_72(){
      super( "N4-72", 4, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{120};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,3, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 0,3, 2,0,1, 0},
      };
      info = "a=b+d\n2A+B=180\nB+C=180\n(A+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double b = 180 - paramValues[0];
      double a = 90-b/2;
      double c = 180-b-a;
      
      double ln = 1.0;
      double lnd = ln * Math.sin(b * DEG2RAD) / Math.sin(c * DEG2RAD);
      double lnc = (lnd - ln)/2;
      double lna = ln + lnc;

      double x3 = lnd * Math.cos(a * DEG2RAD);
      double y3 = lnd * Math.sin(a * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, x3+lnc, y3);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(1);
   }
}
