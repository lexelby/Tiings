package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_32b
   extends TilingType
{
   public TilingTypeNC5_32b(){
      super( "NC5-32b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 4,3, 1,0,4, 1},
            {1, 2,1, 2,1,2, 1},
      };
      info = "a=d=e\nD+E=360\nA+E=180\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2. * paramValues[1] / 100;
      double ln2 = (2.-ln1)/2;
      ln1 += ln2;
      double f = paramValues[0];
      double c = ln2 * Math.cos( f * DEG2RAD);
      double s = ln2 * Math.sin( f * DEG2RAD);

      double x1 = ln1;
      double y1 = 0;
      double x4 = c;
      double y4 = s;
      double x3 = c + ln2;
      double y3 = s;
      double x2 = ln2+2*c;
      double y2 = 2*s;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(3);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(1);
   }
}
