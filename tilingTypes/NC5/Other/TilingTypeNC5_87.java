package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_87
   extends TilingType
{
   public TilingTypeNC5_87(){
      super( "NC5-87", 5, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 1,0, 1,2,3, 0},
            {0, 2,1, 2,1,2, 0},
            {1, 1,0, 3,2,3, 0},
            {0, 2,1, 4,1,2, 0},

            {1, 3,2, 0,2,3, 0},
            {0, 2,1, 6,1,2, 0},
            {1, 1,0, 7,2,3, 0},
            {0, 2,1, 8,1,2, 0},
            {1, 1,0, 9,2,3, 0},
            {0, 2,1,10,1,2, 0},
      };
      info = "2a=b=c=e\nA=60\nB=60\nC=30\nD=210\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 0.15;
      double h = w*Math.sqrt(3);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,4*w,  0);
      baseTile.setPoint(2,5*w,3*h);
      baseTile.setPoint(3,3*w,  h);
      baseTile.setPoint(4, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[1].getX(4);
      offsets[1] = tiles[3].getY(4)-tiles[1].getY(4);
      offsets[2] = tiles[5].getX(4)-tiles[1].getX(4);
      offsets[3] = tiles[5].getY(4)-tiles[1].getY(4);
   }
}
