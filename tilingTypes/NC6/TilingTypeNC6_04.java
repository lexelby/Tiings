package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_04
   extends TilingType
{
   public TilingTypeNC6_04(){
      super( "NC6-4", 6, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,0, 0,0,1, 1},
            {0, 1,2, 1,3,4, 0},
            {1, 5,0, 2,0,1, 1},

            {0, 2,3, 0,4,5, 1},
            {1, 5,0, 4,0,1, 0},
            {0, 1,2, 5,3,4, 1},
            {1, 5,0, 6,0,1, 0},
      };
      info = "a=b=c=d=e=f\nB+C=360\nA+D=C\nE=F\n(B=2F)"; 
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double ca = w * 2/3;
      double sa = w * Math.sqrt(5./9);
      double cb = w * 19/21;
      double sb = w * Math.sqrt(80./21/21);

      baseTile.setPoint(0,        0,   0);
      baseTile.setPoint(1,       cb,  sb);
      baseTile.setPoint(2,2*ca+w-cb, -sb);
      baseTile.setPoint(3,2*ca+w   ,   0);
      baseTile.setPoint(4,  ca+w   ,  sa);
      baseTile.setPoint(5,  ca     ,  sa);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(5)-tiles[6].getX(0);
      offsets[1] = tiles[4].getY(5)-tiles[6].getY(0);
      offsets[2] = tiles[6].getX(3)-tiles[2].getX(5);
      offsets[3] = tiles[6].getY(3)-tiles[2].getY(5);
   }
}