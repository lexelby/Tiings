package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_275
   extends TilingType
{
   public TilingTypeNC5_275(){
      super( "NC5-275", 5, SymmetryType.p6 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 70, 60};
      paramName = new String[]{ "X", "Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {2, 0,1, 0,0,4, 0},
            {2, 0,1, 1,0,4, 0},
            {2, 0,1, 2,0,4, 0},
            {2, 0,1, 3,0,4, 0},
            {2, 0,1, 4,0,4, 0},

            {0, 1,4, 0,4,1, 0},
            {0, 1,4, 1,4,1, 0},
            {0, 1,4, 2,4,1, 0},
            {0, 1,4, 3,4,1, 0},
            {0, 1,4, 4,4,1, 0},
            {0, 1,4, 5,4,1, 0},

            {1, 1,0, 6,0,1, 0},
            {1, 1,0, 7,0,1, 0},
            {1, 1,0, 8,0,1, 0},
            {1, 1,0, 9,0,1, 0},
            {1, 1,0,10,0,1, 0},
            {1, 1,0,11,0,1, 0},
      };
      info = "b=3a\nc=e\nA=60\nC+D=360\n(B+E=120)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 0.4;
      double lnb = 3*lna;
      double c = .5;
      double s = Math.sqrt(3)/2;
      double x = lnb * getParam(paramValues,0)/100;
      double y = lna * getParam(paramValues,1)/100;
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, x+y*c, y*s);
      baseTile.setPoint(3, lnb-x+(lna-y)*c, (lna-y)*s);
      baseTile.setPoint(4, lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[12].getX(1)-tiles[15].getX(4);
      offsets[1] = tiles[12].getY(1)-tiles[15].getY(4);
      offsets[2] = tiles[13].getX(1)-tiles[16].getX(4);
      offsets[3] = tiles[13].getY(1)-tiles[16].getY(4);
   }

}
