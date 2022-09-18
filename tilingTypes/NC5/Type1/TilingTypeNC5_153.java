package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_153
   extends TilingType
{
   public TilingTypeNC5_153(){
      super( "NC5-153", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 2,0,1, 0},
            
            {0, 3,2, 1,1,2, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 3,2, 5,2,3, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=d\nc=a+e\nA=B\nC+E=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnd = 0.7;
      double lne = lnd * getParam(paramValues,0)/100;

      double d = Math.asin( Math.sqrt((3*lnd-2*lne)/4/lnd) )/DEG2RAD;
      
      double c = Math.cos(d*DEG2RAD);
      double s = Math.sin(d*DEG2RAD);

      double x4 = lnd * c;
      double y4 = lnd * s;
      double x3 = x4 + lne * c;
      double y3 = y4 - lne * s;
      double x2 = x3 + lnd * Math.cos( (180-3*d) * DEG2RAD);
      double y2 = y3 + lnd * Math.sin( (180-3*d) * DEG2RAD);
      double x1 = x2 + (lnd+lne) * c;
      double y1 = y2 - (lnd+lne) * s;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(1);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(1);
   }
}
