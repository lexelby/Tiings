package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_78e
   extends TilingType
{
   public TilingTypeNC5_78e(){
      super( "NC5-78e: Split rectangle", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 60, 60};
      paramName = new String[]{ "Aspect", "X", "Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,1, 0,1,4, 0},
            {1, 0,1, 0,0,4, 0},
            {1, 4,1, 2,1,4, 0},
      };
      info = "c=e\nA=90\nC+D=360\n(B+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.6;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;

      double x = lnb * getParam(paramValues,1)/100;
      double y = lna * getParam(paramValues,2)/100;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  x, y);
      baseTile.setPoint(3,  lnb-x, lna-y);
      baseTile.setPoint(4,  0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(4)-tiles[2].getY(4);
      offsets[2] = tiles[0].getX(1)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(1)-tiles[3].getY(4);
   }
}
