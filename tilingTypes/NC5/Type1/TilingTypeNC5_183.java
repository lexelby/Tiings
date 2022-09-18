package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_183
   extends TilingType
{
   public TilingTypeNC5_183(){
      super( "NC5-183", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,4, 1},
            {1, 4,1, 1,1,4, 1},
            {0, 0,4, 2,1,0, 0},
      };
      info = "a=b\nc=e\nB+C=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnab = 0.7;
      double lnd = lnab * getParam(paramValues,1)/100;

      double a = getParam(paramValues,0);
      double x4 = lnab * Math.cos(a * DEG2RAD);
      double y4 = lnab * Math.sin(a * DEG2RAD);
      double x3 = (lnab + x4)/2 - lnd/2;
      double y3 = y4/2;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnab, 0);
      baseTile.setPoint(2, x3+lnd, y3);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(4);
   }
}
