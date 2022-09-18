package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_268
   extends TilingType
{
   public TilingTypeNC5_268(){
      super( "NC5-268", 5, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {2, 1,2, 1,1,2, 1},
            {2, 2,0, 2,0,2, 1},
            {0, 1,2, 3,1,2, 0},
            {1, 0,1, 4,1,0, 0},

            {1, 2,3, 1,3,4, 1},
            {0, 1,0, 6,0,1, 1},
            {2, 1,2, 7,1,2, 0},
            {2, 2,0, 8,0,2, 0},
            {0, 1,2, 9,1,2, 1},
            {1, 0,1,10,1,0, 1},
      };
      info = "a=d=e\nB=C\nC=E\nD+E=360\n(A+B+C=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 0.7;
      double a = getParam(paramValues,0);
      double b = 90-a/2;

      double x4 = ln * Math.cos(a*DEG2RAD);
      double y4 = ln * Math.sin(a*DEG2RAD);
      double x3 = x4 + ln * Math.cos(b*DEG2RAD);
      double y3 = y4 - ln * Math.sin(b*DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln*2, 0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[7].getX(0);
      offsets[1] = tiles[0].getY(4)-tiles[7].getY(0);
      offsets[2] = tiles[5].getX(4)-tiles[10].getX(0);
      offsets[3] = tiles[5].getY(4)-tiles[10].getY(0);
   }

}
