package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_27a
   extends TilingType
{
   public TilingTypeNC5_27a(){
      super( "NC5-27a", 5, SymmetryType.pgg );

      paramMin = new int[]{   0,  0};
      paramMax = new int[]{ 180,100};
      paramDef = new int[]{  90, 50};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 4,3, 0,0,4, 1},
            {0, 0,1, 1,2,3, 0},
            {1, 4,3, 2,0,4, 1},

            {1, 1,0, 3,2,3, 1},
            {0, 4,3, 4,0,4, 0},
            {0, 0,1, 5,2,3, 1},
            {1, 4,3, 6,0,4, 0},
      };
      info = "b=d\na=c+e\nB+C=360\nA=D\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double ln2 = 1.5 * paramValues[1] / 100;
      double ln3 = 1.5-ln2;
      double ln4 = ln2 * Math.sin(a/2*DEG2RAD);
      double an = 90-a/2;

      double x1 = ln4;
      double y1 = 0;
      double x2 = ln4+ ln3 * Math.cos( an * DEG2RAD);
      double y2 =      ln3 * Math.sin( an * DEG2RAD);
      double x3 = x2 + ln4;
      double y3 = y2;
      double x4 = x3 - ln2 * Math.cos( an * DEG2RAD);
      double y4 = y3 + ln2 * Math.sin( an * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[1].getX(0);
      offsets[1] = tiles[0].getY(4)-tiles[1].getY(0);
      offsets[2] = tiles[7].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[7].getY(3)-tiles[0].getY(0);
   }
}
