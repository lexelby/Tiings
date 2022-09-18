package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_82
   extends TilingType
{
   public TilingTypeNC5_82(){
      super( "NC5-82", 5, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,1, 0},
            {1, 0,4, 1,0,1, 0},
            {1, 0,4, 2,0,1, 0},

            {0, 4,3, 0,3,4, 0},
            {0, 4,3, 1,3,4, 0},
            {0, 4,3, 2,3,4, 0},
            {0, 4,3, 3,3,4, 0},
      };
      info = "a=b=2c=2d\nA=90\nB=90\nC=90\n(D=225)\n(E=45)";
   }
   
   public void recalcBase(double[] paramValues) {
      double w = 0.3;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,w+w,  0);
      baseTile.setPoint(2,w+w,  w);
      baseTile.setPoint(3,  w,  w);
      baseTile.setPoint(4,  0,w+w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(4)-tiles[4].getX(0);
      offsets[1] = tiles[6].getY(4)-tiles[4].getY(0);
      offsets[2] = tiles[7].getX(4)-tiles[5].getX(0);
      offsets[3] = tiles[7].getY(4)-tiles[5].getY(0);
   }
}
