package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_07a
   extends TilingType
{
   public TilingTypeNC6_07a(){
      super( "NC6-7a", 6, SymmetryType.cmm );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {0, 0,5, 1,0,5, 0},
            {1, 2,3, 2,1,2, 1},

            {0, 0,1, 0,0,1, 1},
            {1, 2,3, 4,1,2, 0},
            {0, 0,5, 5,0,5, 1},
            {1, 2,3, 6,1,2, 0},
      };
      info = "c=d=e=f\nA=45\nB=90\nC=90\nD=270\nE=90\n(F=135)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;
      
      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,4*ln,    0);
      baseTile.setPoint(2,4*ln,   ln);
      baseTile.setPoint(3,3*ln,   ln);
      baseTile.setPoint(4,3*ln, 2*ln);
      baseTile.setPoint(5,2*ln, 2*ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[5].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[5].getY(0);
   }
}