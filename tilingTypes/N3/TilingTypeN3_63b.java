package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_63b
   extends TilingType
{
   public TilingTypeN3_63b(){
      super( "N3-63b", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,2,1, 0},
            {0, 0,1, 1,0,1, 1},
            {1, 1,2, 2,2,1, 1},
            {2, 0,2, 1,0,2, 1},
            {2, 1,2, 4,2,1, 1},

            {0, 0,2, 5,0,1, 1},
            {1, 1,2, 6,2,1, 1},
            {0, 0,1, 7,0,1, 0},
            {1, 1,2, 8,2,1, 0},
            {2, 0,2, 7,0,2, 0},
            {2, 1,2,10,2,1, 0},
      };
      info = "A=120\n(B+C=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double ln2 = ln * getParam(paramValues, 0)/100;
      double ln1 = ln - ln2;
      
      double w = ln2*0.5;
      double h = w * Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[11].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[11].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0);
   }
}
