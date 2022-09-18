package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_03a
	extends TilingType
{
	public TilingTypeN4_03a(){
		super( "N4-3a", 5, SymmetryType.pgg);

		paramMin = new int[]{  0};
		paramMax = new int[]{100};
		paramDef = new int[]{ 20};
		paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,4, 0,0,4, 1},
            {0, 2,3, 0,4,3, 0},
            {1, 3,4, 1,3,2, 1},

            {1, 1,0, 0,0,1, 0},
            {0, 0,4, 4,0,4, 1},
            {0, 2,3, 4,4,3, 0},
            {1, 3,4, 5,3,2, 1},
      };
      info = "c=d\nA=45\nB=90\nC=90\n(D=135)";
      labels = new int[]{0,-1,1,2,3};
   }

   public void recalcBase(double[] paramValues) {
      double os = getParam(paramValues,0)/100.;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, os,  0);
      baseTile.setPoint(2,  1,  0);
      baseTile.setPoint(3,  1, .5);
      baseTile.setPoint(4, .5, .5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}