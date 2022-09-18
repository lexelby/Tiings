package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_30b
   extends TilingType
{
   public TilingTypeNC5_30b(){
      super( "NC5-30b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 50};
      paramName = new String[]{ "Aspect", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,0, 0,0,2, 0},
            {1, 1,2, 0,1,2, 1},
            {1, 1,2, 1,1,2, 1},
      };
      info = "a=d\nD+E=360\nA=D\nB=C\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2. * paramValues[0] / 100;
      double h = 2-ln2;
      double ln1 = Math.sqrt(h*h+ln2*ln2/4)/2;
      double ln3 = ln1 * paramValues[1] / 100;
      double ln4 = ln1+ln1-ln3;

      double e = Math.atan2(h+h,ln2)/DEG2RAD;
      double b = 180-e-e;

      double x4 = ln1 * Math.cos( b * DEG2RAD);
      double y4 = ln1 * Math.sin( b * DEG2RAD);
      double x3 = x4-ln3;
      double y3 = y4;
      double x2 = x3+x4;
      double y2 = y3+y4;
      double x1 = ln4;
      double y1 = 0;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[2].getX(1);
      offsets[1] = tiles[2].getY(3)-tiles[2].getY(1);
      offsets[2] = tiles[2].getX(4)-tiles[3].getX(0);
      offsets[3] = tiles[2].getY(4)-tiles[3].getY(0);
   }
}
