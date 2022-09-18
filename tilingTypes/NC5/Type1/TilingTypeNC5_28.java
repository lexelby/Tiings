package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_28
   extends TilingType
{
   public TilingTypeNC5_28(){
      super( "NC5-28", 5, SymmetryType.pgg );

      paramMin = new int[]{   0,  0};
      paramMax = new int[]{ 180,100};
      paramDef = new int[]{ 100, 50};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,2,3, 1},
            {1, 2,3, 1,0,4, 1},
            {0, 2,3, 2,1,2, 0},

            {0, 4,0, 3,1,2, 1},
            {1, 1,2, 4,2,3, 0},
            {1, 2,3, 5,0,4, 0},
            {0, 2,3, 6,1,2, 1},
      };
      info = "a=c=d\nD+E=360\nB+E=180\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0];
      double ln1 = 1.5 * paramValues[1] / 100;
      double ln2 = 1.5-ln1;
      double c = 180-f;

      double dx = 2*ln1 - ln2 * Math.cos(c*DEG2RAD);
      double dy = ln2 * Math.sin(c*DEG2RAD);
      double diag = Math.sqrt(dx*dx+dy*dy);
      double ang = Math.atan2(dy,dx)/DEG2RAD;

      double h = ln1 * Math.sin(f*DEG2RAD);
      double b = Math.asin(h/diag)/DEG2RAD + ang;
      double e = 180-b-f;

      double x4 =      ln1 * Math.cos( (b) * DEG2RAD);
      double y4 =      ln1 * Math.sin( (b) * DEG2RAD);
      double x3 = x4 + ln2 * Math.cos( (b-180+c) * DEG2RAD);
      double y3 = y4 + ln2 * Math.sin( (b-180+c) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = x2 + ln1 * Math.cos( (b-180+e) * DEG2RAD);
      double y1 = y2 + ln1 * Math.sin( (b-180+e) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[4].getX(2);
      offsets[3] = tiles[3].getY(0)-tiles[4].getY(2);
   }
}
