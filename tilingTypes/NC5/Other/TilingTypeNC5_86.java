package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_86
   extends TilingType
{
   public TilingTypeNC5_86(){
      super( "NC5-86", 5, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,1, 0},
            {1, 0,1, 1,2,1, 0},

            {0, 1,0, 0,3,4, 0},
            {0, 1,0, 1,3,4, 0},
            {0, 1,0, 2,3,4, 0},

            {1, 3,2, 3,2,3, 0},
            {1, 0,1, 6,2,1, 0},
            {1, 0,1, 7,2,1, 0},

            {0, 1,0, 6,3,4, 0},
            {0, 1,0, 7,3,4, 0},
            {0, 1,0, 8,3,4, 0},
      };
      info = "2a=b=c=e\nA=120\nB=120\nC=30\nD=210\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 0.15;
      double h = w*Math.sqrt(3);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,4*w,  0);
      baseTile.setPoint(2,6*w,2*h);
      baseTile.setPoint(3,3*w,  h);
      baseTile.setPoint(4, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[10].getX(1);
      offsets[1] = tiles[4].getY(2)-tiles[10].getY(1);
      offsets[2] = tiles[5].getX(2)-tiles[11].getX(1);
      offsets[3] = tiles[5].getY(2)-tiles[11].getY(1);
   }
}
