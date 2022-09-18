package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_233b
   extends TilingType
{
   public TilingTypeNC5_233b(){
      super( "NC5-233b", 5, SymmetryType.pgg);

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {1, 4,0, 0,1,2, 1},
            {0, 1,0, 1,0,1, 1},
            {0, 2,1, 2,1,2, 1},
            {1, 0,1, 3,1,0, 1},
            {2, 1,2, 4,4,0, 0},
            
            {2, 0,4, 0,1,0, 1},
            {1, 4,0, 6,1,2, 0},
            {0, 1,0, 7,0,1, 0},
            {0, 2,1, 8,1,2, 0},
            {1, 0,1, 9,1,0, 0},
            {2, 1,2,10,4,0, 1},
      };
      info = "b=c=2a\na=d=e\nB=C\nB=E\nD+E=360\n(A+B+C=180)";
   }
   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double b = Math.acos(.75) / DEG2RAD;
      double a = 180 - 2*b;
      
      double x4 = ln * Math.cos(a * DEG2RAD);
      double y4 = ln * Math.sin(a * DEG2RAD);
      double x3 = x4 + ln * Math.cos((a+b-180)* DEG2RAD);
      double y3 = y4 + ln * Math.sin((a+b-180)* DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln*2,  0);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,  x3,  y3);
      baseTile.setPoint(4,  x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[1].getX(2);
      offsets[1] = tiles[4].getY(3)-tiles[1].getY(2);
      offsets[2] = tiles[5].getX(1)-tiles[11].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[11].getY(0);
   }
}
