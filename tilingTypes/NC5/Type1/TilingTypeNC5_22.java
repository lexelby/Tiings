package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_22
   extends TilingType
{
   public TilingTypeNC5_22(){
      super( "NC5-22", 5, SymmetryType.pgg );

      paramMin = new int[]{   0,  0};
      paramMax = new int[]{ 180,100};
      paramDef = new int[]{  90, 50};
      paramName = new String[]{ "Angle", "Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,2,3, 1},
            {1, 4,0, 1,3,2, 1},
            {0, 2,3, 2,1,2, 0},

            {1, 1,0, 3,0,1, 0},
            {1, 4,0, 4,3,2, 0},
            {0, 2,3, 4,1,2, 1},
            {0, 2,3, 5,1,2, 1},
      };
      info = "a=d+e\nc=d\nC+D=180\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .6;
      double ln2 = ln1*paramValues[1] / 100.;
      double ln3 = ln1+ln2;
      double d = paramValues[0];
      double c = Math.cos( d * DEG2RAD);
      double s = Math.sin( d * DEG2RAD);

      double x3 = ln3 + ln2 * c;
      double y3 =       ln2 * s;
      double x2 = x3 + ln1;
      double y2 = y3;
      double x1 = x2 - ln1 * c;
      double y1 = y2 - ln1 * s;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,ln3,  0);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[6].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[6].getY(1)-tiles[0].getY(4);
   }
}
