package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_219c
   extends TilingType
{
   public TilingTypeNC5_219c(){
      super( "NC5-219c", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {2, 0,1, 1,0,1, 1},
            {0, 0,1, 0,3,4, 1},
            {1, 4,0, 3,0,4, 1},
            {2, 0,1, 4,0,1, 0},

            {2, 1,4, 5,4,1, 0},
            {1, 0,1, 6,0,1, 1},
            {0, 0,4, 7,4,0, 1},
            {0, 3,4, 8,0,1, 0},
            {1, 4,0, 9,0,4, 0},
            {2, 0,1,10,0,1, 1},
      
      };
      info = "c=d=e\na=2c\nb=3c\nA=60\nB=60\nC=120\nD=240\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .2;
      double h = ln * Math.sqrt(3);

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, 6*ln,  0);
      baseTile.setPoint(2, 5*ln,  h);
      baseTile.setPoint(3, 3*ln,  h);
      baseTile.setPoint(4, 2*ln,2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(4)-tiles[11].getX(1);
      offsets[3] = tiles[2].getY(4)-tiles[11].getY(1);
   }
}
