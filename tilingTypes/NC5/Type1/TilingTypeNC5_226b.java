package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_226b
   extends TilingType
{
   private double h;
   public TilingTypeNC5_226b(){
      super( "NC5-226b", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {0, 0,4, 1,4,0, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 0,4, 3,4,0, 0},
            {2, 0,1, 3,2,1, 0},

            {2, 2,3, 4,1,2, 1},
            {1, 2,1, 6,0,1, 1},
            {0, 0,4, 7,4,0, 1},
            {1, 4,3, 7,3,4, 1},
            {0, 0,4, 9,4,0, 1},
            {2, 0,1, 9,2,1, 1},
      };
      info = "a=b=2c\nc=d=e\nA=B\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   public void initialiseImpl(){
      h = Math.sqrt(15);
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .1;
      double ln2 = ln1 * h;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 8*ln1,  0);
      baseTile.setPoint(2, 7*ln1,  ln2);
      baseTile.setPoint(3, 3*ln1,  ln2);
      baseTile.setPoint(4, 2*ln1,  ln2*2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[3].getX(1);
      offsets[1] = tiles[1].getY(0)-tiles[3].getY(1);
      offsets[2] = tiles[5].getX(4)-tiles[11].getX(1);
      offsets[3] = tiles[5].getY(4)-tiles[11].getY(1);
   }
}
