package tilingTypes.P3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP3_12
	extends TilingType
{
	public TilingTypeP3_12(){
		super( "P3-12: Triangle strips mirrored", 3, SymmetryType.pmg );
		// params are angle/distance of the other two points relative to first one 
		paramMin = new int[]{-100,  0};
		paramMax = new int[]{ 100,100};
		paramDef = new int[]{  10, 50};
		paramName = new String[]{ "Skew", "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 0,1, 1,0,1, 1},
            {0, 1,2, 2,2,1, 1},
      };
      info = "(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*(1+paramValues[1])/102.;
      double ln2 = 2-ln1;
      double os = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,     ln1,  0);
      baseTile.setPoint(2,ln1/2+os,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(0);
   }
}
