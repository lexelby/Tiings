package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ac5
   extends TilingType
{
   public TilingTypeN5_01ac5(){
      super( "N5-1ac5: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
         {0, 0,0, 0,0,0, 0},
         {1, 0,4, 0,3,2, 1},
         {2, 2,1, 0,3,4, 0},
         {3, 3,2, 2,0,4, 1},

         {0, 4,0, 2,1,0, 0},
         {1, 0,4, 4,3,2, 1},
         {2, 2,1, 4,3,4, 0},
         {3, 3,2, 6,0,4, 1},

         {0, 1,0, 1,1,2, 1},
         {1, 0,4, 8,3,2, 0},
         {2, 2,1, 8,3,4, 1},
         {3, 3,2,10,0,4, 0},

         {0, 4,0,10,1,0, 1},
         {1, 0,4,12,3,2, 0},
         {2, 2,1,12,3,4, 1},
         {3, 3,2,14,0,4, 0},
      };
      info = "a=b=d=c+e\nA=B\nB=C\nC+E=180\n(B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .6;
      double f = getParam(paramValues,0)/100;
      double ln2 = ln1 * (1-f);
      double h = Math.sqrt(ln1*ln1 - ln2*ln2/4);

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln1,   0);
      baseTile.setPoint(2, ln1+f*ln2/2, h*f);
      baseTile.setPoint(3, ln2/2, h);
      baseTile.setPoint(4, -ln2/2, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(0)-tiles[3].getX(1);
      offsets[1] = tiles[7].getY(0)-tiles[3].getY(1);
      offsets[2] = tiles[5].getX(3)-tiles[15].getX(1);
      offsets[3] = tiles[5].getY(3)-tiles[15].getY(1);
   }
}
