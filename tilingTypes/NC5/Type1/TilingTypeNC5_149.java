package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_149
   extends TilingType
{
   public TilingTypeNC5_149(){
      super( "NC5-149", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 2,0, 0,0,2, 0},
            {0, 3,2, 1,0,1, 0},
            {0, 4,0, 2,0,4, 0},
      };
      info = "a=b=d\nA=B\nA+E=180\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 0.7;
      double lne = lna * getParam(paramValues,0)/100;

      double dx = (lna-lne)/4;
      double dy = Math.sqrt(lna*lna-dx*dx);
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lna, 0);
      baseTile.setPoint(2,  lna-dx-dx, dy+dy);
      baseTile.setPoint(3,  lna-3*dx, dy);
      baseTile.setPoint(4,  dx, dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(1)-tiles[3].getX(2);
      offsets[3] = tiles[2].getY(1)-tiles[3].getY(2);
   }
}
