package tilingTypes.P3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP3_04
	extends TilingType
{
	public TilingTypeP3_04(){
		super( "P3-4&7: Triangle strips offset alternating", 4, SymmetryType.pgg );
		// params are angle/distance of the other two points relative to first one 
		paramMin = new int[]{  0,  0};
		paramMax = new int[]{100,100};
		paramDef = new int[]{ 50, 25};
		paramName = new String[]{ "Aspect", "Offset" };
      
      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,3, 0,3,2, 1},
            {0, 0,1, 1,1,0, 1},
            {0, 3,2, 2,0,3, 0},
            };
      labels = new int[]{0,-1,1,2};
      info = "a=c\nA=B\n(A+B+C=180)";
	}

	public void recalcBase(double[] paramValues) {
      double ln1 = 2*(1+paramValues[0])/102.;
      double ln2 = 2-ln1;
      double ln3 = ln1*getParam( paramValues,1)/100.;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln3, 0);
      baseTile.setPoint(2, ln1, 0);
      baseTile.setPoint(3, ln1/2, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[2].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}
