package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_29a
   extends TilingType
{
   public TilingTypeNC5_29a(){
      super( "NC5-29a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,3,2, 0},
            {1, 2,0, 1,0,2, 0},
            {0, 3,2, 2,0,1, 0},
            
            {0, 1,0, 0,0,4, 1},
            {1, 0,1, 4,3,2, 1},
            {1, 2,0, 5,0,2, 1},
            {0, 3,2, 6,0,1, 1},
      };
      info = "a=d\nc=e\nB=90\nD=270\nE=90\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2. * paramValues[0] / 200;
      double ln1 = (2-ln2)/2;

      double ang = Math.atan2(ln2,2*ln1)/DEG2RAD;
      double b = 2*ang;

      double x4 =      ln1 * Math.cos( (b) * DEG2RAD);
      double y4 =      ln1 * Math.sin( (b) * DEG2RAD);
      double x3 = x4 + ln2 * Math.cos( (b-90) * DEG2RAD);
      double y3 = y4 + ln2 * Math.sin( (b-90) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = x2;
      double y1 = y2 - ln2;

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
