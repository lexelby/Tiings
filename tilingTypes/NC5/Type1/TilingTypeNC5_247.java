package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_247
   extends TilingType
{
   public TilingTypeNC5_247(){
      super( "NC5-247", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 4,0, 0,0,1, 1},
            {1, 1,0, 1,0,1, 1},
            {1, 4,1, 2,1,4, 1},
            {0, 0,1, 3,1,0, 1},
            {2, 0,1, 4,4,0, 0},

            {2, 0,4, 1,2,3, 1},
            {0, 4,0, 6,0,1, 0},
            {1, 1,0, 7,0,1, 0},
            {1, 4,1, 8,1,4, 0},
            {0, 0,1, 9,1,0, 0},
            {2, 0,1,10,4,0, 1},
      };
      info = "a=d\nb=2a\nc=e\nB+D=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double a = getParam(paramValues, 0);
      double diag = calcSide(3,1,a);
      double b = calcAngle(3,diag,1);

      double dx = ln * Math.cos(2*b*DEG2RAD);
      double dy = ln * Math.sin(2*b*DEG2RAD);

      double x4 = ln * Math.cos(a*DEG2RAD);
      double y4 = ln * Math.sin(a*DEG2RAD);
      double x1 = 2 * ln;
      double y1 = 0;
      double x2 = (x1+x4+dx)/2;
      double y2 = (y1+y4-dy)/2;
      double x3 = (x1+x4-dx)/2;
      double y3 = (y1+y4+dy)/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[4].getX(2)-tiles[11].getX(0);
      offsets[3] = tiles[4].getY(2)-tiles[11].getY(0);
   }
}
