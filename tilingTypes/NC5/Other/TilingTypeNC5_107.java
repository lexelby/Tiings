package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_107
   extends TilingType
{
   public TilingTypeNC5_107(){
      super( "NC5-107", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,4, 0,3,4, 0},
            {0, 3,4, 1,4,3, 0},
            {1, 3,4, 2,0,4, 0},
            
            {1, 0,1, 2,1,2, 1},
            {0, 0,4, 4,3,4, 1},
            {0, 3,4, 5,4,3, 1},
            {1, 3,4, 6,0,4, 1},
      };
      info = "a=e\nb=c\na+b=2d\nA=120\nB=60\nC=60\nD=240\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double h = ln * Math.sqrt(3)/2;
      
      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, 3*ln,  0);
      baseTile.setPoint(2, 3*ln/2, h*3);
      baseTile.setPoint(3, ln/2,  h);
      baseTile.setPoint(4,-ln/2,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[3].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(0)-tiles[5].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[5].getY(1);
   }
}
