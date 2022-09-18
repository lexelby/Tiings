package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_03c
	extends TilingType
{
	public TilingTypeN4_03c(){
		super( "N4-3c", 4, SymmetryType.pg );

		paramMin = new int[]{};
		paramMax = new int[]{};
		paramDef = new int[]{};
		paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,3, 0,0,3, 1},
            {0, 1,2, 0,3,2, 0},
            {1, 2,3, 1,2,1, 1},
            };
      info = "c=d\nA=45\nB=90\nC=90\n(D=135)";
   }

   public void recalcBase(double[] paramValues) {
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  1,  0);
      baseTile.setPoint(2,  1, .5);
      baseTile.setPoint(3, .5, .5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0) + offsets[0]/2;
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0) + offsets[1]/2;
   }
}