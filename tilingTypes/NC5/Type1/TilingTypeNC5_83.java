package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_83
   extends TilingType
{
   public TilingTypeNC5_83(){
      super( "NC5-83", 5, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,4,0, 0},
            {0, 0,1, 1,4,3, 0},
            {1, 0,4, 2,4,0, 0},
            {0, 0,1, 3,4,3, 0},
            {1, 0,4, 4,4,0, 0},
            {0, 0,1, 5,4,3, 0},
            {1, 0,4, 6,4,0, 0},
      };
      info = "b=e=2c=2d\nB=90\nC=90\nD=270\n(A+E=90)";
   }
   
   public void recalcBase(double[] paramValues) {
      double w = 0.3;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,w+w,  0);
      baseTile.setPoint(2,w+w,  w);
      baseTile.setPoint(3,  w,  w);
      baseTile.setPoint(4,  w,3*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(4);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(4);
      offsets[2] = tiles[6].getX(3)-tiles[2].getX(4);
      offsets[3] = tiles[6].getY(3)-tiles[2].getY(4);
   }
}
