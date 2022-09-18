package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_197
   extends TilingType
{
   public TilingTypeNC5_197(){
      super( "NC5-197", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {1, 1,2, 1,2,1, 0},
            {0, 4,3, 2,3,4, 0},

            {0, 2,3, 2,4,0, 1},
            {1, 4,3, 4,3,4, 1},
            {1, 1,2, 5,2,1, 1},
            {0, 4,3, 6,3,4, 1},
      };
      info = "b=d\n2a=b+c\nA=C\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 0.5;
      double lnc = lna * getParam(paramValues,1)/100;
      double lnbd = 2*lna - lnc;
      
      double a = getParam(paramValues,0);
      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnbd, 0);
      baseTile.setPoint(2,  lnbd - lnc*c, -lnc*s);
      baseTile.setPoint(3,  lnbd + lnbd - lnc*c, -lnc*s);
      baseTile.setPoint(4,  lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[7].getX(2);
      offsets[3] = tiles[0].getY(3)-tiles[7].getY(2);
   }
}
