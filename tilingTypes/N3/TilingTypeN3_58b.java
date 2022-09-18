package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_58b
   extends TilingType
{
   public TilingTypeN3_58b(){
      super( "N3-58b", 3, SymmetryType.pgg );
      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 2,1, 0,2,1, 1},
            {2, 2,0, 1,2,0, 0},
            {2, 1,2, 0,0,2, 0},
            {0, 2,0, 3,2,0, 1},
            {1, 2,1, 4,2,1, 0},

            {1, 0,1, 2,0,1, 1},
            {0, 2,1, 6,2,1, 0},
            {2, 2,0, 7,2,0, 1},
            {2, 1,2, 6,0,2, 1},
            {0, 2,0, 9,2,0, 0},
            {1, 2,1,10,2,1, 1},
      };
      info = "C=60\n(A+B=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double ln1 = ln * getParam(paramValues, 0)/100;
      double ln2 = ln - ln1;
      double w = ln2 /2 ;
      double h = w * Math.sqrt(3);

      baseTile.setPoint(2,  0,  0);
      baseTile.setPoint(0,  ln1,  0);
      baseTile.setPoint(1,  w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[11].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[11].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[5].getX(1);
      offsets[3] = tiles[1].getY(0)-tiles[5].getY(1);
   }
}
