package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_235
   extends TilingType
{
   public TilingTypeNC5_235(){
      super( "NC5-235", 5, SymmetryType.pgg);

      paramMin = new int[]{60};
      paramMax = new int[]{180};
      paramDef = new int[]{115};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,1,0, 0},
            {0, 0,2, 1,2,0, 0},
            {1, 0,1, 2,1,0, 0},
            {2, 0,1, 2,2,1, 0},
            {2, 0,2, 4,2,0, 0},
            
            {1, 0,4, 0,2,1, 1},
            {0, 0,1, 6,1,0, 1},
            {0, 0,2, 7,2,0, 1},
            {1, 0,1, 8,1,0, 1},
            {2, 0,1, 8,2,1, 1},
            {2, 0,2,10,2,0, 1},
      };
      info = "a=c=d=e\nb=2a\nB=E\nD+E=360\n(A+B+C=180)";
   }
   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double b = getParam(paramValues, 0);
      double diag = calcSide(ln, ln*2, b);
      double a = 2 * calcAngle(2*ln, diag, ln);
      
      double x4 = ln * Math.cos(a * DEG2RAD);
      double y4 = ln * Math.sin(a * DEG2RAD);
      double x3 = x4 + ln * Math.cos((a+b-180) * DEG2RAD);
      double y3 = y4 + ln * Math.sin((a+b-180) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, ln*2,  0);
      baseTile.setPoint(2,   x2, y2);
      baseTile.setPoint(3,   x3, y3);
      baseTile.setPoint(4,   x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[1].getX(2);
      offsets[1] = tiles[4].getY(2)-tiles[1].getY(2);
      offsets[2] = tiles[3].getX(2)-tiles[9].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[9].getY(0);
   }
}
