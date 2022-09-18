package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_29c
   extends TilingType
{
   public TilingTypeNC5_29c(){
      super( "NC5-29c", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 50, 90};
      paramName = new String[]{ "Relative Length", "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,3,4, 1},
            {1, 2,0, 1,0,2, 1},
            {0, 3,4, 2,1,2, 0},

      };
      info = "a=d\nc=d\nb=2d\nB=E\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln1 = lntotal * getParam(paramValues, 0)/200;
      double ln2 = lntotal - ln1;
      double b = getParam(paramValues, 1);
      double diag = calcSide(ln1,ln2,b);
      double a = 2 * calcAngle(diag,ln2,ln1);

      double x1 = ln2;
      double y1 = 0;
      double x2 = x1 + ln1 * Math.cos((180-b) * DEG2RAD);
      double y2 = y1 + ln1 * Math.sin((180-b) * DEG2RAD);
      double x4 =      ln2/2 * Math.cos(a * DEG2RAD);
      double y4 =      ln2/2 * Math.sin(a * DEG2RAD);
      double x3 = x2 - x4;
      double y3 = y2 - y4;      

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[1].getX(2);
      offsets[3] = tiles[1].getY(0)-tiles[1].getY(2);
   }
}
