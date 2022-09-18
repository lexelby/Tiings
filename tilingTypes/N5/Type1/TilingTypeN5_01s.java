package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01s
   extends TilingType
{
   public TilingTypeN5_01s(){
      super( "N5-1s: type 1&5", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 0,4, 0,0,4, 1},
            {0, 0,4, 1,0,4, 0},
            {2, 1,0, 0,1,2, 0},
            {2, 4,0, 4,0,4, 0},
      };
      info = "b=c\nd=e\nA=90\nB=120\nC=120\nD=60\n(E=150)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double h = ln*Math.sqrt(3)/6;

      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,ln*2/3,  0);
      baseTile.setPoint(2,    ln,2*h);
      baseTile.setPoint(3,  ln/2,5*h);
      baseTile.setPoint(4,     0,2*h);
   } 
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[1].getY(2);
      offsets[2] = tiles[4].getX(4)-tiles[3].getX(2);
      offsets[3] = tiles[4].getY(4)-tiles[3].getY(2);
   }
}
