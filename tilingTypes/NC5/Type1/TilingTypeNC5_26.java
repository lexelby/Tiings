package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_26
   extends TilingType
{
   public TilingTypeNC5_26(){
      super( "NC5-26", 5, SymmetryType.pgg );

      paramMin = new int[]{   0,  0,  0};
      paramMax = new int[]{ 180,100,100};
      paramDef = new int[]{ 100, 50, 50};
      paramName = new String[]{ "Angle", "Relative Length", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {1, 0,4, 1,2,3, 0},
            {0, 2,1, 2,1,2, 0},

            {0, 2,3, 3,4,0, 1},
            {1, 2,1, 4,1,2, 1},
            {1, 0,4, 5,2,3, 1},
            {0, 2,1, 6,1,2, 1},
      };
      info = "a=d\nD+E=360\nA+D=180\n(B+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln3 = 1.5 * paramValues[1] / 100;
      double sum = 1.5-ln3;
      double ln1 = sum * paramValues[2] / 100;
      double ln2 = sum-ln1;
      double d = paramValues[0];
      double c = 360-d;
      double b = 180-d;

      // adjust ln3 so that non-intersecting
      double xc = ln1 * Math.cos( b * DEG2RAD);
      double yc = ln1 * Math.sin( b * DEG2RAD);
      double xe = 2*xc + ln2 * Math.cos( (b-180+c) * DEG2RAD);
      double ye = 2*yc + ln2 * Math.sin( (b-180+c) * DEG2RAD);
      // xe..xc..dx
      // ye..yc..0
      // ye/(ye-yc) = (xe-dx)/(xe-xc)
      ln3 += xe - ye/(ye-yc)*(xe-xc);

      double x1 = ln3;
      double y1 = 0;
      double x4 =      ln1 * Math.cos( (b) * DEG2RAD);
      double y4 =      ln1 * Math.sin( (b) * DEG2RAD);
      double x3 = x4 + ln2 * Math.cos( (b-180+c) * DEG2RAD);
      double y3 = y4 + ln2 * Math.sin( (b-180+c) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[3].getX(3);
      offsets[1] = tiles[4].getY(0)-tiles[3].getY(3);
      offsets[2] = tiles[7].getX(4)-tiles[0].getX(2);
      offsets[3] = tiles[7].getY(4)-tiles[0].getY(2);
   }
}
