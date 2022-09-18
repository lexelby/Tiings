package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01r2
   extends TilingType
{
   public TilingTypeN5_01r2(){
      super( "N5-1r2: type 1&5", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,3, 1},
            {2, 0,4, 0,3,4, 0},
            
            {2, 1,2, 1,2,3, 0},
            {1, 1,2, 3,0,1, 1},
            {0, 4,3, 3,4,0, 0},
      };
      info = "b=c=d\na=e\nA=90\nB=120\nC=60\nD=150\n(E=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double h = ln*Math.sqrt(3)/2;

      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,    ln,  0);
      baseTile.setPoint(2,ln*3/2,  h);
      baseTile.setPoint(3,  ln/2,  h);
      baseTile.setPoint(4,     0,  h*2/3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(2)-tiles[0].getX(1);
      offsets[3] = tiles[5].getY(2)-tiles[0].getY(1);
   }
}
