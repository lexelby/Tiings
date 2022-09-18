package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_243
   extends TilingType
{
   public TilingTypeNC5_243(){
      super( "NC5-243", 5, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {2, 1,2, 1,3,2, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 1,0, 3,0,1, 0},
            {2, 1,2, 4,3,2, 0},
      };
      info = "b=c=2a\na=d\nB=C\nC=E\nD+E=360\n(A+B+C=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = .4;
      double lnb = lna*2;
      double a = getParam(paramValues, 0);
      double b = (180-a)/2;

      double x4 = lna * Math.cos(a * DEG2RAD);
      double y4 = lna * Math.sin(a * DEG2RAD);
      double x2 = lnb - lnb * Math.cos(b * DEG2RAD);
      double y2 =       lnb * Math.sin(b * DEG2RAD);
      double x3 = x2 - x4;
      double y3 = y2 - y4;
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, x2,  y2);
      baseTile.setPoint(3, x3,  y3);
      baseTile.setPoint(4, x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[2].getX(0);
      offsets[1] = tiles[5].getY(2)-tiles[2].getY(0);
      offsets[2] = tiles[4].getX(0)-tiles[1].getX(4);
      offsets[3] = tiles[4].getY(0)-tiles[1].getY(4);
   }
}
