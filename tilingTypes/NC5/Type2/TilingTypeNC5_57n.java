package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_57n
   extends TilingType
{
   public TilingTypeNC5_57n(){
      super( "NC5-57n", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{"Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,5, 0,4,5, 0},
            {2, 2,3, 1,3,2, 0},
            {0, 5,0, 2,4,5, 1},
            {1, 0,5, 3,4,5, 1},
            {2, 2,3, 4,3,2, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 0,5, 6,4,5, 0},
            {2, 2,3, 7,3,2, 0},
            {0, 5,0, 8,4,5, 1},
            {1, 0,5, 9,4,5, 1},
            {2, 2,3,10,3,2, 1},
      };
      info = "a=d=e\nb=c=2a\nA=120\nB=60\nC=60\nD=240\n(E=60)";
      labels = new int[]{0,-1,1,2,3,4 };
   }

   public void recalcBase(double[] paramValues) {
      double ln = .35;
      double h = ln * Math.sqrt(3)/2;
      double os = 3 * ln * getParam(paramValues, 0)/100;

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,   os,  0);
      baseTile.setPoint(2, 2*ln,  0);
      baseTile.setPoint(3,   ln,  h*2);
      baseTile.setPoint(4, ln/2,  h);
      baseTile.setPoint(5,-ln/2,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(5)-tiles[0].getX(0);
      offsets[1] = tiles[5].getY(5)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[9].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[9].getY(1);
   }
}
