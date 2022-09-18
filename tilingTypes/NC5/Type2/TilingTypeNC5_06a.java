package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_06a
   extends TilingType
{
   public TilingTypeNC5_06a(){
      super( "NC5-6a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 25, 30};
      paramName = new String[]{ "Aspect", "Point X", "Point Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,4, 0,0,2, 1},
            {0, 3,2, 0,2,3, 0},
            {1, 2,4, 2,0,2, 2},
      };
      info = "b=d\nc=e\nB+D=360\nC+D+2E=360\n2A+B+C=360\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 2. * paramValues[0]/100;   // base length
      double lnh = 2 - lnb; // height
      double lnx1 = lnh * paramValues[1]/100; // x of point
      double lny1 =(1-lnx1/lnh)*lnb* (50-paramValues[2])/100;

      double x1 = lnh - lnx1;
      double y1 = lny1;
      double x2 = lnh;
      double y2 = lnb/2;
      double x3 = lnx1;
      double y3 = lnb/2 + lny1;
      double x4 = 0;
      double y4 = lnb;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}
