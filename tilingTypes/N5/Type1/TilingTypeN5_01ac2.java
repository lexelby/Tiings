package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ac2
   extends TilingType
{
   public TilingTypeN5_01ac2(){
      super( "N5-1ac2: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,1, 0},
            {0, 2,1, 1,1,0, 1},
            {1, 0,4, 2,0,1, 1},

            {0, 3,2, 0,2,3, 0},
            {1, 0,4, 4,0,1, 0},
            {0, 2,1, 5,1,0, 1},
            {1, 0,4, 6,0,1, 1},
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
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(1);
      offsets[2] = tiles[6].getX(3)-tiles[1].getX(1);
      offsets[3] = tiles[6].getY(3)-tiles[1].getY(1);
   }
}
