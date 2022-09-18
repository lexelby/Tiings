package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01r6
   extends TilingType
{
   public TilingTypeN5_01r6(){
      super( "N5-1r6: type 1&5", 5, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {2, 2,3, 0,2,3, 1},
            {1, 0,4, 0,0,1, 0},
            {0, 1,2, 3,2,1, 0},
            {2, 2,3, 3,2,3, 1},
            {1, 0,4, 3,0,1, 0},
            {0, 1,2, 6,2,1, 0},
            {2, 2,3, 6,2,3, 1},
            {1, 0,4, 6,0,1, 0},
            {0, 1,2, 9,2,1, 0},
            {2, 2,3, 9,2,3, 1},
            {1, 0,4, 9,0,1, 0},
            {0, 1,2,12,2,1, 0},
            {2, 2,3,12,2,3, 1},
            {1, 0,4,12,0,1, 0},
            {0, 1,2,15,2,1, 0},
            {2, 2,3,15,2,3, 1},
      };
      info = "a=b=c\nd=e\nA=60\nB=120\nC=90\nD=120\n(E=150)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double h = ln*Math.sqrt(3)/2;

      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,    ln,  0);
      baseTile.setPoint(2,ln*3/2,  h);
      baseTile.setPoint(3,    ln,  h*4/3);
      baseTile.setPoint(4,  ln/2,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[8].getX(1);
      offsets[1] = tiles[2].getY(1)-tiles[8].getY(1);
      offsets[2] = tiles[8].getX(1)-tiles[14].getX(1);
      offsets[3] = tiles[8].getY(1)-tiles[14].getY(1);
   }
}
