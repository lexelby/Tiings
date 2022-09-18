package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_91
   extends TilingType
{
   public TilingTypeNC5_91(){
      super( "NC5-91", 5, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 4,3, 0,4,0, 0},
            {1, 4,3, 1,4,0, 0},
            {1, 4,3, 2,4,0, 0},

            {0, 0,1, 0,0,1, 1},
            {0, 0,1, 1,0,1, 1},
            {0, 0,1, 2,0,1, 1},
            {0, 0,1, 3,0,1, 1},
      };
      info = "2a=d=e\nA=90\nB=90\nC=45\nD=45\n(E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .25;
     
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, 5*w,  0);
      baseTile.setPoint(2, 2*w,3*w);
      baseTile.setPoint(3, 2*w,  w);
      baseTile.setPoint(4,   0,  w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[6].getX(2);
      offsets[1] = tiles[4].getY(3)-tiles[6].getY(2);
      offsets[2] = tiles[5].getX(3)-tiles[7].getX(2);
      offsets[3] = tiles[5].getY(3)-tiles[7].getY(2);
   }
}
