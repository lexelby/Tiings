package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_18b
   extends TilingType
{
   public TilingTypeNC5_18b(){
      super( "NC5-18b", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,3, 0,2,3, 1},
            {1, 3,4, 1,3,4, 0},

            {1, 4,0, 1,4,0, 0},
            {0, 3,4, 3,3,4, 1},
            {2, 2,3, 4,2,3, 0},
      };
      info = "a=b=c\nd=e\nA=60\nB=240\nC=30\nD=120\n(E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .3;
      double h = w*Math.sqrt(3);
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  h);
      baseTile.setPoint(2,3*w,  h);
      baseTile.setPoint(3,  w,  h*5/3);
      baseTile.setPoint(4, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
   }
}
