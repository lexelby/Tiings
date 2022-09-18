package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_157
   extends TilingType
{
   public TilingTypeNC5_157(){
      super( "NC5-157", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,0, 1,0,2, 1},
            {0, 0,1, 2,0,1, 0},
            
            {0, 1,2, 0,3,4, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 2,0, 5,0,2, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=d\nc=e\nA=B\nC+E=180\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnbe = 0.7;
      double lnad = lnbe * getParam(paramValues,0)/100;

      double d = Math.asin( Math.sqrt(1 - lnad/2/lnbe) )/DEG2RAD;
      
      double c = Math.cos(d*DEG2RAD);
      double s = Math.sin(d*DEG2RAD);

      double x4 = lnad * c;
      double y4 = lnad * s;
      double x3 = x4 + lnbe * Math.cos( (3*d-180) * DEG2RAD);
      double y3 = y4 + lnbe * Math.sin( (3*d-180) * DEG2RAD);
      double x2 = x3 + lnad * c;
      double y2 = y3 + lnad * s;
      double x1 = x2 + lnbe * c;
      double y1 = y2 - lnbe * s;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[4].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[4].getY(3);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(3);
   }
}
