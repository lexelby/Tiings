package tilingTypes.P3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP3_09
	extends TilingType
{
	public TilingTypeP3_09(){
		super( "P3-9&10: Rectangle diagonals",3, SymmetryType.cmm );
		// params are angle/distance of the other two points relative to first one 
		paramMin = new int[]{  0};
		paramMax = new int[]{100};
		paramDef = new int[]{ 30};
		paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 0,1, 1,0,1, 1},
            {0, 1,2, 2,2,1, 1},
            };
      info = "A=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*(paramValues[0]+1)/102.;
      double ln1 = 2-ln2;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2,   0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0);
   }
}
