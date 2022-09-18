package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_36
	extends TilingType
{
	public TilingTypeN3_36(){
		super( "N3-36", 5, SymmetryType.p2 );
		// params are angle/distance of the other two points relative to first one
		paramMin = new int[]{-100,  0,  0,  0};
		paramMax = new int[]{ 100,100,100,100};
		paramDef = new int[]{  10, 50, 20, 40};
		paramName = new String[]{ "Skew", "Aspect", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {2, 4,3, 1,3,4, 0},
            {3, 2,3, 2,0,2, 1},

            {0, 4,3, 0,3,4, 0},
            {1, 1,0, 4,0,1, 0},
            {2, 4,3, 5,3,4, 0},
            {3, 2,3, 6,0,2, 1},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*getParam(paramValues,1)/100.;
      double ln2 = 2-ln1;
      double os = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);
      double os1 = getParam(paramValues,2)/100.;
      double os2 = getParam(paramValues,3)/100.;

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1, os1*ln1,  0);
      baseTile.setPoint(2, os2*ln1,  0);
      baseTile.setPoint(3,     ln1,  0);
      baseTile.setPoint(4,ln1/2+os,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[7].getX(4);
      offsets[1] = tiles[3].getY(3)-tiles[7].getY(4);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
