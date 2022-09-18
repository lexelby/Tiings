package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_38
	extends TilingType
{
	public TilingTypeN3_38(){
		super( "N3-38", 4, SymmetryType.cm );
		// params are angle/distance of the other two points relative to first one
		paramMin = new int[]{-100,  0,  0};
		paramMax = new int[]{ 100,100,100};
		paramDef = new int[]{  10, 50, 30};
		paramName = new String[]{ "Skew", "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {2, 1,0, 1,0,1, 0},
            {3, 3,2, 2,2,3, 0},

            {0, 0,1, 0,0,1, 1},
            {1, 3,2, 4,2,3, 1},
            {2, 1,0, 5,0,1, 1},
            {3, 3,2, 6,2,3, 1},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*getParam(paramValues,1)/100.;
      double ln2 = 2-ln1;
      double os = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);
      double os1 = ln1*getParam(paramValues,2)/100.;

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,     os1,  0);
      baseTile.setPoint(2,     ln1,  0);
      baseTile.setPoint(3,ln1/2+os,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(0) + offsets[0]/2;
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(0) + offsets[1]/2;
   }
}
