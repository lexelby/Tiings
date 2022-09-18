package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01k3
   extends TilingType
{
   public TilingTypeN5_01k3(){
      super( "N5-1k3: type 1&2", 5, SymmetryType.p2 );

      paramMin = new int[]{ 90,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{100, 20, 40};
      paramName = new String[]{ "Angle", "Relative Length 1", "Relative Length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,3,2, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 2,3, 2,3,2, 0},
            {2, 0,1, 3,3,4, 1},
            {2, 2,3, 4,3,2, 1},
      };
      info = "a=c\nA+B=180\nA=E\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double sum = 2;
      double b = paramValues[0];
      double lnb = paramValues[1] * sum / 100;
      double lnc = paramValues[2] * (sum-lnb) / 100;
      double lna = sum-lnb-lnc;

      double x4 = lnb * Math.cos( b * DEG2RAD);
      double y4 = lnb * Math.sin( b * DEG2RAD);
      double x2 = lna + x4;
      double y2 = y4;
      double x3 = x4 - lnc * Math.cos( (b+b) * DEG2RAD);
      double y3 = y4 - lnc * Math.sin( (b+b) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lna,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[4].getX(3);
      offsets[1] = tiles[3].getY(0)-tiles[4].getY(3);
      offsets[2] = tiles[5].getX(0)-tiles[1].getX(2);
      offsets[3] = tiles[5].getY(0)-tiles[1].getY(2);
   }
}
