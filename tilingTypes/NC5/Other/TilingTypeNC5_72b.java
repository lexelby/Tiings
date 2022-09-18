package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_72b
   extends TilingType
{
   public TilingTypeNC5_72b(){
      super( "NC5-72b", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,3,4, 0},
            {1, 2,3, 1,1,2, 1},
            {0, 3,4, 2,0,4, 1},
            
            {0, 1,0, 0,0,1, 0},
            {1, 0,4, 4,3,4, 0},
            {1, 2,3, 5,1,2, 1},
            {0, 3,4, 6,0,4, 1},
      };
      info = "a=e\nb+d=2a\nc=d\nA=90\nD=90\nE=90\n(B=45)\n(C=225)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .6;
      double f = ln1 / (1 + 1 / Math.sqrt(2));

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1*2-f, 0);
      baseTile.setPoint(2,ln1,  ln1-f);
      baseTile.setPoint(3,ln1,  ln1);
      baseTile.setPoint(4,  0,  ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(0);
   }
}
