package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_29b
   extends TilingType
{
   public TilingTypeNC5_29b(){
      super( "NC5-29b", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 50, 90};
      paramName = new String[]{ "Relative Length", "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,3,2, 1},
            {1, 2,0, 1,0,2, 1},
            {0, 3,2, 2,1,0, 0},
            
            {0, 1,0, 0,0,4, 1},
            {1, 1,0, 4,3,2, 0},
            {1, 2,0, 5,0,2, 0},
            {0, 3,2, 6,1,0, 1},
      };
      info = "a=d\nc=e\nB+D=360\nD+E=360\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double b = paramValues[1];
      double minln2 = b<=90 ? 2 * Math.sin((90-b) * DEG2RAD) : 0;
      double minparam = 2*minln2/(2 + minln2);
      double ln2 = 2 * (minparam + (1-minparam)*paramValues[0]/100.) / 2;
      double ln1 = (2-ln2)/2;

      double diag = calcSide(ln1*2, ln2, b);
      double a = 2*calcAngle(ln1*2, diag, ln2);

      double x4 =      ln1 * Math.cos( a * DEG2RAD);
      double y4 =      ln1 * Math.sin( a * DEG2RAD);
      double x3 = x4 + ln2 * Math.cos( (a+b-180) * DEG2RAD);
      double y3 = y4 + ln2 * Math.sin( (a+b-180) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = 2*ln1;
      double y1 = 0;
 
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[3].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[7].getX(0)-tiles[0].getX(2);
      offsets[3] = tiles[7].getY(0)-tiles[0].getY(2);
   }
}
